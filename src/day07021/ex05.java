package day07021;
// 별표찍기 5번

import java.util.Scanner;

public class ex05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("별찍기 55번");
        System.out.println("숫자를 입력하세요.");
        System.out.print("> ");
        
        int userNumber = scanner.nextInt();
        
        int iStart = 1;
        int iEnd = userNumber;
        
        for(int i = iStart; i <= iEnd; i++) {
            String stars = "";
            
            int jStart = userNumber - 1;
            int jEnd = i;
            
            for(int j = jStart; j >= jEnd; j--) {
                stars += " ";
            }
            
            jStart = 2;
            jEnd = i;
            
            for(int j = jStart; j <= jEnd; j++) {
                stars += "*";
            }
            
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
