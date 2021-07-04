package day07021;
//  별찍기 3번 다시
import java.util.Scanner;

public class ex031 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("별찍기 3번");
        System.out.println("숫자를 입력하세요.");
        System.out.print("> ");
        
        int userNumber = scanner.nextInt();
        
        int iStart = 1;
        int iEnd = userNumber;
        
        for(int i = iStart; i <= iEnd; i++) {
            String stars = "";
            
            // 왼쪽 공백
            int jStart = userNumber - i;
            int jEnd = 1;
            
            for(int j = jStart; j >= jEnd; j--) {
                stars += " ";
            }   
                // 오른쪽 별표
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
