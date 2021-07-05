package day0705;
// 로또게임 최종버젼

// 컴퓨터 숫자를 뽑고 나서
// 사용자로부터 자동으로 할지 수동으로 할지 입력 받아서
// 각각에 코드를 구현하고
// 
// 맨 마지막에
// 컴퓨터의 숫자와 사용자의 숫자를 쭉 출력한 후에
// 컴퓨터 숫자를 기준으로 하여 총 몇개가 맞았는지 출력하는 프로그램을 작성하시오.
// 5시 20분

// 이건 내가 풀어본 버

import java.util.Scanner;
import java.util.Random;

public class LottoGame050 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random(); // 숫자가 안에 있던가
        
        // 상수
        final int NUMBER_MIN = 1;
        final int NUMBER_MAX = 45;
        final int SIZE = 6; // <- size
        
        // 컴퓨터 랜덤 배열 생성
        int[] computerRandom = new int[SIZE];
        
        // 컴퓨터의 선택 
        // 배열에 랜덤한 숫자를 넣는다.
        for(int i = 0; i < computerRandom.length; i++) {
            computerRandom[i] = random.nextInt(NUMBER_MAX)+1;
        }
        
        // 사용자 숫자 배열 생성
        int[] userNumbers = new int[SIZE];
        
        // 메뉴 숫자 선언
        int userChoice = 0;
        
        // 메뉴 구현
        while(true) {
            System.out.println("1. 자동 2. 수동 3. 종료");
            System.out.print("> ");
            userChoice = scanner.nextInt();
            
            // 자동일 때
            if (userChoice == 1) {
                
                // 컴퓨터 숫자 배열 생성
                int[] computerNumbers = new int[SIZE];
                
                // 배열에 랜덤한 숫자를 넣는다.
                for(int i = 0; i < computerNumbers.length; i++) {
                    computerNumbers[i] = random.nextInt(NUMBER_MAX)+1;
                }
                
                // 컴퓨터 랜덤넘버 출력
                for(int i = 0; i < computerRandom.length; i++) {
                    System.out.printf("numbers[%d] : %2d\n", i, computerRandom[i]);
                }
                // 사용자 넘버 출력
                for(int i = 0; i < userNumbers.length; i++) {
                    System.out.printf("numbers[%d] : %d\n",i, userNumbers[i]);
                }
                
                // 컴퓨터 랜덤넘버와 사용자 넘버를 비교 
                // 컴퓨터 숫자를 기준으로 하여 총 몇개가 맞았는지 출력
                for(int i = NUMBER_MIN; i <= NUMBER_MAX; i++) {
                    for(int j = NUMBER_MIN; j <= NUMBER_MAX; j++) {
                        if(i == j) {
                            System.out.printf("%d개 맞았습니다!", i);
                        }
                    } else if () {
                        System.out.printf("맞은 수가 없습니다!");

                    }
                }

                
              // 수동일 때
            } else if(userChoice == 2) {

                // 입력값 받기
                // 배열에 랜덤한 숫자를 넣는다.
                String message;
                message = "숫자를 입력해주세요.";
                for(int i = 0; i < userNumbers.length; i++) {
                    System.out.println("숫자를 입력하세요.");
                    System.out.print("> ");
                    userNumbers[i] = scanner.nextInt();
                    
                    // 잘못 입력 블록
                    while (userNumbers[i] <= NUMBER_MIN || userNumbers[i] >= NUMBER_MAX) {
                        System.out.println("잘못 입력하셨습니다.");
                        System.out.println(message);
                        System.out.print("> ");
                        userNumbers[i] = scanner.nextInt();
                    } 
                }

                    // 중복 제거하는 코드 
                    for(int i = 0; i < userNumbers.length; i++) {
                        for(int j = 0; j < userNumbers.length; j++) {
                            if(i != j && userNumbers[i] == userNumbers[j]) {
                                System.out.println("--------------------------");
                                System.out.printf("%d와 %d에 중복!\n", i, j);
                                userNumbers[i] = random.nextInt(NUMBER_MAX) + 1;
                               System.out.println("--------------------------");
                               j = -1;
                            }
                        }
                    }
                    
                    // 오름차순 정렬하는 코드
                    for(int i = 0; i < userNumbers.length - 1; i++) { //영상
                        if(userNumbers[i] > userNumbers[i+1]) {
                            int temp = userNumbers[i];
                            userNumbers[i] = userNumbers[i+1];
                            userNumbers[i+1] = temp;
                            i = -1; // 다시 맨처음부터 검사하려고 
                        }
                    }
                    
                    // 컴퓨터 랜덤넘버 출력
                    for(int i = 0; i < computerRandom.length; i++) {
                        System.out.printf("numbers[%d] : %2d\n", i, computerRandom[i]);
                    }
                    
                    // 사용자 넘버 출력                   
                    for(int i = 0; i < userNumbers.length; i++) {
                        System.out.printf("numbers[%d] : %d\n",i, userNumbers[i]);
                    }
                    
                    // 컴퓨터 랜덤넘버와 사용자 넘버를 비교 
                    // 컴퓨터 숫자를 기준으로 하여 총 몇개가 맞았는지 출력

            } else if(userChoice == 3) {
                
                System.out.println("이용해주셔서 감사합니다.");
            }
            
            scanner.close();
        } 
    }
}
