package virtualThread;

import java.util.stream.IntStream;

public class MaxVirtualThread {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Number of cores: " + Runtime.getRuntime().availableProcessors());

        int MAX_THREAD = 10;
        IntStream.rangeClosed(1, MAX_THREAD).forEach((i) -> Thread.ofVirtual().name("virtual-thread-" + i).start(() -> {
            try {
                System.out.println("[" + Thread.currentThread() + "] Started thread: " + i);
                Thread.sleep(5000);
                System.out.println("[" + Thread.currentThread() + "] Ended thread: " + i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }));

        Thread.sleep(10000);
    }

}
