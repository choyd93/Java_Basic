package ExampleCode;

//숙제 1.

//BmiChecker를 메소드화 시키시오

//숙제 2. 
//GradeBook을 여러 학생을 관리할 수 있는 버젼으로 만들되
//메소드화 시키시오.

//비고) 앞으로 ScannerUil은 쓰셔도 되고 안쓰셔도 되지만
// 
//강사님 버젼

import java.util.Scanner;
import util.ScannerUtil;

public class Hw01_Bmi_0707 {

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

   double height = 0;
   double weight = 0;
   boolean inputSwitch = false;

   while (true) {
       int userChoice = ScannerUtil.nextInt(scanner, "1. 입력 2. 출력 3. 종료", 1, 3);
       if (userChoice == 1) {
           // 입력 코드 구현
           
           // 입력 시 출력할 메시지를 저장할 String 변수
           String message = "";
           
           // 키 입력을 담당하는 메소드 호출
           message = "키를 m 단위로 입력해주세요.";
           height = ScannerUtil.nextDouble(scanner, message, 0.01, HEIGHT_MAX);
           // <- 여기 잘 모르겠음.
           
           // 몸무게 입력을 담당하는 메소드 호출
           message = "몸무게를 kg 단위로 입력해주세요.";
           weight = ScannerUtil.nextDouble(scanner, message, 0.01, WEIGHT_MAX);
           
           // inputSwitch를 true로 변경
           inputSwitch = true;
        

       } else if (userChoice == 2) {
           if (inputSwitch) {
               // 출력 메소드 구현
               printInfo(height, weight);

           } else {
               System.out.println("아직 입력된 정보가 없습니다.");
           }

       } else if (userChoice == 3) {
           System.out.println("사용해주셔서 감사합니다.");
           break;
       }
   }
   
   scanner.close();
}

// 배열을 안쓰네
public static void printInfo(double height, double weight) {
   // bmi 계산
   double bmi = weight / height / height;
   
   // 비만도 결정
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
   
   // 결과 출력
   System.out.printf("키 : [%.2f]m 몸무게 : [%.2f]kg\n", height, weight);
   System.out.printf("BMI : [%.3f] 비만도 : [%s]\n", bmi, result);

}

}