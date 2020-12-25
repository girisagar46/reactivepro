package rxjava3.chapter2;

public class PushPull {

  public static void main(String[] args) throws InterruptedException {

    Runnable r =
        () ->
            new PushPull()
                .runningAsync(
                    new PushPullCallback() {
                      @Override
                      public void pushData(String data) {
                        System.out.println("PushPullCallBack data: " + data);
                      }

                      @Override
                      public void pushCompleted() {
                        System.out.println("PushPullCallBack done!");
                      }

                      @Override
                      public void pushError(Exception ex) {
                        System.out.println("PushPullCallBack Error called, Got an exception" + ex);
                      }
                    });

    Thread t = new Thread(r);
    t.start();

    Thread.sleep(2000);

    System.out.println("Main thread completed");
  }

  public void runningAsync(PushPullCallback callback) {
    System.out.println("I am running in a separate thread!");
    sleep(1000);
    callback.pushData("Data1");
    callback.pushData("Data2");
    callback.pushData("Data3");

    callback.pushError(new RuntimeException("Oops!"));
    callback.pushCompleted();
  }

  private void sleep(int duration) {
    try {
      Thread.sleep(duration);
    } catch (InterruptedException exception) {
      exception.printStackTrace();
    }
  }
}
