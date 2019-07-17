package future;

import java.util.function.Consumer;

public class SyncInvoker {
    public static void main(String[] args) throws InterruptedException {
//        String result = get();
//        System.out.println(result);
        FutrueService futrueService = new FutrueService();
        Future<String> future = futrueService.submit(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "FINISH";
        },System.out::println);
        System.out.println("=====================");
        System.out.println("do some thing");
        Thread.sleep(1000);
        System.out.println("=====================");
       // System.out.println(future.get());
    }

    private static String get() throws InterruptedException {
        Thread.sleep(3000);
        return "FINISH";
    }
}
