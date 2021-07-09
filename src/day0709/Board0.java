package day0709;
// 게시판 프로그램을 작성하시오.

// 게시글에는
// 글 번호, 제목, 작성자, 내용이 들어가며
// 글 번호는 자동으로 부여됩니다. //<- 1. 동적 배열. 2이 배열이랑 상관이 있나
// 또한 목록보기 기능이 있으며 // PrintByIndex 메소드? 뒤로가기
// 목록보기 기능을 실행시에는 <- 2.
// 인덱스, 제목이 출력되며 <- 2.
// 개별 글 보기 기능이 있어야 합니다. <- 3.
// 또한 개별 글 수정/삭제 기능이 있어야 합니다. <- 4.
// 4시 20분까지
// 내가 한 버젼
// 번호 입력부터 오류가 남..

import java.util.Scanner;
import util.ScannerUtil;
import util.ArrayUtil;

public class Board0 {
    // 상수 선언
    // 총 저장 가능한 글의 갯수
    static final int BOARD_SIZE = 5;

    // <- 동적 배열이니까 이거는 뺴주면 될려나
    // 배열의 제목 인덱스
    // static final int INDEX_TITLE = 0;
    // 배열의 작성자 인덱스
    // static final int INDEX_WRITER = 1;
    // 배열의 내용 인덱스
    // static final int INDEX_CONTENT = 2;

    static final int NUMBER_MIN = 1;
    static final int NUMBER_MAX = 100;

    static Scanner scanner = new Scanner(System.in);

    // 배열 변수 선언
    static int[] idArray = new int[0];
    static String[] boardArray = new String[0];
    static String[] nameArray = new String[0];
    static String[] contentsArray = new String[0];
    static int index = 0;

    public static void main(String[] args) {

        showMenu();
    }

    public static void showMenu() {
        String message = "1. 입력 2. 출력 3. 종료"; // while 밖에 넣는 이유는?
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);

            if (userChoice == 1) {
                // 입력 코드 구현
                insert();

            } else if (userChoice == 2) {

                if (index > 0) {
                    // 출력 시작

                    // printAll(index, idArray, boardArray, nameArray, contentsArray);
                    print();

                } else {
                    // 경고 메시지도 메소드로 빼야되나
                    System.out.println();
                    System.out.println("-----------------------");
                    System.out.println("아직 등록된 게시글이 없습니다.");
                    System.out.println("-----------------------");
                    System.out.println();
                }
            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
            scanner.close();
        }
    }

    // 입력 메소드
    public static void insert() {
        int index = 0; // <- 전역변수?
        if (index < BOARD_SIZE) {
            String message = "번호를 입력하세요.";
            // <-- 여기 원래 이차배열이였는데 동적배열이니까 다시 1차배열로 바꾸는거 맞는지 확인하기
            idArray[index] = ScannerUtil.nextInt(scanner, message, NUMBER_MIN, NUMBER_MAX);

            // message = "제목을 입력하세요.";
            // boardArray[index] = ScannerUtil.nextLine(scanner, message);
            // <- 이렇게 바꾸는게 맞나? 뭐가 다른걸까 비교하기

            message = "제목을 입력하세요.";
            String board = ScannerUtil.nextLine(scanner, message);
            boardArray = ArrayUtil.add(boardArray, board);

            message = "작성자 이름을 입력하세요.";
            String name = ScannerUtil.nextLine(scanner, message);
            nameArray = ArrayUtil.add(nameArray, name);

            message = "내용을 입력하세요.";
            String contents = ScannerUtil.nextLine(scanner, message);
            contentsArray = ArrayUtil.add(nameArray, contents);

            // 인덱스 올라가는거 까먹지 않기
            index++;
        } else {
            System.out.println();
            System.out.println("---------------------");
            System.out.println("더이상 입력하실 수 없습니다.");
            System.out.println("---------------------");
            System.out.println();
        }
    }

    // 출력 메소드 <- GradeBook01에서는 파라미터가 없는데?
    // 이 메소드는 필요 없을듯?
    public static void printAll(int index, int[] idArray, String[] nameArray, String[] boardArray,
            String[] contentsArray) {
        for (int i = 0; i < index; i++) {
            System.out.println();

            System.out.println("---------------------");
            System.out.println("제목 : " + boardArray[i]);
            System.out.println("---------------------");
            System.out.printf("번호 : %d 작성자 : %s\n", idArray[i], boardArray[i]);
            System.out.println("---------------------");
            System.out.println(boardArray[i]);
            System.out.println();
        }
    }

    // 잘못 입력할 시 블록하는 메소드
    public static void print() {
        if (ArrayUtil.isEmpty(idArray)) {
            System.out.println("아직 입력된 학생이 존재하지 않습니다.");
        } else {
            for (int i = 0; i < idArray.length; i++) {
                System.out.println("아직 입력된 학생이 존재하지 않습니다.");
                System.out.printf("%d. %s\n", i + 1, nameArray[i]);
            }
            // 사용자로부터 몇번 인덱스의 학생을 볼지 입력을 받는다.
            // 단, 한가지 주의할 것은 사용자가 입력할 번호와
            // 실제 인덱스가 다르다라는 것이다.
            String message = "상세보기할 학생의 번호를 입력하세요.\n뒤로 가실려면 0을 눌러주세요.";
            // <-- 최대값은 배열의 크기가 됨. 이미 -1을 통해 1부터 시작했기 떄문. 응?
            int userChoice = // 0이라고 입력하면 -1 이 되는 것.
                    ScannerUtil.nextInt(scanner, message, 0, idArray.length) - 1;
            if (userChoice != -1) {
                printByIndex(userChoice); // 이렇게만 적어주면 뒤로가기 되는 것.
            }
        }
    }

    // 출력 및 뒤로가기와 수정 삭제 메소드
    // printAll 메소드를 이런 형식으로 바꾸면 될듯함.
    public static void printByIndex(int index) {
        int id = ArrayUtil.get(idArray, index);
        String name = ArrayUtil.get(nameArray, index);
        System.out.printf("번호 : %d번 이름 : %s\n", id, name);
        String board = ArrayUtil.get(boardArray, index);
        String contents = ArrayUtil.get(contentsArray, index);
        System.out.printf("제목 : %s \n 내용 : %s \n", board, contents);

        String message = "1. 수정 2. 삭제 3. 뒤로가기";
        int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);

        if (userChoice == 1) {
            // 수정 메소드 호출
            update(index);
        } else if (userChoice == 2) {
            // 삭제 메소드 호출
            delete(index);
        } else if (userChoice == 3) {
            print();
        }
    }

    // 수정하기 메소드
    public static void update(int index) {
        // 제목과 내용만 수정할 수 있게 해보자
        String message;
        message = "새로운 제목을 입력해주세요(기존 제목 : " + boardArray[index] + ")";
        boardArray[index] = ScannerUtil.nextLine(scanner, message);

        message = "새로운 내용을 입력해주세요(기존 내용 : " + contentsArray[index] + ")";
        contentsArray[index] = ScannerUtil.nextLine(scanner, message);
        printByIndex(index);

    }

    // 삭제하기 메소드
    public static void delete(int index) {
        // 사용자로부터 정말로 삭제할지 물어봐서
        // 1이라고 입력했을 떄에만 삭제하고 메뉴보기로 돌아간다.
        // 그외의 값은 무조건 동의하지 않은 걸로 보고
        // 다시 개별 보기로 돌아간다.
        String message = "정말로 삭제하시겠습니까? (1: 예 2: 아니오)";
        int userChoice = ScannerUtil.nextInt(scanner, message);
        if (userChoice == 1) {
            // 각 배열의 index번 칸을 삭제한 후에
            // 목록 보기로 돌아간다.
            idArray = ArrayUtil.remove(idArray, index);
            nameArray = ArrayUtil.remove(nameArray, index);
            boardArray = ArrayUtil.remove(boardArray, userChoice);
            contentsArray = ArrayUtil.remove(boardArray, userChoice);

            print();
        } else {
            // index번 학생 개별 보기로 돌아간다.
            printByIndex(index);
        }
    }

}
