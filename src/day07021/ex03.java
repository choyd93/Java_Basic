package day07021;
// 별찍기 3번

import java.util.Scanner;

public class ex03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("별찍기 32번");
        System.out.println("숫자를 입력해주세요.");
        System.out.print("> ");
        
        int userNumber = scanner.nextInt();
        
        int iStart = 1;
        int iEnd = userNumber;

        // 세로 1.
        for(int i = iStart; i <= iEnd; i++) {
            String stars = "";
            
            // 가로 왼쪽 공백 - 공백 부분을 빼줌.
            int jStart = userNumber - 1; // 공백이 별찍기 2번 모양과 같음.
            int jEnd = i;

            for(int j = jStart; j >= jEnd; j--) {
                stars += " ";
            }
           
            // 가로 오른쪽 + 네모 모양으로 만들기 위해
            jStart = 1;
            jEnd = i;

            for(int j = jStart; j <= jEnd; j++) {
                stars += "*";
            } 
             System.out.println(stars);
        } 
        scanner.close();
    }
}
