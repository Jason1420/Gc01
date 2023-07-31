package Thread.rdnumber;

public class CurrentNumberThread extends Thread{
    int count;
    boolean isStop = false;

    public int getCount(){
        return count;
    }
    @Override
    public void run(){
        while(!isStop){
            count++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
