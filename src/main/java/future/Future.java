package future;

public interface Future<T> {
    T get() throws InterruptedException;
}
