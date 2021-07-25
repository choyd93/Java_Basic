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
   //<-- 데이터가 선언만 되있는 Board01 을 가져와서 
    
    public static void showMenu() {

        while (true) {
            System.out.println("     << 성적 처리 프로그램 >>");
            System.out.println("================================");
            System.out.println("--->   메뉴를 입력해주세요.");
            String msg = new String("1. 성적입력  2. 성적출력  3. 종료");
            System.out.println("================================");

            int userChoice = nextInt(scanner, msg, 0, 3); 
            if (userChoice == 1) {
                insert();
            } else if (userChoice == 2) {
                printAll();
            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            } 
        }
        scanner.close();
      }

    public static void insert() { 
        // 중요포인트! 구조체를 사용했으니 구조체 객체를 생성하고
        // 어레이 리스트 선언? <-- 전역변수라 필요없을까
        Board01 b = new Board01(); //<-- 구조체 객체 생성
        
        String msg;
               
        msg = "학번을 입력해주세요.";
        b.setId(nextInt(scanner, msg));
        
        for(int i = 0; i < Board.size(); i++) {
        while(Board.get(i).getId() == b.getId()) {
            System.out.println("동일한 학번이 존재합니다.");
            msg = "다시 학번을 입력해주세요.";
            b.setId(nextInt(scanner, msg));
            --i;
            }
        }
        
        msg = "성명을 입력해주세요.";
        b.setName(nextLine(scanner, msg)); //<- 구조체에 있는 이름에 세팅해줌.
        
        String str = b.getName(); // <- String 메소드를 사용하려면 변수를 String에 넣어서 선언
        while(!(str.matches(b.getName()))) { 
            System.out.println("문자를 입력해주세요.");
            msg = "성명을 다시 입력해주세요.";
            b.setName(nextLine(scanner, msg)); 
        }
        
        msg = "국어점수를 입력해주세요.";
        b.setKor(nextInt(scanner, msg, SCORE_MIN, SCORE_MAX)); 
        //<- 구조체에 있는 국어점수에 세팅

        msg = "영어점수를 입력해주세요.";
        b.setEng(nextInt(scanner, msg, SCORE_MIN, SCORE_MAX));

        msg = "수학점수를 입력해주세요.";
        b.setMath(nextInt(scanner, msg, SCORE_MIN, SCORE_MAX));

        Board.add(b); //<- 빈구조체 객체 b에 담긴 것을 모두 Board01에 추가해줌. 

        System.out.println(Board);
        System.out.println(Board.size());
    }

    // 학생의 목록 출력 <-- 여기 중요 
    public static void printAll() {
        
        if(Board.isEmpty()) { //<-- 입력된 정보가 존재하지 않을 시
            System.out.println("아직 입력된 정보가 존재하지 않습니다.");
        } else {
            System.out.println("=====================");
            System.out.println("    << 학생 성적 >> ");
            System.out.println("=====================");
            System.out.println("학번 | 이름");
            System.out.println("---------------------");
            for(int i = 0; i < Board.size(); i++)
                System.out.printf("%d.   %s\n", Board.get(i).getId(), Board.get(i).getName());
                // <- i번 번호. Board01에서 i번째에 있는 내용을 가져와서 이름만 가져온다.
        }
        
        String message = new String("상세보기할 학생의 번호나 뒤로 가실려면 0을 입력해주세요.");
        int userChoice = nextInt(scanner, message, 0, 100); //<-- -1을 왜하나 했더니 쓸모없는거였음.
        if (userChoice != -1) { //<-- 이거 왜그런걸까????
            printOne(userChoice);
        }
    }

    public static void printOne(int index) {
        
        for(int i = 0; i < Board.size(); i++) {
        if(Board.get(i).getId() == index){
            Board.get(i).printInfo();
        } else {
            System.out.println("잘못입력하셨습니다.");
        }
        }
        while (true) {
            System.out.println("============================");
            System.out.println("선택화면");
            String msg = new String("1. 검색 2. 추가 3. 수정 4. 삭제 5. 종료 ");
            System.out.println("============================");
            int userChoice = nextInt(scanner, msg, 0, 5);
            if (userChoice == 1) {
                research();
            } else if (userChoice == 2) {
                msg = new String("정말로 추가하시겠습니까? 1. 예 2. 아니오");
                String yesNo = nextLine(scanner, msg);

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
                printOne(index);
            } else if (userChoice == 5) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    public static void update(int index) {

        System.out.println("수정할 내용의 번호를 입력해주세요.");
        String msg = "1. 국어 2. 영어 3. 수학 4. 이름 5. 뒤로가기";
        int userChoice = nextInt(scanner, msg, 0, 5);
        
        Board01 b = new Board01();
        
        if(userChoice == 1) {
           msg = "국어점수를 입력해주세요.";
           
           for(int i = 0; i < Board.size(); i++) {
           if(index == Board.get(i).getId()) {
               Board.get(i).setKor(nextInt(scanner, msg, SCORE_MIN, SCORE_MAX));           
           }
           }
           Board.add(b);  
           System.out.println(Board);
           System.out.println("==========");
        
        }else if (userChoice == 2) {
            for(int i = 0; i < Board.size(); i++) {
                if(index == Board.get(i).getId()) {
                    Board.get(i).setEng(nextInt(scanner, msg, SCORE_MIN, SCORE_MAX));           
                }
                Board.add(b);   
             } 
        } else if (userChoice == 3) {
            for(int i = 0; i < Board.size(); i++) {
                if(index == Board.get(i).getId()) {
                    Board.get(i).setMath(nextInt(scanner, msg, SCORE_MIN, SCORE_MAX));           
                }
                Board.add(b);   
             }    
        } else if (userChoice == 4) {
            for(int i = 0; i < Board.size(); i++) {
                if(index == Board.get(i).getId()) {
                    Board.get(i).setName(nextLine(scanner, msg));           
                }
                Board.add(b);   
             } 
            
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
    
    public static void research() {
        
        if(Board.isEmpty()) {
            System.out.println("검색할 게시물이 존재하지 않습니다.");
            showMenu();
        }
        
        String msg = "1. 이름으로 검색 2. 학번으로 검색 3. 뒤로 가기";
        
        int userChoice = nextInt(scanner, msg, 0, 3);
        if(userChoice == 1) {
            msg = new String("조회할 이름을 입력해주세요.");
            String researchName = nextLine(scanner, msg);
            
            for(int i = 0; i < Board.size(); i++) {
            while(!(researchName.equalsIgnoreCase(Board.get(i).getName()))) {
                System.out.println("잘못 입력하셨습니다.");
                msg = new String("조회할 이름을 다시 입력해주세요.");
                researchName = nextLine(scanner, msg);
                i--; //
            } 
            printOne(i);
        }    
        } else if (userChoice == 2) {
            msg = new String("조회할 학번을 입력해주세요.");
            int researchId = nextInt(scanner, msg, 0, 100);
            
            while(true) {                    // <--이거 while 맞는지 다시확인. 
            for(int i = 0; i < Board.size(); i++) {
            if(researchId == Board.get(i).getId()) { //<- 
                printOne(researchId);
                } 
            }
                System.out.println("잘못입력하셨습니다.");  
                msg = new String("조회할 학번을 입력해주세요.");
                researchId = nextInt(scanner, msg); 
            }
            
        }else if (userChoice == 3) {
            showMenu();
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
