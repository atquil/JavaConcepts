package multithreading.advance.future;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureClass {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //runAsync does not return any data
        CompletableFuture.runAsync(()->{
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName);
        });

        //supplyAsync returns the data
        CompletableFuture<String> threadName = CompletableFuture.supplyAsync(()-> Thread.currentThread().getName());
        System.out.println("Returning threadName: "+threadName.get()+". Status : "+threadName.isDone());
    }
}
