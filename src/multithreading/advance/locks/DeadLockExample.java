package multithreading.advance.locks;

public class DeadLockExample {
    public static void main(String[] args) {
        String firstData = "First Object";
        String secondData = "Second Object";
        Thread firstThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (firstData){
                    System.out.println("Frist Thread:"+firstData);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    // Now secondData is blocked
                    synchronized (secondData){
                        System.out.println("First thread"+secondData);
                    }
                }

            }
        });

        Thread secondThread = new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (secondData){
                    System.out.println("Inside the Second Thread: "+secondData);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (firstData){
                        System.out.println("Inside the Second Thread:"+firstData);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }


            }
        });
        firstThread.start();
        secondThread.start();
    }
}
