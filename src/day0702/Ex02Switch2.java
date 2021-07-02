package day0702;
// 사용자로부터 월을 입력받으면
// 해당 월의 마지막 날짜를 알려주는 프로그램
import java.util.Scanner;

public class Ex02Switch2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("월을 입력하세요.");
        System.out.print("> ");
        int month = scanner.nextInt();
        
        /*
        switch(month) {
        case 1 :
            System.out.println("31일까지 입니다.");
            break;
        case 1 :
            System.out.println("31일까지 입니다.");
            break;
        case 1 :
            System.out.println("31일까지 입니다.");
            break;
        case 1 :
            System.out.println("31일까지 입니다.");
            break;   
        }
        */
        
        // 의도적으로 짧게 
        // 하지만 갯수가 많아지면 케이스가 많아지기 떄문에 사용을 잘 안함. 
        switch(month) {
        case 2 :
            System.out.println("28일 까지입니다.");
            break;
        case 4 :
        case 6 :
        case 9 :
        case 11 :
            System.out.println("30일까지 입니다.");
            break;
        case 1 :
        case 3 :
        case 5 :
        case 7 :
        case 8 :
        case 10 :
        case 12 :
            System.out.println("31일까지 입니다.");
            break;
            
        }
        
        
        scanner.close();
    }

}
