package day0702;

// 별찍기 3번
import java.util.Scanner;

public class StarPrinter03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 2번째 줄에 5-2
        System.out.println("별찍기 3번");
        System.out.println("출력할 줄 수를 입력해주세요,");
        System.out.print("> ");
        int userNumber = scanner.nextInt();

        int iStart = 1;
        int iEnd = userNumber;

        for (int i = iStart; i <= iEnd; i++) {
            String stars = "";

            // 공백을 담당하는 j for 문
            int jStart = 1;
            int jEnd = userNumber - i;
            for (int j = jStart; j <= jEnd; j++) {
                stars += " ";

            }

            // 별을 담당하는 j for 문
            jStart = 1;
            jEnd = i;
            for (int j = jStart; j <= jEnd; j++) {
                stars += "*";
            }

            System.out.println(stars);

        }

        /*
         * System.out.println("별찍기 3번"); System.out.println("출력할 줄 수를 입력해주세요,");
         * System.out.print("> "); int userNumber = scanner.nextInt();
         * 
         * int iStart = 1; int iEnd = userNumber;
         * 
         * for(int i = iStart; i <= iEnd; i++) { //세로 String stars = "";
         * 
         * int jStart = 1; int jEnd = i;
         * 
         * for(int j = jStart; j <= iEnd; j++) { //가로 stars += "*"; }
         * 
         * System.out.printf("%2s", stars); }
         */

        scanner.close();
    }

}