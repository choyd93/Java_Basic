package day0709;
// 전역 변수를 사용하여

// 학생 성적 관리 프로그램을 작성하시오.
// 단, 최대한 메소드를 만들어서
// 메인 메소드 내부의 코드를 최소화 시키시오.
// 30분까지
// 40분 부터 같이 풀 예정

// 내가 푼 버젼
// 입력이 5 넘어가면 오류가 뜸.

import java.util.Scanner;

import util.ScannerUtil;
import util.ArrayUtil;

public class Gradebook010 {
    // 1. 상수 선언
    // 과목 숫자
    static final int SUBJECT_SIZE = 3;
    // 최대 학생 숫자
    static final int STUDENT_SIZE = 5;
    // 최저 점수
    static final int SCORE_MIN = 0;
    // 최고 점수
    static final int SCORE_MAX = 100;

    // <- 이거 중요
    // 국어 점수 인덱스
    static final int INDEX_KOREAN = 0;
    // 영어 점수 인덱스
    static final int INDEX_ENGLISH = 1;
    // 수학 점수 인덱스
    static final int INDEX_MATH = 2;
    
    // 변수들을 전역 변수로 뺌. final을 안붙이니까 변수임.
    static Scanner scanner = new Scanner(System.in);
    // 1. 번호를 저장할 배열
    static int[] idArray = new int[STUDENT_SIZE];
    // 2. 이름을 저장할 배열
    static String[] nameArray = new String[STUDENT_SIZE];
    // <- 3가지 점수를 하나에 저장
    // 3. 점수를 저장할 배열
    static int[][] scoreArray = new int[STUDENT_SIZE][SUBJECT_SIZE];
    
    // <- 인덱스와 메시지로 전역변수로 빼야할까? 메소드에서 빨간줄 나와서 전역변수로 뺌.
    // 4. 입력할 인덱스를 저장할 변수
    static int index = 0;


    public static void main(String[] args) {

        // 변수 선언
        // 각종 입력 시 출력할 안내 문구를 저장할 String 변수
        // <- 메시지도 전역변수로 뺴야되나
        String message;

        // <- 메뉴 구현도 메소드로 빼야 되는걸까?
        while (true) {
            message = "1. 입력 2. 출력 3. 종료";
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);

            if (userChoice == 1) {
                
                // 입력코드
                userInfo();
                

            } else if (userChoice == 2) {
                // 출력 코드 구현
                userOutput();


            } else if (userChoice == 3) {
                // 종료 코드 구현
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    
    // <- printInfo를 userOutput에 어떻게 적용해야할까? Output은배열이기 때문에 적용방법이 궁금. 아니면 이 메소드는 안쓸지도?
    // 계산 후 출력 메소드
    public static void printInfo(int id, String name, int korean, int english, int math) {
        // 총점 계산
        int sum = korean + english + math;

        // 평균 계산
        double average = (double) sum / SUBJECT_SIZE;

        // 출력
        System.out.printf("번호 : %03d번 이름 : %s\n", id, name);
        System.out.printf("국어 : %03d점 영어 : %03d점 수학 : %03d점\n", korean, english, math);
        System.out.printf("총점 : %03d점 평균 : %06.2f점\n", sum, average);

    }
    
    // setScore 메소드를 userInfo에 어떻게 사용할까? 
    // 점수를 입력받는 메소드
    public static int setScore(String message, Scanner scanner) {
        int score = 0;
        System.out.println(message);
        System.out.print("> ");
        score = scanner.nextInt();

        while (!(score >= SCORE_MIN && score <= SCORE_MAX)) {
            System.out.println("잘못 입력하셨습니다.");
            System.out.println(message);
            System.out.print("> ");
            score = scanner.nextInt();
        }
        scanner.close();
        return score;
    }

    
    // 여기서부터 내가 해야할 것.
    // 입력 코드 구현 메소드
    // <- 1. index를 ArrayUtil.size(arr)로 변경
    public static void userInfo() {
        String message =""; //<- 2. 이거 선언
        int[] arr = new int[0]; //<- 3.arr 빨간줄 나오기 떄문에 따로 선언해줌. 전역변수로 바꿔도 될까? 

        if (ArrayUtil.size(arr) < STUDENT_SIZE) { //<- arr에 빨간줄 왜?
            
            // <- 이것도 줄일수 있을거같은데 
            // 번호 입력
            message = "번호를 입력해주세요.";
            idArray[index] = ScannerUtil.nextInt(scanner, message); // 4. index 전역변수로 변경
            // 이름 입력
            message = "이름을 입력해주세요.";
            nameArray[index] = ScannerUtil.nextLine(scanner, message);
            // 국어 점수 입력
            message = "국어점수를 입력해주세요.";
            scoreArray[index][INDEX_KOREAN] = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
            // 영어 점수 입력
            message = "영어점수를 입력해주세요.";
            scoreArray[index][INDEX_ENGLISH] = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
            // 수학 점수 입력
            message = "수학점수를 입력해주세요.";
            scoreArray[index][INDEX_MATH] = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);

            // index 1 증가
            index++;
        } else {
            System.out.println("더이상 입력하실 수 없습니다.");
        }
    }
    
    // 출력 코드 구현 메소드
    public static void userOutput() {
    if (index > 0) {
        // 출력 시작
        for (int i = 0; i < index; i++) {
            System.out.println();
            System.out.println("-----------------------");
            System.out.printf("%d번째 학생 정보\n", i + 1);
            System.out.println("==========================");
            System.out.printf("번호 : %03d번 이름 : %s\n", idArray[i], nameArray[i]);

            // <- 이것도 줄일수 있을거같은데 
            System.out.printf("국어 : %03d점 영어 : %03d점 수학 : %03d점\n", scoreArray[i][INDEX_KOREAN],
                    scoreArray[i][INDEX_ENGLISH], scoreArray[i][INDEX_MATH]);
            int sum = scoreArray[i][INDEX_KOREAN] + scoreArray[i][INDEX_ENGLISH]
                    + scoreArray[i][INDEX_MATH];

            double average = (double) sum / SUBJECT_SIZE;

            System.out.printf("총점 : %03d점 평균 : %06.2f점\n", sum, average);

            System.out.println("-----------------------");
            System.out.println();
        }

    } else {
        System.out.println("아직 입력된 학생이 존재하지 않습니다.");
    }
    }
}
