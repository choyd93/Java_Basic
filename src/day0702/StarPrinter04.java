package day0702;

// 별찍기 4번
import java.util.Scanner;

public class StarPrinter04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 2번째 줄에 5-2
        
        /* 내가쓴 코드 이것도 정상작동됨.
        System.out.println("별찍기 4번");
        System.out.println("출력할 줄 수를 입력해주세요,");
        System.out.print("> ");
        int userNumber = scanner.nextInt();

        int iStart = 1;
        int iEnd = userNumber;

        for (int i = iStart; i <= iEnd; i++) {
            String stars = "";

            // 공백을 담당하는 j for 문
            int jStart = 1;
            int jEnd = i;
            for (int j = jStart; j <= jEnd; j++) {
                stars += " ";
            }

            // 별을 담당하는 j for 문
            jStart = 1;
            jEnd = userNumber - i;
            for (int j = jStart; j <= jEnd; j++) {
                stars += "*";
            }

            System.out.println(stars);
        }
        */
        
        System.out.println("별찍기 4번");
        System.out.println("출력할 줄 수를 입력해주세요,");
        System.out.print("> ");
        int userNumber = scanner.nextInt();

        int iStart = 1;
        int iEnd = userNumber;

        for (int i = iStart; i <= iEnd; i++) {
            String stars = "";

            // 공백을 담당하는 j for 문
            int jStart = 1;
            int jEnd = i - 1;
            for (int j = jStart; j <= jEnd; j++) {
                stars += " ";
            }

            // 별을 담당하는 j for 문
            jStart = i;
            jEnd = userNumber;
            for (int j = jStart; j <= jEnd; j++) {
                stars += "*";
            }

            System.out.println(stars);
        }
        
        scanner.close();
    }
}