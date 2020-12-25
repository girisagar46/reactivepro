package rxjava3.chapter2;

public class CallBackDemo {

  public static void main(String[] args) throws InterruptedException {
    System.out.println("Main thread is running");

    Runnable r =
        () -> new CallBackDemo().runningAsync(() -> System.out.println("CallBack called!"));
    Thread t = new Thread(r);
    t.start();

    Thread.sleep(2000);

    System.out.println("Main thread completed!");
  }

  public void runningAsync(CallBack callback) {
    System.out.println("I am running in separate thread");
    sleep(1000);
    callback.call();
  }

  private void sleep(int duration) {
    try {
      Thread.sleep(duration);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
