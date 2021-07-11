package day0709;
// 전역 변수를 사용하여

// 학생 성적 관리 프로그램을 작성하시오.
// 단, 최대한 메소드를 만들어서
// 메인 메소드 내부의 코드를 최소화 시키시오.
// 30분까지
// 40분 부터 같이 풀 예정

// 강사님 버젼
// 최대 학생 숫자 x
// 세과목 인덱스 없으며, 이차배열 사용 x
// 따라서 쳤는데 오류가 남. 아직입력된 학생이 존재하지 않습니다.

import java.util.Scanner;

import util.ScannerUtil;
import util.ArrayUtil;

public class Gradebook01 {
    // 상수 선언

    // 점수 최소값
    static final int SCORE_MIN = 0;
    // 점수 최대값
    static final int SCORE_MAX = 100;
    // 과목 숫자
    static final int SUBJECT_SIZE = 3;

    // 전역 변수 <- 세과목 이차배열 사용 x
    static Scanner scanner = new Scanner(System.in);
    // 1. 번호를 저장할 배열
    static int[] idArray = new int[0];
    // 2. 이름을 저장할 배열
    static String[] nameArray = new String[0];
    // <- 3가지 점수를 하나에 저장
    // 3. 점수를 저장할 배열
    static int[] koreanArray = new int[0];
    static int[] englishArray = new int[0];
    static int[] mathArray = new int[0];
    // 다음 입력할 학생의 번호
    static int id = 1;

    public static void main(String[] args) {
        // 메뉴 출력 메소드 호출
        showMenu(); // <- 메뉴호출까지

    }

    public static void showMenu() {
        String message = "1. 입력 2. 출력 3. 종료"; // <- String 같이 선언하면 되네
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
            if (userChoice == 1) {
                // 입력 메소드 호출
                insert();                   // <- userInfo
            } else if (userChoice == 2) {
                // 출력 메소드 호출
                print();                    // <- userOutput
            } else if (userChoice == 3) {
                // while 종료
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
        scanner.close();
    }

    public static void insert() {
        // 각종 출력에 사용할 메시지
        String message;
        
        idArray = ArrayUtil.add(idArray, id++);
        // 이름 입력
        message = "이름을 입력해주세요.";
        String name = ScannerUtil.nextLine(scanner, message);
        nameArray = ArrayUtil.add(nameArray, name);
        // 국어 점수 입력
        message = "국어점수를 입력해주세요.";
        int korean = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
        koreanArray = ArrayUtil.add(koreanArray, korean);
        // 영어 점수 입력
        message = "영어점수를 입력해주세요.";
        int english = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
        englishArray = ArrayUtil.add(englishArray, english);
        // 수학 점수 입력
        message = "수학점수를 입력해주세요.";
        int math = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
        mathArray = ArrayUtil.add(mathArray, math);
    }

    public static void print() {
        if (ArrayUtil.isEmpty(idArray)) {
            System.out.println("아직 입력된 학생이 존재하지 않습니다.");
        } else {
            for (int i = 0; i < idArray.length; i++) {
                // System.out.println("아직 입력된 학생이 존재하지 않습니다."); <- 이게 추가되어있었음. 
                System.out.printf("%d. %s\n", i + 1, nameArray[i]);
            }
            // 사용자로부터 몇번 인덱스의 학생을 볼지 입력을 받는다.
            // 단, 한가지 주의할 것은 사용자가 입력할 번호와
            // 실제 인덱스가 다르다라는 것이다.
            String message = "상세보기할 학생의 번호를 입력하세요.\n뒤로 가실려면 0을 눌러주세요.";
            // <-- 최대값은 배열의 크기가 됨. 이미 -1을 통해 1부터 시작했기 떄문. 응?
            int userChoice = // 0이라고 입력하면 -1 이 되는 것.
                    ScannerUtil.nextInt(scanner, message, 0, idArray.length) - 1;
            if (userChoice != -1) {
                printByIndex(userChoice); // 이렇게만 적어주면 뒤로가기 되는 것.               
            }
        }
    }

    public static void printByIndex(int index) {
        int id = ArrayUtil.get(idArray, index);
        String name = ArrayUtil.get(nameArray, index);
        System.out.printf("번호 : %d번 이름 : %s\n", id, name);
        int korean = ArrayUtil.get(koreanArray, index);
        int english = ArrayUtil.get(englishArray, index);
        int math = ArrayUtil.get(mathArray, index);
        System.out.printf("국어 : %03d점 영어 : %03d점 수학 : %03d점\n", korean, english, math);
        int sum = korean + english + math;
        double average = (double) sum / SUBJECT_SIZE;
        System.out.printf("총점 : %03d점 평균 : %06.2f점\n", sum, average);

        String message = "1. 수정 2. 삭제 3. 뒤로가기";
        int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);

        if (userChoice == 1) {
            // 수정 메소드 호출
            update(index);
        } else if (userChoice == 2) {
            // 삭제 메소드 호출
            delete(index);
        } else if (userChoice == 3) {
            print(); // <- 여기 실행순서 스샷 보기
        }
    }
    public static void update(int index) {
        // 수정의 경우, 번호나 이름은 수정할 수 없고
        // 국어 영어 수학만 새로운 값을 입력 받도록 한다.
        String message;
        message = "새로운 국어 점수를 입력해주세요(기존 점수 : " + koreanArray[index] + "점)";
        koreanArray[index] = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
       
        message = "새로운 영어 점수를 입력해주세요(기존 점수 : " + englishArray[index] + "점)";
        englishArray[index] = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
      
        message = "새로운 수학 점수를 입력해주세요(기존 점수 : " + mathArray[index] + "점)";
        mathArray[index] = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
       
        printByIndex(index);
        
    }
    
    public static void delete(int index) {
        // 사용자로부터 정말로 삭제할지 물어봐서
        // 1이라고 입력했을 떄에만 삭제하고 메뉴보기로 돌아간다.
        // 그외의 값은 무조건 동의하지 않은 걸로 보고
        // 다시 개별 보기로 돌아간다.
        String message = "정말로 삭제하시겠습니까? (1: 예 2: 아니오)";
        int userChoice = ScannerUtil.nextInt(scanner, message);
        if(userChoice == 1) {
            // 각 배열의 index번 칸을 삭제한 후에
            // 목록 보기로 돌아간다.
            idArray = ArrayUtil.remove(idArray, index);
            nameArray = ArrayUtil.remove(nameArray, index);
            koreanArray = ArrayUtil.remove(koreanArray, userChoice);
            englishArray = ArrayUtil.remove(englishArray, index);
            mathArray = ArrayUtil.remove(mathArray, index);
            print();
        } else {
            // index번 학생 개별 보기로 돌아간다.
            printByIndex(index);
        }
    }
}





