package GarbageCollection;

import java.util.ArrayList;
import java.util.List;

public class GarbageCollectionTest {
    public static void main(String[] args) {
        int i = 0;
        List<int[]> list = new ArrayList<>();
        while (true) {
            int[] a = new int[10000];
            int[] b = new int[10000];
            int[] c = new int[10000];
            if(i % 1000 == 0){
                list.add(a);
                list.add(b);
                list.add(c);
            }
            a = null;
            b = null;
            c = null;
            System.out.println(i++);

        }
    }
}
