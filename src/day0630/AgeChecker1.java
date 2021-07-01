package day0630;
// 숙제 1.

// 2가지 검증 방법을 각각 사용하여
// 사용자의 나이에 따른
// 영유아, 어린이, 청소년, 성인을 출력하는 프로그램을 작성하시오.
// 기네스북에 따르면, 세상에서 가장 나이가 많았던 나이는 122세였습니다.

//사용자로부터 나이를 입력받아서
//6세 미만 : 영유아입니다.
//~13세이하 : 어린이입니다.
//~18세이하 : 청소년입니다.
//그 외 : 성인입니다.
//가 출력되는 프로그램을 작성하시오.
import java.util.Scanner;

public class AgeChecker1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 나이 입력
        System.out.println("나이를 입력하세요.");
        System.out.print("> ");
        int age = scanner.nextInt();

        System.out.println("첫번째 방법");
        // 2. 잘못된 나이값 확인 
        if (age <= 122) {
            // 3. 나이값 if문
            if (age >= 0 && age <= 6) {
                System.out.println("영유아입니다.");
            } else if (age >= 6 && age <= 13) {
                System.out.println("어린이입니다.");
            } else if (age >= 14 && age <= 18) {
                System.out.println("청소년입니다.");
            } else {
                System.out.println("성인입니다.");
                }
        //4. 잘못된 나이값 출력, 중괄호 주의
        } else {
            System.out.println("잘못된 값입니다.");
        }
        System.out.println("---------------");
        System.out.println("두번째 방법");
        
        // 1. 나이 범위 설정
        if (age <= 122 && age >= 0) {
            // 2. 나이값 if문
            if (age < 6) {
                System.out.println("영유아입니다.");
            } else if (age <= 13) {
                System.out.println("어린이입니다.");
            } else if (age <= 18) {
                System.out.println("청소년입니다.");
            } else {
                System.out.println("성인입니다.");
                }
        // 3. 잘못된 나이값 출력, 중괄호 주의
        } else {
            System.out.println("잘못된 값입니다.");
        }
        }
    }