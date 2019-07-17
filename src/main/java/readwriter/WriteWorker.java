package readwriter;

import java.util.Random;

public class WriteWorker extends Thread{
    private SharedData sharedData;
    private String filter;
    private int index = 0;
    private Random random;

    public WriteWorker(SharedData sharedData,String filter){
        this.sharedData=sharedData;
        this.filter =filter;
    }

    @Override
    public void run() {
        try {
            while (true){
                sharedData.write(this.nextChar());
                Thread.sleep(1000l);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public char nextChar(){
        char c = filter.charAt(index);
        index++;
        if (index>=filter.length())
            index = 0;
        return c;
    }
}
