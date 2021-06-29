package day0629;
// 사용자로부터
// 이름, 키, 몸무게를 입력 받아서
// 이름 : ### 키 : #.## m 몸무게 : ##.## kg
// BMI 수치 : ##.###
// 의 형식으로 출력되는 프로그램을 작성하시오.
// 단, 키는 m 단위이고 몸무게는 kg 단위 입니다.
// BMI 게산 공식은 몸무게 / 키 / 키 입니다.
import java.util.Scanner;

public class BmiCalc {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.println("이름을 입력해주세요");
       System.out.print("> ");
       String name = scanner.nextLine();
       
       Scanner scanner1 = new Scanner(System.in);
       System.out.println("키를 입력해주세요");
       System.out.print("> ");
       double height = scanner1.nextDouble();
       
       Scanner scanner2 = new Scanner(System.in);
       System.out.println("몸무게를 입력해주세요");
       System.out.print("> ");
       double weight = scanner2.nextDouble();
       
       double BMI = (weight / (height * height));
       
       System.out.printf("이름 : %s 키 : %03.2fm 몸무게 : %05.2fkg\n", name, height, weight);
       System.out.printf("BMI 수치 : %05.2f\n", BMI);
      
    }

}
