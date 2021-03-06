package day0715;

import java.util.Scanner;

//문항2. 정수와 소수 구별하기
//사용자가 입력한 숫자가 몇자리 숫자인지 확인하고
//만약 4자리 숫자일 경우
//천의 자리, 백의 자리, 십의 자리, 일의 자리가
//각각 얼마인지 출력하는 코드를 작성하고 여기에 붙여넣으시오


public class TestReview02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 1. 사용자로부터 숫자를 입력 받는다.
        int userChoice = scanner.nextInt();
        // 2. 4자리 숫자가 맞는지 확인한다.
        //    4자리 숫자일려면 1000이상 9999 이하의 범위에 속하면 된다. 
        if(userChoice >= 1000 && userChoice <= 9999) {
        
        // 3. 4자리 숫자일 경우, 각 자리를 분리해낸다.
        //    1000의 자리의 경우, 우리가 Int / int를 하면
        //    나머지가 무시 되니깐 숫자 / 1000한 값을 변수1에 저장한다.
        //    100의 자리의 경우, 원래 (숫자 - 변수1 * 1000) 하면,
        //    백의 자리 이하의 숫자만 남으니깐, 그 숫자 / 100을 하면
        //    백의 자릿수가 나오므로 해당 값을 변수 2에 저장한다.
        //    10의 자리의 경우 (숫자 - 변수1 * 1000 - 변수2 * 100) 하면 
        //    십의 자리 이하의 숫자만 남으니깐, 그 숫자 / 10을 한 결과값을
        //    변수 3에 저장한다.
        //    1의 자리의 경우 (숫자 - 변수1 * 1000 - 변수2 * 100 - 변수3 * 10)
        //    의 결과값은 자동으로 1의 자릿수가 된다. 
        
            
            
            
            
        }    
        
        // 3. 4자리 숫자일 경우, 각 자리를 분리해낸다.
        //    3-1. 먼저 임시 변수에 사용자가 입력한 숫자를 할당한다.
        int temp = userChoice;
        //    3-2. 사용자가 입력한 값 / 1000을 변수1에 저장한다.
        int num1 = userChoice / 1000;
        //    3-3. 임시변수에 %= 연산자를 사용하여 1000으로 나눈 나머지를
        //         저장한다.
        temp %= 1000;
        //    3-4. 임시변수 / 100을 변수2에 저장한다.
        int num2 = temp / 100;
        //    3-5. 임시변수에 %= 연산자를 사용하여 100으로 나눈 나머지를 저장한다.
        temp %= 100;
        //    3-6. 임시변수 / 10 을 변수2에 저장한다.
        int num3 = temp / 10;
        //    3-7. 임시변수에 %= 연산자를 사용하여 10을 나눈 나머지를
        //         변수3에 저장한다. 
        int num4 = temp % 10;
        
        // 4. 결과값을 출력한다.
        System.out.println("천의 자리 : " + num1);
        System.out.println("백의 자리 : " + num2);
        System.out.println("십의 자리 : " + num3);
        System.out.println("일의 자리 : " + num4);

        

        
        
        
        
        scanner.close();  
    }
}



