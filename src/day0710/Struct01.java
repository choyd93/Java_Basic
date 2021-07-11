package day0710;

import type.Board; // <- 

public class Struct01 { //보드 만들기
    
    public static void main(String[] args) {
        // 우리가 만든 student.java를 사용하여
        // 변수를 만들어보자
        Board s = new Board();
        
        // Student 클래스 변수 s에 값을 입력해보자
        s.id = 1;
        s.name = "조재영";
        s.korean = 80;
        s.english =  79;
        s.math = 80;
        
        // Student 클래스 변수 s를 printf로 출력해보자 
        System.out.printf("번호 : %03d번 이름 : %s\n", s.id, s.name);
        System.out.printf("국어 : %03d점 영어 : %03d점 수학 : %03d점\n", 
                       s.korean, s.english, s.math);
       
        // Student 클래스 변수를 하나 더 만들어보자
        Student s2 = new Student();
        s2.id = 2;
        s2.name = "김철수";
        s2.korean = 70;
        s2.english =  80;
        s2.math = 81;
        
        // Student 클래스 변수 s2를 printf로 출력해보자 
        System.out.printf("번호 : %03d번 이름 : %s\n", s2.id, s2.name);
        System.out.printf("국어 : %03d점 영어 : %03d점 수학 : %03d점\n", 
                       s2.korean, s2.english, s2.math);
        
        // Student 클래스의 배열을 만들어보자 
        Student[] arr = new Student[3];
       
        arr[0] = new Student(); // <- 이거 추가하면 null 에러 x 
        arr[0].id = 30;
        arr[0].name = "30번 학생";
        arr[0].korean = 30;
        arr[0].english =  31;
        arr[0].math = 32;
        
        // arr[0].name을 출력해보자.
        System.out.println("arr[0].name : " + arr[0].name);
        
        // Student 변수끼리의 실제 값 비교를 해보자
        
        s.id = 1;
        s.name = "a";
        s.korean = 10;
        s.english = 10;
        s.math = 10;
        
        s2.id = 1;
        s2.name = "a";
        s2.korean = 10;
        s2.english = 10;
        s2.math = 10;
        
        System.out.println("s == s2: " + (s == s2));
        System.out.println("s.equals(s2) : " + s.equals(s2));
        
    }

}
