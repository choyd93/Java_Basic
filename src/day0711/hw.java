package day0711;
// 게시판 프로그램을 MVC 패턴을 적용시켜서 만드시오.
// 단, 회원과 관련된 기능은 넣지 않습니다. (로그인, 회원가입 없이)
import viewer.BoardViewer;

public class hw {
    public static void main(String[] args) {
        BoardViewer viewer = new BoardViewer();
        
        viewer.showMenu();
        
    }

}
