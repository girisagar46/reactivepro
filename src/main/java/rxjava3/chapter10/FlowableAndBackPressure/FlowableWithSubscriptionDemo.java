package rxjava3.chapter10.FlowableAndBackPressure;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.SneakyThrows;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class FlowableWithSubscriptionDemo {

  public static void main(String[] args) throws InterruptedException {
    Flowable.range(1, 10000) // with Flowable, the producer produces with a limit
        .map(
            e -> {
              System.out.println(
                  "Produced item is: " + e + ": " + Thread.currentThread().getName());
              return e;
            })
        .observeOn(Schedulers.io()) // switch the thread
        .subscribe(
            new Subscriber<Integer>() {

              Subscription s;
              AtomicInteger count = new AtomicInteger(0);

              @Override
              public void onSubscribe(Subscription s) {
                this.s = s;
                System.out.println("Asking for 20 items");
                s.request(20); // 20 to control Backpressure as per our conveniences
              }

              @SneakyThrows
              @Override
              public void onNext(Integer t) {
                if (count.getAndIncrement() % 20 == 0) {
                  System.out.println("Asking for next 20 items ");
                  s.request(20);
                }
                System.out.println("The subscriber consumed: " + t);

                sleep(100);
              }

              @Override
              public void onError(Throwable t) {
                t.printStackTrace();
              }

              @Override
              public void onComplete() {
                System.out.println("Completed!");
              }
            });

    sleep(100000);
  }

  private static void sleep(long milliseconds) throws InterruptedException {
    Thread.sleep(milliseconds);
  }
}
