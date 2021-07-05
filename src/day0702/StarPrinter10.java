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
            
            // 왼쪽 별 부분
            int jStart = userNumber;
            int jEnd = i; 

            for (int j = jStart; j >= jEnd; j--) {
                stars += "*";
            }
            
            // 왼쪽 별 담당하는 j for 문
            jStart = 1;
            jEnd = i - 1;
            for (int j = jStart; j <= jEnd; j++) {
                stars += " ";
            }
            
            // 오른쪽 공백을 담당하는 j for 문
            jStart = 1;
            jEnd = i - 1;
            for (int j = jStart; j <= jEnd; j++) {
                stars += " ";
            }

            // 오른쪽 별을 담당하는 j for 문
            jStart = userNumber;
            jEnd = i;
            for (int j = jStart; j >= jEnd; j--) {
                stars += "*";
            }

            System.out.println(stars);
        }
        // 세로2
        for(int i = iStart; i <= iEnd; i++) {

            // 왼쪽 별
            String stars = "";
            
            int jStart = 1;
            int jEnd = i; 
            
            for(int j = jStart; j <= jEnd; j++) {

                stars += "*";
            }
            
            // 왼쪽 공백
            jStart = userNumber;
            jEnd = i;
            for (int j = jStart; j >= jEnd; j--) {
                stars += " ";

            }

            // 오른쪽 공백 
            jStart = userNumber;
            jEnd = i;
            for (int j = jStart; j >= jEnd; j--) {
                stars += " ";
            }
            
            // 오른쪽 별
            jStart = 2;
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