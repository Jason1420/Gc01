package Thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Barrier {
    private static final int NUM_THREADS = 3;

    public static void main(String[] args) {
        // Tạo một rào cản với số lượng luồng cần đến là 3
        CyclicBarrier barrier = new CyclicBarrier(NUM_THREADS);

        // Tạo và chạy 3 luồng đồng thời
        for (int i = 0; i < NUM_THREADS; i++) {
            Thread thread = new Thread(() -> {
                try {
                    System.out.println("Thread " + Thread.currentThread().getId() + " đến rào cản.");
                    // Gọi phương thức await() để thông báo đến rào cản rằng luồng đã đến.
                    barrier.await();
                    System.out.println("Thread " + Thread.currentThread().getId() + " tiếp tục thực thi sau khi rào cản được mở.");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
    }
}
