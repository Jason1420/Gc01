package Thread.method;

public class BlockSynchronized {
    private int count = 0;

    public int getCount() {
        return count;
    }

    private Object lock = new Object();

    public void increment() {
        synchronized (lock) {
            count++; // Thực hiện việc tăng biến count một lần duy nhất bởi một luồng tại một thời điểm
        }
    }
    public static void main(String[] args) {
        BlockSynchronized example = new BlockSynchronized();

        // Tạo và chạy 2 luồng đồng thời
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                example.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
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
