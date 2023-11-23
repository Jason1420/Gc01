package Thread;

public class ThreadTest2 {
    private int count = 0;

    public int getCount() {
        return count;
    }

    private Object lock = new Object();
    // đồng bộ trên một đối tượng riêng biệt
    // các đối tượng khác không bị ảnh hưởng (bao gồm this)

    private Object lock2 = new Object();

    public void increment() {
        synchronized (lock) {
            count++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + "  " + count);
        }
    }

    public void print() {
        synchronized (lock2) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        ThreadTest2 example = new ThreadTest2();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                example.increment();
            }
        });

        Thread thread2 = new Thread(() -> {

            for (int i = 0; i < 10; i++) {
                example.increment();
            }
        });

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                example.print();
            }


        });
        Thread thread4 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                example.print();
            }


        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        // Đợi cho cả hai luồng thực thi xong
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + example.getCount());
    }
}