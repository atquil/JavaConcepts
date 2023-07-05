package multithreading.advance.future;


import java.util.concurrent.*;

class RunnableClass implements Runnable{

    @Override
    public void run() {
        System.out.println("Inside Runnable - No return type");
    }
}

class CallableClass implements Callable<String>{

    @Override
    public String call() throws Exception {
        return " ThreadName:"+Thread.currentThread().getName();
    }
}
public class RunnableAndCallableThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Benefit of Callable if we require some return type
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for(int i=0; i<11; i++){
            Future<String> value = executor.submit(new CallableClass());
            System.out.println("From Callable: "+value.get());
        }
        executor.shutdown();


    }
}
