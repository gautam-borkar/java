public class CreateThread {

  public static void main(String[] args) throws InterruptedException {
    // Using functional interface
    Runnable runnable = () -> System.out.println("Running thread using functional interface.");
    Thread t1 = new Thread(runnable);
    t1.start();

    // Extending the Thread class
    Thread t2 = new ExtendThread();
    t2.run();

    // Implement runnable interface
    Thread t3 = new Thread(new ImplementRunnable());
    t3.run();

    t1.join();
    t2.join();
    t3.join();
  }
}
