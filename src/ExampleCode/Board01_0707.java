package ExampleCode;
// 게시판 프로그램을 작성하시오.

// 게시글에는 번호, 제목, 작성자, 내용의 정보가 들어가야 하고
// 이 프로그램은 총 5 개의 게시글을 관리할 수 있습니다.

// 3시 50분까지 (쉬는 시간 포함)

// 입력, 출력으로 나눠서 하는게 맞나

// 강사님 버젼

import java.util.Scanner;

import util.ScannerUtil;

public class Board01_0707 {
    // 상수 선언
    // 총 저장 가능한 글의 갯수
    static final int BOARD_SIZE = 5;

    // 배열의 제목 인덱스
    static final int INDEX_TITLE = 0;

    // 배열의 작성자 인덱스
    static final int INDEX_WRITER = 1;

    // 배열의 내용 인덱스
    static final int INDEX_CONTENT = 2;

    static final int NUMBER_MIN = 1;
    static final int NUMBER_MAX = 100;

    public static void main(String[] args) {

        // 변수 선언
        Scanner scanner = new Scanner(System.in);
        // 배열로 저장할 떄에는 이름 뒤에 Array 넣어주기
        // 번호 배열
        int[] idArray = new int[BOARD_SIZE];

        // 제목, 작성자, 내용 배열
        String[][] boardArray = new String[BOARD_SIZE][3];

        // 다음에 입력할 인덱스. <- 자주 까먹는 부분
        int index = 0;

        // 각종 입력 시 출력할 안내 문구를 저장할 String 변수. 메뉴 안에 들어가도 댐.
        // <- 자주 까먹는 부분
        String message;

        // 메뉴 구현
        while (true) {
            message = "1. 입력 2. 출력 3. 종료";
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);

            if (userChoice == 1) {
                // 입력 코드 구현
                // 여기를 넣는 방법을 주의
                if (index < BOARD_SIZE) {
                    message = "번호를 입력하세요.";
                    idArray[index] = ScannerUtil.nextInt(scanner, message, NUMBER_MIN, NUMBER_MAX);

                    // <- 이부분 기억하기
                    message = "제목을 입력하세요.";
                    boardArray[index][INDEX_TITLE] = ScannerUtil.nextLine(scanner, message);

                    message = "작성자 이름을 입력하세요.";
                    boardArray[index][INDEX_WRITER] = ScannerUtil.nextLine(scanner, message);

                    message = "내용을 입력하세요.";
                    boardArray[index][INDEX_CONTENT] = ScannerUtil.nextLine(scanner, message);

                    // 인덱스 올라가는거 까먹지 않기
                    index++;
                } else {
                    System.out.println();
                    System.out.println("---------------------");
                    System.out.println("더이상 입력하실 수 없습니다.");
                    System.out.println("---------------------");
                    System.out.println();

                }

                // 여기 알아보기
            } else if (userChoice == 2) {

                // index > 0 으로 시작하는 거 명심. 여기가 조금 약함.
                if (index > 0) {
                    // 출력 시작

                    printAll(index, idArray, boardArray);

                } else {
                    // 아직 입력된 게시글이 존재하지 않으므로
                    // 경s고 메시지만 출력
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
        }
        scanner.close();
    }

    public static void printAll(int index, int[] idArray, String[][] boardArray) {
        for (int i = 0; i < index; i++) {
            System.out.println();

            System.out.println("---------------------");
            System.out.println("제목 : " + boardArray[i][INDEX_TITLE]);
            System.out.println("---------------------");
            System.out.printf("번호 : %d 작성자 : %s\n", idArray[i], boardArray[i][INDEX_WRITER]);
            System.out.println("---------------------");
            System.out.println(boardArray[i][INDEX_CONTENT]);
            System.out.println();
        }
    }
}