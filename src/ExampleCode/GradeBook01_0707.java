package ExampleCode;
 // 5명의 학생을

 // 관리할 수 있는 프로그램.
 // 단, 국영수 점수는
 // 별개의 배열이 아닌
 // 1개의 2차원 배열로 관리한다. // 이게중요 
 // 각 학생의 점수 2차원 배열의 0번 배열은 국어, 1번 배열은 영어, 2번 배열은 수학 // 이게중요
 // 이 될 수 있도록 코드를 작성하시오.
 // 1시 20분까지
 // 메소드로 분리할 필요 x

 import java.util.Scanner;

 import util.ScannerUtil;

 public class GradeBook01_0707 {
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

     public static void main(String[] args) {

         // 변수 선언
         Scanner scanner = new Scanner(System.in);

         // 1. 번호를 저장할 배열
         int[] idArray = new int[STUDENT_SIZE];
         // 2. 이름을 저장할 배열
         String[] nameArray = new String[STUDENT_SIZE];

         // <- 3가지 점수를 하나에 저장
         // 3. 점수를 저장할 배열
         int[][] scoreArray = new int[STUDENT_SIZE][SUBJECT_SIZE];

         // 4. 입력할 인덱스를 저장할 변수
         int index = 0;

         // 각종 입력 시 출력할 안내 문구를 저장할 String 변수
         String message;

         while (true) {
             message = "1. 입력 2. 출력 3. 종료";
             int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);

             if (userChoice == 1) {
                 // 입력 코드 구현
                 if (index < STUDENT_SIZE) {
                     // 번호 입력
                     message = "번호를 입력해주세요.";
                     idArray[index] = ScannerUtil.nextInt(scanner, message);
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

             } else if (userChoice == 2) {
                 // 출력 코드 구현
                 if (index > 0) {
                     // 출력 시작
                     for (int i = 0; i < index; i++) {
                         System.out.println();
                         System.out.println("-----------------------");
                         System.out.printf("%d번째 학생 정보\n", i + 1);
                         System.out.println("==========================");
                         System.out.printf("번호 : %03d번 이름 : %s\n", idArray[i], nameArray[i]);

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

             } else if (userChoice == 3) {
                 // 종료 코드 구현
                 System.out.println("사용해주셔서 감사합니다.");
                 break;
             }
         }
     }

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
         } scanner.close();
         return score;
     }
 }

