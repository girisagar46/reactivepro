package rxjava3.chapter8.ConcurrencyAndParallel;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.Locale;

public class SubscribeOnDemo {

  public static void main(String[] args) throws InterruptedException {
    Observable.just("HitMan", "John Wick", "Wanted", "Wonder Woman")
        .subscribeOn(
            Schedulers.computation()) // this Scheduler will be used because it's closer to source
        .map(e -> e.toUpperCase(Locale.ROOT))
        .subscribeOn(Schedulers.newThread())
        .filter(e -> e.startsWith("W"))
        .subscribe(SubscribeOnDemo::print);

    Thread.sleep(1000);
  }

  private static void print(String e) {
    System.out.println(e + " printed by " + Thread.currentThread().getName());
  }
}
