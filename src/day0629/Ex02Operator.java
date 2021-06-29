package day0629;
// 연산자 02
// 할당연산자

// 할당연산자는 오른쪽 값을 연산하여 왼쪽 공간에 할당한다.

// 할당연산자에는
// =, +=, -=, *=, /=, %=, ++, --

public class Ex02Operator {
   public static void main (String[] args) {
       // int 변수 number 선언
       int number;
       
       // 1. =
       //   오른쪽 값을 왼쪽 공간에 할당한다.
       System.out.println("1. =");
       
       number = 4; // 4를 number에 할당해라
       System.out.println("number의 현재값: " + number);
       System.out.println();
       
       // 2. +=
       // 왼쪽 공간의 현재 값에 오른쪽 값을 더한 결과값을
       // 다시 왼쪽 공간에 할당한다.
       System.out.println("2. +=");
       
       number += 1; // number의 현재 값인 4에 오른쪽 값 1을 더한 결과값인
                    // 5를 다시 number에 할당해라 
       System.out.println("number의 현재값: " + number);
       System.out.println();
       
       // 3. -=
       // 왼쪽 공간의 현재 값에 오른쪽 값을  결과값을
       // 다시 왼쪽 공간에 할당한다.
       System.out.println("3. -=");
       number -= 7; // number의 현재 값인 5에 오른쪽 값 7을  결과값인
                    // -2를 다시 number에 할당해라 
       System.out.println("number의 현재값: " + number);
       System.out.println();
       
       // 4. *=
       // 왼쪽 공간의 현재 값에 오른쪽 값을 나눈 몫을
       // 다시 왼쪽 공간에 할당한다.
       System.out.println("4. -=");
       number *= 4; // number의 현재 값인 -2에 오른쪽 값 4를 곱한 결과값인
                    // -8를 다시 number에 할당해라 
       System.out.println("number의 현재값: " + number);
       System.out.println();
       
       // 5. /=
       // 왼쪽 공간의 현재 값에 오른쪽 값을 더한 결과값을
       // 다시 왼쪽 공간에 할당한다.
       System.out.println("5. -=");
       number /= 2; // number의 현재 값인 -8에 오른쪽 값 2을 나눈 인
                    // -4를 다시 number에 할당해라 
       System.out.println("number의 현재값: " + number);
       System.out.println();
       
       // 6. %=
       // 왼쪽 공간의 현재 값에 오른쪽 값을 나눈 나머지를
       // 다시 왼쪽 공간에 할당한다.
       System.out.println("6. -=");
       number %= 2; // number의 현재 값인 -4에 오른쪽 값 2을 나눈 나머지인
                    // 0를 다시 number에 할당해라 
       System.out.println("number의 현재값: " + number);
       System.out.println();
       
       // += 의 경우, String 공간에도 사용 가능한데
       // 오른쪽 값을 왼쪽 공간의 현재값애 뒤에 이어붙여서
       // 하나의 커다란 String으로 만들어서
       // 왼쪽 공간에 결과값을 저장해라 라는 의미가 된다
       String str = "1"; // "1"
       str += 2; // "12"
       str += "3"; // "123"
       str += 4.5; // "1234.5"
       System.out.println("str의 현재값: " + str);
       
       // ++, --는 좀 특이한 연산자로써
       // 해당 공간의 값을 정확히 1씩 증가(감소)시킨다.
       // 단, 변수의 앞에 붙냐 뒤에 붙냐에 따라서 의미가 달라지게 된다.
       
       // ++ 혹은 --가 앞에 붙는 경우
       // 전위증가(감소)연산자 라고 부른다.
       // 전위증감연산자의 경우, 해당 줄에서 가장 높은 우선순위, 즉
       // 가장 빨리 실행되는 코드로 지정이 된다.
       
       System.out.println("1. 전위 증감 연산자");
       System.out.println("number의 현재값 : " + number);
       System.out.println("++number: " + ++number);
       // 위 코드는 한줄로 되어있는 것처럼 보이지만
       // 다음과 같은 과정을 거친다.
       // 1. ++number가 실행이 되어 number의 현재값인 0이 1 증가하여
       //       number의 현재값은 1이 된다.
       // 2. "++number: " 뒤에 number의 현재값인 1이 이어져서
       //    "++number: 1" 이라는 String 값이 만들어진다.
       // 3. System.out.println()이 해당 String 값을 화면에 출력한다.
       System.out.println("number의 현재값: " + number);
       System.out.println();
       
       // ++ 혹은 --가 변수의 뒤에 붙는 경우에는
       // 후위증감연산자라고 부르며
       // 해당 줄에서 가장 마지막 우선순위를 가진다.
       // 즉 가장 마지막에 실행이 된다.
       System.out.println("2. 후위증감연산자");
       System.out.println("number의 현재값:" + number);
       System.out.println("number++: " + number++);
       // 위 코드는 다음과 같은 과정을 가진다.
       // 1. "number++: " String 값 뒤에 number의 현재값인
       //     1이 이어져서 "number++: 1" 이라는 String 값이 만들어진다.
       // 2. System.out.println()이 해당 String 값을 화면에 출력한다.
       // 3. number++이 실행되서 number의 현재값이 1에서 2로 증가한다.
       
       System.out.println("number의 현재값 : " + number);
       System.out.println();
       
   }

}
