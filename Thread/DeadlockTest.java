package Thread;

public class DeadlockTest {
    public static String s1 = "Hello";
    public static String s2 = " World";
    public static class ThreadS1 implements Runnable{

        @Override
        public void run() {
            while(true){
                synchronized (s1){
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (s2){
                        System.out.println(s1 + s2);
                    }
                }
            }
        }
    }

    public static class ThreadS2 implements Runnable{

        @Override
        public void run() {
            while(true){
                synchronized (s2){
                    synchronized (s1){
                        System.out.println(s1 + s2);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadS1());
        Thread t2 = new Thread(new ThreadS2());
        t1.start();
        t2.start();
    }
}
