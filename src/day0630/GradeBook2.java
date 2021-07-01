package day0630;
// 숙제 2.

// 사용자로부터 번호, 이름, 국어, 영어, 수학 점수를 입력 받아서
// 예쁘게 출력하시오.

// 단, 모든 입력이 끝난 후에 모든 점수가 올바른 범위일때에만
// 출력이 진행 되고
// 만약 잘못된 점수가 존재할 경우에는
// "잘못된 점수가 있어서 결과를 출력할 수 없습니다."
// 가 출력되게 코드를 작성하시오.

// 다입력하고 검증 

//출력 결과
//번호 : ##번 이름 : ###
//국어 : ###점 영어 : ###점 수학 : ###점

import java.util.Scanner;

public class GradeBook2 {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    // 1. 번호 입력 
    System.out.println("번호를 입력하세요.");
    System.out.print("> ");
    int number = scanner.nextInt();
    
    // 2. 이름 입력 
    System.out.println("이름을 입력하세요.");
    System.out.print("> ");
    String name = scanner.nextLine();
    
    // 3. 국어 점수 입력 
    System.out.println("국어점수를 입력하세요.");
    System.out.print("> ");
    int korean = scanner.nextInt();
    
    // 4. 영어 점수 입력 
    System.out.println("영어점수를 입력하세요.");
    System.out.print("> ");
    int english = scanner.nextInt();
    
    // 5. 수학 점수 입력 
    System.out.println("수학점수를 입력하세요.");
    System.out.print("> ");
    int math = scanner.nextInt();
    
    // 모든 시험점수를 변수로 묶고 싶음.
    //String all = korean, english, math;
    
    // 6. 입력 받고 올바른 범위일때만 출력 중첩 if문
    if (korean >= 0 && korean <= 100) {
        if (english >= 0 && english <= 100) {
            if (math >= 0 && korean <= 100) {
                System.out.println("출력결과");
                System.out.printf("번호 : %d 이름 : %s\n", number, name);
                System.out.printf("국어점수 : %.3d점 영어점수 : %3d점 수학점수 : %3d점\n", korean, english, math);
            
            } else {
                System.out.println("잘못된 점수가 있어서 결과를 출력할 수 없습니다.");
            }
        } else {
            System.out.println("잘못된 점수가 있어서 결과를 출력할 수 없습니다."); 
        }  
    } else {
        System.out.println("잘못된 점수가 있어서 결과를 출력할 수 없습니다."); 
    }
        scanner.close();
    }
}
// &&으로 묶