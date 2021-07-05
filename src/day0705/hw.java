package day0705;
// 숙제 1. 5명의 키와 몸무게를 토대로 해서 bmi 결과를 입력한 사람까지만 출력하는 프로그램

//사용자로부터 키와 몸무게를 입력 받아서

//BMI를 계산하여
//비만도를 출력하는 프로그램
//단,  기네스북에 따르면 셰게에서 가장 키가 컸던 사람의 키는 
//2.72m였습니다.
//또한 가장 몸무게가 무거웠던 사람의 몸무게는 635kg이었습니다.
//만약 사용자가 잘못된 값을 입력할 경우, 
//올바른 값을 입력할 때 까지 다시 입력 받으시오

// 숙제 2. 숫자 맞추기 게임에서 점수를 총 5개까지 보관하고
//         점수는 자동으로 오름차순 정렬해서 보여주게 만들어주는 프로그램.

//사용자가 1. 플레이 2. 최고기록 보기 3. 종료
//중 하나를 입력하면, 각각의 기능이 실행된다.
//1. 플레이
// 사용자가 플레이를 실행시키면, 컴퓨터는
// 1~100까지의 랜덤한 숫자를 생성한다.
// 그리고 사용자는 그 숫자가 얼마인지 입력해서 맞춰야 하는데
// 사용자가 맞출때까지 입력은 계속 된다.
// 만약 사용자가 입력한 숫자가 컴퓨터의 숫자보다 크면 "DOWN" 이라고 출력된다.
// 만약 사용자가 입력한 숫자가 컴퓨터의 숫자보다 작으면 "UP" 이라고 출력된다.
// 또한, 사용자가 틀릴 때마다 현재 점수가 1점씩 올라가는데
// 최종적으로, 최고기록과 비교해서현재 점수가 더 작으면
// 현재 점수가 새로운 최고기록이 된다.
// 그리고 사용자가 정답을 맞추면 현재 점수, 최고 기록 그리고
// 만약 사용자가 최고 기록을 갱신했으면 축하메시지까지 출력이 된다.

//2. 최고기록 보기
// 현재 최고기록을 보여준다.
// 단, 만약 사용자가 한번도 플레이 한적이 없으면
// "아직 플레이 기록이 없습니다!"만 출력이 된다.

//3. 종료
// 프로그램을 종료시킨다.

import java.util.Scanner;

public class hw {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1번 문제

        // 1. 상수 선언
        // 1) 최대 학생 숫자
        final int STUDENT_SIZE = 5;
        // 2) 몸무게 최대값
        final double WEIGHT_MAX = 635;
        // 3) 키 최대값 
        final double HEIGHT_MAX = 2.72;
        // 4) 몸무게, 키 최소값
        final double WH_NUMBER_MIN = 1;
        // 4) BMI 범위 선언
        final double STANDARD_I = 18.5;
        final double STANDARD_II = 23;
        final double STANDARD_III = 25;

        // 2. 변수 배열 저장
        // 1) 번호를 저장할 배열
        int[] idArray = new int[STUDENT_SIZE];
        // 2) 이름을 저장할 배열
        String[] nameArray = new String[STUDENT_SIZE];
        // 3) 키를 저장할 배열
        double[] heightArray = new double[STUDENT_SIZE];
        // 4) 몸무게를 저장할 배열
        double[] weightArray = new double[STUDENT_SIZE];
        // 5) bmi를 저장할 배열 <- 이게 맞는 지 궁금.
        double[] bmiArray = new double[STUDENT_SIZE];
        // 6. 비만도를 저장할 배열 <- 이게 맞는 지 궁금.
        String[] resultArray = new String[STUDENT_SIZE];

        int index = 0; // <- 이게 중요한듯 함.

        boolean inputSwitch = false; // <- 이게 중요한듯 함.

        // 3. 학생 5명 정보 입력 받고 잘못 입력 했을 시 블록하는 코드
        if (index < STUDENT_SIZE) {
            // 입력 가능한 상태
            // 각 배열의
            // index번 칸에
            // 정보를 입력한다.

            System.out.println("번호를 입력해주세요.");
            System.out.print("> ");
            idArray[index] = scanner.nextInt();

            System.out.println("이름을 입력해주세요.");
            System.out.print("> ");
            scanner.nextLine();
            nameArray[index] = scanner.nextLine();

            double score; // <- 하나로 통일해서 관리하기

            System.out.println("키를 입력해주세요.");
            System.out.print("> ");
            score = scanner.nextDouble();

            // 잘못 입력 했을 시 블록하는 코드
            while (!(score >= WH_NUMBER_MIN && score <= HEIGHT_MAX)) {
                System.out.println("잘못 입력하셨습니다.");
                System.out.println("키를 다시 입력해주세요.");
                System.out.print("> ");
                score = scanner.nextDouble();
            }
            heightArray[index] = score;

            System.out.println("몸무게를 입력해주세요.");
            System.out.print("> ");
            score = scanner.nextDouble();

            // 잘못 입력 했을 시 블록하는 코드
            while (!(score >= WH_NUMBER_MIN && score <= WEIGHT_MAX)) {
                System.out.println("잘못 입력하셨습니다.");
                System.out.println("몸무게를 다시 입력해주세요.");
                System.out.print("> ");
                score = scanner.nextDouble();
            }
            weightArray[index] = score;

            // 다음 입력할 순서를
            // 1 증가시킨다.
            index++;
        } else {
            // 더이상 입력할 수 없는 상태
            System.out.println("이미 5명의 정보를 입력했습니다.");
        }

        // 4. 학생 정보 입력 안됬을 때 블록
        if (index == 0) {
            // 아직 한명도 입력이 안되어 있는 상태
            System.out.println("아직 한명도 입력되지 않았습니다.");
        } else {
            // 한명 이상이 입력되어 있는 상태
            for (int i = 0; i < index; i++) {

                // 5. BMI를 계산한다. <- 이렇게 하는 게 맞는지 궁금
                bmiArray[i] = weightArray[i] / heightArray[i] / heightArray[i];

                // 6. if - else if 구조를 통하여
                // 비만도를 String에 저장
                if (bmiArray[i] < STANDARD_I) {
                    resultArray[i] = "저체중";
                } else if (bmiArray[index] < STANDARD_II) {
                    resultArray[i] = "정상체중";
                } else if (bmiArray[index] < STANDARD_III) {
                    resultArray[i] = "과체중";
                } else {
                    resultArray[i] = "비만";
                }
                // 7. 출력
                System.out.printf("번호 : %03d번 이름 : %s\n", idArray[i], nameArray[i]);
                System.out.printf("키 : %.2f m 몸무게 : %.2f kg\n", heightArray[i], weightArray[i]);
                System.out.printf("bmi : %.3f m 비만도 : %2d\n", bmiArray[i], resultArray[i]);
            }
        }
        scanner.close();
    }
}