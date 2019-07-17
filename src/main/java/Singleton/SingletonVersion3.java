package Singleton;

import java.util.stream.IntStream;

/**
 * double check
 * 懒加载
 */
public class SingletonVersion3 {
    private static SingletonVersion3  singletonVersion3;

    private SingletonVersion3(){}

    public  static SingletonVersion3 getInstance(){
        if (singletonVersion3 == null){
            synchronized (SingletonVersion3.class){
                if (singletonVersion3 == null)
                singletonVersion3 = new SingletonVersion3();
            }
        }
        return singletonVersion3;
    }
    public static void main(String[] args) throws InterruptedException {
        // IntStream.rangeClosed(1,100).forEach(i-> System.out.println(SingletonVersion1.getInstacne()));

        Thread t1 = new Thread(()->{
            IntStream.rangeClosed(1,40).forEach(i->new Thread(()->{
                System.out.println(SingletonVersion3.getInstance());
            },i+"").start());
        });
        t1.start();
        t1.join();
    }
}
