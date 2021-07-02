package day0702;

// 별찍기 5번
import java.util.Scanner;

public class StarPrinter05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*
        System.out.println("별찍기 5번");
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
            
            // 오른쪽 출력 부분 담당
            jStart = 2;
            jEnd = i;
            
            for(int j = jStart; j <= jEnd; j++) {

                stars += "*";
            }

            System.out.println(stars);
        }
        */
        
        System.out.println("별찍기 5번");
        System.out.println("출력할 줄 수를 입력해주세요,");
        System.out.print("> ");
        int userNumber = scanner.nextInt();

        int iStart = 1;
        int iEnd = userNumber;

        for (int i = iStart; i <= iEnd; i++) {
            String stars = "";
            
            // 공백의 갯수를 저장할 int 변수
            int spaceWidth = userNumber - i;
            
            // 별의 갯수를 저장할 int 변수
            int starWidth = 2 * i - 1; 
           

            // 공백을 담당하는 j for 문
            for (int j = 1; j <= spaceWidth; j++) {
                stars += " ";

            }

            // 별을 담당하는 j for 문
            for (int j = 1; j <= starWidth; j++) {
                stars += "*";               
            }
            
            System.out.println(stars);
        }
            scanner.close();
        }
    }