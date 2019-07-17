package readwriter;

public class ReadWriteLockClient {
    public static void main(String[] args) throws InterruptedException {
        SharedData data = new SharedData(10);
        new ReadWorker(data).start();
        new ReadWorker(data).start();
        new ReadWorker(data).start();
        new ReadWorker(data).start();
        new WriteWorker(data,"abcdefghijkl").start();
        new WriteWorker(data,"ABCDEFGHIJKL").start();
        new ReadWorker(data).start();

        String name = "";
    }
}
