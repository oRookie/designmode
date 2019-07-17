package Singleton;

import java.util.stream.IntStream;

public class SingletonVersion4 {
    static class InstanceHoleder {
        private final static  SingletonVersion4 singletonVersion4 = new SingletonVersion4();
    }
    public static SingletonVersion4 getInstance(){
        return InstanceHoleder.singletonVersion4;
    }

    public static void main(String[] args) throws InterruptedException {
        // IntStream.rangeClosed(1,100).forEach(i-> System.out.println(SingletonVersion1.getInstacne()));

        Thread t1 = new Thread(()->{
            IntStream.rangeClosed(1,40).forEach(i->new Thread(()->{
                System.out.println(SingletonVersion4.getInstance());
            },i+"").start());
        });
        t1.start();
        t1.join();
    }
}
