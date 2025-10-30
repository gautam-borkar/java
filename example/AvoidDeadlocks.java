package example;

public class AvoidDeadlocks {
    static Object lockA = new Object();
    static Object lockB = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized(lockA) {
                try {
                    System.out.println("Thread-1: Acquired lock on Object-A");
                    Thread.sleep(1000);

                    synchronized(lockB){
                        System.out.println("Thread-1: Acquired lock on Object-B");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized(lockB) {
                try {
                    System.out.println("Thread-2: Acquired lock on Object-B");
                    Thread.sleep(1000);

                    synchronized(lockA){
                        System.out.println("Thread-2: Acquired lock on Object-A");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("End");
    }
}