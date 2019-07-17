package observer.t2;

import java.util.List;

public class ThreadLifeCycleObserver implements LifeCycleListener {



    public void
    concurrentQuery(List<String> ids){
        if (ids == null || ids.isEmpty())
            return;
        ids.stream().forEach(id->new Thread(new ObservableRunnable(this) {
            @Override
            public void run() {
                try {
                    notifyChange(new RunnableEvent(RunnableState.RUNNING,Thread.currentThread(),null));
                    System.out.println("query for the id "+id);
                    Thread.sleep(1000L);
                    notifyChange(new RunnableEvent(RunnableState.DONE,Thread.currentThread(),null));
                }catch (Exception e){
                    notifyChange(new RunnableEvent(RunnableState.ERROR,Thread.currentThread(),e));
                }
            }
        },id).start());
    }

    @Override
    public void onevent(ObservableRunnable.RunnableEvent runnableEvent) {
        System.out.println("The runnbale "+ runnableEvent.getThread().getName() + " data changed and state is "+ runnableEvent.getState());
        if (runnableEvent.getCause()!= null){
            System.out.println(runnableEvent.getThread().getName() + " process failed ...");
            runnableEvent.getCause().printStackTrace();
        }
    }
}
