package thread;

public class Threads {
    public static void main(String[] args) {

        //Interview Questions
        //1. What are the different kind of thread: Demon Thread and Non-Demon Thread
        //2. How to create a thread : Extend Thread/ new Thread / implement Runnable
        //3. Which one is better extending or implmenting : When only one class to extend then extend Thread (not supported multiple inheritance), otherwise implment runnable
        //4. How to use Runnable Interface: We will have to create a new Thread (runnableObject). to create a thread
        //5. What is demon thread: Not a main thread, which is generally used for garbage collection. JVM can exit whithout finishing the demon thread.
        //6. How to create a demon thread, and how to check it. we can setDemon(true) to a thread, and can check using currentThread().getName()
        //7. How to start a thread: thread.start() will call the run() method of the thread.
        //8. Difference between start() and run() method: when we  call start() it will create the chold thread, but if we directly call run() method , it will work as a normal method.
        //9. What are the task of Start(): Register the task to TaskSchedular and call main
        //10. What if we don't override run() method: It will go the Thread.class and run it's run method() which will not do anything.
        //11. Can we overload the run(): Yes you can do, but then we will lose the thread, and it will run by main theread only as run in Thread.class has no parameter.
        //12. Can we restart the same thread using threadName.start(): No , will through IlleagelThreadStateException
        //13. What is thread priority: Range from [1-10], main thread at 5, ThreadSchedular will give, we can also set using myThread.setPriority(7). if more then 10 then IllegalThreadArgumentException
        System.out.println(Thread.currentThread().getName());

        // Thread are of two types : Main thread and Demon thread
        // All threads created by ueser or main method are non-demon thread
        //Demon thread: Garbage collection , JVM is not concerned and will not demon thread to die.

        //Create a instance of thread.MyThread to run the child thread
        MyThread myThread = new MyThread();
        myThread.setPriority(7);
        myThread.start();

        //Now running the demon thread , this will not be able to finish the job
        MyDemonThread myDemonThread = new MyDemonThread();
        myDemonThread.setDaemon(true);
        myDemonThread.start();
        //Context switching: As any one point of time only one thread can run, the main thread works then switches to one of the child thred then again to main thread
        for(int i=0;i<400;i++){
            System.out.println("Main thread:"+Thread.currentThread().getName());
        }

        //Calling Runnable in between
        MyThreadWithRunnable myThreadWithRunnable = new MyThreadWithRunnable();
        //Thread is not present so have to create a thread which will call the method.

        Thread thread = new Thread(myThreadWithRunnable,"runnableThread");
        thread.start();



    }
}

//Creating a thread -- extend Thread and implement runnable

class MyThread extends Thread{
    @Override
    public void run() {
        // Child wil run this

        for(int i=0;i<40000;i++){
            System.out.println("ExtendsThread"+Thread.currentThread().getName());
        }
    }
}

//RUNNABLE INTERFACE: When we extends thread it has several methods inside it like stop etc, but runnable has only run method.

class MyThreadWithRunnable implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<40000;i++){
            System.out.println("RunnableInterface"+Thread.currentThread().getName());
        }
    }
}

//When to use extend Thread and when to use implement Runnable: As java does not support multi thereading thus, it's better to use extends Thread, when we know only one class needs to be inherited,
// but if we have multiple class then use implements Runnable.

class MyDemonThread extends Thread{
    @Override
    public void run() {
        System.out.println("DemonThread:"+currentThread().isDaemon());
        for(int i=0;i<400000;i++){
            System.out.println("I am getting terminated at:"+i);

        }

    }
}