package day0707;
// ArrayUtil의 메소드들을 테스트 하는 클래

import util.ArrayUtil;
public class Ex01Test {
    public static void main(String[] args) {
        // 이제 우리가 크기가 알아서 늘어나는 배열을 만들었기 때문
        // 이제는 배열을 초기화할 때 크기를 0으로 초기화해준다.
        
        int[] arr = new int[0];
        
        // 1. arr의 현재크기를 출력
        System.out.println("ArrayUtil.size(arr) : "+ArrayUtil.size(arr));
        
        // 2. isEmpty()
        System.out.println("ArrayUtil.size(arr) : " +
        ArrayUtil.isEmpty(arr));
        
        // 3. add()
        arr = ArrayUtil.add(arr, 15); //<- 뒤에 번호는 배열 
        System.out.println("ArrayUtil.size(arr) : "+ArrayUtil.size(arr));

        arr = ArrayUtil.add(arr, 20);
        
        arr = ArrayUtil.add(arr, 25);

        arr = ArrayUtil.add(arr, 20);
        
        arr = ArrayUtil.add(arr, 30);
        
        System.out.println("ArrayUtil.size(arr) : "+ArrayUtil.size(arr));

        // 4. indexOf() <- 인덱스의 자리 출력
        
        System.out.println("indexOf(arr, 25): " +
        ArrayUtil.indexOf(arr, 25));
        
        System.out.println("indexOf(arr, 999): " +
        ArrayUtil.indexOf(arr, 999)); //<- 없으니까 -1 
        
        System.out.println("indexOf(arr, 20): " +
        ArrayUtil.indexOf(arr, 20));
        
       System.out.println("add(arr, index, e) 테스트");
       System.out.println("get(arr, 2) : " + ArrayUtil.get(arr, 2));
       arr = ArrayUtil.add(arr, 2, 999);
       System.out.println("get(arr, 2) : " + ArrayUtil.get(arr, 2));

    }
}
