package day0711;
// 우리가 MVC 패턴으로 구현한
// 학생관리 프로그램의 시작점.
// 단, 이 클래스에는
// 메인 메소드만 있고
// 그리고 메인 메소드는
// 스튜던트뷰어 객체 생성 후 
// showMenu() 메소드만 호출한다. 

import viewer.StudentViewer;

public class GradeBook {
    public static void main(String[] args) {
        StudentViewer viewer = new StudentViewer();
        viewer.showMenu();
        
    }
}
