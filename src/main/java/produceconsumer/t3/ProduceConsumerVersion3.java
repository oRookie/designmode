package produceconsumer.t3;

import java.util.stream.Stream;

/**
 * 版本3 修復版本2中可能會出現的線程全部阻塞
 */
public class ProduceConsumerVersion3 {
    private int i = 0;

    private final Object MONITOR = new Object();

    private volatile boolean isProduced = false;  //true为已经生产

    public void produce() {
        synchronized (MONITOR) {
            /**
             * 这个地方必须是while 而不能是if。
             * 如果是if的话，当两个线程wait后被唤醒时候，就会出现两个人都生成数据
             */
            while (isProduced) {
                try {
                    MONITOR.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("p --->" + (++i));
            isProduced = true;
            MONITOR.notifyAll();

        }

    }

    public void consume() {
        synchronized (MONITOR) {
            /**
             * 这个地方必须是while 而不能是if。
             * 如果是if的话，当两个线程wait后被唤醒时候，就会出现两个人都消费数据
             */
            while (!isProduced) {
                try {
                    MONITOR.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("c --->" + i);
            isProduced = false;
            MONITOR.notifyAll();

        }

    }

    public static void main(String[] args) {

        ProduceConsumerVersion3 produceConsumerVersion2 = new ProduceConsumerVersion3();

        Stream.of("p1","p2","p3").forEach((n)->{
            new Thread(n){
                @Override
                public void run() {
                    while (true){
                        try {
                            Thread.sleep(10l);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        produceConsumerVersion2.produce();
                    }
                }
            }.start();
        });
        Stream.of("c1","c2","c3","c4").forEach((n)->{
            new Thread(n){
                @Override
                public void run() {
                    while (true){
                        try {
                            Thread.sleep(10l);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        produceConsumerVersion2.consume();
                    }
                }
            }.start();
        });

//        new Thread("produce1") {
//            @Override
//            public void run() {
//                while (true) {
//                    try {
//                        Thread.sleep(100l);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    produceConsumerVersion2.produce();
//                }
//            }
//        }.start();
//        new Thread("consumer1") {
//            @Override
//            public void run() {
//                while (true) {
//                    try {
//                        Thread.sleep(100l);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    produceConsumerVersion2.consume();
//                }
//            }
//        }.start();
//
//        new Thread("produce2"){
//            @Override
//            public void run() {
//                produceConsumerVersion2.produce();
//            }
//        }.start();
//        new Thread("consumer2"){
//            @Override
//            public void run() {
//                produceConsumerVersion2.consume();
//            }
//        }.start();

    }
}
