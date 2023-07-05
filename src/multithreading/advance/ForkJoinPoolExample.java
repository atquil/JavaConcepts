package multithreading.advance;

import java.util.IntSummaryStatistics;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class ForkJoinPoolExample {
    public static void main(String[] args) {

        //System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","2"); //Can set custom threads to ForkJoinPool
        // Get how many number of available processor
        System.out.println("Total processor:"+Runtime.getRuntime().availableProcessors());
        // Total number of threads available for ForkAndJoin
        System.out.println("Thread available:"+ ForkJoinPool.getCommonPoolParallelism());

        final IntStream intStream = IntStream.range(1,50);
        intStream.parallel()
                .forEach(n->{
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(n+" Accessed by:"+Thread.currentThread());
                });
    }
}
