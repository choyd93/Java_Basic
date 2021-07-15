package day0711;
// 여러분들이 클래스를 만들 때
// 많은 것들을 고려해야 하지만
// 객체지향적 관점에서
// 여러분들이 제일 중요하게 생각해볼 문제는
// 바로 단일책임원칙이다.
// 단일책임원칙이란, 해당 클래스가
// 하나만 책임져야한다는 것이다.
// 예를 들어서, 여러분들이 게시판 프로그램을 만들면서
// 로그인 시스템과 게시글 시스템을 융합한다고 가정해보자.
// 만약 단일책임원칙이 정확하게 지켜져 있다면,
// 여러분들이 추가적으로 유지보수를 하게 될때 수정해야할 범위가
// 매우 제한적이 되어서 유지보수가 쉬워진다.
// 만약 여러분들이 로그인과 관련된 UI를 수정한다면, 당연히 
// 로그인의 UI 담당 클래스만 수정하면 된다.
// 하지만 Board02.java 처럼 단일책임원칙이 지켜지지 않은 경우에는
// 우리가 손댈 곳이 많아지게 되고, 유지 보수가 어려워지게 된다.
// 로그인 코드를 고치기 위해서 우리는 게시판 전체를 관리하는 클래스를
// 고치게 되는 것이다.

// 사람들이 단일책임원칙을 지키기 위해 여러가지
// 프로그래밍 패턴을 만들었는데 
// 웹프로그래밍의 경우, MVC 패턴이라는 것을 사용하게 된다. 
// MVC패턴이란, 프로젝트를 크게 3가지 부분으로 나누는데
// M은 Model의 줄임말로써, 데이터를 담을 객체를 정의할 클래스를 말한다.
// V는 Viewer의 줄임말로써, 사용자가 보게될 화면을 뷰어라고 한다.
//    Viewer의 경우, 여러분들이 웹 프로젝트를 진행하게 되면, 웹페이지 그 자체가
//    뷰어가 담당할 수도 있지만, 우리는 콘솔에서 프로그래밍 하기 때문에
//    클래스로 뷰어를 담당하게 될 것이다.
// C는 Controller의 줄임말로써, 사용자가 뷰어에서 요청한 정보를 데이터베이스에서
//    처리해서, 그 결과를 뷰어로 보내주는 역할을 맡게 된다.
//    우리는 데이터베이스가 존재하지 않기 때문에, 컨트롤러 클래스 안에
//    private 필드로 ArrayList를 하나 만들어서
//    일종의 데이터베이스 처럼 다루게 될 것이다. 

public class Ex02Mvc {

}
