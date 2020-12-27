package rxjava3.chapter8.ConcurrencyAndParallel;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.time.LocalTime;

public class FlatMapConcurrencyDemo {

  public static void main(String[] args) throws InterruptedException {

    // Emissions are processed by computation thread in parallel
    // flatMap() creates Observable for each emission which is processed in parallel but we need to
    // think deep before implementing such behaviour as it might just create overhead in our
    // application
    Observable.just("HitMan", "John Wick", "Wanted")
        .flatMap(e -> Observable.just(e).subscribeOn(Schedulers.computation()).map(
            FlatMapConcurrencyDemo::compute))
        .subscribe(System.out::println);

    Thread.sleep(7000);
  }

  public static String compute(String element) throws InterruptedException {
    return element
        + " : Printed By: "
        + Thread.currentThread().getName()
        + " at: "
        + LocalTime.now();
  }
}
