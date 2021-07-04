package day07021;
// 별찍기 8번

import java.util.Scanner;

public class ex08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("별찍기 8번입니다.");
        System.out.println("숫자를 입력하세요.");
        System.out.print("> ");

        int userNumber = scanner.nextInt();

        int iStart = 0;
        int iEnd = userNumber;

        for (int i = iStart; i <= iEnd; i++) {
            String stars = "";

            int jStart = userNumber; //
            int jEnd = i;

            for (int j = jStart; j >= jEnd; j--) {
                stars += " ";
            }

            jStart = 1;
            jEnd = i - 1 ;

            for (int j = jStart; j <= jEnd; j++) {
                stars += "*";
            }
            System.out.println(stars);
   
        } 
        
        for (int i = iStart; i <= iEnd; i++) {
            String stars = "";

            int jStart = 1;
            int jEnd = i;

            for (int j = jStart; j <= jEnd; j++) {
                stars += " ";
            }

            jStart = userNumber - 1;
            jEnd = i;

            for (int j = jStart; j >= jEnd; j--) {
                stars += "*";
            }
            System.out.println(stars);
   
        }
        scanner.close();

    }
}