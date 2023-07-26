public class TestHeap {
    public static void main(String[] args) {
        TestHeap[] list = new TestHeap[1000000000];
        for(int i =0; i < 1000000000; i++){
            TestHeap a = new TestHeap();
            System.out.println(i);
//            System.gc();
        }
    }
}
