package Thread;

public class MultiThread {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();
        Thread t1 = new Thread(new ThreadRandom(sharedData));
        Thread t2 = new Thread(new ThreadSquare(sharedData));
        t2.start();
        t1.start();
    }
}
