package day0705;
//사용자로부터 로또 숫자를 입력 받아 정렬하여 출력하는 프로그램.
//단, 사용자가 1~45를 벗어나거나 중복된 숫자를 입력할 수 없도록 합니다.
//4시 10분까지 
//내가 중복, 오름차순 코드 가져와서 만든 코드

import java.util.Random;
import java.util.Scanner;

public class LottoGame040 {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     Random random = new Random();
     
     final int SIZE = 6;
     final int NUMBER_MIN = 0;
     final int NUMBER_MAX = 45;
     
     // 랜덤한 숫자를 담을 배열 생성
     int[] numbers = new int[SIZE];
     
     // 배열에 랜덤한 숫자를 넣는다.
     String message;
     message = "숫자를 입력해주세요.";
     for(int i = 0; i < numbers.length; i++) {
         System.out.println("숫자를 입력하세요.");
         System.out.print("> ");
         numbers[i] = scanner.nextInt();
         
         // 잘못 입력 블록
         while (numbers[i] <= NUMBER_MIN || numbers[i] >= NUMBER_MAX) {
             System.out.println("잘못 입력하셨습니다.");
             System.out.println(message);
             System.out.print("> ");
             numbers[i] = scanner.nextInt();
         } 
     }

         // 중복 제거하는 코드 
         for(int i = 0; i < numbers.length; i++) {
             for(int j = 0; j < numbers.length; j++) {
                 if(i != j && numbers[i] == numbers[j]) {
                     System.out.println("--------------------------");
                     System.out.printf("%d와 %d에 중복!\n", i, j);
                     numbers[i] = random.nextInt(NUMBER_MAX) + 1;
                    System.out.println("--------------------------");
                    j = -1;
                 }
             }
         }
         
         // 오름차순 정렬하는 코드
         for(int i = 0; i < numbers.length - 1; i++) { //영상
             if(numbers[i] > numbers[i+1]) {
                 int temp = numbers[i];
                 numbers[i] = numbers[i+1];
                 numbers[i+1] = temp;
                 i = -1; // 다시 맨처음부터 검사하려고 
             }
         }
     
     // 출력

     for(int i = 0; i < numbers.length; i++) {
         System.out.printf("numbers[%d] : %d\n",i, numbers[i]);
     }
     
 }
}