package multithreading.advance;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.*;

class ThreadClass implements Callable<String>{
    private final String myThread;

    public ThreadClass(String threadName) {
        this.myThread = threadName;
    }

    @Override
    public String call() throws Exception {
        return myThread+":"+Thread.currentThread().getName();
    }
}
public class InvokeAllAndInvokeAnyThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //Let's have a list of callable object
        List<Callable<String>> threadName = new ArrayList<>();
        threadName.add(new ThreadClass("alpha"));
        threadName.add(new ThreadClass("beta"));
        threadName.add(new ThreadClass("gamma"));
        threadName.add(new ThreadClass("bim"));

        String output = executorService.invokeAny(threadName);
        System.out.println(output);

        System.out.println("==============");

        List<Future<String>> threadNames = executorService.invokeAll(threadName);
        threadNames.forEach(thread-> {
            try {
                System.out.println(thread.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.shutdown();

    }
}
