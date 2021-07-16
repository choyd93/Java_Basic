package viewer;

import java.util.Scanner;
import java.util.Calendar;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

import model.UserDTO;
import controller.UserController;
import util.ScannerUtil;

public class UserViewer {

    private UserController userController;
    private Scanner scanner;
    private UserDTO logIn;
    private BoardViewer boardViewer; //토탈 2.
    private ReplyViewer replyViewer;

    private int nextUserId = 1;

    public UserViewer() {
        userController = new UserController();
        scanner = new Scanner(System.in);
    }
    
    // 토탈 3.
    public void setBoardViewer(BoardViewer boardViewer) {
        this.boardViewer = boardViewer;
    }
    
    public void setReplyViewer(ReplyViewer replyViewer) {
        this.replyViewer = replyViewer;
    }

    public void index() {
        String msg = new String("1. 로그인 2. 회원가입 3. 종료");
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, msg, 1, 3);
            if (userChoice == 1) {
                logIn();
            } else if (userChoice == 2) {
                register();
            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                scanner.close();
                break;
            }
        }
    }

    public void register() {
        UserDTO u = new UserDTO();

        String msg;

        u.setId(nextUserId);

        // 사용할 username 입력
        msg = new String("사용하실 ID를 입력해주세요.");
        String username = ScannerUtil.nextLine(scanner, msg);

        // username 검증
        while (userController.validateUsername(username)) {
            System.out.println("중복된 ID는 사용하실 수 없습니다.");
            System.out.println("만약 가입을 원하시지 않으면 x을 입력해주세요.");
            username = ScannerUtil.nextLine(scanner, msg);
            if (username.equalsIgnoreCase("x")) {
                break;
            }
        }
        // 사용할 비밀번호 입력
        msg = new String("PW를 입력해주세요.");
        String password = ScannerUtil.nextLine(scanner, msg);

        // 사용할 닉네임 입력
        msg = new String("사용하고자 하는 닉네임을 입력해주세요.");
        String nickname = ScannerUtil.nextLine(scanner, msg);

        u.setUsername(username);
        u.setPassword(password);
        u.setNickname(nickname);

        u.setWrittenDate(Calendar.getInstance());
        u.setUpdatedDate(Calendar.getInstance());

        // 컨트롤러에 u 추가
        userController.insert(u);

    }


    public UserDTO logIn() {
        String msg;
        msg = new String("ID : ");
        String username = ScannerUtil.nextLine(scanner, msg);

        msg = new String("PW : ");
        String password = ScannerUtil.nextLine(scanner, msg);

        // 일치하는 회원이 나올때까지
        // 다시 username과 password를 입력받거나
        // 아니면 사용자가 더이상 로그인을 원하지 않는지 입력받는다.
        while (userController.logIn(username, password) == null) {
            System.out.println("일치하는 회원이 없습니다.");
            System.out.println("아이디와 비밀번호를 다시 확인해주세요.");
            
            msg = new String("아이디를 입력하시거나 뒤로 가실려면 x를 눌러주세요.");
            username = ScannerUtil.nextLine(scanner, msg);
            
            if (username.equalsIgnoreCase("x")) {
                break;
            }
            
            msg = new String("비밀번호를 입력해주세요.");
            password = ScannerUtil.nextLine(scanner, msg);
           
        }
        
        if(!(username.equalsIgnoreCase("x"))) {
            // 사용자가 로그인을 원하고 일치하는 회원이 나왔을 경우
            // 해당 회원으로 UserDTO logIn 객체를 초기화한다. 
            return userController.logIn(username, password);

        }
        return null;
     }
    

    // 4. 토탈 쇼메뉴 삭제
    
      
    public UserDTO printOne(int id) { // 4. 토탈 int id, public 추가 
        UserDTO u = userController.selectOne(id); //4. 토탈 <- 추가
        System.out.println("----------------------------------");
        System.out.println("회원 번호: " + u.getId());
        System.out.println("회원 아이디: " + u.getUsername());
        System.out.println("회원 닉네임: " + u.getNickname());
        System.out.println("----------------------------------");
        String msg = new String("1. 작성글 보기  2. 작성댓글 보기 3. 수정  4. 회원탈퇴  4. 뒤로가기"); 
        // <- 4. 토탈 작성글보기 추가 
        
        int userChoice = ScannerUtil.nextInt(scanner, msg, 1, 4);
        if (userChoice == 1) {
            boardViewer.printUserBoard(id); // 토탈 5. (4)
        } else if (userChoice == 2) {
            replyViewer.printUserReply(id);
        } else if (userChoice == 3) { 
            update(id);
        }  else if (userChoice == 3) { 
            u = delete(id);
        } 
        
        return u;
    }
    
    private void update(int id) {
        String msg = new String("비밀번호를 수정하시겠습니까? y/n");
        String yesNo = ScannerUtil.nextLine(scanner, msg);
        String password = new String();
        if(yesNo.equalsIgnoreCase("y")) {
            msg = new String("새로운 비밀번호를 입력해주세요.");
            password = ScannerUtil.nextLine(scanner, msg);
        }
        msg = new String("닉네임을 수정하시겠습니까? y/n");
        yesNo = ScannerUtil.nextLine(scanner, msg);
        String nickname = new String();
        if(yesNo.equalsIgnoreCase("y")) {
            msg = new String("새로운 닉네임을 입력해주세요.");
            nickname = ScannerUtil.nextLine(scanner, msg);
        }
        
        msg = new String("입력하신 정보로 수정하시겠습니까? y/n");
        yesNo = ScannerUtil.nextLine(scanner, msg);
        if(yesNo.equalsIgnoreCase("y")) {
            UserDTO u = userController.selectOne(id);
            
            if(!password.isEmpty()) {
                u.setPassword(password);
            }
            
            if(!nickname.isEmpty()) {
                u.setNickname(nickname);     
            }
            userController.update(u);

        }
    }
       private UserDTO delete(int id) {
           String msg = new String("정말로 탈퇴하시겠습니까? y/n");
           String yesNo = ScannerUtil.nextLine(scanner, msg);
           if(yesNo.equalsIgnoreCase("y")) {
               // < ----토탈 6.1
               // 해당 회원번호를 작성자 회원번호로 가진
               // 게시글 삭제를 할 메소드를 여기서 실행시킨다. 
               boardViewer.deleteByWriterId(id);
               userController.delete(id);
               return null;
           }
           return userController.selectOne(id);
       }
        
      
      public UserDTO selectById(int id) {
          return userController.selectOne(id);
      }
        
    }
















