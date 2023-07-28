package Thread;

public class ThreadSquare implements Runnable {
    SharedData sharedData;

    public ThreadSquare(SharedData sharadData) {
        this.sharedData = sharadData;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){

            synchronized (sharedData){
                try {
                    sharedData.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("T2 >> "+ sharedData.rad*sharedData.rad);
                sharedData.notifyAll();

            }
        }
        System.out.println("T2");
    }
}
