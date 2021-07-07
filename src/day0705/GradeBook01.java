package day0705;
// 국어, 영어, 수학 점수를

// 별개의 int 변수가 아니라
// scoreArray라는 int 배열을 사용한
// 성적 입출력 프로그램을 작성하시오.
// 단, 입력과 출력 기능은 분리되어 있고
// 잘못된 점수는 올바른 점수가 입력 될때까지
// 다시 입력을 받게 하시오.
// 12시까지

//단, 무한루프를 적용시켜서
//입력과 출력을 분리하여
//사용자가 입력을 누를 때에만 입력만 실행이 되고
//출력을 누를 때에만 기존에 저장된 정보를 토대로 해서 출력이 되게
//코드를 작성한다.
//또한 사용자가 1~10을 벗어난 번호나 잘못된 점수를 입력하면
//올바른 값이 들어올 때까지 다시 입력을 받는다.

//힌트 : 변수의 유효범위를 잘 생각해보자

//심화과정 : 만약 사용자가 아무런 정보 입력도 안한 상태에서
//       출력을 누르면 "아직 입력된 정보가 존재하지 않습니다" 가
//       출력이 되게 코드를 작성하시오.

//3시 10분까지

//출력 결과
//번호: ##번 이름: ###
//국어: ###점 영어: ###점 수학: ###점
//총점: ###점 평균: ###.##점

import java.util.Scanner;

public class GradeBook01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 최저 점수를 저장하는 int 상수
        final int SCORE_MIN = 0;
        // 최고 점수를 저장하는 int 상수
        final int SCORE_MAX = 100;
        // 과목 숫자를 저장하는 int 상수
        final int SUBJECT_SIZE = 3;
        // 번호를 저장하는 int 변수
        int id = 0;
        // 이름을 저장하는 String 변수
        String name = "";
        // 점수를 저장하는 int[] 변수
        int[] scoreArray = new int[SUBJECT_SIZE];
        boolean inputSwitch = false;
        
        while(true) {
            System.out.println("1. 입력 2. 출력 3. 종료");
            System.out.print("> ");
            int userChoice = scanner.nextInt();
            
            if(userChoice == 1) {
                // 점수 입력
                System.out.println("번호");
                System.out.print("> ");
                id = scanner.nextInt();
                
                System.out.println("이름");
                System.out.print("> ");
                scanner.nextLine();
                name = scanner.nextLine();
                
                System.out.println("국어 점수");
                System.out.print("> ");
                scoreArray[0] = scanner.nextInt();
                while (!(scoreArray[0] >= SCORE_MIN && scoreArray[0] <= SCORE_MAX)) {
                    System.out.println("잘못 입력하셨습니다.");
                    System.out.println("국어 점수");
                    System.out.print("> ");
                    scoreArray[0] = scanner.nextInt();
                    }
          
                
                System.out.println("영어 점수");
                System.out.print("> ");
                scoreArray[1] = scanner.nextInt();
                while (!(scoreArray[0] >= SCORE_MIN && scoreArray[0] <= SCORE_MAX)) {
                    System.out.println("잘못 입력하셨습니다.");
                    System.out.println("영어 점수");
                    System.out.print("> ");
                    scoreArray[1] = scanner.nextInt();
                    }
                
                System.out.println("수학 점수");
                System.out.print("> ");
                scoreArray[2] = scanner.nextInt();
                while (!(scoreArray[0] >= SCORE_MIN && scoreArray[0] <= SCORE_MAX)) {
                    System.out.println("잘못 입력하셨습니다.");
                    System.out.println("수학 점수");
                    System.out.print("> ");
                    scoreArray[2] = scanner.nextInt();
                    }
                
               inputSwitch = true;
                           
            } else if (userChoice == 2) {
                // 점수 출력
                if(inputSwitch) {
                    // 점수가 한번이라도 입력된 경
                    System.out.printf("번호 : %03d번 이름 : %s\n", id, name);
                    System.out.printf("국어점수 : %.3d점 영어점수 : %3d점 수학점수 : %3d점\n",
                           scoreArray[0], scoreArray[1], scoreArray[2]);
                    int sum = scoreArray[0] + scoreArray[1] + scoreArray[2];
                    double average = (double)sum / SUBJECT_SIZE;
                    System.out.printf("총점 :%03d점 평균 %06.2f점\n", sum, average);
                } else {
                    // 점수가 한번도 입력 안된 경우
                    System.out.println("아직 입력된 정보가 존재하지 않습니다.");

                }
                    
            } else if (userChoice == 3) {
                // while(true) 종료
               System.out.println("사용해주셔서 감사합니다.");
               break;
            }
        }
        scanner.close();
     }

 }
        
        /* 
         * 
         // 프로그램에 사용할 상수를 선언
        // 1. 번호 최소값
        final int ID_MIN = 1;
        // 2. 번호 최대값
        final int ID_MAX = 10;
        // 3. 점수 최소값
        final int SCORE_MIN = 0;
        // 4. 점수 최대값
        final int SCORE_MAX = 100;
        
        // 질문지 배열
        String[] scoreArray = new String[5];
        
        scoreArray[0] = "번호";
        scoreArray[1] = "이름";
        scoreArray[2] = "국어점수";
        scoreArray[3] = "영어점수";
        scoreArray[4] = "수학점수";
        
        // for 문을 사용하여
        // 배열의 각 인덱스번 칸에 값를 입력 받는다.
        for(int i = 0; i < scoreArray.length; i++) {
            System.out.printf("%d을(를) 입력하세요 : ", i+1);
            scoreArray[i] = scanner.nextLine();
        }

        // 잘못된 점수 블록
        while (!(scoreArray[i] >= ID_MIN && scoreArray[i] <= ID_MAX)) {
            System.out.println("잘못된 입력값입니다.");
            System.out.println(message);
            System.out.print("> ");
            // 다시 입력받기 
            for(int i = 0; i < scoreArray.length; i++) {
                System.out.printf("%d을(를) 입력하세요 : ", i+1);
                scoreArray[i] = scanner.nextLine();
            }
        }
        // for 문을 사용하여
        // 배열 전체를 출력한다.
        for(int i = 0; i < scoreArray.length; i++) {
            System.out.printf("arr[%d] : %d\n", i, scoreArray[i]);
        }
        */
