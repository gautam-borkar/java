package example;

public class Counter {

  private int count;

  public long getCount() {
    return count;
  }

  public void incrementCountUnsynchronized() {
    count++;
  }

  public synchronized void incrmentCountSynchronized() {
    count++;
    // synchronized (Counter.class) {
    // count++;
    // }
  }
}