package day0705;
// LottoGame02.java의 코드를 복사해오고

import java.util.Random;

public class LottoGame03 {
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
        
        // 정렬하는 코드를 구현해보자
        // 정렬은 i번째와 i+1번을 비교하여
        // 만약 i번째에 저장된 값이 더 크면
        // 2개의 위치를 바꾸고 다시 처음부터 검사해주면 된다.
        
        // 이거 어려움.
        for(int i = 0; i < numbers.length - 1; i++) { //영상
            if(numbers[i] > numbers[i+1]) {
                int temp = numbers[i];
                numbers[i] = numbers[i+1];
                numbers[i+1] = temp;
                i = -1; // 다시 맨처음부터 검사하려고 
            }
        }
        
     // 정렬 후 출력
        System.out.println("--------------------------");
        System.out.println("정렬 후");
        System.out.println("--------------------------");
        for(int i = 0; i < numbers.length; i++) {
            System.out.printf("numbers[%d] : %d\n",i, numbers[i]);
        }
        System.out.println("--------------------------");
        
    }
}
