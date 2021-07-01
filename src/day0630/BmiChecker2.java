package day0630;
// 숙제1.

// 사용자로부터 키와 몸무게를 입력 받아서
// BMI를 계산하여
// 비만도를 출력하는 프로그램 
// 단, 기네스북에 따르면 세계에서 가장 키가 컸던 사람의 키는
// 2.72m였습니다.
// 또한 가장 몸무게가 무거웠던 사람의 몸무게는 635kg이였습니다.
// 만약 사용자가 잘못된 값을 입력할 경우, 더이상 추가적인 입력 없이
// 경고 메시지 출력 후 프로그램이 종료되도록 코드를 작성하시오

//출력결과)
//키 : #.##m 몸무게 : ##.##kg
//BmI : ##.### 비만도 : 과체중

//BMI 공식은 몸무게 / 키 / 키 입니다.
//단, 몸무게는 kg, 키는 m 단위입니다.
//BMI 18.5 미만 : 저체중
//~23 미만 : 정상
//~25 미만 : 과체중
//그 이상 : 비만

import java.util.Scanner;

public class BmiChecker2 {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       
       // 내가 안한 것
       // 각 비만도의 기준점이 될 상수
       final double STANDARD_I = 18.5;
       final double STANDARD_II = 23;
       final double STANDARD_III = 25;
       
       //1. 키를 입력
       System.out.println("키를 m단위로 입력하세요.");
       System.out.print("> ");
       double height = scanner.nextDouble();
           if (height <= 2.72) {
               // 2. 몸무게를 입력
               System.out.println("몸무게를 kg단위로 입력하세요.");
               System.out.print("> ");
               double weight = scanner.nextDouble();
               
               if (weight > 0 && weight <= 635) {
                   // 3. bmi, result
                   double bmi = weight/height/height;
                   String result;
                   
                   if (bmi < STANDARD_I) {
                      result = "저체중입니다.";
                   } else if (bmi < STANDARD_II) {
                       result = "정상체중입니다.";
                   } else if (bmi < STANDARD_III) {
                       result = "과체중입니다.";
                   } else {
                       result = "그외입니다.";
                           }
                       // 출력
                       System.out.printf("키 : %.2f 몸무게 :%.3f\n", height, weight);
                       System.out.printf("bmi : %.3f 비만도 : %s\n", bmi, result);
               } else {
                    System.out.println("잘못된 값입니다.");
               }
          } else {
              System.out.println("잘못된 값입니다.");
          }       
           }
}
// 내가 안한 것 : 상수 선언, weight > 0 
