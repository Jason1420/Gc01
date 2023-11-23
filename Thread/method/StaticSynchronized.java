package Thread.method;

public class StaticSynchronized {
    private static int count = 0;

    public static synchronized void increment() {
        count++;
        System.out.println(Thread.currentThread().getName() + "  "+count);
    }
// đồng bộ static trên lớp, nên không cần tạo đối tượng
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() ->{
            for(int i = 0; i< 10; i++){
                increment();
            }
        });
        Thread t2 = new Thread(() ->{
            for(int i = 0; i< 10; i++){
                increment();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final count: " + count);
    }

}
