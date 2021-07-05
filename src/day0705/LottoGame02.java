package day0705;
// 로또 번호 생성기
// 중복 제거 버젼

import java.util.Random;

public class LottoGame02 {
    public static void main(String[] args) {
        Random random = new Random();
        final int SIZE = 6;
        final int NUMBER_MAX = 45;
        
        // 랜덤한 숫자를 담을 배열 생성
        int[] numbers = new int[SIZE];
        
        // 배열에 랜덤한 숫자를 넣는다.
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(NUMBER_MAX)+1;
        }
        
        // 중간 단계 출력
        System.out.println("--------------------------");
        System.out.println("중복 제거 전");
        System.out.println("--------------------------");
        for(int i = 0; i < numbers.length; i++) {
            System.out.printf("numbers[%d] : %d\n",i, numbers[i]);
        }
        System.out.println("--------------------------");
        
        // 2중 for 문을 사용하여
        // i와 j가 다르지만
        // numbers[i]와 numbers[j]가 같으면
        // i에 새로운 값을 넣고
        // 다시 처음부터 검사하는 for문을 만들어보자.
        for(int i = 0; i < numbers.length; i++) {
            for(int j = 0; j < numbers.length; j++) {
               if(i != j && numbers[i] == numbers[j]) {
                   System.out.println("--------------------------");
                   System.out.printf("%d와 %d에 중복!\n", i, j);
                   numbers[i] = random.nextInt(NUMBER_MAX) + 1;
                   System.out.println("--------------------------");
                   j = -1;
                   
                   // 0으로 하면 j가 0으로 원래 초기화 되어 있기 떄문에 0부터 하기 위해
                   // -1을 넣어야 댐.
               }
            }
        }
      
        // 중복 제거 후 출력
        System.out.println("--------------------------");
        System.out.println("중복 제거 후");
        System.out.println("--------------------------");
        for(int i = 0; i < numbers.length; i++) {
            System.out.printf("numbers[%d] : %d\n",i, numbers[i]);
        }
        System.out.println("--------------------------");
        
        
    }

}
