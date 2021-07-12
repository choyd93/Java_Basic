package day0710;
// ArrayList
// 기존에 우리가 여러 개의 똑같은 데이터타입을 다루기 위해
// 사용했던 배열은 2세대 언어에서도 존재하던 개념으로써
// 클래스화가 되어있지 않았기 때문에 동적할당이나
// 도움이 되는 메소드를 우리가 ArrayUtil 이라는 별개의
// 메소드를 모아둔 클래스를 사용해서 도움을 받았었다.
// 하지만, 우리가 직접 경험을 했듯이, Arrayutil에 만들어 놓은 메소드는
// 특정 데이터타입에만 적용되는 메소드들을 만들어놨기 때문에
// 우리가 다른 데이터타입을 만들면, 매번 해당 데이터타입에 적용될 수 있는
// 메소드를 ArrayUtil에 처음부터 끝까지 새로 만들었어야 했다. 

// 그렇다면, 자바는 동적할당이 가능한 배열을 내부적으로 제공해주지 않을까?
// 자바에서 기본적으로 제공해주는 ArrayList는 
// 쉽게 말해서 배열을 클래스화 시켜놓은 것으로써,
// 우리가 데이터타입을 새로 만들더라도
// 이 ArrayList를 사용하면 손쉽게 동적할당을 적용시킬 수 있다.

// ArrayList를 import 하자
import java.util.ArrayList; 
import type.Student;

public class Ex02ArrayList {
    public static void main(String[] args) {
        // ArrayList 객체를 만들 때에는
        // 반드시 해당 객체가 무엇의 모음집 인지를
        // < > 안에 적어주어야 한다.
        // 이러한 < > 를 우리는 템플릿이라고 부른다.
        // 단, 템플릿 안에는 반드시 클래스 이름이 들어와야 한다.
        // 하지만 기본형 데이터타입의 ArrayList 등
        // 기본형 데이터타입을 모은 클래스가 필요할 때에는
        // 우리가 기본형 데이터타입을 클래스로 "포장" 시켜놓은
        // 자바의 기본 클래스를 사용하게 된다.
        // 대표적으로 int는 integer, double은 Double등이 있다.
        // 이러한 클래스들을 "포장 클래스" 혹은 wrapper 클래스라고 한다.
        
        // ArrayList 객체의 선언과 초기화
        // ArrayList<클래스 이름> 이름 = new ArrayLis<>();
        
        ArrayList<Student> list = new ArrayList<>();
        
        // 1. 현재 list가 비어있는지 체크할 때에는?
        //    list.isEmpty()
        System.out.println("1. isEmpty()");
        System.out.println("list.isEmpty() : " + list.isEmpty());
        
        // 2. 현재 list의 크기를 알고 싶을 떄에는?
        //    list.size()
        System.out.println("2. size()");
        System.out.println("list.size() : " + list.size());
        
        Student s1 = new Student(1, "1", 1, 1, 1);
        Student s2 = new Student(2, "2", 2, 2, 2);
        Student s3 = new Student(3, "3", 3, 3, 3);
        Student s4 = new Student(4, "4", 4, 4, 4);
        Student s5 = new Student(5, "5", 5, 5, 5);
        
        // 3. 현재 list에 새로운 객체를 추가할 때에는?
        //    list.add(객체)
        
        System.out.println("3. add()");
        list.add(s1);
        System.out.println("add(s1) 이후 size() : " + list.size());
        list.add(s2);
        System.out.println("add(s2) 이후 size() : " + list.size());
        list.add(s3);
        System.out.println("add(s3) 이후 size() : " + list.size());
        list.add(s4);
        System.out.println("add(s4) 이후 size() : " + list.size());
        list.add(s5);
        System.out.println("add(s5) 이후 size() : " + list.size());

        // 4. 특정 인덱스에 있는 객체를 불러올 때에는?
        //  get(인덱스)
        System.out.println("4. get()");
        System.out.println("list.get(0).getName() : "
                + list.get(0).getName());
        
        // 5. 특정 인덱스에 새로운 객체를 추가할 때에는?
        //    add(인덱스)
        Student s6 = new Student(6,"6", 6, 6, 6);
        System.out.println("6. add(index)");
        System.out.println("add(index) 전 get(3).getName() : "
                + list.get(3).getName());
        System.out.println("add(index) 전 size() : " + list.size());
                list.add(3, s6);
        System.out.println("add(index) 후 get(3).getName() : "
                + list.get(3).getName());
        System.out.println("add(index) 후 size() : " + list.size());

        // 6. 특정 인덱스에 객체를 다른 객체로 바꿀 떄에는?
        //    set()
        System.out.println("6. set()");
        System.out.println("set() 전 get(5)의 getName() : "
                + list.get(5).getName());
        Student temp = list.set(5, s6);
        System.out.println("set() 후 get(5)의 getName() : "
                + list.get(5).getName());
        System.out.println("temp.getName() : " + temp.getName());
        
        // 7. 특정 인덱스의 객체를 삭제할 때에는?
        //    remove(index)
        //    단 잘못된 인덱스를 삭제하면 에러
        System.out.println("7. remove(index)");
        System.out.println("remove() 전 get(2).getName() : " + list.get(2).getName());
        System.out.println("remove() 전 size : " + list.size());
        list.remove(2);
        System.out.println("remove() 후 get(2).getName() : " 
                + list.get(2).getName());
        System.out.println("remove() 후 size : " + list.size());


        
        // 여기서부터는
        // 템플릿 클래스 안에
        // equals() 메소드가 정확하게 오버라이드 되어있어야
        // 정상적으로 결과가 나오게 된다.
        // 왜냐하면 여기서부터 사용할 메소드들은 내부적으로
        // 템플릿 클래스 객체의 equals() 메소드를 사용하기 때문이다. 
        // 8. 특정 객체가 리스트에
        //    존재하는지 확인할 때에는
        //    contains().
        //    단, 객체에는 equals()가 true가 나오는 객체면
        //    다른 객체더라도 상관없다.
        System.out.println("7. contains()");
        Student s100 = new Student(1, "1", 1, 1, 1); // <- 이해 안됨.
        Student s7 = new Student(7, "7", 7, 7, 7);
        System.out.println("list.contains(s1) : " + list.contains(s1));
        System.out.println("contains(s7) : " + list.contains(s7));
        System.out.println("contains(s100) : " + list.contains(s100));

        // 9. 특정 객체의 리스트 안에서의
        //    인덱스를 찾을 때에는?
        //    indexof()
        //    단, 해당 객체가 존재하지 않으면 -1
        System.out.println("8. indexof()");
        System.out.println("indexof(s6) : " + list.indexOf(s6));
        System.out.println("indexof(s7) : " + list.indexOf(s7));
        System.out.println("indexof(s100) : " + list.indexOf(s100));
        
        // 10. 특정 객체가 인덱스 중 가장 마지막에 있는 번호를 찾을 때에는?
        //    lastIndexOf()
        System.out.println("9. lastIndexof()");
        System.out.println("lastIndexof(s6) : " + list.lastIndexOf(s6));
        
        // 11. 리스트에서 특정 객체를 삭제할 때에는?
        //     remove(객체)
        //     만약, 일치하는 객체가 없으면? 삭제 안됨.
        //     다른 객체지만 equals()가 true가 나오는 객체가 리스트에 있으면?
        //     해당 객체는 삭제됨.
        System.out.println("11. remove()");
        System.out.println("remove(s6) 전 size() : " + list.size());
        list.remove(s6);
        System.out.println("remove(s6) 후 size() : " + list.size());

        
        System.out.println("remove(s6) 전 size() : " + list.size());
        list.remove(s7);
        System.out.println("remove(s6) 후 size() : " + list.size());

        
        System.out.println("remove(s6) 전 size() : " + list.size());
        list.remove(s100);
        System.out.println("remove(s6) 후 size() : " + list.size());


    }

}
