package GarbageCollection;

public class DanglingPointer {
        public static void main(String[] args) {
            Integer a = 10;

            Integer b = a;

            System.out.println("a = " + a);
            System.out.println("b = " + b);

            a = null;

            System.out.println("a = " + a);
            System.out.println("b = " + b);

        }
}
