package day0707;

public class dd {
    
        private static void swap(int a, int b) {
            int temp = a;
            a = b;
            b = temp;
        }

        public static void main(String args[]) {
            int a = 1;
            int b = 2;

            System.out.println("a => " + a);
            System.out.println("b => " + b);

            swap(a, b);

            System.out.println("------- swap 후 -------");

            System.out.println("a => " + a);
            System.out.println("b => " + b);
        }
    }

