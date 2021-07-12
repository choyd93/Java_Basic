package day0710;
//숙제 : 사원관리 프로그램 클래스를 사용하여 만드시오
//사원은 사원의 번호, 이름, 부서, 직급, 연봉이 들어간다.

import java.util.Scanner;
import java.util.ArrayList;
import util.ScannerUtil;
import type.EmplyManage;

public class Hw {
    // 상수
    private static final int SALARY_MIN = 28000000;
    private static final int SALARY_MAX = 100000000;

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<EmplyManage> list = new ArrayList<>();
    private static int nextId = 1; // <- 이건 뭘까

    public static void main(String[] args) {
        showMenu();

    }

    // insert()
    private static void insert() {
        // 정보를 담을 EmplyManage 객체
        EmplyManage s = new EmplyManage();

        String msg;

        msg = new String("번호를 입력해주세요.");
        s.setId(nextId++); // <- 이거 뭐냐

        msg = new String("이름을 입력해주세요.");
        s.setName(ScannerUtil.nextLine(scanner, msg));

        msg = new String("부서를 입력해주세요.");
        s.setDepart(ScannerUtil.nextLine(scanner, msg));

        msg = new String("직급을 입력해주세요.");
        s.setRank(ScannerUtil.nextLine(scanner, msg));

        msg = new String("연봉을 입력해주세요.");
        s.setSalary(ScannerUtil.nextInt(scanner, msg, SALARY_MIN, SALARY_MAX));

        // <- 정보가 담긴 Student 객체를 list에 추가
        list.add(s);
    }

    // showMenu()
    public static void showMenu() {
        while (true) {
            String message = new String("1. 입력 2. 출력 3. 종료");
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
            if (userChoice == 1) {
                insert();
            } else if (userChoice == 2) {
                printAll();
            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                scanner.close();

                break;
            }
        }
    }

    // printAll()
    public static void printAll() {
        if (list.isEmpty()) {
            System.out.println("아직 입력된 정보가 없습니다.");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%d, %s\n", i + 1, list.get(i).getName());
            }
            String msg = "상세보기할 사원의 번호를 입력해주세요. (0은 뒤로가기)";
            int userChoice = ScannerUtil.nextInt(scanner, msg, 0, list.size()) - 1;
            if (userChoice != -1) {
                printOne(userChoice);
            }
        }

    }

    // printOne()
    public static void printOne(int index) {
        list.get(index).printInfo();
        String msg = new String("1. 수정 2. 삭제 3. 뒤로가기");
        int userChoice = ScannerUtil.nextInt(scanner, msg, 0, 3);
        if (userChoice == 1) {
            update(index);
        } else if (userChoice == 2) {
            delete(index);
        } else if (userChoice == 3) {
            printAll();
        }

    }

    // update()
    public static void update(int index) {
        EmplyManage s = new EmplyManage();
        String msg;

        msg = new String("직급을 입력해주세요.");
        list.get(index).setRank(ScannerUtil.nextLine(scanner, msg));

        msg = new String("연봉을 입력해주세요.");
        list.get(index).setSalary(ScannerUtil.nextInt(scanner, msg, SALARY_MIN, SALARY_MAX));

        printOne(index);

    }

    // delete()
    public static void delete(int index) {
        String msg = "정말로 삭제하시겠습니까? (y/n)";
        int userChoice = ScannerUtil.nextInt(scanner, msg, 1, 2);
        if (userChoice == 1) {
            list.remove(index);
            printAll();
        } else {
            printOne(index);
        }
    }
}