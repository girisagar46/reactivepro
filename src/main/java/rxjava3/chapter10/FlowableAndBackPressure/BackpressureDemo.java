package rxjava3.chapter10.FlowableAndBackPressure;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class BackpressureDemo {

  public static void main(String[] args) throws InterruptedException {
    //    Observable.range(1, 10000) -> This gives the Backpressure
    Flowable.range(1, 10000) // with Flowable, the producer produces with a limit
        .map(
            e -> {
              System.out.println(
                  "Produced item is: " + e + ": " + Thread.currentThread().getName());
              return e;
            })
        .observeOn(Schedulers.io()) // switch the thread
        .subscribe(
            e -> {
              sleep(100); // simulate that consumer takes a little bit of time
              System.out.println(
                  "Consumed item is: " + e + ": " + Thread.currentThread().getName());
            });

    sleep(100000);
  }

  private static void sleep(long milliseconds) throws InterruptedException {
    Thread.sleep(milliseconds);
  }
}
