package day0723;

import java.util.ArrayList;
import java.util.Scanner;

import type.Board;
import type.Board01;

public class gradeBook {

    // 1. 상수선언
    static final int SCORE_MIN = 0;
    static final int SCORE_MAX = 100;
    static Scanner scanner = new Scanner(System.in);
    static ArrayList <Board01> Board = new ArrayList<>();
    
    public static void showMenu() {

        while (true) {
            System.out.println("     << 성적처리 프로그램 >>");
            System.out.println("================================");
            System.out.println("--->   메뉴를 입력해주세요.");
            String msg = new String("1. (조회)검색  2. 입력  3. 출력  4. 종료");
            System.out.println("================================");

            int userChoice = nextInt(scanner, msg, 1, 4); 
            if (userChoice == 1) {
                research();
            } else if (userChoice == 2) {
                insert();
            } else if (userChoice == 3) {
                printAll();
            } else {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
            scanner.close();
        }
    }

    public static void research() {
        
        if(Board.isEmpty()) {
            System.out.println("검색할 게시물이 존재하지 않습니다.");
            showMenu();
        }
        
        String msg = "1. 이름으로 검색 2. 학번으로 검색 3. 뒤로 가기";
        
        int userChoice = nextInt(scanner, msg, 1, 2);
        if(userChoice == 1) {
            
            msg = new String("조회할 이름을 입력해주세요.");
            String researchName = nextLine(scanner, msg);
            
            for(int i = 0; i < Board.size(); i++) {
            while(!(researchName.equals(Board.get(i).getName()))) {
                System.out.println("잘못 입력하셨습니다.");
                msg = new String("조회할 이름을 다시 입력해주세요.");
                researchName = nextLine(scanner, msg);
            } 
            printOne(i);
        }    
        } else if (userChoice == 2) {
            msg = new String("조회할 학번을 입력해주세요.");
            int researchId = nextInt(scanner, msg);
            
            while(!(researchId > 0)) {
               System.out.println("잘못입력하셨습니다.");
               
            }
            
                
        } else if (userChoice == 3) {
            showMenu();
        }

    }

    public static void insert() { 
        // 중요포인트! 구조체를 사용했으니 구조체 객체를 생성하고
        // 어레이 리스트 선언? <-- 전역변수라 필요없을까
        Board01 b = new Board01(); //<-- 구조체 객체 생성
        
        String msg;
               
        msg = "학번을 입력해주세요.";
        b.setId(nextInt(scanner, msg));
        
        msg = "성명을 입력해주세요.";
        b.setName(nextLine(scanner, msg)); //<- 구조체에 있는 이름에 세팅해줌.

        msg = "국어점수를 입력해주세요.";
        b.setKor(nextInt(scanner, msg, SCORE_MIN, SCORE_MAX)); 
        //<- 구조체에 있는 국어점수에 세팅

        msg = "영어점수를 입력해주세요.";
        b.setEng(nextInt(scanner, msg, SCORE_MIN, SCORE_MAX));

        msg = "수학점수를 입력해주세요.";
        b.setMath(nextInt(scanner, msg, SCORE_MIN, SCORE_MAX));

        Board.add(b); //<- 빈구조체 객체 b에 담긴 것을 모두 Board01에 추가해줌. 
        
        printAll();

    }

    // 학생의 목록 출력 <-- 여기 중요 
    public static void printAll() {
        
        if(Board.isEmpty()) { //<-- 입력된 정보가 존재하지 않을 시
            System.out.println("아직 입력된 정보가 존재하지 않습니다.");
        } else {
            for(int i = 0; i < Board.size(); i++)
                System.out.printf("%d. %s\n", Board.get(i).getId(), Board.get(i).getName());
                // <- i번 번호. Board01에서 i번째에 있는 내용을 가져와서 이름만 가져온다.
        }
        
        String message = new String("상세보기할 학생의 번호나 뒤로 가실려면 0을 입력해주세요.");
        int userChoice = nextInt(scanner, message, 0, Board.size())-1;
        if (userChoice != -1) { //<-- 이거 왜그런걸까????
            printOne(userChoice);
        }
    }
   

    public static void printOne(int index) {

        System.out.println("============================");
        System.out.println("       << 학생 성적 >>");
        System.out.println("============================");

        for(int i = 0; i < Board.size(); i++) {
        if(Board.equals(Board.get(i).getId(index)){//<-- Board index 게시물의 정보를 보여주는 메소드
            
        }
        }
        while (true) {
            System.out.println("============================");
            System.out.println("선택화면");
            String msg = new String("1. (조회)검색 2. 추가 3. 수정 4. 삭제 5. 종료 ");
            System.out.println("============================");
            int userChoice = nextInt(scanner, msg, 1, 5);
            if (userChoice == 1) {
                research();
            } else if (userChoice == 2) {
                System.out.println("정말로 추가하시겠습니까? 1. 예 2. 아니오");
                System.out.print("> ");

                String yesNo = scanner.nextLine();

                while (!(yesNo.equalsIgnoreCase("예"))) { // <-- 이것도 메소드화 가능할듯
                    System.out.println("잘못 입력하셨습니다.");
                    System.out.println("다시 입력해주세요.");
                    System.out.print("> ");

                    yesNo = scanner.nextLine();
                }
                insert();

            } else if (userChoice == 3) {
                update(index);
            } else if (userChoice == 4) {
                delete(index);
            } else if (userChoice == 5) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    public static void update(int index) {

        System.out.println("수정할 내용의 번호를 입력해주세요.");
        String msg = "1. 국어 2. 영어 3. 수학 4. 이름 5. 뒤로가기";
        int userChoice = nextInt(scanner, msg, 1, 5);
        
        Board01 b = new Board01();
        
        if(userChoice == 1) {
           msg = "국어점수를 입력해주세요.";
           Board.get(index).setKor(nextInt(scanner, msg, SCORE_MIN, SCORE_MAX));
           printOne(index);
           
        } else if (userChoice == 2) {
            msg = "영어점수를 입력해주세요.";
            Board.get(index).setEng(nextInt(scanner, msg, SCORE_MIN, SCORE_MAX));
            printOne(index);

        } else if (userChoice == 3) {
            msg = "수학점수를 입력해주세요.";
            Board.get(index).setMath(nextInt(scanner, msg, SCORE_MIN, SCORE_MAX));
            printOne(index);

            // 되돌아가는 코드
                  
        } else if (userChoice == 4) {
            
            msg = "이름을 입력해주세요.";
            b.setName(nextLine(scanner, msg));
            Board.add(b); 

            // 되돌아가는 코드
            
        } else if (userChoice == 5) {
            printOne(index);
        }
    }

    public static void delete(int index) {
        String msg = new String("해당 게시물을 정말로 삭제하시겠습니까? 1. 예 2. 아니오");
        String yesNo = nextLine(scanner, msg);
        if(yesNo.equalsIgnoreCase("y")) {
           Board.remove(index);
           printAll();
        } else {
            printOne(index);
        }
    }
    
    
    // ScannerUtil 메소드
    public static void printMessage(String msg) {
        System.out.println(msg);
        System.out.print("> ");
    }
    
    public static int nextInt(Scanner scanner, String msg) {
        printMessage(msg);
        return scanner.nextInt();
    }
    
    public static int nextInt(Scanner scanner, String msg, int min, int max) {
       
        int temp = nextInt(scanner, msg);
        
        while(!(temp > min && temp < max)) {
            System.out.println("잘못입력하셨습니다.");
            System.out.println("다시 입력해주세요.");
            System.out.print("> ");
            temp = nextInt(scanner, msg);
        }
        
        return temp;
    }
    
    public static String nextLine(Scanner scanner, String msg) {
        printMessage(msg);
        
        String temp = scanner.nextLine();
        
        while(temp.isEmpty()) {
            temp = scanner.nextLine();
        }
        return temp;
    }
    

    public static void main(String[] args) {

        showMenu();
    }

}
