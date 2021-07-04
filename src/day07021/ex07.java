package day07021;
// 별찍기 7번

import java.util.Scanner;

public class ex07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("별찍기 71번");
        System.out.println("숫자를 입력해주세요.");
        System.out.print("> ");
        
        int userNumber = scanner.nextInt();
        
        int iStart = 1;
        int iEnd = userNumber;
        
        for(int i = iStart; i <= iEnd; i++) {
            String stars = "";
            
            int jStart = 1;
            int jEnd = i - 1;
            
            for(int j = jStart; j <= jEnd; j++) {
                stars += "*";
            } System.out.println(stars);
        } 
        
        iStart = 1;
        iEnd = userNumber;
        
        for(int i = iStart; i <= iEnd; i++) {
            String stars = "";
            
            int jStart = userNumber - 1 ;
            int jEnd = i - 1;
            
            for(int j = jStart; j >= jEnd; j--) {
                stars += "*";
            } System.out.println(stars);
        }
        scanner.close();
    }
}
