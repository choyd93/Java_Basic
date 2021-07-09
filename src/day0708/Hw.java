package day0708;
// 숙제

// 로또 게임을
// 사용자로부터 총 몇게임을 할거고
// 각 게임마다 자동인지 수동인지 입력 받아서
// 게임별 결과를 다 출력해주는 프로그램을 작성하시오.

//이차원 배열이랑 사용자 몇개할지 정해주는걸 구현하는게 포인트


import java.util.Random;
import java.util.Scanner;

import util.ArrayUtil;
import util.ScannerUtil;

// 2차원 배열 사용.

public class Hw { 
    // 상수
    static final int SIZE = 6;
    static final int NUMBER_MIN = 1;
    static final int NUMBER_MAX = 45;

    public static void main(String[] args) {
        // 변수
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[0];
        int[] userNumbers = new int[0];

        // 컴퓨터의 숫자를 저장할 배열
        int[] computerArray = new int[0]; // <- size - 0으로 변경 

        // 먼저 사용자에게 총 몇게임을 할지 입력을 받는다.
        String message = "총 몇게임 하시겠습니까?";
        int total = ScannerUtil.nextInt(scanner, message);

        // 사용자의 숫자를 저장할 배열
        int[][] userArray = new int[total][0]; // <- size - 0으로 변경, int[][]로 배열 한개 추가

        // 컴퓨터의 숫자를 정한다.
        computerArray = insertRandom(computerArray);

        // 사용자의 숫자를 정하는데
        // 각 게임마다 자동으로 할지 수동으로 할지 입력 받는다.
        setUserNumber(scanner, userArray);

        printResult(computerArray, userArray);
    }

    public static int[] insertRandom(int[] arr) {
        Random random = new Random();
        while (ArrayUtil.size(arr) < SIZE) {
            int number = random.nextInt(NUMBER_MAX) + 1;
            if (!(ArrayUtil.contains(arr, number)))
                ;
            {
                arr = ArrayUtil.add(arr, number);
            }
        }

        // 정렬 메소드 호출
        sort(arr);

        return arr;
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                i = -1;
            }
        }
    }

    // 여기가 핵심인듯 함. 이차배열
    public static void setUserNumber(Scanner scanner, int[][] userArray) {
        for (int i = 0; i < userArray.length; i++) {
            System.out.println("------------------");
            System.out.printf("%2d번 게임\n", i + 1);
            System.out.println("------------------");
            String message = "1. 자동 2. 수동";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
                userArray[i] = insertRandom(userArray[i]);
            } else {
                userArray[i] = insertManual(scanner, userArray[i]);
            }
        }
    }

    // 수동으로 숫자를 입력해주는 메소드
    public static int[] insertManual(Scanner scanner, int[] arr) {
        String message = "1~45 사이의 숫자를 입력해주세요.";
        while (ArrayUtil.size(arr) < SIZE) {
            // 1. 사용자로부터 숫자를 입력 받는다.
            System.out.println();
            System.out.println("======================");
            System.out.printf("[%d]번 숫자\n", ArrayUtil.size(arr) + 1);
            System.out.println("=====================");
            System.out.println();

            int number = ScannerUtil.nextInt(scanner, message, NUMBER_MIN, NUMBER_MAX);

            // 2. 해당 숫자가 배열에 존재하는지 체크한다.
            if (!ArrayUtil.contains(arr, number)) {
                // 3. 만약 존재하지 않는다면 arr에 추가한다.
                arr = ArrayUtil.add(arr, number);
            } else {
                // 4. 존재하면 경고 메시지만 출력해준다.
                System.out.println("중복된 숫자입니다.");
            }
        }
        sort(arr);
        return arr;
    }

    public static void printResult(int[] computerNumbers, int[][] userArray) {
        // 컴퓨터의 숫자를 출력한다.
        System.out.println("=================");
        System.out.println("컴퓨터 숫자");
        print(computerNumbers, computerNumbers, 1); //<-오른쪽 컴퓨터 넘버스 추가
        System.out.println("=================");

        // 사용자의 숫자를
        // 게임별로 출력하며 그 옆에 총 맞은 갯수까지 출력해준다.
        System.out.println("=================");
        System.out.println("사용자 숫자");
        for(int i = 0; i < userArray.length; i++) {
            
            print(computerNumbers, userArray[i], 2);
        }
    }
    
    // 배열을 출력하는 메소드
    public static void print(int[] computerArr, int[] arr, int mode) { // <-- int mode 추가
        System.out.println();
        System.out.println("------------------------");
        for (int i = 0; i < ArrayUtil.size(arr); i++) {
            System.out.printf("%2d ", ArrayUtil.get(arr, i)); //<-  이걸 다시 쓰고 싶음. ;
        }  
            if (mode == 2) {
            // 사용자 숫자일 경우
            // 총 맞은 갯수를 출력해준다.
            System.out.printf("총 맞은 갯수 : %d개 ",compare(computerArr,arr)); //<-compare 넣어줌
            
        }
        System.out.println();
        System.out.println("------------------------");
        System.out.println();
    }
    
    public static int compare(int[] arr1, int[] arr2) {
        int count = 0;
        for(int i = 0; i < ArrayUtil.size(arr1); i++) {
            for(int j = 0; j < ArrayUtil.size(arr2); j++) {
                if(ArrayUtil.get(arr1, i) == ArrayUtil.get(arr2, j)) {
                    count++;
                }
            }
        }       
        return count;
    }
}





















