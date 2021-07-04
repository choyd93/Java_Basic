package day07021;
// 별찍기 2번

import java.util.Scanner;

public class ex02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("별찍기 2번 문제입니다.");
        System.out.println("숫자를 입력하세요.");
        System.out.print("> ");
        
        int userNumber = scanner.nextInt();
        
        // 세로1
        int iStart = 1;
        int iEnd = userNumber;
        
        for(int i = iStart; i <= iEnd; i++) {
            String stars = "";
            
            int jStart = userNumber; // 유저넘버로 시작
            int jEnd = i;
            
            // 가로1 
            for(int j = jStart; j >= jEnd; j--) {
                stars += "*";
            }
            System.out.println(stars);
        }
        
        scanner.close();
    }

}
