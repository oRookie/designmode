package readwriter;

import java.util.Optional;

public class ReadWorker extends Thread{
    private SharedData sharedData;
    
    public ReadWorker(SharedData sharedData){
        this.sharedData=sharedData;
    }
    
    @Override
    public void run() {
        try{
            while (true){
                char[] chars = sharedData.read();
                Optional.of(Thread.currentThread().getName() +" reads "+String.valueOf(chars)).ifPresent(System.out::println);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
