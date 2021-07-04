package day07021;
//  별찍기 4번 다시

import java.util.Scanner;

public class ex041 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("숫자를 입력하세요.");
        System.out.print("> ");
        
        int userNumber = scanner.nextInt();
        
        int iStart = 1;
        int iEnd = userNumber;
        
        // 세로 1.
        for(int i = iStart; i <= iEnd; i++) {
            String stars = "";
            
            // 왼쪽 공백
            int jStart = 1;
            int jEnd = i;
            
            for(int j = jStart; j <= jEnd; j++) {
                stars += " ";
            }
            
            // 오른쪽 별표
            jStart = userNumber;
            jEnd = i;
            
            for(int j = jStart; j >= jEnd; j--) {
                stars += "*";
            }
            System.out.println(stars);
               
        }
        scanner.close();
    } 

}
