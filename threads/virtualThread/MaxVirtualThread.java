package virtualThread;

import java.util.stream.IntStream;

public class MaxVirtualThread {

    public static void main(String[] args) throws InterruptedException {
        int MAX_THREAD = 10000000;
        IntStream.rangeClosed(1, MAX_THREAD).forEach((i) -> Thread.ofVirtual().name("virtual-thread-" + i).start(() -> {
            try {
                System.out.println("Started thread: " + i);
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }));

        Thread.sleep(10000000);
    }

}
