package multithreading.advance.future;

import java.util.concurrent.*;

class MyCallable implements Callable<String>{

    @Override
    public String call() throws Exception {
        return "SomeValue";
    }
}
public class FutureTaskExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<String> callable =  executorService.submit(new MyCallable());
        System.out.println(callable.get());

        //In FutureTask, we will directly supply the object to executor

        FutureTask<String> callableObject = new FutureTask<>(new MyCallable());
        executorService.submit(callableObject);

        System.out.println(callableObject.get());

        executorService.shutdown();

        executorService.awaitTermination(10,TimeUnit.SECONDS);
    }
}
