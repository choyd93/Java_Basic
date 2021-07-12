package day0710;
// ArrayList를 사용하여
// 학생관리 프로그램을 작성하시오.
// 내가 푼 버젼 

import java.util.Scanner;
import java.util.ArrayList;

import util.ArrayUtil;
import util.ScannerUtil;
import type.Student;

public class GradeBook030 {
        static final int SUBJECT_SIZE = 3;
        static final int SCORE_MIN = 0;
        static final int SCORE_MAX = 100;

        static ArrayList<Student> list = new ArrayList<>();
        static Scanner scanner = new Scanner(System.in);
        static Student[] arr = new Student[0];
        static int id = 1;

        public static void main(String[] args) {
            // 메뉴 메소드 호출
            showMenu();
        }

        public static void showMenu() {
            while (true) {
                String message = "1. 입력 2. 출력 3. 종료";
                int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
                if (userChoice == 1) {
                    insert();
                } else if (userChoice == 2) {
                    printAll();
                } else if (userChoice == 3) {
                    System.out.println("사용해주셔서 감사합니다.");
                    break;
                }    
            }
            scanner.close();
        }

        public static void insert() {
            // Student 변수를 하나 만든다
            Student s = new Student();
            // 위의 Student 변수 s에 값을 넣는다.

            // 입력시에 출력할 메시지를 저장할 변수
            String message;

            message = "번호를 입력해주세요.";
            // s에 번호를 넣고 id를 1 증가시킨다.
            s.setId(ScannerUtil.nextInt(scanner, message));
            // s에 이름을 넣는다.
            message = "이름을 입력해주세요.";
            s.setName(ScannerUtil.nextLine(scanner, message));
            message = "국어 점수를 입력해주세요.";
            s.setKorean(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));
            message = "영어 점수를 입력해주세요.";
            s.setEnglish(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));
            // s에 수학 점수를 넣는다.
            message = "수학 점수를 입력해주세요.";
            s.setMath(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));
            // 변수 s를 배열에 추가해준다.
            arr = ArrayUtil.add(arr, s);
        }

        public static void printAll() {
           if(ArrayUtil.isEmpty(arr)) {
               System.out.println("아직 입력된 정보가 없습니다.");
           }else {
               for(int i = 0; i < ArrayUtil.size(arr); i++) {
                   System.out.printf("%d, %s\n", i+1, ArrayUtil.get(arr, i).name);
               }
               String message = "상세보기할 학생의 번호를 입력해주세요.(0은 뒤로가기)";
               int userChoice = ScannerUtil.nextInt(scanner, message, 0, ArrayUtil.size(arr)) - 1; //<-
               if(userChoice != -1) {
                   printOne(userChoice);
               }
           }
        }
        public static void printOne(int index) {
            Student s = ArrayUtil.get(arr, index);

            s.printInfo();
            
            String message = "1. 수정 2. 삭제 3. 뒤로가기";
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
            
            if(userChoice == 1) {
               update(index);
            }else if(userChoice == 2) {
                delete(index);
            }else if(userChoice == 3) {
                printAll();
            }
        }
        
        public static void update(int index) {
            
            String message;
            // 국어 점수 수정 
            message = "새로운 국어 점수를 입력해주세요";
            //list.get(arr, index).korean = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
            list.get(index).getKorean(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);)
            
            // 영어 점수 수정
            message = "새로운 영어 점수를 입력해주세요";
            //ArrayUtil.get(arr, index).english = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
            list.get(index).getEnglish(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
            
            // 수학 점수 수정
            message = "새로운 수학 점수를 입력해주세요";
            ArrayUtil.get(arr, index).math = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
           
            // 수정 후 개별 보기 화면으로 돌아간다.
            printOne(index);
            
        }
        
        public static void delete(int index) {

            String message = "정말로 삭제하시겠습니까? (1: 예 2: 아니오)";
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 2);
            if(userChoice == 1) {
                
                //arr = ArrayUtil.remove(arr, index);
                arr = list.remove(index);
                printAll();
                
            } else {
                // 개별 보기화면으로 돌아간다.  
                printOne(index);
            }
        }
    }

