package rxjava3.chapter8.ConcurrencyAndParallel;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ObserveOnDemo {
  // observeOn helps in switching schedulers
  // position of observeOn matters
  // observeOn has performance overhead because it does not wait for downstream process
  // (producer-consumer problem) that's why we use Flowable instead of Observable
  public static void main(String[] args) throws InterruptedException {
    Observable.just("HitMan", "John Wick", "Wanted", "Wonder Woman")
        .subscribeOn(
            Schedulers.computation()) // this Scheduler will be used because it's closer to source
        .map(ObserveOnDemo::upper)
        .observeOn(Schedulers.newThread())
        .filter(e -> e.startsWith("W"))
        .doOnNext(e -> System.out.println(Thread.currentThread().getName()))
        .observeOn(Schedulers.io())
        .subscribe(ObserveOnDemo::print); // this is carried out by RxCachedThreadScheduler

    Thread.sleep(1000);
  }

  private static void print(String e) {
    System.out.println(e + " printed by " + Thread.currentThread().getName());
  }

  private static String upper(String e) {
    System.out.println(e + " upper done by " + Thread.currentThread().getName());
    return e.toUpperCase();
  }
}
