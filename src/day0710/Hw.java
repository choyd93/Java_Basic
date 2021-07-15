package day0710;
//숙제 : 사원관리 프로그램 클래스를 사용하여 만드시오
//사원은 사원의 번호, 이름, 부서, 직급, 연봉이 들어간다.
// 삭제한 사원 번호는 건너뛰기

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
    private static int nextId = 1; // <- 게시글이라 1로 설정 

    public static void main(String[] args) {
        showMenu();

    }

    // insert()
    private static void insert() {
        // 정보를 담을 EmplyManage 객체
        EmplyManage s = new EmplyManage();

        String msg;

        msg = new String("번호를 입력해주세요.");
        s.setId(nextId++); // <- 게시판이라 번호순서로 

        msg = new String("이름을 입력해주세요.");
        //s.setName(ScannerUtil.nextLine(scanner, msg));
        String name = ScannerUtil.nextLine(scanner, msg);
        s.setName(name);

        msg = new String("부서를 입력해주세요.");
        s.setTeam(ScannerUtil.nextLine(scanner, msg));

        msg = new String("직급을 입력해주세요.");
        s.setPosition(ScannerUtil.nextLine(scanner, msg));

        msg = new String("연봉을 입력해주세요.");
        s.setSalary(ScannerUtil.nextInt(scanner, msg, SALARY_MIN, SALARY_MAX));

        // <- 정보가 담긴 Employ 객체를 list에 추가
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
            String msg = "상세보기할 사원의 번호를 입력해주세요. (0은 뒤로가기)";
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%d, %s\n", list.get(i).getId(), list.get(i).getName());
            }
            int userChoice = ScannerUtil.nextInt(scanner, msg);
            
            while(selectById(userChoice) == null && userChoice != 0) {
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(scanner, msg);
            
            }
            if(userChoice != 0) {
                printOne(userChoice);
            }
        }
    }
    
    // 사용자가 입력한 사원 번호와 일치하는 리스트의 객체를
    // 리턴해주는 메소드.
    // 단, 일치하는 사원이 존재하지 않을 때에는
    // null 을 리턴해준다.
    
    private static EmplyManage selectById(int id) {
        EmplyManage e = new EmplyManage();
        e.setId(id);
        int index = list.indexOf(e);
        if(index != -1) {
            return list.get(index);
            
        }
        
        return null;
    }
    

    // printOne()
    public static void printOne(int id) {
        // 파라미터로 들어온 id 값을 사용하여
        // 일치하는 Employee 객체를 불러온다.
        EmplyManage e = selectById(id); // <- 이걸 왜 이런식으로 불러오나

        e.printInfo();
        
        String msg = new String("1. 수정 2. 삭제 3. 뒤로가기");
        int userChoice = ScannerUtil.nextInt(scanner, msg, 0, 3);
        if (userChoice == 1) {
            update(id);
        } else if (userChoice == 2) {
            delete(id);
        } else if (userChoice == 3) {
            printAll();
        }

    }

    // update()
    public static void update(int id) {
        String msg;
        // 파라미터로 들어온 id와 일치하는 Employee 객체
        EmplyManage e = selectById(id);
        
        msg = new String("새로운 부서를 입력해주세요.");
        e.setTeam(ScannerUtil.nextLine(scanner, msg));
        //list.get(index).setTeam(ScannerUtil.nextLine(scanner, msg));

        msg = new String("새로운 직급을 입력해주세요.");
        //list.get(index).setPosition(ScannerUtil.nextLine(scanner, msg));
        e.setPosition(ScannerUtil.nextLine(scanner, msg));
        
        msg = new String("새로운 연봉을 입력해주세요.");
        //list.get(index).setSalary(ScannerUtil.nextInt(scanner, msg, SALARY_MIN, SALARY_MAX));
        e.setSalary(ScannerUtil.nextInt(scanner, msg, SALARY_MIN, SALARY_MAX));
        
        printOne(id);

    }

    // delete()
    public static void delete(int id) {
        EmplyManage e = selectById(id);
        String msg = "정말로 삭제하시겠습니까? (y/n)";
        int userChoice = ScannerUtil.nextInt(scanner, msg, 1, 2);
        if (userChoice == 1) {
            list.remove(e);
            printAll();
        } else {
            printOne(id);
        }
    }
}