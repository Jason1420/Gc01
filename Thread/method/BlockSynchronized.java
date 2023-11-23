package Thread.method;

public class BlockSynchronized {
    private int count = 0;

    public int getCount() {
        return count;
    }

    private Object lock = new Object();
    // đồng bộ trên một đối tượng riêng biệt
    public void increment() {
        synchronized (/*this*/ lock) {
            count++;
            System.out.println(Thread.currentThread().getName() + "  "+count);
        }
    }
    public static void main(String[] args) {
        BlockSynchronized example = new BlockSynchronized();

        // Tạo và chạy 2 luồng đồng thời
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

        thread1.start();
        thread2.start();

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
