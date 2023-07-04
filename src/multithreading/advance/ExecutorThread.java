package multithreading.advance;


import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable{
    @Override
    public void run() {

        try {
            System.out.println("ThreadNo:"+Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

public class ExecutorThread {
    public static void main(String[] args) throws InterruptedException {

        // As creating a thread is an expensive operation, we will require a pool of thread where we will submit all the thread for our operations.

        long startTime = System.currentTimeMillis();
        System.out.println("StartTime"+startTime);

        //If the task is IO intensive like DB call, then we can use more number of threads as it will help in fetching the task faster
        ExecutorService IOIntensive = Executors.newFixedThreadPool(10); // Setting thread pool size

        for(int i=0; i<10;i++){
            IOIntensive.execute(new Task()); // Now all 10 threads will work
        }


        IOIntensive.shutdown();
        IOIntensive.awaitTermination(10, TimeUnit.SECONDS); //After this time only it will execute further

        if(IOIntensive.isShutdown()){

            System.out.println("Duration"+ (System.currentTimeMillis() - startTime));
        }


        // If our task is CPU intensive it is better to assign the thread count based on Core as these many main thread can only work at one point of time
        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Core Count:"+coreCount);
        ExecutorService cpuIntensive = Executors.newFixedThreadPool(coreCount); // Setting thread pool size
        cpuIntensive.execute(new Task());
        cpuIntensive.shutdown();
    }
}
