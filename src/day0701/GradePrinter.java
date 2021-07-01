package day0701;
//사용자로부터 점수를 입력받아서
//90~: A
//80~: B
//70~: C
//60~: D
//그외: F 
//가 출력되는 프로그램을 작성하시오

import java.util.Scanner;

//단 사용자가 잘못된 점수를 입력하면 올바른 점수를 입력할 때 까지
//다시 입력이 되도록 코드를 작성하시오

//출력 예시)
//사용자의 점수: [##]점 
//최종 성적: [B]

import java.util.Scanner;

public class GradePrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
     // 1. 점수를 입력 받는다.
        System.out.println("점수를 입력하세요.");
        System.out.print("> "); 
        int score = scanner.nextInt();
            
        while (score <= 0 || score >= 100) {
            // 사용자가 점수를 잘못 입력했으므
            // 다 입력하라고 시킨다.
            System.out.println("잘못된 점수입니다.");
            System.out.println("0~100 사이의 점수를 입력해주세요.");
            System.out.print("> ");
            score = scanner.nextInt();
        }
        
        /* 위에 있는 while문 이런 형식으로도 가능 
        while (!(score >= 0 && score <= 100)) {
            System.out.println("다시 입력해주세요.");
            System.out.print("> ");
            score = scanner.nextInt();    
        }
        */
        
        String result;
        if (score >= 90) {
            result = "A";
        } else if (score >= 80) {
            result = "B";
        } else if (score >= 70) {
            result = "C";
        } else if (score >= 60) {
            result = "D";
        } else {
            result = "F";
        }
        
        // 3. 점수와 결과를 출력한다.
        System.out.printf("사용자의 점수 : [%2d]점 최종 성적 : [%s]\n", score, result);
        
        scanner.close();
        }
    }
