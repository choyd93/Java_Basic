package day0630;
// 사용자로부터 점수를 입력받아서
// 90~: A
// 80~: B
// 70~: C
// 60~: D
// 그외: F
// 가 출력되는 프로그램을 작성하시오.
// 출력 예시)
// 사용자의 점수 : [##]점
// 최종 성적 : [B]
// 3시 45분까지

import java.util.Scanner;

public class GradePrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1. 점수를 입력 받는다.
        System.out.println("점수를 입력하세요.");
        System.out.print("> ");
        
        int score = scanner.nextInt();
        
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
            result = "f";
        }
        
        // 3. 점수와 결과를 출력한다.
        System.out.printf("사용자의 점수 : [%2d]점\n", score);
        System.out.printf("최종 성적 : [%s]\n", result);
        
        scanner.close();
        }
    }
