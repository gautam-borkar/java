package platformThread;

import java.util.stream.IntStream;

public class MaxPlatformThread {

    public static void main(String[] args) {
        final int MAX_THREAD = 10000;

        IntStream.rangeClosed(1, MAX_THREAD).forEach((i) -> {
            Thread.ofPlatform().name("max-thread" + i).start(() -> {
                try {
                    System.out.println("Started thread: " + i);
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });
    }
    
}
