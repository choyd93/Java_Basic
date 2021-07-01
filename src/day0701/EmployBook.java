package day0701;
// 사원의 정보를 저장하고 출력하는 프로그램을 작성하시오.

// 단, 사원의 정보를 입력할 때에는
// 메뉴에서 "입력" 이라는 글자를 입력해야 입력 기능이 실행되고
// 출력할 때에는 마찬가지 "출력" 이라고 입력해야 출력 기능이 실행되게
// 프로그램을 작성하시오.
// (힌트 : 참조형 데이터타입의 비교는?)
// 또한 아무런 정보가 입력되지 않은 상태에서는
// 사용자가 출력을 선택하면, 입력된 정보가 없음을 알려야 합니다.

// 사원의 정보에는 다음과 같은 것이 있어야 합니다.
// 1. 사원 번호
// 2. 사원 이름
// 3. 사원 직급
// 4. 사원 부서
// 5. 사원 월급

// 쉬는 시간 포함 4시 40분까지

import java.util.Scanner;

public class EmployBook {
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
        // 5. 월급 최소값
        final int SALARY_MIN = 0;
        // 6. 월급 최대값
        final int SALARY_MAX = 10000000;

        // 변수
        int id = 0, salary = 0 ;
        String name = "";
        String rank = "";
        String department ="";
        String userChoice ="";
        
        // 만약 사용자가 입력을 하면
        // true로 바뀌는 boolean 변수
        boolean inputSwitch = false;
    

        // 입출력 무한루프
        while (true) {
            
            System.out.println("입력 출력 종료 중 실행할 기능을 입력하세요.");
            System.out.print("> ");
            userChoice = scanner.nextLine();

            if (userChoice.equals("입력")) {

                // 사용자로부터 입력을 받는 코드를 구현한다.
                System.out.println("입력 시작");
            
            // 1. 번호를 입력받는다.
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
             scanner.nextLine(); // 버퍼메모리 비우기
             name = scanner.nextLine();

             
             // 3. 직급을 입력받는다.
             message = "직급을 입력해주세요.";
             System.out.println(message);
             System.out.print("> ");
             rank = scanner.nextLine();
             
             // 4. 부서를 입력받는다.
             message = "부서를 입력해주세요.";
             System.out.println(message);
             System.out.print("> ");
             name = scanner.nextLine();
             
             // 5. 월급을 입력받는다.
             message = "월급을 입력해주세요.";
             System.out.println(message);
             System.out.print("> ");
             scanner.nextInt(); // 버퍼메모리 비우기
             salary = scanner.nextInt();
             
             scanner.nextLine(); // 이게 중요 한번 루프로 돌고 다시 돌아오기 떄문에 버퍼메모리 지우기용임.

             while (!(input >= SALARY_MIN && input <= SALARY_MAX)) {
                 System.out.println("잘못 입력하셨습니다.");
                 System.out.println(message);
                 System.out.print("> ");
                 input = scanner.nextInt();
             }
             scanner.nextLine();

             // 이거 이후로 입력할 값이 없기 떄문에 다시 while로 올라감
             // 계속 입력했기 떄문에 위에서 버퍼메모리 에러가 발생함.(중요)
             
             inputSwitch = true;
             
            } else if (userChoice.equals("출력")) {
                // 출력 코드
                // 입력된 데이터를 출력하는 코드를 구현한다.
                System.out.println("출력 시작");
                
                if(inputSwitch) {

                    // 결과를 출력한다.
                    System.out.printf("사원 번호 : %03d번 사원 이름 : %s\n", id, name);
                    System.out.printf("사원 직급 : %s번 사원 부서 : %s\n",rank, department);
                    System.out.printf("사원 월급 : %d원\n", salary);
                 
                } else {
                    System.out.println("아직 입력된 정보가 없습니다.");
                    
                }
                // 종료
            } else if (userChoice.equals("종료")){
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
            scanner.close();
}
}