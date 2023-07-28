package Thread.synchronization;

import java.util.Random;

public class ThreadRandom implements Runnable {
    SharedData sharedData;

    public ThreadRandom(SharedData sharadData) {
        this.sharedData = sharadData;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){

            synchronized (sharedData){
                Random random = new Random();
                sharedData.rad = random.nextInt(10);
                System.out.println("T1 >> "+ sharedData.rad);

                sharedData.notifyAll();
                try {
                    sharedData.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("T1");
    }
}
