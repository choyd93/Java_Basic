package day0711;
// 게시판 프로그램에 입력날짜와 수정날짜를 추가하여 Board.java를 개조하여
// 사용자가 글을 입력하면 자동으로 입력날짜 수정날짜가 입력시간으로 입력이 되고
// 사용자가 해당 글을 수정하면 자동으로 수정날짜가 수정시간으로 바뀌게 프로그램을 만드시오
// 단, 주요 기능들 중 글 개별 보기나 수정 삭제는 인덱스가 아닌 글 번호로 접근하고
// 그외 기능들은 기존 프로그램에서 복사 붙여넣기 하셔도 됩니다.


import java.util.ArrayList;

import java.util.Calendar;
import java.util.Scanner;

import type.Board;
import type.EmplyManage;
import util.ArrayUtil;
import util.ScannerUtil;

public class Board01 {
    // 상수 선언
    // 총 저장 가능한 글의 갯수
    private static final int BOARD_SIZE = 5;
    private static final int NUMBER_MIN = 1;
    private static final int NUMBER_MAX = 100;

    // 배열 전역 변수
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList <Board> list = new ArrayList<>();

    // 다음 입력된 글의 번호를 저장할 int 변수 <- 이게 뭘까
    private static int currentId = 1001;

    public static void main(String[] args) {
        // 메뉴창 출력을 담당하는 메소드 호출
        showMenu();
    }

    // 메뉴창 출력을 담당하는 메소드
    public static void showMenu() {
        String message = "1. 새 글 등록  2. 글 목록 보기 3. 종료";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);

            // 사용자의 입력에 따라 각각의 메소드를 호출한다.
            if (userChoice == 1) {
                // 새 글 등록을 담당하는 메소드 호출
                write();
            } else if (userChoice == 2) {
                // 목록 보기를 담당하는 메소드 호출
                printAll();
            } else if (userChoice == 3) {
                // 사용자에게 메시지 출력 후 종료
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
        scanner.close();
    }

    // 새 글 쓰기를 담당하는 write()
    public static void write() {
        Board e = new Board();
        
        // 입력 시 출력할 메시지를 저장할 변수
        String message;
        
        // 번호 등록   
        e.setId(currentId++);
        
        // 제목 등록
        message = "새 글의 제목을 입력해주세요.";
        e.setTitle(ScannerUtil.nextLine(scanner, message));
        
        // 작성자 등록
        message = "글의 작성자를 입력해주세요.";
        e.setwriter(ScannerUtil.nextLine(scanner, message));
        
        // 내용 등록
        message = "글의 내용을 입력해주세요.";
        e.setContent(ScannerUtil.nextLine(scanner, message));
        
        // 글 작성시간 등록
        e.setWrittenDate(Calendar.getInstance());
        
        // 글 수정시간 등록 
        e.setUpdatedDate(Calendar.getInstance());    
        
        list.add(e);
    }
        
    // printAll()
    private static void printAll() {
        if (list.isEmpty()) {
            System.out.println("아직 등록된 글이 존재하지 않습니다.");
        } else {
            for (int i = 0; i < list.size(); i++) {
                Board e = list.get(i);
                System.out.printf("%d번 글 , %s\n", e.getId(), e.getTitle());
            }
            
            String msg = "상세보기할 사원의 번호를 입력해주세요. (0은 뒤로가기)";

            int userChoice = ScannerUtil.nextInt(scanner, msg);
            
            while(selectById(userChoice) == null && userChoice != 0) {
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(scanner, msg);
            
            }
            if(userChoice != 0) {
                printOne(userChoice);
            }
        }
    }
    
    // 사용자가 입력한 사원 번호와 일치하는 리스트의 객체를
    // 리턴해주는 메소드.
    // 단, 일치하는 사원이 존재하지 않을 때에는
    // null 을 리턴해준다.
    
    private static Board selectById(int id) {
        Board e = new Board();
        e.setId(id);
        if(list.contains(e)) {
            return list.get(list.indexOf(e));
        }    
        return null;
    }
    
    // printOne()
    public static void printOne(int id) {
        // 파라미터로 들어온 id 값을 사용하여
        // 일치하는 Employee 객체를 불러온다.
        Board e = selectById(id); // <- 이걸 왜 이런식으로 불러오나

        e.printInfo();
        
        String msg = new String("1. 수정 2. 삭제 3. 뒤로가기");
        int userChoice = ScannerUtil.nextInt(scanner, msg, 1, 3);
        if (userChoice == 1) {
            update(id);
        } else if (userChoice == 2) {
            delete(id);
        } else if (userChoice == 3) {
            printAll();
        }

    }

    // 수정을 담당하는 update(index)
    private static void update(int id) {
        
        Board e = selectById(id);

        // 글을 수정할 때에는
        // 번호와 작성자는 수정되선 안되므로
        // 제목과 내용만 새로 입력을 받아서 저장한다.

        // 입력시 출력할 메시지를 저장할 변수
        String message;

        // 제목을 입력 받는다.
        message = "새로운 제목을 입력해주세요.";
        e.setTitle(ScannerUtil.nextLine(scanner, message));

        // 내용을 입력 받는다.
        message = "새로운 내용을 입력해주세요.";
        e.setContent(ScannerUtil.nextLine(scanner, message));
        
        // 수정 시간 수정 
        e.setUpdatedDate(Calendar.getInstance());
        
        // 수정 후 해당 인덱스의 개별 글 보기를 실행해서
        // 수정 결과를 볼 수 있게 메소드를 호출한다.
        printOne(id);
    }

 // delete()
    private static void delete(int id) {
        Board e = selectById(id);
        String msg = "정말로 삭제하시겠습니까? (y/n)";
        int userChoice = ScannerUtil.nextInt(scanner, msg, 1, 2);
        if (userChoice == 1) {
            list.remove(e);
            printAll();
        } else {
            printOne(id);
        }
    }
}