package day0628;


public class Ex11GradeBook {
    public static void main (String[] args) {

    // 학생의 국어점수, 영어점수, 수학점수, 총점, 평균을 각각 알맞은 이름의 변수에
 // 저장하고 출력하세요
 // 결과)
 // 국어점수
 int korGrade = 87;
 // 영어점수
 int EngGrade = 89;
 // 수학점수
 int mathGrade = 88;
 // 88
 // 총점
 System.out.println(korGrade + EngGrade + mathGrade);
 // 264
 System.out.println((korGrade + EngGrade + mathGrade)/3);
 // 평균
 System.out.println((korGrade + EngGrade + mathGrade)/3f);
 // 88.0
    }
}
