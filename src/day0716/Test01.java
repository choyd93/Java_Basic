package day0716;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
       
        
        // 1. 사용자에게 두자리수를 입력을 받는다.
        Scanner scanner = new Scanner(System.in);

        System.out.println("두자리 숫자를 입력해주세요.");
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
        // 5. 일의 자리와 십의 자리를 더하여 sum을 선언한다. 
        // 6. if문을 통해 sum * sum을 한 수가 일의자리 + 십의자리 수가 되면
        //    "카프리카수 입니다."를 출력하고
        //    틀리면 "카프리카수가 아닙니다"를 출력한다. 

         }
}
