package day0702;

// 별찍기 10번
import java.util.Scanner;

public class StarPrinter10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("별찍기 10번");
        System.out.println("출력할 줄 수를 입력해주세요,");
        System.out.print("> ");
        int userNumber = scanner.nextInt();

        int iStart = 1;
        int iEnd = userNumber;
        
        //세로1
        for (int i = iStart; i <= iEnd; i++) {
            String stars = "";
            
            // 2번 왼쪽 윗 부분
            int jStart = i;
            int jEnd = userNumber; 

            for (int j = jStart; j <= jEnd; j++) {
                stars += "*";
            }
            
            // 4번 공백을 담당하는 j for 문
            jStart = 1;
            jEnd = i - 1;
            for (int j = jStart; j <= jEnd; j++) {
                stars += " ";
            }

            // 4번별을 담당하는 j for 문
            jStart = i;
            jEnd = userNumber;
            for (int j = jStart; j <= jEnd; j++) {
                stars += "*";
            }

            System.out.println(stars);
        }
        // 세로2
        for(int i = iStart; i <= iEnd; i++) {

            //
            String stars = "";
            
            int jStart = 1;
            int jEnd = i; 
            
            for(int j = jStart; j <= jEnd; j++) {

                stars += "*";
            }
            
            // 공백을 담당하는 j for 문
            jStart = 1;
            jEnd = userNumber - i;
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
        System.out.println("");

            scanner.close();
        }
    }