package day0710;

import java.util.Scanner;
import util.ScannerUtil;
import util.ArrayUtil;

public class bmiTest {
    // 1. 상수
    static final double WH_MIN = 0;
    static final double HEIGHT_MAX = 2.72;
    static final double WEIGHT_MAX = 635;

    static final double BMI_STANDARD_I = 18.5;
    static final double BMI_STANDARD_II = 23;
    static final double BMI_STANDARD_III = 24;

    static Scanner scanner = new Scanner(System.in);
    
    static double height = 0;
    static double weight = 0;

    public static void main(String[] args) {
        // 2. 변수
        // 변수를 메소드에 선언하는게 맞을까. 전역변수로 만드는게 맞을까


        // 3. 메뉴 구현
        // <- String message는 뭘까
        int index = 0; // <- 이건 어디에 쓰이는 거더라
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, "1. 입력 2. 출력 3. 종료", 1, 3); //<-여기까먹음. 

            // System.out.println("1 입력 2. 출력 3. 종료"); <- 무한 증가 
            if (userChoice == 1) {
                inPut();

            } else if (userChoice == 2) {
                outPut(height, weight);

            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }

        }

    }

    public static void inPut() {
        String message = "";
        message = "키를 m 단위로 입력해주세요.";
        height = ScannerUtil.nextDouble(scanner, message, 0.01, HEIGHT_MAX);
        
        message = "몸무게를 kg 단위로 입력해주세요.";
        weight = ScannerUtil.nextDouble(scanner, message, 0.01, WEIGHT_MAX);
        /*
        System.out.println("키를 m단위로 입력해주세요.");
        System.out.print("> ");
        height = scanner.nextDouble();
        block1();

        System.out.println("몸무게를 kg단위로 입력해주세요.");
        System.out.print("> ");
        weight = scanner.nextDouble();
        block2();
         */
    }

    public static void outPut(double height, double weight) {
        double bmi = height / weight / weight;

        String obesity = "";
        if (bmi < BMI_STANDARD_I) {
            obesity = "저체중";
        } else if (bmi < BMI_STANDARD_II) {
            obesity = "정상체중";
        } else if (bmi < BMI_STANDARD_III) {
            obesity = "과체중";
        }

        System.out.printf("키 : [%.2f]m 몸무게 : [%.2fg]\n", height, weight);
        System.out.printf("bmi : [%.3f]m 비만도 : [%s]\n", bmi, obesity);

    }

    // <- 다른 숫자 블록하는 메소드를 따로 만들어야 할려나
    public static void block1() {
        double index = 0;
        while (index < WH_MIN || index > HEIGHT_MAX)
            System.out.println("잘못 입력하셨습니다.");
        System.out.println("다시 입력해주세요.");
        System.out.print("> ");
        index = scanner.nextDouble();
    }

    public static void block2() {
        double index = 0;
        while (index < WH_MIN || index > WEIGHT_MAX)
            System.out.println("잘못 입력하셨습니다.");
        System.out.println("다시 입력해주세요.");
        System.out.print("> ");
        index = scanner.nextDouble();
    }
}
