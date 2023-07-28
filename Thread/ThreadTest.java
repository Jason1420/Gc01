package Thread;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start main thread");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i =0; i < 1000000000; i ++){
                    System.out.println("Thread 1 >> " + i);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i =0; i < 1000000000; i ++){
                    System.out.println("Thread 2 >> " + i);
                }
            }
        });

        t1.start();
        t2.start();
//        t1.join();
        System.out.println("Stop main thread");

    }
    public synchronized void instanceMethod() {
        // Các thao tác được đồng bộ hóa trên đối tượng this
    }

    public void methodWithSynchronizedBlock() {
        // Các thao tác không đồng bộ ở đây

        synchronized (this) {
            // Các thao tác được đồng bộ hóa bên trong khối synchronized
        }

        // Các thao tác không đồng bộ ở đây
    }

    public static synchronized void staticMethod() {
        // Các thao tác được đồng bộ hóa trên lớp này
    }
}