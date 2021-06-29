package day0628;
// 학생의 국어점수, 영어점수, 수학점수, 총점, 평균을 각각 알맞은 이름의 변수에
// 저장하고 출력하세요
// 결과)
// 국어점수
// 영어점수
// 수학점수
// 88
// 총점
// 264
// 평균
// 88.0

public class Ex11GradeBook {
    public static void main (String[] args) {

 // 국어점수
System.out.println("국어점수");
 int korean = 87;
 System.out.println(korean);
 // 영어점수
 System.out.println("영어점수");
 int english = 89;
 System.out.println(english);
 // 수학점수
 System.out.println("수학점수");
 int mathGrade = 88;
 System.out.println(mathGrade);

 System.out.println(korean + english + mathGrade);
 System.out.println((korean + english + mathGrade)/3);
 System.out.println((korean + english + mathGrade)/3f);
 //내가 한 코드 

 System.out.println("총점");
 int sum = 264;
 System.out.println(sum);
 
 System.out.println("평균");
double average = 88.0;
System.out.println(average);


    }
}
