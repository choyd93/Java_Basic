package day0629;
// 여러분들이 직접 변수를 만들고 값을 넣어서 다음과 같은 모양으로
// 출력되는 프로그램을 작성하시오 (11시 5분까지)
// 결과)
// 이름 : ###
// 나이 : ##
// 국어 : ##
// 영어 : ##
// 수학 : ##
// 총점 : ##
// 평균 : ##, ###

public class GradeBook2 {
    public static void main(String[] args) {
       String name = "조영동";
       int age = 29;
       int korean = 90;
       int english = 85;
       int math = 80;
       int sum = korean + english + math;
       double average = (double)sum / 3;
       
       System.out.println("이름 : " + name);
       System.out.println("나이 : " + age);
       System.out.println("국어 : " + korean);
       System.out.println("영어 : " + english);
       System.out.println("수학 : " + math);
       System.out.println("총점 : " + sum);
       System.out.println("평균 : " + average);
       
       String average1 = "조영동";
       
    }
}
