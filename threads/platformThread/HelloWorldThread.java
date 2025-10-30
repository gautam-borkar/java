package platformThread;

public class HelloWorldThread {

    private static volatile String result = "";

    private static synchronized void hello() {
        result = result.concat("Hello");
    }

    private static synchronized void world() {
        result = result.concat(" World!");
    }

    public static void main(String[] args) throws InterruptedException {
        // We would like to get the output as "Hello World!"
        Thread helloThread = Thread.ofPlatform().name("hello-thread").start(HelloWorldThread::hello);
        Thread worldThread = Thread.ofPlatform().name("world-thread").start(HelloWorldThread::world);

        helloThread.join();
        worldThread.join();

        System.out.println("Result: " + result);

    }
}
