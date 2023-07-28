package Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int count = 0;
    private Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock(); // Yêu cầu khóa
        try {
            count++; // Tăng giá trị biến count lên 1
        } finally {
            lock.unlock(); // Giải phóng khóa sau khi hoàn thành công việc
        }
    }

    public int getCount() {
        return count;
    }
    public static void main(String[] args) {
        Counter counter = new Counter();

        // Tạo và chạy 2 luồng đồng thời
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
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

        System.out.println("Final count: " + counter.getCount());
    }
}

