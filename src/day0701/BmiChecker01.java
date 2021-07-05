package day0701;

//사용자로부터 키와 몸무게를 입력 받아서

//BMI를 계산하여
//비만도를 출력하는 프로그램
//단,  기네스북에 따르면 셰게에서 가장 키가 컸던 사람의 키는 
//2.72m였습니다.
//또한 가장 몸무게가 무거웠던 사람의 몸무게는 635kg이었습니다.
//만약 사용자가 잘못된 값을 입력할 경우, 
//올바른 값을 입력할 때 까지 다시 입력 받으시오

import java.util.Scanner;

public class BmiChecker01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final double STANDARD_I = 18.5;
        final double STANDARD_II = 23;
        final double STANDARD_III = 25;

        // 1. 키를 입력받는다.
        System.out.println("키 m단위로 입력하세요.");
        System.out.printf("> ");
        double input = scanner.nextDouble();

        while (input <= 0 || input >= 2.72) {
            // 사용자가 점수를 잘못 입력했으므
            // 다 입력하라고 시킨다.
            System.out.println("잘못된 키 입니다.");
            System.out.println("키를 입력해주세요.");
            System.out.print("> ");
            input = scanner.nextDouble();
        }
        /* 이 코드도 가능 
         *         while (!(height > 0 && height < 2.72)) {
         *              System.out.println("다시 입력해주세요.");
                        System.out.print("> ");
                        height = scanner.nextDouble();
         *         
         */
        
        // 2. 몸무게를 입력받는다.
        
        double height = input;
        
        System.out.println("몸무게 kg단위로 입력하세요.");
        System.out.printf("> ");
        input = scanner.nextDouble();

        while (input <= 0 || input >= 635) {
            // 사용자가 점수를 잘못 입력했으므
            // 다 입력하라고 시킨다.
            System.out.println("잘못된 몸무게 입니다.");
            System.out.println("몸무게를 입력해주세요.");
            System.out.print("> ");
            input = scanner.nextInt();
        }
        
        double weight = input;

        // 3. BMI를 계산한다.
        double bmi = weight / height / height;

        // 4. if - else if 구조를 통하여
        // 비만도를 String에 저장
        String result;
        if (bmi < STANDARD_I) {
            result = "저체중"; // <- 여기까지 하면 초기화가 안되서 에러
        } else if (bmi < STANDARD_II) {
            result = "정상체중";
        } else if (bmi < STANDARD_III) {
            result = "과체중";
        } else {
            result = "비만"; // <- 반드시 초기화 되는 코드
        }

        // 5. 출력
        System.out.printf("키 : %.2f m 몸무게 : %.2f kg\n", height, weight);
        System.out.printf("bmi : %.3f 비만도 :%s\n", bmi, result);

        scanner.close();
    }
}