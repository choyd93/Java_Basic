package day0702;

// 별찍기 2
import java.util.Scanner;

public class StarPrinter02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("별찍기 2번");
        System.out.println("출력할 줄 수를 입력해주세요,");
        System.out.print("> ");
        int userNumber = scanner.nextInt();

        int iStart = 1;
        int iEnd = userNumber;
        for (int i = iStart; i <= iEnd; i++) {
            String stars = "";

            int jStart = i;
            int jEnd = userNumber; //이게 왜 userNumber 일까

            for (int j = jStart; j <= jEnd; j++) {
                stars += "*";
            }

            System.out.println(stars);
        }
        scanner.close();
        
        
        /* 내가 쓴 코드
        
        String stars = "";
        for(int i = userNumber; i > 0 ; i++) {
            // j for문이 한번 반복할 때마다
            // stars의 현재 내용에 *을 붙여서
            // 다시 stars에 저장한다.
            stars += "*";
            System.out.println(stars);

            
            int jStart1 = userNumber;
            int jEnd = 1; 
            
            for(int j = jStart1; j > jEnd; j++) {
            }
        }
        System.out.println("");
        */
    }

}
