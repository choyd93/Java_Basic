package day0701;

import java.util.Scanner;

//사용자로부터

//번호, 이름, 국어 점수, 영어 점수, 수학 점수를 차례대로 입력 받아서
//다음과 같은 형식에 맞추어 출력하는 프로그램을 작성하시오

//단 사용자가 1~10 사이가 아닌 번호를 입력하거나
//올바르지 않은 점수를 입력하면 
//올바른 값이 입력될때까지 다시 입력을 하도록 코드를 작성하시오

//출력 결과
//번호: ##번 이름: ###
//국어: ###점 영어: ###점 수학: ###점
//총점: ###점 평균: ###.##점

import java.util.Scanner;

public class GradeBook01 {
    public static void main(String[] args) {
        // 프로그램에 사용할 상수를 선언
        // 1. 번호 최소값
        final int ID_MIN = 1;
        // 2. 번호 최대값
        final int ID_MAX = 10;
        // 3. 점수 최소값
        final int SCORE_MIN = 0;
        // 4. 점수 최대값
        final int SCORE_MAX = 100;
        
        Scanner scanner = new Scanner(System.in);
        
        // 정수 입력값을 임시로 저장할
        // int 변수
        int input;
        
        // 출력 시 사용자에게 안내할 문구를 저장할
        // String 변수
        String message;
        
        // 1. 번호를 입력받는다. 
        message = "번호를 입력해주세요.";    
        System.out.println(message);
        System.out.print("> ");
        input = scanner.nextInt();
        
        while (input <= 0 || input >= 10) {
            System.out.println("잘못된 입력값입니다.");
            System.out.print("> ");
            input = scanner.nextInt();
        } 
        
        int id = input;
        
        // 2. 이름을 입력받는다. 
        message = "이름을 입력해주세요.";
        System.out.println(message);
        System.out.print("> ");
        scanner.nextLine(); // 버퍼메모리 비우기?
        String name = scanner.nextLine();
        
        // 3. 국어 점수를 입력받는다. 
        message = "국어 점수를 입력해주세요.";
        System.out.println(message);
        System.out.print("> ");
        input = scanner.nextInt();
        
        while (input <= SCORE_MIN && input >= SCORE_MAX) {
            System.out.println("잘못 입력하셨습니다.");
            System.out.println(message);
            System.out.print("> ");
            input = scanner.nextInt();
        } 
        int korean = input;
        
        // 4. 영어 점수를 입력받는다. 
        System.out.println("영어점수를 입력하세요.");
        System.out.print("> ");
        input = scanner.nextInt();
        
        while (input <= SCORE_MIN && input >= SCORE_MAX) {
            System.out.println("잘못된 입력값입니다.");
            System.out.print("> ");
            input = scanner.nextInt();
        } 
        int english = input;
        
        // 5. 수학 점수를 입력받는다. 
        message = "수학 점수를 입력해주세요.";
        System.out.println(message);
        System.out.print("> ");
        input = scanner.nextInt();
        
        while (input <= SCORE_MIN && input >= SCORE_MAX) {
            System.out.println("잘못 입력하셨습니다.");
            System.out.println(message);
            System.out.print("> ");
            input = scanner.nextInt();
        } 
        int math = input;
        
        // 총점을 계산한다.
        int sum = korean + english + math;
        
        // 평균을 계산한다.
        double average = (double)sum / 3;
        
        
        // 결과를 출력한다. 
        System.out.printf("번호 : %03d번 이름 : %s\n", id, name);
        System.out.printf("국어점수 : %.3d점 영어점수 : %3d점 수학점수 : %3d점\n", korean, english, math);
        System.out.printf("총점 :%03d점 평균 %06.2f점\n", sum, average);
        
        // 6. 입력 받고 올바른 범위일때만 출력 중첩 if문
        if ((korean >= 0 && korean <= 100) &&
                    (english >= 0 && english <= 100) &&
                    (math >= 0 && korean <= 100)) {
                    System.out.println("출력결과");
                    System.out.printf("번호 : %d 이름 : %s\n", id, name);
                    System.out.printf("국어점수 : %.3d점 영어점수 : %3d점 수학점수 : %3d점\n", korean, english, math);
                
                } else {
                    System.out.println("잘못된 점수가 있어서 결과를 출력할 수 없습니다.");
                }
            scanner.close();
        }
    }