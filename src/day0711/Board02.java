package day0711;
// 게시판에 회원 기능까지 추가한 버젼

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.Scanner;

import type.Board;
import type.User;
import util.ScannerUtil;

public class Board02 {

    // 배열 전역 변수
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Board> boardList = new ArrayList<>();
    private static ArrayList<User> userList = new ArrayList<>();
    private static User LogIn = null;

    private static int nextBoardId = 1001;
    private static int nextUserId = 1;

    public static void main(String[] args) {
        // 메뉴창 출력을 담당하는 메소드 호출
        index();
    }

    private static void index() {
        String message = new String("1. 로그인 2. 회원가입 3. 종료");
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
            if (userChoice == 1) {
                // 로그인 메소드 호출
                // 해당 메소드는 User 객체 logIn에 
                // 로그인 성공 시에 값을 저장한다.
                // 만약 저장된 값이 null 이면 아무것도 하지 않지만
                // 그 외의 경우에는 showMenu 메소드를 실행시킨다. 
                
                logIn();
                if(LogIn != null) {
                    showMenu();
                }
            } else if (userChoice == 2) {
                // 회원가입 메소드 호출
                register();
                
            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
        scanner.close();
    }
    
    private static void logIn() {  
        String message = new String ("ID : ");
        String username = ScannerUtil.nextLine(scanner, message);
        
        message = new String("PW : ");
        String password = ScannerUtil.nextLine(scanner, message);
        
        while(validate(username, password) == null) {
            System.out.println("일치하는 회원이 없습니다.");
            System.out.println();
            String yesNo = ScannerUtil.nextLine(scanner, "다시 시도하시겠습니까? y/n");
            
            if(yesNo.equalsIgnoreCase("n")) {
                break;
            }
            username = ScannerUtil.nextLine(scanner, "ID : ");
            password = ScannerUtil.nextLine(scanner, "PW : ");
        }
        
        LogIn = validate(username, password);
    }
    
    private static User validate(String username, String password) {
        for(int i = 0; i < userList.size(); i++) {
            if(userList.get(i).auth(username, password)) {
                return userList.get(i);
            }
        }
        return null;
    }
    
    
    private static void register() {
        User u = new User();
        
     // 입력 시 출력할 메시지를 저장할 변수
        String message;
        
        u.setId(nextUserId);
        
        // id 입력
        message = new String("ID를 입력해주세요.");
        String username = ScannerUtil.nextLine(scanner, message);
       
        // 해당 아이디가 중복인지 체크
        while(validateUsername(username)) {
            System.out.println("중복된 ID는 사용하실 수 없습니다.");
            System.out.println("만약 가입을 원하시지 않으면 -1을 입력해주세요.");
            username = ScannerUtil.nextLine(scanner, message);
            if(username.equals("-1")) {
                break;
            }
        }        
            // 패스워드 입력
            message = new String("PW를 입력해주세요.");
            String password = ScannerUtil.nextLine(scanner, message);
            
            // 닉네임 입력
            message = new String("사용하고자 하는 닉네임을 입력해주세요.");
            String nickname = ScannerUtil.nextLine(scanner, message);
            
            u.setUsername(username);
            u.setPassword(password);
            u.setNickname(nickname);
            
            // userList 추가
            userList.add(u);
        }
        

   private static boolean validateUsername(String username) {
       //for(int i = 0; i < userList.size(); i++) {
       //    User u = userList.get(i);
       //    if(u.getUsername().equals(u))
       //}
       
       // 위의 for 문을 짧게 줄여서 쓰는 방법이 있는데
       // forEach 문이라고 부른다.
       // 단, 실제 리스트의 크기가 변경되거나 하면 에러가 발생하므로
       // 단순 값 비교나 출력에 사용하면 편하다.
       
       // forEach 문은 다음과 같은 구조를 가진다.
       // for(클래스 객체이름 : 리스트와 같이 모여있는 객체){
       //
       // }
       for(User u : userList) {
           if(u.getUsername().equals(username)) {
               return true;
           }
           
       }       
       
       return false;
   }

    // 메뉴창 출력을 담당하는 메소드
    public static void showMenu() {
        String message = "1. 새 글 등록  2. 글 목록 보기 3. 로그아웃";
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
                System.out.println("로그아웃 되셨습니다.");
                LogIn = null;
                break;
            }
        }
    }

    // 새 글 쓰기를 담당하는 write()
    public static void write() {
        Board e = new Board();
        
        // 입력 시 출력할 메시지를 저장할 변수
        String message;
        
        // 번호 등록   
        message = new String("번호를 입력해주세요.");
        e.setId(nextBoardId++);
        
        // 제목 등록
        message = "새 글의 제목을 입력해주세요.";
        e.setTitle(ScannerUtil.nextLine(scanner, message));
        
        // 작성자 등록
        e.setWriterId(LogIn.getId());
        
        // 내용 등록
        message = new String("글의 내용을 입력해주세요.");
        e.setContent(ScannerUtil.nextLine(scanner, message));
        
        // 글 작성시간 등록
        e.setWrittenDate(Calendar.getInstance());
        
        // 글 수정시간 등록 
        e.setUpdatedDate(Calendar.getInstance());    
        
        boardList.add(e);
    }

    // printAll()
    private static void printAll() {
        if (boardList.isEmpty()) {
            System.out.println("아직 등록된 글이 존재하지 않습니다.");
        } else {
            for (int i = 0; i < boardList.size(); i++) {
                Board e = boardList.get(i);
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
        if(boardList.contains(e)) {
            return boardList.get(boardList.indexOf(e));
        }    
        return null;
    }

    // printOne()
    public static void printOne(int id) {
        // 파라미터로 들어온 id 값을 사용하여
        // 일치하는 Employee 객체를 불러온다.
        Board e = selectById(id); // <- 이걸 왜 이런식으로 불러오나
        printInfo(e);
        // e.printInfo(); <- 이제 이게 아님.
        
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
        String yesNo = ScannerUtil.nextLine(scanner, msg);

        if (yesNo.equalsIgnoreCase("y")) {
            boardList.remove(e);
            printAll();
        } else {
            printOne(id);
        }
    }
    
    public static User selectUserById(int id) {
        User u = new User();
        u.setId(id);
        for(User origin : userList) {
            if(u.equals(origin)) {
                return origin;
            }
        }
        
        return null;
    }
    
    public static void printInfo(Board b) {
        SimpleDateFormat sdf = new SimpleDateFormat("y-m-d H:m:s");
        System.out.println("=================================");
        System.out.println("제목 : " + b.getTitle());
        System.out.println("---------------------------------");
        User u = selectUserById(b.getWriterId());
        System.out.printf("번호 : %03d번 작성자 : %s\n", b.getId(), u.getNickname());
        System.out.printf("번호 : %03d번 작성자 : %s\n", b.getId(), b.getWriterId());

        System.out.printf("작성일 : " + sdf.format(b.getWrittenDate().getTime()));
        System.out.printf("\n수정일 : " + sdf.format(b.getUpdatedDate().getTime()));
        System.out.printf("\n-----------------------------------");
        System.out.println();
        System.out.println("내용 : " +b.getContent());
        System.out.println("=================================");

    }
}