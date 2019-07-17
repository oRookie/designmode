package observer.t2;

import java.util.Arrays;

public class ThreadCycleClient {
    public static void main(String[] args) {
        new ThreadLifeCycleObserver().concurrentQuery(Arrays.asList("1","2"));
    }
}
