package future;

import java.util.function.Consumer;

public class FutrueService{
   public <T> Future<T> submit(final FutureTask<T> task, final Consumer<T> consumer){
        AyncFuture ayncFuture = new AyncFuture();
        new Thread(()->{
            T call = task.call();
            ayncFuture.done(call);
            consumer.accept(call);
        }).start();
        return ayncFuture;
   };
}
