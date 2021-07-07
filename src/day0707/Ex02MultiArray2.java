package day0707;
// 구구단을 출력하는 프로그램을 작성하시오.
// 단, 2차원 배열을 사용하여
// 2~9단의 결과값을 각각의 배열에 먼저 저장하고
// 그리고 2차원 배열 전체를 출력하는 방식으로 작성하시오.
// 11시 20분까지

public class Ex02MultiArray2 {
    public static void main(String[] args) {
        int[][] intArr = new int[9][9];
        // 각 단의 결과값을 담을 2차원 배열 선언 
        int[][] gugudan = new int[8][9]; // 2단부터 시작하기 떄문에 8
        
        
        
        // 각 단의 결과값을 저장하는 for 문
        for(int i = 0; i < gugudan.length; i++) {
            // 현재 몇단인지를 저장할 int 변수
            int dan = i + 2;
            for(int j = 0; j < gugudan[i].length; j++) { //gugudan[i] <-이건 왜?
                int multiplier = j + 1;
                gugudan[i][j] = dan * multiplier; //<- 이게 핵심.
            }
        }
        
        // 각 단의 결과값을 출력하는 for 문
        for(int i = 0; i < gugudan.length; i++) {
            System.out.println();
            System.out.println("==========================");
            System.out.printf("%2d단\n", i+2);
            System.out.println("==========================");
            for(int j = 0; j < gugudan[i].length; j++) { //gugudan[i] <-이건 왜?

                System.out.printf("%d * %d = %2d\n", i + 2, j + 1, gugudan[i][j]);
                System.out.println("-------------------------");
            }
        }

        
        
        /*
        // 배열끼리 곱하게 하는 방법 -> 선언?
        // int aa = i * j; // <- 따로 선언?
        
        for(int i = 1; i < intArr.length; i++) {
            for(int j = 1; j < intArr[i].length; j++) {
                System.out.printf("intArr[%d]x[%d]:%d\n", 
                        i, j, intArr[i] * intArr[j]);
            }
        }
        */
    }
}
