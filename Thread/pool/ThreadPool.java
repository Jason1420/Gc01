package Thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        // Tạo thread pool với 5 luồng
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        // Thực thi các tác vụ
        for (int i = 0; i < 10; i++) {
            Runnable task = new Task(i);
            threadPool.execute(task);
        }

        // Đóng thread pool sau khi hoàn thành các tác vụ
        threadPool.shutdown();
    }
}

class Task implements Runnable {
    private int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskId + " is being executed by Thread " + Thread.currentThread().getId());
    }
}
