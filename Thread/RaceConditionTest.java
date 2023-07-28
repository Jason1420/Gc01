package Thread;

public class RaceConditionTest {
    private static int count = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
//                synchronized (RaceConditionTest.class){
                    count++;
//                }
//                System.out.println("Thread 1 >> " +i+" >> " + count);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
//                synchronized (RaceConditionTest.class){
                    count++;
//                }
//                System.out.println("Thread 2 >> " +i +" >> " + count);
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + count);
    }
}
