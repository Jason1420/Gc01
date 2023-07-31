package Thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            Runnable task = new Task(i);
            threadPool.execute(task);
        }

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
