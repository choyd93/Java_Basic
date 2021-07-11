package day0706;
// 숙제 1.

// BmiChecker를 메소드화 시키시오

// 숙제 2. 
// GradeBook을 여러 학생을 관리할 수 있는 버젼으로 만들되
// 메소드화 시키시오.

// 비고) 앞으로 ScannerUil은 쓰셔도 되고 안쓰셔도 되지만
//      
// 내가 풀어본 버젼

import java.util.Scanner;
import util.ScannerUtil;

public class Hw010 {

    // 1. 상수 선언
    // 1) 입력 가능한 인원 수
    static final int SIZE = 5;
    // 2) 몸무게 최대값
    static final double WEIGHT_MAX = 635;
    // 3) 키 최대값
    static final double HEIGHT_MAX = 2.72;
    // 4) 몸무게, 키 최소값
    static final double WH_NUMBER_MIN = 1;
    // 4) BMI 범위 선언
    static final double STANDARD_I = 18.5;
    static final double STANDARD_II = 23;
    static final double STANDARD_III = 25;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 2. 변수 배열 저장
        // 1) 번호를 저장할 배열
        int[] idArray = new int[SIZE];
        // 2) 이름을 저장할 배열
        String[] nameArray = new String[SIZE];
        // 3) 키를 저장할 배열
        double[] heightArray = new double[SIZE];
        // 4) 몸무게를 저장할 배열
        double[] weightArray = new double[SIZE];

        // 다음 입력할 인덱스를 저장할 int 변수
        int index = 0; // <- 이게 중요한듯 함.

        while (true) {
            System.out.println("1. 입력 2. 출력 3. 종료");
            System.out.print("> ");
            int userChoice = scanner.nextInt();
            if (userChoice == 1) {
                // 입력 코드 구현

                if (index < SIZE) {
                    // 배열에 여유 공간 있어서 입력 가능

                    // 사용자가 입력한 실수 값을 임시 보관할 double 변수
                    double temp;

                    // 키를 입력 받아서 키 배열의 index번 칸에 저장
                    System.out.println("키를 입력해주세요.");
                    System.out.print("> ");
                    temp = scanner.nextDouble();

                    while (!(temp > 0 && temp <= HEIGHT_MAX)) {
                        System.out.println("잘못된 키입니다.");
                        System.out.println("키를 입력해주세요.");
                        System.out.print("> ");
                        temp = scanner.nextDouble();
                    }
                    heightArray[index] = temp;

                    // 몸무게를 입력 받아서 몸무게 배열의 index번 칸에 저장
                    System.out.println("몸무게를 입력해주세요.");
                    System.out.print("> ");
                    temp = scanner.nextDouble();

                    while (!(temp > 0 && temp <= WEIGHT_MAX)) {
                        System.out.println("잘못된 몸무게입니다.");
                        System.out.println("몸무게를 입력해주세요.");
                        System.out.print("> ");
                        temp = scanner.nextDouble();
                    }
                    weightArray[index] = temp;

                    // index의 값을 1 증가
                    index++;

                } else {
                    // 이미 5명을 다 입력해서 더이상 입력 불가
                    System.out.println("더이상 입력하실 수 없습니다.");
                }

            } else if (userChoice == 2) {
                // 출력 코드 구현

                outPut(int index, heightArray[i], weightArray[i]); // 메소드 파라미터 안에 배열을 넣어도 될
                
                        bmiChecker(bmi); // bmi 메소드 -> return 하면 result 나오는거아닌가. result에 빨간줄 가있는 이유는 무엇.

                        System.out.println("---------------------");
                    }

                } else {
                    // 아직 1명도 입력이 안되었으므로
                    // 경고 메시지만 출력
                    
                    alert();
                }

            } else if (userChoice == 3) {
                // 종료 코드 구현
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    
    
    // BMI 메소드화 -> 출력까지 같이할지 아니면 뺼지 고민, 왜 마지막 중괄호에 빨간줄이?
    public static String bmiChecker(double bmi) {
        
        String result;
        if (bmi < STANDARD_I) {
            result = "저체중";
        } else if (bmi < STANDARD_II) {
            result = "정상체중";
        } else if (bmi < STANDARD_III) {
            result = "과체중";
        } else {
            result = "비만";
        }
        System.out.printf("BMI : [%.3f] 비만도 : [%s]\n", bmi, result);
        return result;
    }
    
    // 출력 부분 
    public static void outPut(int index, heightArray[i], weightArray[i]) {

    if (index > 0) {
        // 1명 이상이 입력되었으므로
        // 배열 전체를 출력한다.
        for (int i = 0; i < index; i++) {
            System.out.println("---------------------");
            System.out.printf("\t%d번째 정보\n", i + 1);
            System.out.println("---------------------");
            System.out.printf("키 : [%.2f]m 몸무게 : [%.2f]kg\n", heightArray[i], weightArray[i]);
            double bmi = weightArray[i] / heightArray[i] / heightArray[i];
            }
        }
    }
   
    // 경고 메시지만 출력
    public static void alert() {
    System.out.println("-----------------");
    System.out.println("아직 입력된 정보가 없습니다.");
    System.out.println("---------------------");
    }
    
    // 입력 받아서 배열의 index번 칸에 저장
    // 잘못된 값 블록
    // 메소드 안에 배열을 넣을 수 있을까?

    public static void outPut2(Scanner scanner, double temp) {
    System.out.println("몸무게를 입력해주세요.");
    System.out.print("> ");
    temp = scanner.nextDouble();
    
    a = ScannerUtil.nextDouble(Scanner scanner, String message) 
             // <-다른 패키지 안에 있는 메소드를 이렇게 불러오는게 맞나

    while (!(temp > 0 && temp <= WEIGHT_MAX)) {
        System.out.println("잘못된 몸무게입니다.");
        System.out.println("몸무게를 입력해주세요.");
        System.out.print("> ");
        temp = scanner.nextDouble();
    }
    weightArray[index] = temp;
    }
}
