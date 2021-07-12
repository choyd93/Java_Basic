package day0710;

// Student 클래스 객체를 사용한
// 학생관리 프로그램

import java.util.Scanner;
import type.Student;
import util.ArrayUtil;
import util.ScannerUtil;

public class GradeBook02 {
    static final int SUBJECT_SIZE = 3;
    static final int SCORE_MIN = 0;
    static final int SCORE_MAX = 100;

    static Student[] arr = new Student[0];

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         
        // 입력 시 출력할 메시지
        String message;
        
        // 사용자가 입력한 값을 저장한 Student 객체 
        Student s = new Student();
        
        message = new String("학생의 이름을 입력해주세요.");
        //s.name = ScannerUtil.nextInt(scanner, message);
        s.setName(ScannerUtil.nextLine(scanner, message));
        
        message = new String("학생의 번호를 입력해주세요.");
        //s.id = ScannerUtil.nextInt(scanner, message);
        s.setId(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));
        
        message = new String("학생의 국어점수를 입력해주세요.");
        //s.korean = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
        s.setKorean(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));
        
        message = new String("학생의 영어점수를 입력해주세요.");
        //s.english = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
        s.setEnglish(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));
        
        message = new String("학생의 수학점수를 입력해주세요.");
        //s.math = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
        s.setMath(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));
        
        s.printInfo();
        
    }
}
