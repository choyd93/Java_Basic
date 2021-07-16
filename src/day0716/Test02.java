package day0716;
import java.util.Scanner;
import java.util.Random;

public class Test02 {
    public static void main(String[] args) {
       
        
        // 1. 사용자에게 네자리수를 입력을 받는다.
        Scanner scanner = new Scanner(System.in);

        System.out.println("네자리 숫자를 입력해주세요.");
        System.out.print("> ");
        
        int userNumber = scanner.nextInt();
        
        // 2. 사용자에게 입력받은 수가 두자리수가 맞는지 확인한다. 
        while(!(userNumber >= 10 && userNumber <= 99)) {
            System.out.println("두자리 숫자가 아닙니다.");
            System.out.println("두자리 숫자를 입력해주세요.");
            System.out.print("> ");
            userNumber = scanner.nextInt();
        }
        
        // 3. 사용자가 입력한 두자리수 중  십의 자리를 구한다.
        // 4. 사용자가 입력한 두자리수 중  일의 자리를 구한다.
        // 5. 사용자가 입력한 두자리수 중  백의 자리를 구한다.
        // 6. 사용자가 입력한 두자리수 중  천의 자리를 구한다.

        // 7. 랜덤 메소드를 이용하여 네자리수를 랜덤으로 두개 나눈다.
        // 8. 두개씩 나눈 수를 각각 선언한다. 
        // 8. 각각 나눈 수를 if문을 통해 곱한 후 나온 수가 
        //    (일의자리수 + 십의자리수) + (백의자리 + 천의자리)가 되면
        //    "카프리카수 입니다."를 출력하고
        //    틀리면 "카프리카수가 아닙니다"를 출력한다. 

         }
}