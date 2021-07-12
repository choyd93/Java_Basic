package day0709;
// 숙제 1. Student 배열을 위한 ArrayUtil 메소드를 만들고
//        학생관리 프로그램 Student 데이터타입을 사용하여 만드시오.
// 숙제 2. type에 Board 데이터타입을 만들고 1번 과정과 같이
//        게시글 프로그램을 만드시오. 
// 숙제 3. 사원의 번호, 이름, 부서, 직급, 연봉을 관리하는 프로그램을 만드시오. 

// 내가 풀어본 버젼

import java.util.Scanner;
import util.ArrayUtil;
import util.ScannerUtil;
import type.Student;

public class Hw { 
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
    
    //Student 클래스의 배열 생성  <- 맞을까
    static Student[] idArray = new Student[0]; // <- 2. Student 타입의 배열 생성
    
    static Student s = new Student();  // 1. Student 전체 클래스를 가져온것, 가상의 공간

    // 다음 입력할 학생의 번호
    static int index = 0; // index

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
            
            // 구조체는 사용할때마다 선언을 해야한다. 
            // 3. 
            // 이름 입력
            
            idArray = ArrayUtil.add(idArray, s); // 클래스 s 자체가 들어간것. 
            for(int i = 0; i < idArray.length; i++) {
                idArray[i] = new Student();
                
            message = "번호를 입력해주세요.";
            idArray[i].id =  ScannerUtil.nextInt(scanner, message);
            message = "이름을 입력해주세요.";
            idArray[i].name = ScannerUtil.nextLine(scanner, message);
            message = "국어점수를 입력해주세요.";
            idArray[i].korean =  ScannerUtil.nextInt(scanner, message);
            message = "영어점수를 입력해주세요.";
            idArray[i].english =  ScannerUtil.nextInt(scanner, message);
            message = "수학점수를 입력해주세요.";
            idArray[i].math =  ScannerUtil.nextInt(scanner, message);
            
            }
        }        
        
        
        public static void print() {
            if (ArrayUtil.isEmpty(idArray)) {
                System.out.println("아직 입력된 학생이 존재하지 않습니다.");
            } else {
                for (int i = 0; i < idArray.length; i++) {
                    // System.out.println("아직 입력된 학생이 존재하지 않습니다."); <- 이게 추가되어있었음. 
                    System.out.printf("%d. %s\n", i + 1, idArray[i].name);
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
            idArray = ArrayUtil.get(null, index); 
            for(int i = 0; i < idArray.length; i++) {
                idArray[i].id =  ArrayUtil.get(id, index);
                
            }
            
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
            message = "새로운 국어 점수를 입력해주세요(기존 점수 : " + idArray[index].korean + "점)";
            koreanArray[index] = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
           
            message = "새로운 영어 점수를 입력해주세요(기존 점수 : " + idArray[index].english + "점)";
            englishArray[index] = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
          
            message = "새로운 수학 점수를 입력해주세요(기존 점수 : " + idArray[index].math + "점)";
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
                
                print();
            } else {
                // index번 학생 개별 보기로 돌아간다.
                printByIndex(index);
            }
        }

}
