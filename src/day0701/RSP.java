package day0701;
// 가위 바위 보 게임

// 1. 플레이 2. 현재 기록 보기 3. 종료
// > 2
// 아직 플레이 기록이 없습니다.
// 1. 플레이 2. 현재 기록 보기 3. 종료
// > 1
// 1. 가위 2. 바위 3. 보
// > 0
// 잘못 입력하셨습니다.
// 1. 가위 2. 바위 3. 보
// > 819
// 잘못 입력하셨습니다.
//1. 가위 2. 바위 3. 보
// > 2
// 사용자의 선택 : 바위
// 컴퓨의 선택 : 가위
// 사용자 승!!
// 1. 플레이 2. 현재 기록 보기 3. 종료
// > 1
// 1. 가위 2. 바위 3. 보
// > 1
// 사용자의 선택 : 가위
// 컴퓨터의 선택 : 바위
// 사용자 패!!
// 1. 플레이 2. 현재 기록 보기 3. 종료
// > 2
// 현재 전적 : 1승 0무 1패 (승률 : 50%)
// 1. 플레이 2. 현재 기록보기 3. 종료
// > 3
// 플레이 해주셔서 감사합니다.

import java.util.Random;
import java.util.Scanner;

public class RSP {
    public static void main(String[] args) {

        // 객체 생성
        Scanner scanner = new Scanner(System.in);
        Random random = new Random(); 

        // 변수 선언. 플레이 선택은 유저초이스 변수로 생성
        int number = 0; // 유저 선택 숫자
        int randomNumber = 0; // 랜덤 숫자
        int userChoice; // 메뉴바 선택
        
        // 가위바위보 출력 부분 
        // 스트링이 대문자임. 이거 변수 표시가 안됬던 이유는 중괄호 때 
        String win = "이겼습니다"; 
        String lose = "비겼습니다.";
        String draw = "사용자 패!";

        // 무한루프 메뉴보기,

        while (true) {
            System.out.println("가위바위보 게임");
            System.out.println("1. 플레이 2. 현재 기록 보기 3. 종료");
            System.out.print("> ");
            userChoice = scanner.nextInt();
            
            // 메뉴바 잘못된 값 입력 시 블록
            while (!(userChoice > 0 && userChoice < 4)) {
                System.out.println("잘못된 값을 입력하셨습니다.");
                System.out.println("다시 입력해주세요");
            }
            
            // 플레이 선택 시
            if (userChoice == 1) {
                // 무한루프 가위바위보 입력
                while (true) {
                    System.out.println("1. 가위  2. 바위  3. 보");
                    System.out.print("> ");
                    number = scanner.nextInt();
                    
                    // 가위바위보 잘못된 값 입력 시 블록
                    while (!(userChoice > 0 && userChoice < 4)) {
                        System.out.println("잘못된 값을 입력하셨습니다.");
                        System.out.println("다시 입력해주세요");
                        
                       // 사용자가 가위바위보 잘 입력했을 랜덤가위바위보 값 생성
                    } randomNumber = random.nextInt(3)+1;
                    
                    // 사용자 vs 컴퓨터 가위바위보 if 경우의 수             
                    if (number == 1 && randomNumber == 1) {
                        System.out.printf("사용자의 선택 : 가위");
                        System.out.printf("컴퓨터의 선택 : 가위");
                        System.out.printf(draw);
                    } else if (number == 2 && randomNumber == 2) {
                        System.out.printf("사용자의 선택 : 바위");
                        System.out.printf("컴퓨터의 선택 : 바위");  
                        System.out.printf(draw);
                    } else if (number == 3 && randomNumber == 3) {
                        System.out.printf("사용자의 선택 : 보");
                        System.out.printf("컴퓨터의 선택 : 보");
                        System.out.printf(draw);
                    } else if (number == 1 && randomNumber == 2) {
                        System.out.printf("사용자의 선택 : 가위");
                        System.out.printf("컴퓨터의 선택 : 바위");
                        System.out.printf(lose);
                    } else if (number == 1 && randomNumber == 3) {
                        System.out.printf("사용자의 선택 : 가위");
                        System.out.printf("컴퓨터의 선택 : 보");
                        System.out.printf(win);
                    } else if (number == 2 && randomNumber == 1) {
                        System.out.printf("사용자의 선택 : 바위");
                        System.out.printf("컴퓨터의 선택 : 가위");
                        System.out.printf(win);
                    } else if (number == 2 && randomNumber == 3) {
                        System.out.printf("사용자의 선택 : 바위");
                        System.out.printf("컴퓨터의 선택 : 보");
                        System.out.printf(lose);
                    } else if (number == 3 && randomNumber == 1) {
                        System.out.printf("사용자의 선택 : 보");
                        System.out.printf("컴퓨터의 선택 : 가위");
                        System.out.printf(lose);
                    } else if (number == 3 && randomNumber == 2) {
                        System.out.printf("사용자의 선택 : 보");
                        System.out.printf("컴퓨터의 선택 : 바위");
                        System.out.printf(win);
                        
                
            // 현재 기록 보기 선택     
            // 현재 전적 : 1승 0무 1패 (승률 : 50%)
        } else if (userChoice == 2) {
            if () {
                
            }
            
            
            // 종료
        } else if (userChoice == 3) {
            System.out.println("플레이 해주셔서 감사합니다.");
        } scanner.close();
            
        }    
    }
}
    }
}