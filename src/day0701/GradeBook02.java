package day0701;

// 성적출력 프로그램
// 단, 무한루프를 적용시켜서
// 입력과 출력을 분리하여
// 사용자가 입력을 누를 때에만 입력만 실행이 되고
// 출력을 누를 때에만 기존에 저장된 정보를 토대로 해서 출력이 되게
// 코드를 작성한다.
// 또한 사용자가 1~10을 벗어난 번호나 잘못된 점수를 입력하면
// 올바른 값이 들어올 때까지 다시 입력을 받는다.

// 힌트 : 변수의 유효범위를 잘 생각해보자

// 심화과정 : 만약 사용자가 아무런 정보 입력도 안한 상태에서
//          출력을 누르면 "아직 입력된 정보가 존재하지 않습니다" 가
//          출력이 되게 코드를 작성하시오.

// 3시 10분까지

//출력 결과
//번호: ##번 이름: ###
//국어: ###점 영어: ###점 수학: ###점
//총점: ###점 평균: ###.##점

import java.util.Scanner;

public class GradeBook02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 프로그램에 사용할 상수를 선언
        // 1. 번호 최소값
        final int ID_MIN = 1;
        // 2. 번호 최대값
        final int ID_MAX = 10;
        // 3. 점수 최소값
        final int SCORE_MIN = 0;
        // 4. 점수 최대값
        final int SCORE_MAX = 100;
        //
        final int SUBJECT_SIZE = 3;

        // 변수
        int id = 0, korean = 0, english = 0, math = 0;
        String name = "";
        // 만약 사용자가 입력을 하면
        // true로 바뀌는 boolean 변수
        boolean inputSwitch = false;

        // 입출력 무한루프
        while (true) {
            
            System.out.println("1. 입력 2. 출력 3. 종료");
            int userChoice = scanner.nextInt();

            if (userChoice == 1) {

                // 사용자로부터 입력을 받는 코드를 구현한다.
                System.out.println("입력 시작");

                // 아무 입력 없을 때 출력을 누르면 "아직 입력된 정보가 존재하지 않습니다"
                //String n = "";
                //while (userChoice == name) {
                //    System.out.println("아직 입력된 정보가 존재하지 않습니다.");
                //}

                // 입력값 받기
                int input;
                String message;
                message = "번호를 입력해주세요.";
                System.out.println(message);
                System.out.print("> ");
                input = scanner.nextInt();

                while (!(input >= ID_MIN && input <= ID_MAX)) {
                    System.out.println("잘못된 입력값입니다.");
                    System.out.println(message);
                    System.out.print("> ");
                    input = scanner.nextInt();
                }
                id = input;

                // 2. 이름을 입력받는다.
                message = "이름을 입력해주세요.";
                System.out.println(message);
                System.out.print("> ");
                scanner.nextLine(); // 버퍼메모리 비우기?
                name = scanner.nextLine();

                // 3. 국어 점수를 입력받는다.
                message = "국어 점수를 입력해주세요.";
                System.out.println(message);
                System.out.print("> ");
                input = scanner.nextInt();

                while (!(input >= SCORE_MIN && input <= SCORE_MAX)) {
                    System.out.println("잘못 입력하셨습니다.");
                    System.out.println(message);
                    System.out.print("> ");
                    input = scanner.nextInt();
                }
                korean = input;

                // 4. 영어 점수를 입력받는다.
                System.out.println("영어점수를 입력하세요.");
                System.out.println(message);
                System.out.print("> ");
                input = scanner.nextInt();

                while (!(input >= SCORE_MIN && input <= SCORE_MAX)) {
                    System.out.println("잘못된 입력값입니다.");
                    System.out.print("> ");
                    input = scanner.nextInt();
                }
                english = input;

                // 5. 수학 점수를 입력받는다.
                message = "수학 점수를 입력해주세요.";
                System.out.println(message);
                System.out.print("> ");
                input = scanner.nextInt();

                while (!(input >= SCORE_MIN && input <= SCORE_MAX)) {
                    System.out.println("잘못 입력하셨습니다.");
                    System.out.println(message);
                    System.out.print("> ");
                    input = scanner.nextInt();
                }
                math = input;
                
                inputSwitch = true;

            } else if (userChoice == 2) {
                // 출력 코드
                // 입력된 데이터를 출력하는 코드를 구현한다.
                System.out.println("출력 시작");
                
                if(inputSwitch) {
                    // 총점을 계산한다.
                    int sum = korean + english + math;

                    // 평균을 계산한다.
                    double average = (double) sum / SUBJECT_SIZE;

                    // 결과를 출력한다.
                    System.out.printf("번호 : %03d번 이름 : %s\n", id, name);
                    System.out.printf("국어점수 : %03d점 영어점수 : %03d점 수학점수 : %03d점\n", korean, english, math);
                    System.out.printf("총점 :%03d점 평균 %06.2f점\n", sum, average);
                 
                } else {
                    System.out.println("아직 입력된 정보가 없습니다.");
                    
                }

                // 유효범위 떄문에 출력이 안되는 상태

            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
                // break 란, 반복문 혹은 switch 조건문에서 사용되며
                // break를 만나는 순간 break가 속한 반복문 혹은
                // switch 조건문은 종료된다.
            }
        }

        scanner.close();
    }
}
