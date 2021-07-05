package day0705;

//별찍기 8번

import java.util.Scanner;

public class starPrinter08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("별찍기 8번입니다.");
        System.out.println("숫자를 입력하세요.");
        System.out.print("> ");

        int lineNumber = scanner.nextInt();

        for (int i = 1; i <= 2 * lineNumber - 1; i++) {
            String stars = "";

            if (i < lineNumber) {
                // 윗부분

                // 공백을 담당하는 j for문
                int spaceWidth = lineNumber - i;
                for (int j = 1; j <= spaceWidth; j++) {
                    stars += " ";
                }

                // 별을 담당하는 j for문
                int starWidth = i;
                for (int j = 1; j <= starWidth; j++) {
                    stars += "*";
                }

            } else {
                // 아랫부분의 j for문의 기준이 될
                // int 변수
                int lowerI = i - lineNumber + 1;

                // 아랫부
                
                // 공백을 담당하는 j for 문
                int spaceWidth = lowerI - 1;
                for(int j = 1; j <= spaceWidth; j++) {
                    stars += " ";
                }
                
                // 별을 담당하는 j for 문
                int starWidth = lineNumber - lowerI + 1;
                for(int j = 1; j <= spaceWidth; j++) {
                    stars += "*";
                }
                    
            }

            System.out.println(stars);
        }
        scanner.close();

    }
}
