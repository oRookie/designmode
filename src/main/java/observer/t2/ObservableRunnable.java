package observer.t2;

/**
 * 这相当于是一个事件源Subject
 */
public abstract class ObservableRunnable implements Runnable {
    protected LifeCycleListener lifeCycleListener;

    public ObservableRunnable(LifeCycleListener lifeCycleListener){
        this.lifeCycleListener = lifeCycleListener;
    }

    protected void notifyChange(RunnableEvent runnableEvent){
        lifeCycleListener.onevent(runnableEvent);
    }

    public enum RunnableState {
        RUNNING,ERROR,DONE;
    }

    public static class RunnableEvent{
        private final RunnableState state;
        private final Thread thread;
        private final Throwable cause;


        public RunnableEvent(RunnableState state, Thread thread, Throwable cause) {
            this.state = state;
            this.thread = thread;
            this.cause = cause;
        }

        public RunnableState getState() {
            return state;
        }

        public Thread getThread() {
            return thread;
        }

        public Throwable getCause() {
            return cause;
        }
    }
}
