package day0706;
// 사용자로부터 번호, 이름, 국어, 영어, 수학을 입력받아서

// 출력하는 프로그램을 만드시오.
// 단, 입력과 출력은 분리되어 있습니다.
// 또한 입력과 출력은 메소드로 분리되어 있는데
// 점수 입력 메소드를 만들어서
// 그 메소드를 통해서 점수 입력/검증을 끝난 값을
// 각각의 점수에 넣을 수 있고
// 출력의 경우, 출력 메소드가 파라미터로 받은 값을
// 예쁘게 출력합니다.
// 20분까지

// 내가 푼 코드 

import java.util.Scanner;

public class GradeBook010 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1. 상수 선언
        
        // 2. 변수 선언
        int number = 0;
        
        // 메뉴 출력
        while(true) {
            System.out.println("1. 입력 2. 출력 3. 종료");
            int userChoice = scanner.nextInt();
            
            if (userChoice == 1) {
                
                // 메소드 출력 어찌하냐
                number(number);
            
                name(name);
                score(score(0));
                
               
            } else if (userChoice == 2) {
                
                
            } else if (userChoice == 3) {
                System.out.println("이용해주셔서 감사합니다.");
            }
        }
        
        
        
        
    }
    
    // 점수 입력 메소드 생성
    // 번호 입력
    // 모든 메소드마다 스캐너 변수를 생성해야 되는 걸까
    public static int number(int number) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("번호를 입력하세요.");
        System.out.print("> ");
        return number = scanner.nextInt();
    }
    // 이름 입력
    public static String name(String name) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("번호를 입력하세요.");
        System.out.print("> ");
        scanner.nextLine();
        return name = scanner.nextLine();
        
    }
    // 점수 입력 <- 점수는 1개로 관리?
    public static int score(int score) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("번호를 입력하세요.");
        System.out.print("> ");
        return score = scanner.nextInt();
        
    } 
    
}
