package virtualThread;

import java.lang.Thread.Builder.OfVirtual;

public class ExploreVirtualThread {
    private static void doSomeWork() {
        try {
            System.out.println("Started doSomeWork");
            Thread.sleep(1000);
            System.out.println("Ended doSomeWork");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void main() throws InterruptedException {
        OfVirtual virtualThread1 = Thread.ofVirtual().name("virtualThread-1");
        virtualThread1.start(() -> System.out.println("Run task virtualThread-1 in background"));

        Thread.ofVirtual().name("virtualThread-2").start(ExploreVirtualThread::doSomeWork);

        System.out.println("Main program ended");
    }
    
}