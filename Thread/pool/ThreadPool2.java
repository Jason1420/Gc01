package Thread.pool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool2 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 100; i++) {
            threadPool.execute(new Task());
        }
        System.out.println("Thread name >> " + Thread.currentThread().getName());
    }

    public static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread name >> " + Thread.currentThread().getName());
        }
    }
}
