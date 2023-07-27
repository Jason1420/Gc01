public class TestHeap {
    public static void main(String[] args) throws InterruptedException {
        TestHeap[] list = new TestHeap[1000000000];
        int i = 0;
        while(true){
            list[i++] = new TestHeap();
            System.out.println(i);
//            Thread.sleep(50);
//            System.gc();
        }
    }
}
