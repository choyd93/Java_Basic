package day0628;
// 기본형 데이터타입 01
// 정수형(Integer)
// 정수란? 소수점이 존재하는 숫자
// 자바의 경우, 기본형 데이터타입 중 정수를
// 이진법으로 변환하여 저장한다.
// 정수형 기본 데이터타입은 4가지가 있다.
// byte : 8비트 -> 8자리 2진법 숫자 -> (-2의 8제곱개의 숫자를 표현 가능)
//             -> (-2의 7제곱 ~ 2의 7제곱 -1) -> -128~127
// short : 16비트 -> 16자리 2진법 숫자 -> (-2의 16제곱개의 숫자를 표현 가능)
//               -> (-2의 15제곱 ~ 2의 15제곱 -1) -> -32000~32000
// int : 32비트 -> 32자리 2진법 숫자 -> (-2의 32제곱개의 숫자를 표현 가능)
//             -> (-2의 31제곱 ~ 2의 31제곱 -1) -> - 20억 ~ 20억 
// long : 64비트 -> 64자리 2진법 숫자 -> (-2의 64제곱개의 숫자를 표현 가능)
//              -> (-2의 63제곱 ~ 2의 63제곱 -1) -> 커다란 수 
// 비트란? 2진법 자릿수를 뜻한다.

// 컴퓨터의 경우, 맨 앞자리를 기준으로 하여 이면 +, 1이면 -를 뜻한다.
// 즉, byte를 기준으로 해서 최대값은 0111 1111, 즉 127이 된다.
// 최소값은 1000 000 즉 -128이 된다.
// 만약 범위를 벗어나는 값을 저장하는 경우에는 최대값보다 큰 값이 들어와서
// 부정확한 값으로 표시가 되는 것을 우리는 overflow라고 하고
// 반대로 최소값보다 작은 값이 들어와서 부정확한 값으로 표시가 되는 것을
// 우리는 underflow라고 한다.

public class Ex06Integer {
    public static void main(String[] args) {
        // 1. byte 변수 myByte를 만들어서 20을 넣고 출력해라
        byte myByte = 20;
        System.out.println(myByte);
        
        // 2. short 변수 myShort을 만들어서 150을 넗고 출력해라
        short myShort = 150;
        System.out.println(myShort);
        
        // 3. int 변수 myInt를 만들어서 8982을 넣고 출력해라
        int myInt = 8982;
        System.out.println(myInt);
        
        // 4. long 변수 myLong을 만들어서 9999999을 넣고 출력해라
        long myLong = 9999999;
        System.out.println(myLong);
        
        // 5. 4번까지 코드를 작성하고 실행이 끝나면 myByte에 150을 넣어라
        // myByte = 150;
        // 위 코드는 에러가 발생하는 코드로써,
        // byte의 범위인 -128~127을 벗어나는 값을
        // byte 변수인 myByte에 할당하려고 했기 때문에
        // 자바가 에러를 표시하게 된다.
        
        // 기본적으로 자바는 코드의 10진법 숫자를 int로 인식한다.
        // 또한 더이상 메모리와 같은 자원(resource)는 부족할 일이 극히 드물기 떄문에
        // 우리는 앞으로 정수형 데이터타입을 사용할 일이 있으면
        // int는 기본적으로 사용하고, 만약 +-20억을 벗어날 가능성이 있으면
        // long을 쓰면 된다.
        
        System.out.println(myByte);
    }

}
