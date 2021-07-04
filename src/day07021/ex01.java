package day07021;
// 별찍기 1번 연습
import java.util.Scanner;

public class ex01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       // 상수값 입력
        
        //입력을 받는다.
        System.out.println("숫자를 입력하세요.");
        System.out.print("> ");
        
        int userNumber = scanner.nextInt();
        
        // 선언 i 최소값 최대값? 시작과 끝
        int iStart = 1; // 처음에 출력할 값이 1이므로
        int iEnd = userNumber; // 유저값만큼 출력해야 하므로
                
        //세로 1
        //String stars = "*"; // 이걸 언제 선언하는지 모르겠음. 마지막에 별을 출력해야 되니까 여기에 선언하자.

        for(int i = iStart; i <= iEnd; i++) {
            String stars = ""; // 공백 선언
            // 여기 뭔가 들어가야함.
            
            //가로 1
            // 선언 
            int jStart = 1;
            int jEnd = i; //나는 userNumber로 작성함.
            for(int j = jStart; j <= jEnd; j++) {
                
                // j for문이 한번 반복할 때마다
                // stars의 현재 내용에 *을 붙여서
                // 다시 stars에 저장한다.
                stars += "*";

            }
            // 마지막에 별 출력
            System.out.println(stars);

        }
        System.out.println(""); // 이건뭘까?
        
        scanner.close();
    }

}

// 선언할 때 들어갈 값이 중요함. 기억 안나는 부분을 공부해서 확고하게 만들어야 함.
