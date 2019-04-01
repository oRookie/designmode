package produceconsumer.t1;

/**
 * 线程间无法通信
 */
public class ProduceConsumerVersion1 {
    private int i = 0;

    public void produce(){
        while (true){
            System.out.println("p --->"+i++);
        }
    }

    public void consume(){
        while (true){
            System.out.println("C --->"+i);
        }
    }

    public static void main(String[] args) {
        ProduceConsumerVersion1 produceConsumerVersion1 = new ProduceConsumerVersion1();
        new Thread("produce"){
            @Override
            public void run() {
                produceConsumerVersion1.produce();
            }
        }.start();
        new Thread("consumer"){
            @Override
            public void run() {
                produceConsumerVersion1.consume();
            }
        }.start();
    }
}
