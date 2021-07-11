package day0708;
// 컴퓨터의 숫자를 뽑고
// 사용자로부터 입력을 받아서
// 자동 혹은 수동으로 숫자를 뽑아서
// 결과(몇개 맞았는지)를 출력해주는 프로그램을 작성하시오.
// 단, 메소드를 적극적으로 만들어서 프로그램을 작성하시오.
// 6시까지 -> 15분 실화

// 내가 풀어본 버젼 

import java.util.Scanner;
import java.util.Random;

import util.ScannerUtil;
import util.ArrayUtil;

public class LottoGame40 {
    // 상수
    static final int SIZE = 6;
    static final int NUMBER_MIN = 1;
    static final int NUMBER_MAX = 45;
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
                       
        
       // 변수        
        int[] numbers = new int[0];

        int index = 0;
        
       String message = "";
       int [] userChoice = new int[0];
       
       while(true) {
           message = "1. 입력 2. 출력 3. 종료";
           int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);

        
        while (true) {
            message = "1. 자동 2. 수동 3. 종료";
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
            
            // <- 여기도 메소드화?
            // 자동일 때
            if (userChoice == 1) {
                arr = insertauto(arr);
                
                numbers = setNumbers(numbers, scanner);
                sort(numbers);
                print(numbers);
                scanner.close();
            }
            // 수동일 떄
            else if (userChoice == 2) {
                arr = insertManual(scanner, arr);
            }
            sort(arr);
            return arr;
                
                
        }else if (userChoice == 3) {
            // 종료 코드 구현
            System.out.println("사용해주셔서 감사합니다.");
            break;
        }
    }
        
    }


    public static int[] setNumbers(int[] arr, Scanner scanner) {
        String message = "1~45 사이의 숫자를 입력해주세여.";
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
        return arr;
    }
    
    // 정렬 메소드
    public static void sort(int[] arr) {
        for (int i = 0; i < ArrayUtil.size(arr) - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                i = -1;
            }
        }
    }
    // 출력 메소드
    public static void print(int[] arr) {
        for(int i = 0; i < ArrayUtil.size(arr); i++) {
            System.out.printf("%d번 숫자 : [%2d]\n", i+1, arr[i]);
        }  
    }
}

