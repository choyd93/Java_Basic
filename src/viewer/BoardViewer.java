package viewer;

import java.util.Scanner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import model.BoardDTO;
import model.UserDTO;
import type.User;
import controller.BoardController;
import util.ScannerUtil;

public class BoardViewer {

    private BoardController boardController;
    private Scanner scanner;
    private UserDTO logIn; // 되는건가
    private UserViewer userViewer;
    private ReplyViewer replyViewer;

    private int nextId = 1001;

    // 보드뷰어 생성자 메소드
    public BoardViewer() {
        boardController = new BoardController();
        scanner = new Scanner(System.in);
    }

    public void setLogIn(UserDTO logIn) {
        this.logIn = logIn;
    }

    public void setUserViewer(UserViewer userViewer) {
        this.userViewer = userViewer;
    }

    public void setReplyViewer(ReplyViewer replyViewer) {
        this.replyViewer = replyViewer;
    }

    public void showMenu() {
        String msg = new String("1. 새 글 등록 2. 목록보기 3. 종료");
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, msg, 1, 3);
            if (userChoice == 1) {
                write();
            } else if (userChoice == 2) {
                printAll();
            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    private void write() {
        String msg;

        BoardDTO b = new BoardDTO();

        msg = new String("제목을 입력해주세요.");
        b.setTitle(ScannerUtil.nextLine(scanner, msg));

        b.setWriterId(logIn.getId());

        msg = new String("내용을 입력해주세요.");
        String content = ScannerUtil.nextLine(scanner, msg);
        b.setContent(content);

        int id = boardController.insert(b);
        printOne(id);
    }

    public void printAll() { // 토탈 5. 출력관련 코드 삭제

        ArrayList<BoardDTO> boardList = boardController.selectAll();

        printList(boardList); // 토탈 5. 출력부분 지우고 이 부분 추가

        String msg;
        if (boardList.isEmpty()) {
            msg = new String("1. 새글 쓰기 2. 뒤로가기");
        } else {
            msg = new String("1. 새글 쓰기 2. 게시글 개별보기 3. 뒤로");
        }
        int userChoice = ScannerUtil.nextInt(scanner, msg);

        if (userChoice == 1) {
            // 사용자가 글쓰기를 골랐을 경우, 새글쓰기 메소드인
            // write()를 실행시킨다.
            write();
        } else if (!boardList.isEmpty() && userChoice == 2) {
            // 글목록이 저장되어 있는 boardList의 isEmpty()가 true가 아니고
            // 사용자가 2를 골랐을 경우에는
            // 사용자가 게시글 개별보기를 선택한 경우이므로
            // 상세보기할 게시글 번호를 입력받는다.
            int userInput = validateId();
            if (userInput != 0) {
                printOne(userInput);
            }
        }
    }

    // <-- 토탈 5. (3)
    public void printUserBoard(int writerid) {
        ArrayList<BoardDTO> temp = boardController.selectByWriterId(writerid);

        printList(temp);
    }

    // 파라미터로 들어온 어레이리스트를 '출력만' 해주는 <-- 토탈 5. 메소드
    // printList(ArrayList<BoardDTO> list
    public void printList(ArrayList<BoardDTO> list) {
        System.out.println("========================================");
        System.out.println();
        if (list.isEmpty()) {
            System.out.println("아직 등록된 글이 없습니다.");
        } else {
            for (BoardDTO e : list) {
                UserDTO u = userViewer.selectById(e.getWriterId());
                System.out.printf("%d. %s\n", e.getId(), e.getTitle(), u.getNickname());

            }
        }
        System.out.println();
        System.out.println("========================================");
    }

    private int validateId() {
        String message = new String("상세보기할 글의 번호를 입력해주시거나 뒤로 가실려면 0을 입력해주세요.");
        int userInput = ScannerUtil.nextInt(scanner, message);

        while (userInput != 0 && boardController.selectOne(userInput) == null) {
            System.out.println("해당 글 번호는 유효하지 않습니다.");
            userInput = ScannerUtil.nextInt(scanner, message);
        }
        return userInput;
    }

    // printOne()
    public void showBoardMenu(int id) {

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
    private void update(int id) {

        // 입력시 출력할 메시지를 저장할 변수
        String message;

        // 제목을 입력 받는다.
        message = "새로운 제목을 입력해주세요.";
        String title = (ScannerUtil.nextLine(scanner, message));

        // 내용을 입력 받는다.
        message = "새로운 내용을 입력해주세요.";
        String content = (ScannerUtil.nextLine(scanner, message));

        message = new String("정말로 수정하시겠습니까? y/n");
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("y")) {
            BoardDTO b = new BoardDTO();

            b.setId(id);
            b.setTitle(title);
            b.setContent(content);
            boardController.update(b);
        }

        printOne(id);
    }

    // delete()
    private void delete(int id) {
        String msg = new String("정말로 삭제하시겠습니까? (y/n)");
        String yesNo = ScannerUtil.nextLine(scanner, msg);
        // 토탈 6. (3)
        if (yesNo.equalsIgnoreCase("y")) {
            boardController.delete(id);
            printAll();
        } else {
            printOne(id);
        }
    }

    public void printOne(int id) {
        BoardDTO b = boardController.selectOne(id);
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m:s");
        System.out.println("=================================");
        System.out.println("제목 : " + b.getTitle());
        System.out.println("---------------------------------");
        UserDTO u = userViewer.selectById(b.getWriterId());
        System.out.printf("번호 : %03d번 작성자 : %s\n", b.getId(), u.getNickname());
        System.out.printf("작성일 : " + sdf.format(b.getWrittenDate().getTime()));
        System.out.printf("\n수정일 : " + sdf.format(b.getUpdatedDate().getTime()));
        System.out.printf("\n-----------------------------------");
        System.out.println();
        System.out.println("내용 : " + b.getContent());
        System.out.println("=================================");

        // 해당 게시글에 달린 댓글을 쭉 출력한다.
        replyViewer.printBoardReply(id);

        // 만약 로그인 한 유저가 해당 글의 작성자와 일치하는 경우,
        // 글 수정, 삭제 기능을 실행시킬 수 있는
        // showBoardMenu() 메소드를 실행시킨다.
        // 아닐 경우에는 " 1. 뒤로가기"를 출력해서
        // 사용자가 목록으로 돌아가기만 가능하게 만들어준다.

        if (b.getWriterId() == logIn.getId()) {
            showBoardMenu(id);
        } else {
            String msg = new String("1. 댓글 입력 2. 댓글 삭제 3. 뒤로가기");
            int userChoice = ScannerUtil.nextInt(scanner, msg, 1, 3);
            if(userChoice == 1) {
                // 댓글 입력을 담당하는
                // replyViewer의 메소드 실행
                replyViewer.insert(id);
            }else if(userChoice == 2) {
                // 댓글 삭제를 담당하는
                // replyViewer의 메소드 실행
                replyViewer.delete(id);
            } 
            if(userChoice != 3) {
                printOne(id);
            }
        }
    }

    // 토탈 6.1 (2)
    public void deleteByWriterId(int writerId) {
        boardController.deleteByWriterId(writerId);
    }
}
