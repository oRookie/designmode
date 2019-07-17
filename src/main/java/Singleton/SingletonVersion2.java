package Singleton;

import java.util.stream.IntStream;

/**
 * 懒加载
 */
public class SingletonVersion2 {
    private static SingletonVersion2  singletonVersion2;

    private SingletonVersion2(){}

    public static SingletonVersion2 getInstance(){
        if (singletonVersion2 == null){
            singletonVersion2 = new SingletonVersion2();
        }
        return singletonVersion2;
    }

    public static void main(String[] args) throws InterruptedException {
       // IntStream.rangeClosed(1,100).forEach(i-> System.out.println(SingletonVersion1.getInstacne()));

        Thread t1 = new Thread(()->{
            IntStream.rangeClosed(1,40).forEach(i->new Thread(()->{
                System.out.println(SingletonVersion2.getInstance());
            },i+"").start());
        });
        t1.start();
        t1.join();
    }
}
