package day0714;

import java.util.Scanner;
import util.ScannerUtil;

public class Test2 {
    
    public static void main(String[] args) {
        
    Scanner scanner = new Scanner(System.in);
    
    String msg = new String("0~999중 정수를 입력하세요.");
    int number = ScannerUtil.nextInt(scanner, msg, 0, 10000);
    
    System.out.printf("백의자리 : %d\n",number/100);
    System.out.printf("십의자리 : %d\n",(number%100)/10);
    System.out.printf("일의자리 : %d\n",number%10);

    }
}
