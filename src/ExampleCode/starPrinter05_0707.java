package ExampleCode;

//별찍기 5번

import java.util.Scanner;
import util.ScannerUtil;

public class starPrinter05_0707 {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     // 사용자로부터 출력할 줄 수를 입력 받는다.
     int lineNumber = ScannerUtil.nextInt(scanner, "출력할 줄 수를 입력해주세요.");
     
     // 각 줄의 가로 칸 
     int totalWidth = 2 * lineNumber - 1; // 9칸이 되야 되기 떄문
     
     // 2차원 배열 선언
     char[][] stars = new char[lineNumber][totalWidth];
     
     // 2차원 배열의 각 칸의 값 결정
     for(int i = 0; i < stars.length; i++) {
         // 우리가 계산하기 쉽게
         // i를 1부터 시작하게 저장하는 변수
         int newI = i + 1;
         
         // 공백의 갯수
         int spaceWidth = lineNumber - newI;
         
         // 별의 갯수
         int starWidth = newI * 2 - 1;
         
         // 공백을 담당하는 j for 문 
         for(int j = 0; j < spaceWidth; j++) {
             stars[i][j] = ' ';                
         }
         
         // 별을 담당하는 j for 문
         for(int j = spaceWidth; j < spaceWidth + starWidth; j++) {
             stars[i][j] = '*';
         }
         
     }
     
     // 2차원 배열 출력
     for(int i = 0; i < stars.length; i++) {
         for(int j = 0; j < stars[i].length; j++) {//i번쨰
             System.out.print(stars[i][j]);
         }
             
         
         System.out.println();
     }
     
     
     
     
     scanner.close();
 }
}
