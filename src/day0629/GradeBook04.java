package day0629;
// 사용자로부터
// 번호, 이름, 국어 점수, 영어 점수, 수학 점수를 차례대로 입력 받아서
// 다음과 같은 형식에 맞추어 출력하는 프로그램을 작성하시오.

// 출력 결과
// 번호 : ##번 이름 : ###
// 국어 : ###점 영어 : ###점 수학 : ###점
// 총점 : ###점 평균 : ###.##점

import java.util.Scanner;

public class GradeBook04 {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.println("1. 번호를 입력해주세요");
       System.out.print("> ");
       int number = scanner.nextInt();
       
       System.out.println("2. 이름을 입력해주세요");
       System.out.print("> ");
       Scanner scanner1 = new Scanner(System.in);
       String name = scanner1.nextLine();
 
       Scanner scanner2 = new Scanner(System.in);
       System.out.println("3. 국어점수를 입력해주세요");
       System.out.print("> ");
       int korean = scanner2.nextInt();
       
       Scanner scanner3 = new Scanner(System.in);
       System.out.println("4. 영어점수를 입력해주세요");
       System.out.print("> ");
       int english = scanner3.nextInt();
       
       Scanner scanner4 = new Scanner(System.in);
       System.out.println("4.수학점수를 입력해주세요");
       System.out.print("> ");
       int math = scanner4.nextInt();
 
       System.out.printf("번호 : %03d번 이름 : %s\n" , number, name);
       System.out.printf("국어점수 : %03d점 영어점수 : %03d점 수학점수 : %03d점\n" , korean, english, math);
       
       int sum = korean + english + math;
       double average = (double)sum/3;
       
       System.out.printf("총점 : %03d점 평균 : %06.2f점\n" , sum, average);

       
    }

}
