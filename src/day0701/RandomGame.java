package day0701;
// 랜덤 숫자 맞추기 게임

// 사용자가 1. 플레이 2. 최고기록 보기 3. 종료
// 중 하나를 입력하면, 각각의 기능이 실행된다.
// 1. 플레이
//    사용자가 플레이를 실행시키면, 컴퓨터는
//    1~100까지의 랜덤한 숫자를 생성한다.
//    그리고 사용자는 그 숫자가 얼마인지 입력해서 맞춰야 하는데
//    사용자가 맞출때까지 입력은 계속 된다.
//    만약 사용자가 입력한 숫자가 컴퓨터의 숫자보다 크면 "DOWN" 이라고 출력된다.
//    만약 사용자가 입력한 숫자가 컴퓨터의 숫자보다 작으면 "UP" 이라고 출력된다.
//    또한, 사용자가 틀릴 때마다 현재 점수가 1점씩 올라가는데
//    최종적으로, 최고기록과 비교해서현재 점수가 더 작으면
//    현재 점수가 새로운 최고기록이 된다.
//    그리고 사용자가 정답을 맞추면 현재 점수, 최고 기록 그리고
//    만약 사용자가 최고 기록을 갱신했으면 축하메시지까지 출력이 된다.

// 2. 최고기록 보기
//    현재 최고기록을 보여준다.
//    단, 만약 사용자가 한번도 플레이 한적이 없으면
//    "아직 플레이 기록이 없습니다!"만 출력이 된다.

// 3. 종료
//    프로그램을 종료시킨다.

import java.util.Random;
import java.util.Scanner;

public class RandomGame {
    public static void main(String[] args) {

        // 객체 생성
        Scanner scanner = new Scanner(System.in);
        Random random = new Random(100); // 랜덤은 시스템인없음.
        // 여기 100을 안넣었음.

        // 변수 선언. 플레이 선택은 유저초이스 변수로 생성
        int number = 0; // 유저 선택 숫자
        int randomNumber = 0; // 랜덤 숫자
        int userChoice;
        int score = 1; // 현재 점수
        int max = 0; // 최대값

        // 이거 뭔지 더 알아보기
        boolean inputSwitch = false;

        // 무한루프 메뉴보기,

        while (true) {
            System.out.println("1. 플레이 2. 최고기록 보기 3. 종료");
            System.out.print("> ");
            userChoice = scanner.nextInt();
            score++;


            // 메뉴 잘못 입력했을 때 블록
           
            while (!(userChoice > 0 && userChoice < 4)) {
                System.out.println("잘못된 값을 입력하셨습니다.");
                System.out.println("1. 플레이 2. 최고기록 보기 3. 종료");
                System.out.print("> ");
                userChoice = scanner.nextInt();
            }
            

            // 플레이 선택 시

            if (userChoice == 1) {

                // 랜덤 숫자 생성 (0포함 하지 않기 위해 +1)
                System.out.println("컴퓨터 숫자 생성 완료");
                randomNumber = random.nextInt(100) + 1;

                // 유저 숫자 입력
                System.out.print("0~100까지 숫자를 입력해주세요. : ");
                number = scanner.nextInt();

                // 잘못된 값 블록
                while (!(number >= 0 && number <= 100)) {
                    System.out.println("잘못된 값을 입력하셨습니다.");
                    System.out.println("0~100까지 숫자를 입력해주세요.");
                    System.out.print("> ");
                    number = scanner.nextInt();
                }

                // 숫자 Up & Down If문
                /*
                 * if문이 아니고 while인가 if (number == randomNumber) { System.out.println("정답!"); }
                 * else if (number > randomNumber) { System.out.println("UP"); score++; } else
                 * if (number < randomNumber) { System.out.println("Down"); score++; }
                 */

                // 사용자 숫자가 랜덤숫자가 맞지 않는 동안
                // 여기서 계속 같은 값만 나옴.

                // 사용자 숫자가 랜덤숫자랑 틀리면 점수가 올라가고 다시 입력 받음.
                /*
                 * if (number > randomNumber) {
                    System.out.println("Down");
                    
                    System.out.print("0~100까지 숫자를 입력해주세요 : ");
                    number = scanner.nextInt();

                } else if (number < randomNumber) {
                    System.out.println("UP");
                    
                    System.out.print("0~100까지 숫자를 입력해주세요 : ");
                    number = scanner.nextInt();

                } else if (number == randomNumber) {
                    System.out.println("정답!");
                    System.out.printf("현재 기록 : %d회\n", score);
                }
                */
                while(!(number == randomNumber)) {
                if (number == randomNumber) {
                    System.out.println("정답!");
                    System.out.printf("현재 기록 : %d회\n", score);
                    break;
                    // 여기코드가 밑에 코드랑 겹침. 여긴 왜출력이 안될까
                    
                } else if (number < randomNumber) {
                    System.out.println("UP");
                    System.out.print("0~100까지 숫자를 입력해주세요 : ");
                    number = scanner.nextInt();
                    continue;

                } else if (number > randomNumber) {
                    System.out.println("Down");
                    System.out.print("0~100까지 숫자를 입력해주세요 : ");
                    number = scanner.nextInt();
                    continue;
                }
                }
                System.out.println("정답!");
                System.out.printf("현재 기록 : %d회\n", score);
            }
            // 2. 최고 기록 보기. 최대값을 모르겠음.
            if (userChoice == 2) {
                if (inputSwitch) {

                    System.out.printf("현재기록 : %d회\n", score);
                } else {
                    System.out.println("아직 입력된 값이 없습니다.");
                }

                // 3. 종료
            } else if (userChoice == 3) {
                System.out.println("이용해주셔서 감사합니다.");
                break; // 이거 언제 써야 되는걸까
            }

        }
        scanner.close();
    }
}