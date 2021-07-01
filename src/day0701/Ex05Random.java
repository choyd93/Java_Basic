package day0701;
// Random
// 스캐너와 마찬가지로, 자바가 기본적으로 제공해주는
// 라이브러리에 포함된 Random 클래스는
// 우리가 랜덤한 숫자를 필요로 할 때
// 사용되는 클래스 데이터타입으로써,
// 스캐너처럼 import를 해야 한다.

import java.util.Random;

public class Ex05Random {
    public static void main(String[] args) {
        // Random 클래스 변수를 만들 떄에는
        // new Random() 안에
        // 숫자를 입력하면
        // 새로 실행해도 랜덤한 값이 안나온다.
        
        Random random = new Random();
        
        // 1. Random 클래스 변수는
        // 내부적으로
        // 0과 1 사이의 무수한 실수를
        // 뒤죽박죽 가지고 있다.
        // 예시 : 0 0.718234 0.123417 0.123 -0 0.821 0.4571 ....
        // 만약 우리가 특정 데이터타입의 값이 필요하다고 하면
        // 내부적으로 해당 데이터타입의 최대값을 곱해서
        // 만들어준다.
        
        // 1.랜덤한 실수가 필요한 경우, nextDouble()을 쓰면 된다.
        double d = random.nextDouble();
        
        System.out.printf("컴퓨터가 뽑아준 랜덤 실수 : [%.4f]\n", d);
        
        // 2. 랜덤한 정수가 필요한 경우, nextInt()를 쓰면 된다.
        int i = random.nextInt();
        
        System.out.printf("컵퓨터가 뽑아준 랜덤 정수 : [%d]\n", i);
        
        // 3. 특정 범위안의 랜덤한 정수가 필요한 경우, nextInt(최대값)을 쓰면 된다.
        //    단, 이 때에는 0부터 최대값 -1 사이의 랜덤한 숫자가 나오게 된다.
        
        i = random.nextInt(3);
        
        System.out.printf("특정 범위 안의 랜덤 정수 : [%d]\n", i);
        
        // 그렇다면
        // 만약 0부터 최대값 -1이 아닌
        // 1부터 최대값까지의 랜덤한 정수가 필요할 땐
        // 어떻게 해야할까??
        // 최종 결과값에 1을 더해주면 된다.
        
        i = random.nextInt(3) + 1;
        // random.nextInt(3) -> 0 1 2
        // 0 -> 1
        // 1 -> 2
        // 2 -> 3
        
        System.out.println("i+1:" + (i+1));
        
        
        System.out.printf("특정 범위 안의 랜덤 정수 : [%d]\n", i);    
    }
}
