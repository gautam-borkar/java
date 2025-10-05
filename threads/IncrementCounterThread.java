public class IncrementCounterThread {

  public static void main(String[] args) throws InterruptedException {
    Counter count = new Counter();

    Runnable incrementCount = () -> {
      for (int i = 0; i < 1000; i++) {
        count.incrmentCountSynchronized();
      }
    };

    Thread t1 = new Thread(incrementCount);
    Thread t2 = new Thread(incrementCount);

    t1.start();
    t2.start();

    t1.join();
    t2.join();

    System.out.println("Final count: " + count.getCount());
  }
}
