package platformThread;

import java.lang.Thread.Builder.OfPlatform;

public class ExploreThread extends Thread {

    static void doSomething() {
        try {
            System.out.println("Do something started.");
            Thread.sleep(1000);
            System.out.println("Run task platformThread-2 in background");
            System.out.println("Do something ended.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    static void main() {
        // 1 - Using extend Thread
        ExploreThread exploreThread = new ExploreThread();
        exploreThread.start();

        // 2 - Runnable functional interface
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        Thread t1 = new Thread(runnable);
        t1.start();

        // 3 - Platform thread in Java 21
        OfPlatform platformThread1 = Thread.ofPlatform().name("platformThread-1");
        platformThread1.start(() -> {
            System.out.println("Run task platformThread-1 in background");
        });

        OfPlatform platformThread2 = Thread.ofPlatform().name("platformThread-2");
        platformThread2.start(() -> ExploreThread.doSomething());

        Thread platformThread3 = Thread.ofPlatform().name("platformThread-3").unstarted(() -> {
            System.out.println("Run task platformThread-3 in background");
        });
        platformThread3.run();

        System.out.println("Program ended.");
    }
}
