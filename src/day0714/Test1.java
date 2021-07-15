package day0714;

public class Test1 {
    public static void main(String[] args) {

        int[] arr = new int[5];
        
        int number = 2;
        for (int i = 0; i <= arr.length; i++) {
            arr[i] = number;
            number *=2;
            System.out.println(arr[i]);
        }
        }
    }