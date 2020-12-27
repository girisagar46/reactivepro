package rxjava3.chapter8.ConcurrencyAndParallel;

import io.reactivex.rxjava3.core.Observable;

public class ConcurrencyRxJavaDemo {

  public static void main(String[] args) throws InterruptedException {
    Observable<String> source =
        Observable.create(
            e -> {
              // Since thread is inside the create, new observer will always get executed by the new
              // thread. New thread sends emission to the observer synchronously.
              // But, we do not do this in practice.
              new Thread(
                      () -> {
                        e.onNext("Hello");
                        e.onNext("RxJava");
                      })
                  .start();
            });

    source.subscribe(
        e ->
            System.out.println(
                "Observer 1: " + e + " Thread is: " + Thread.currentThread().getName()));
    source.subscribe(
        e ->
            System.out.println(
                "Observer 2: " + e + " Thread is: " + Thread.currentThread().getName()));
  }
}
