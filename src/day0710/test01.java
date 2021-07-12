package day0710;
//숙제 : 사원관리 프로그램 클래스를 사용하여 만드시오

//사원은 사원의 번호, 이름, 부서, 직급, 연봉이 들어간다.

import java.util.Scanner;
import java.util.ArrayList;
import util.ArrayUtil;
import util.ScannerUtil;
import type.EmplyManage;

public class test01 {
    // 상수
    static final int SALALY_MIN = 28000000;
    static final int SALALY_MAX = 100000000;

    // 변수
    static Scanner scanner = new Scanner(System.in);
    static ArrayList <EmplyManage> list = new ArrayList<>();// <- 어레이 리스트 객체

    public static void main(String[] args) {
        showMenu();

    }

    // showMenu()
    public static void showMenu() {
        String msg = new String("1. 입력 2. 출력 3. 종료"); // <- 안일까 밖일까
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, msg, 1, 3);
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

    // insert()
    public static void insert() {
        EmplyManage s = new EmplyManage();         //<- 객체 생성

        String msg;
        msg = new String("사원 번호를 입력해주세요.");
        s.setId(ScannerUtil.nextInt(scanner, msg));
        
        msg = new String("사원 이름을 입력해주세요.");
        s.setName(ScannerUtil.nextLine(scanner, msg));

        msg = new String("사원 부서를 입력해주세요.");
        s.setDepart(ScannerUtil.nextLine(scanner, msg));

        msg = new String("사원 직급을 입력해주세요.");
        s.setRank(ScannerUtil.nextLine(scanner, msg));

        msg = new String("사원 연봉을 입력해주세요.");
        s.setSalary(ScannerUtil.nextInt(scanner, msg, SALALY_MIN, SALALY_MAX));

        //<- add 비슷한거 
    }
    
    // printAll()
    public static void printAll() {
        EmplyManage s = new EmplyManage();         //<- 객체 생성 이거 맞나?
        s.printInfo();
        
        String msg = new String("1. 수정하기 2. 삭제하기 3. 뒤로가기");
        int userChoice = ScannerUtil.nextInt(scanner, msg, 1, 3);
        
        if (userChoice == 1) {
            update();
        }else if (userChoice == 2) {
            delete(userChoice); // <- 유저초이스 이유?
        }else if (userChoice == 3) {
            printOne(); // <- 이 곳 맞을까
        }
    }

    // printOne() <- 여긴 뭘까
    public static void printOne(int index) {
        
      String msg = new String ("상세보기할 학생의 번호를 입력해주세요. (0은 뒤로가기");
      int userChoice = ScannerUtil.nextInt(scanner, msg, 0, list.get(index).getName()) - 1;
        
      if( userChoice != -1)  { //<- 이게 맞나
          System.out.println("아직 입력한 값이 없습니다.");
      } else {
          printOne();
      }

      
    }

    // update()
    public static void update() {
        EmplyManage s = new EmplyManage();         //<- 객체 생성

        String msg;
        msg = new String("사원 번호를 입력해주세요.");
        s.setId(ScannerUtil.nextInt(scanner, msg));
        
        msg = new String("사원 이름을 입력해주세요.");
        s.setName(ScannerUtil.nextLine(scanner, msg));

        msg = new String("사원 부서를 입력해주세요.");
        s.setDepart(ScannerUtil.nextLine(scanner, msg));

        msg = new String("사원 직급을 입력해주세요.");
        s.setRank(ScannerUtil.nextLine(scanner, msg));

        msg = new String("사원 연봉을 입력해주세요.");
        s.setSalary(ScannerUtil.nextInt(scanner, msg, SALALY_MIN, SALALY_MAX));
        
        printAll(); //<- 여기가는거 맞을까
    }

    // delete()
    public static void delete(int index) {
        String msg = new String("정말로 현재 정보를 삭제하시겠습니까? (y/n)");
        int userChoice = ScannerUtil.nextInt(scanner, msg, 1, 2);
        if(userChoice == 1) {
            list.remove(index);
        } else {
            printOne(); // <- 여기 맞을까 
        }
    }

}
