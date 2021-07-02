package day0702;

import java.util.Scanner;

// 1. 1부터 6까지 출력하시오.

// 2. 17부터 12까지 출력하시오.
// 3. 71부터 83까지의 모든 짝수를 출력하시오.
// 4. 사용자로부터 숫자를 하나 입력 받아서
//    1부터 그 수까지 출력하시오.
// 5. 사용자로부터 숫자를 두 개 입력 받아서
//    더 큰수 부터 더 작은 수까지 출력하시오. 
// 6. 사용자로부터 숫자를 하나 입력 받아서
//    1부터 그 수까지의 합을 출력하시오. 
// 7. 사용자로부터 숫자를 하나 입력받아서
//    1부터 그 수까지의 곱을 출력하시오.

public class Ex04ForLoop2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String LINE = "\n========================\n";

        // for 반복문
        for (int i = 1; i <= 3; i++) {
            System.out.printf("i의 현재 값 : [%d]\n", i);
        }
        System.out.println(LINE);

            // 1. 1부터 6까지 출력하시오.
            System.out.println("1");

            for (int i = 1; i <= 6; i++) {
                System.out.println(i);
            }

            System.out.println(LINE);

            // 2. 17부터 12까지 출력하시오.
            /*
            for (i = 12; i < 18; i++) {
                System.out.printf("i의 현재 값 : [%d]\n", i);
            }
            */
            // 강사님
            
            System.out.println("2번");

            int start = 17;
            int end = 12;
            for(int i = start; i >= end; i--) {
                System.out.println(i);
            }

            System.out.println(LINE);

            // 3. 71부터 83까지의 모든 짝수를 출력하시오.
            // 짝수 까먹음.
            System.out.println("3번");
            
            /*
            for (i = 71; i < 83; i++) {
                System.out.printf("i의 현재 값 : [%d]\n", i);
            }
            */
            
            // 강사님
            start = 71;
            end =83;
            for(int i =start; i <= end; i++) {
                if(i % 2 == 0) {
                    System.out.println(i);
                }
            }
            System.out.println(LINE);
            

            // 4. 사용자로부터 숫자를 하나 입력 받아서 1부터 그 수까지 출력하시오.
            System.out.println("4번");

            
            System.out.println("숫자를 하나 입력하세요.");
            System.out.print("> ");
            int userNumber = scanner.nextInt();
            
            start = 1;
            end = userNumber;
            
            for(int i = start; i <= end; i++) {
                System.out.println(i);
            }
            
            // 내가 쓴 코
            //for(i = 1; i <= number; i++) {
            //    System.out.printf("i의 현재 값 : [%d]\n", i);
            // }
   

            System.out.println(LINE);


            // 5. 사용자로부터 숫자를 두 개 입력 받아서 더 큰수 부터 더 작은 수까지 출력하시오.
            // 큰수부터 작은수까지가 뭐일까
            System.out.println("5번");

            /* 내가 쓴 코드
            System.out.println("숫자를 입력하세요.");
            System.out.print("> ");
            int number1 = scanner.nextInt();
            
            System.out.println("다른 숫자를 입력하세요.");
            System.out.print("> ");
            int number2 = scanner.nextInt();
            
            if (number1 > number2) {
                
            }
            
            for(i = 1; i) {
                System.out.printf("i의 현재 값 : [%d]\n", i);
            }
            System.out.println("LINE");
            */
            
            // 강사님

            System.out.println("1번 숫자.");
            System.out.print("> ");
            int number1 = scanner.nextInt();
            
            System.out.println("2번 숫자.");
            System.out.print("> ");
            int number2 = scanner.nextInt();
            
            if(number1 > number2) {
                start = number1;
                end = number2;
            } else {
                start = number2;
                end = number1;
            }
            
            for(int i = start; i >= end; i--) {
                System.out.println(i);
            }
            
        
            // 6. 사용자로부터 숫자를 하나 입력 받아서 1부터 그 수까지의 합을 출력하시오. 
            System.out.println("6번");
            
            /* 내가 쓴 코드
            System.out.println("숫자를 입력하세요.");
            System.out.print("> ");
            number = scanner.nextInt();
            
            int a = 1;
            for( i = 0; i <= number; i++) {
                if (i <= number) {
                    a ++;
                System.out.printf("i의 현재 값 : [%d]\n", i+a);
            }
                System.out.println("LINE");
            }
            */
            
            // 강사님
            System.out.println("숫자를 입력하세요.");
            System.out.print("> ");
            userNumber = scanner.nextInt();
            
            // 1부터의 합을 저장할 int 변수
            int sum = 0;
            
            start = 1;
            end = userNumber;
            for(int i = start; i <= end; i++) {
                sum += i;
            }
            System.out.printf("1부터 %d까지의 합 : %d\n", userNumber, sum);
            
            
            System.out.println(LINE);
            
            
            
            // 7. 사용자로부터 숫자를 하나 입력받아서 1부터 그 수까지의 곱을 출력하시오.
            System.out.println("7번");

            /* 내가 쓴 코드

            System.out.println("숫자를 입력하세요.");
            System.out.print("> ");
            number = scanner.nextInt();
            
            a = 1;
            for(i = 0; i <= number; i++) {
                if (i <= number) {
                    a ++;
                System.out.printf("i의 현재 값 : [%d]\n", i * a);
            }
                System.out.println("LINE");
            }
            */
            
            // 강사님
            System.out.println("숫자를 입력하세요.");
            System.out.print("> ");
            userNumber = scanner.nextInt();
            
            // 1부터 userNumber까지의 곱을 저장할 변수
            int sigma = 1;
            
            start = 1;
            end = userNumber;
            for(int i = start; i <= end; i++) {
                sigma *= i;
            }
            System.out.printf("1부터 %d까지의 곱 : %d\n", userNumber, sigma);
            
            
            
            scanner.close();
        }
        
    }
