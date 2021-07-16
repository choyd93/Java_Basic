package viewer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import model.ReplyDTO;
import model.UserDTO;
import controller.ReplyController;
import util.ScannerUtil;

public class ReplyViewer {

    private ReplyController replyController;
    private Scanner scanner;
    private UserViewer userViewer;
    private UserDTO logIn;

    // private int nextId = 1001;

    public ReplyViewer() {
        replyController = new ReplyController();
        scanner = new Scanner(System.in);
    }

    // 유저뷰어를 링크
    public void setUserViewer(UserViewer userViewer) {

    }

    // 로그인 링크
    public void setLogIn(UserDTO logIn) {
        this.logIn = logIn;
    }

    // 특정 댓글을 형식에 맞추어 출력하는 메소드
    private void printOne(int id) {
        ReplyDTO r = replyController.selectOne(id);
        System.out.println("------------------------");
        // 작성자 닉네임 : 내용 at시간의 형식으로 출력될 수 있게
        // printf를 작성한다.
        // 단, 작성자 닉네임의 경우, ReplyDTO 객체가 직접 값을
        // 가지고 있는 것이 아닐 작성자의 회원 번호를 가지고 있으므로
        // 그 회원번호를 토대로 해서 해당 회원의 정보를 가지고 올 수 있게
        // userViewer를 링크시켜야 한다.
        // 따라서 필드에 userViewer를 추가해주자.

        // 출력에 나올 닉네임 값을 저장할 String 객체
        String nickname;

        if (r.getWriterId() == 0) {
            // 해당 회원은 탈퇴한 회원이므로
            // nickname 의 값을 "탈퇴한 회원"으로 초기화
            nickname = new String("탈퇴한 회원");
        } else {
            UserDTO u = userViewer.selectById(r.getWriterId());
            nickname = u.getNickname();
        }

        // 날짜 출력시 어떤 형식인지를 저장한 String 객체
        String format = new String("M/d H:m:s");

        // 날짜를 형식에 맞추어 출력할 때 필요로 하는 SimpleDateFormat 객체
        SimpleDateFormat sdf = new SimpleDateFormat(format);

        System.out.printf("%d. %s : $s at %s\n", r.getReplyId(), nickname, r.getContent(),
                sdf.format(r.getWrittenDate().getTime()));
        System.out.println("------------------------");

    }

    // 파라미터로 넘어온 어레이리스트 객체의 댓글을 모두 출력해줄
    // printList(ArrayList)
    public void printList(ArrayList<ReplyDTO> list) {
        System.out.println("=========================");
        System.out.println("        댓글목록");
        System.out.println("=========================");
        System.out.println();

        if (list.isEmpty()) {
            System.out.println("아직 등록된 댓글이 없습니다.");
        } else {
            for (ReplyDTO r : list) {
                printOne(r.getReplyId());
            }
        }
        System.out.println("==========================");
    }

    // 댓글 삭제와 관련된 기능들
    // delete(ArrayList<ReplyDTO>)
    void delete(int boardId) {
        ArrayList<ReplyDTO> list = replyController.selectByBoardId(boardId);
        String msg = new String("삭제할 댓글의 번호가 없으면 0을 입력해주세요.");
        int userChoice = ScannerUtil.nextInt(scanner, msg);

        if (userChoice != 0) {
            ReplyDTO r = replyController.selectOne(userChoice);

            // 먼저 해당 댓글 번호가 유효한지 체크하고
            // 그리고 해당 댓글의 작성자가 로그인한 유저인지 체크하고
            // 마지막으로 해당 댓글이 파라미터 list에 속하는 댓글이 맞는지 체크
            if (r != null) {
                if (r.getWriterId() == logIn.getId()) {
                    if (list.contains(r)) {
                        msg = new String("정말로 삭제하시겠습니까? y/n");
                        String yesNo = ScannerUtil.nextLine(scanner, msg);
                        if(yesNo.equalsIgnoreCase("y")) {
                            replyController.delete(r.getReplyId());
                        }
                    }

                }
            }

        }

    }
    
    // 댓글 입력을 담당하는
    // insert(int) 메소드
    public void insert(int boardId) {
        // 값들을 담을 ReplyDTO 객체
        ReplyDTO r = new ReplyDTO();
        
        // r에 현재 게시글 번호를 저장한다.
        r.setBoardId(boardId);
        
        // r에 작성자 번호를 저장한다. 
        r.setWriterId(logIn.getId());
        
        // 입력할 때 출력할 메시지를 저장할 String 객체
        String msg = new String("내용을 입력해주세요.");
        String content = ScannerUtil.nextLine(scanner, msg);
        
        // r에 댓글의 내용을 저장한다.
        r.setContent(content);
        
        replyController.isert(r);
    }
    
    // 사용자 댓글만 출력하는 메소드 
    public void printUserReply(int writerId) {
        ArrayList<ReplyDTO> temp = replyController.selectByWriterId(writerId);
        printList(temp);
    }
    
    // 해당 게시글 댓글만 출력하는 메소드
    public void printBoardReply(int boardId) {
        ArrayList<ReplyDTO> temp =
                replyController.selectByBoardId(boardId);
        printList(temp);
    }
    
    // 회원탈퇴 시 해당 회원의 댓글 목록을 수정하는 메소드
    public void updateWriterId(int writerId) {
        replyController.updateWriterId(writerId);
    }
    
}









