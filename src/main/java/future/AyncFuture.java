package future;

public class AyncFuture<T> implements  Future<T>{

    private boolean done = false;

    private  T result;

    public void done(T result){
        synchronized (this){
            this.done = true;
            this.result = result;
            this.notifyAll();
        }
    }


    @Override
    public T get() throws InterruptedException {
        synchronized (this){
            while(!done){
                this.wait();
            }
        }
        return result;
    }
}
