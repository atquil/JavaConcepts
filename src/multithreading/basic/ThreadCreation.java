package multithreading.basic;

// Threads are of two types: Demon thread(background thread), and Non-DemonThread
// Threads can be created using :
//          a. Extending a thread : Suitable if we are going to have only one inherited class
//          b. Implementing a runnable interface: Suitable if we want to have multiple inherited class

//Extension of thread
class ThreadClassUsingExtension extends Thread {

    @Override
    public void run() {
        //sub thread is created
        System.out.println("Thread:" + Thread.currentThread().getName());
    }
}


// Using Runnable Interface
class RunnableInterfaceThread implements Runnable {

    @Override
    public void run() {
        //sub thread is created
        System.out.println("Thread:" + Thread.currentThread().getName());
    }
}

//Demon Thread
class MyDemonThread extends Thread{
    @Override
    public void run() {
        System.out.println("I am in the Demon Thread:"+Thread.currentThread().getName());
    }
}


public class ThreadCreation {

    public static void main(String[] args) {

        //Simple Thread creating

        ThreadClassUsingExtension threadClassUsingExtension = new ThreadClassUsingExtension();
        threadClassUsingExtension.setName("Thread using Extension"); //Optional step
        threadClassUsingExtension.setPriority(6); // By default the main thread has priority 5, and it ranges from 0-10, the higher the priority the eariler it get's executed.

        threadClassUsingExtension.start(); //The start will set the thread, and will call the run method


        RunnableInterfaceThread runnableInterfaceThread = new RunnableInterfaceThread();
        Thread thread = new Thread(runnableInterfaceThread); // Calling the runnableInterfaceThread
        thread.setName("runnableThread");
        thread.start();


        //Demon Thread: If all process end's will die. 
        MyDemonThread myDemonThread = new MyDemonThread();
        myDemonThread.setName("demonThread");
        myDemonThread.setDaemon(true);
        myDemonThread.start();
    }



}

