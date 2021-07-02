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
        boolean inputSwitch = false; //
        double odds = 0; // 승률 저장
        int score = 1; // 현재 횟수
        
        // 가위바위보 전적 저장
        int win = 0; 
        int lose = 0;
        int draw = 0;

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
                    while(!(number == randomNumber)) {
                        
                        
                        // 강사님의 가르침 
                        // 1. 코드를 단순화 한다는점에서 좋음.
                        // 아래는 승리/패배/무승부를 결정하는 코드들로써
                        // 둘중 자신이 더 마음에 드는 코드를 사용하면 된다.
                        
                        // 2개의 값이 같을 때에는
                        // 비긴 것이므로 draw++
                        // else일때 졌는지 이겼는지를 확인한다.
                        if(userChoice == computerChoice) {
                            System.out.println("비겼습니다");
                            draw++;
                        } else {
                            // 사용자의 선택값에 따라서
                            // 각 결과를 if/else로 결정한다.
                            String result = "사용자";
                           if(userChoice == OPTION1) {
                               // 사용자가 가위를 골랐을 경우
                               if(computerChoice == OPTIOIN2) {
                                   //컴퓨터가 바위를 골랐을 경우
                                   result += "패";
                                   lose++;
                               } else if (computerChoice == OPTIOIN3) {
                                   //컴퓨터가 보를 골랐을 경우
                                  result += "승";
                                  win++;
                               }
                           } else if(userChoice == OPTION2) {
                               // 사용자가 바위를 골랐을 경우
                               if(computerChoice == OPTION1) {
                                   // 컴퓨터가 가위를 골랐을 경우
                                   result += "승";
                                   win++;
                               }else if(computerChoice == OPTION2) {
                                   // 컴퓨터가 보를 골랐을 경우
                                   result += "패";
                                   lose++;
                               }
                           } else if(userChoice == OPTION3) {
                               // 사용자가 보를 골랐을 경우
                               if(computerChoice == OPTION1) {
                                   //컴퓨터가 가위를 골랐을 경우
                                  result += "패";
                                  lose++;
                               }else if(computerChoice == OPTION2) {
                                   // 컴퓨터가 바위를 골랐을 경우
                                   result += "승";
                                   win++;
                               }
                           }
                           System.out.println(result);
                           
                           /*
                           // 2. 아예 승리가 나오는 경우( 코드를 간결하게 만든다는 점에서 좋음)
                           //    패배가 나오는 경우를 조건식으로 만든다.
                          if((userChoice == OPTION1 && computerChocie == OPTION2) ||
                             (userChoice == OPTION2 && computerChoice == OPTION3) ||
                             (userChoice == OPTION3 && computerChoice == OPTION1)) {
                              // (사용자가 가위를 고르고 컴퓨터가 바위를 골랐거)'나'
                              // (사용자가 바위를 고르고 컴퓨터가 보를 골랐거)'나'
                              // (사용자가 보를 고르고 컴퓨터가 가위를 골랐을) 때
                              result += "패";
                              lose++;
                              
                           } else {
                               result += "";
                               win++;
                           }
                        }
                        
                       System.out.println(result);
                        
                        */
                        
                        
                    if (number == 1 && randomNumber == 1) {
                        System.out.printf("사용자의 선택 : 가위");
                        System.out.printf("컴퓨터의 선택 : 가위");
                        System.out.printf("비겼습니다.");
                        draw++;
                        continue; // 이거는 없는게 좋음.
                    } else if (number == 2 && randomNumber == 2) {
                        System.out.printf("사용자의 선택 : 바위");
                        System.out.printf("컴퓨터의 선택 : 바위");  
                        System.out.printf("비겼습니다.");
                        draw++;
                        continue;
                    } else if (number == 3 && randomNumber == 3) {
                        System.out.printf("사용자의 선택 : 보");
                        System.out.printf("컴퓨터의 선택 : 보");
                        System.out.printf("비겼습니다.");
                        draw++;
                        continue;
                    } else if (number == 1 && randomNumber == 2) {
                        System.out.printf("사용자의 선택 : 가위");
                        System.out.printf("컴퓨터의 선택 : 바위");
                        System.out.printf("사용자 패!");
                        lose++;
                        continue;
                    } else if (number == 1 && randomNumber == 3) {
                        System.out.printf("사용자의 선택 : 가위");
                        System.out.printf("컴퓨터의 선택 : 보");
                        System.out.printf("사용자 승!");
                        win++;
                        break;
                    } else if (number == 2 && randomNumber == 1) {
                        System.out.printf("사용자의 선택 : 바위");
                        System.out.printf("컴퓨터의 선택 : 가위");
                        System.out.printf("사용자 승!");
                        win++;
                        break;
                    } else if (number == 2 && randomNumber == 3) {
                        System.out.printf("사용자의 선택 : 바위");
                        System.out.printf("컴퓨터의 선택 : 보");
                        System.out.printf("사용자 패!");
                        lose++;
                    } else if (number == 3 && randomNumber == 1) {
                        System.out.printf("사용자의 선택 : 보");
                        System.out.printf("컴퓨터의 선택 : 가위");
                        System.out.printf("사용자 패!");
                        lose++;
                    } else if (number == 3 && randomNumber == 2) {
                        System.out.printf("사용자의 선택 : 보");
                        System.out.printf("컴퓨터의 선택 : 바위");
                        System.out.printf("사용자 !");
                        win++;
                        break;
                    }
                
            // 현재 기록 보기 선택     
            // 현재 전적 : 1승 0무 1패 (승률 : 50%)
        } 
                    
                    else if (userChoice == 2) {
                        // 승리 / (총 경기) x 100
                        int sum = win +lose + draw;
                       //odds = ((double)win/(double)(score))*100;
                        // odds = (double_win / sum * 100;
                    }
                        if (inputSwitch) {
                               System.out.printf("현재 전 : %d승 %d무 %d패 (승률 : %.2f)\n", win, draw, lose, odds);
                        } else {
                            System.out.println("아직 입력된 값이 없습니다.");
                        }
 
            // 종료
        } else if (userChoice == 3) {
            System.out.println("플레이 해주셔서 감사합니다.");
        } scanner.close();
        break;
            
        }    
    }
}
    }
}