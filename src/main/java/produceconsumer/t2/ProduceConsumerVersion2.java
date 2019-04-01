package produceconsumer.t2;

/**
 * 多线程运行此段程序时是有问题的
 *
 */
public class ProduceConsumerVersion2 {
    private int i = 0;

    private final Object MONITOR = new Object();

    private volatile boolean isProduced = false;  //true为已经生产

    public void produce(){
        synchronized (MONITOR){
            while (true){
                if (!isProduced){
                    System.out.println(Thread.currentThread().getName()+"   produce");
                    System.out.println("p --->"+(++i));
                    MONITOR.notify();
                    isProduced = true;
                }else{
                    try {
                        System.out.println(Thread.currentThread().getName()+"   wait");
                        MONITOR.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void consume(){
        synchronized (MONITOR){
            while (true){
                if (!isProduced){
                    try {
                        System.out.println(Thread.currentThread().getName()+"   wait");
                        MONITOR.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    System.out.println(Thread.currentThread().getName()+"   consume");

                    System.out.println("c --->"+i);
                    MONITOR.notify();
                    isProduced = false;
                }
            }
        }
    }

    public static void main(String[] args) {

        ProduceConsumerVersion2 produceConsumerVersion2 = new ProduceConsumerVersion2();

        new Thread("produce1"){
            @Override
            public void run() {
                produceConsumerVersion2.produce();
            }
        }.start();
        new Thread("consumer1"){
            @Override
            public void run() {
                produceConsumerVersion2.consume();
            }
        }.start();

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

/**
 *
 * 多线程运行的时候可能会出现这个情
 * 况，线程并没有死锁，而是全部wait了
 *
 * produce1   produce
 * p --->1
 * produce1   wait
 * consumer1   consume
 * c --->1
 * consumer1   wait
 * produce1   produce
 * p --->2
 * produce1   wait
 * consumer1   consume
 * c --->2
 * consumer1   wait
 * produce1   produce
 * p --->3
 * produce1   wait
 * consumer1   consume
 * c --->3
 * consumer1   wait
 * produce1   produce
 * p --->4
 * produce1   wait
 * consumer1   consume
 * c --->4
 * consumer1   wait
 * produce2   produce
 * p --->5
 * produce2   wait
 * produce1   wait
 * consumer1   consume
 * c --->5
 * consumer1   wait
 * produce2   produce
 * p --->6
 * produce2   wait
 * produce1   wait
 * consumer2   consume
 * c --->6
 * consumer2   wait
 * consumer1   wait
 */