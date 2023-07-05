package multithreading.basic;

// Can we directly run the run method -- Yes, but it will act as regular method.
class ThreadClass extends Thread{
    @Override
    public void run() {
            System.out.println(Thread.currentThread().getName());
    }
}

// [IMP] Can we overload the run method : Yes we can but it will run as regular method and it will not start the new thread
class OverLoadedThreadClass extends Thread{
    //@Override
    public void run(Integer i) {
        System.out.println(Thread.currentThread().getName()); //Main thread will run this
    }
}
public class OverloadAndOverrideThread {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        ThreadClass directRunMethod = new ThreadClass();
        directRunMethod.setName("ChildThread");
        directRunMethod.run(); //Run as regular method
        //threadClass.start();

        OverLoadedThreadClass overLoadedThreadClass = new OverLoadedThreadClass();
        overLoadedThreadClass.setName("OverloadedThread");
        overLoadedThreadClass.start(); //Only Main thread running as a regular method
    }
}
