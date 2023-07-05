package multithreading.advance.producerConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueueExample {
    public static void main(String[] args) {
        // Create a BlockingQueue with a capacity of 1024.
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);

        // Create a thread that produces items and adds them to the queue.
        Thread producer = new Thread(new Runnable() {
            public void run() {
                try {
                    // Add the value "1" to the queue.
                    queue.put("1");
                    Thread.sleep(1000);
                    queue.put("1");
                    Thread.sleep(1000);queue.put("1");
                    Thread.sleep(1000);queue.put("1");queue.put("1");queue.put("1");queue.put("1");queue.put("1");queue.put("1");

                    // Wait for one second.
                    Thread.sleep(1000);
                    // Add the value "2" to the queue.
                    queue.put("2");
                    // Wait for one second.
                    Thread.sleep(1000);
                    // Add the value "3" to the queue.
                    queue.put("Finished");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Create a thread that consumes items from the queue.
        Thread consumer = new Thread(new Runnable() {
            public void run() {
                try {
                    // Read an item from the queue.
                    String data = queue.take();
                    // Keep reading items from the queue until we read the value "Finsihed".
                    while (!data.equals("Finished")) {
                        System.out.println(data);
                        data = queue.take();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Start both threads.
        producer.start();
        consumer.start();
    }
}
