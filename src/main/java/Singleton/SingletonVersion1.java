package Singleton;

import java.util.stream.IntStream;

/**
 * 勤加载
 */
public class SingletonVersion1 {
    private static  SingletonVersion1 singletonVersion1 = new SingletonVersion1();
    private SingletonVersion1(){}
    public static SingletonVersion1 getInstacne(){
        return singletonVersion1;
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(1,100).forEach(i-> System.out.println(SingletonVersion1.getInstacne()));
    }
}
