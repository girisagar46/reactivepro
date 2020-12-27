package rxjava3.chapter7.Multicasting;

import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

public class CachingDemo {

  public static void main(String[] args) throws InterruptedException {
    Observable<Long> src = Observable.interval(1, TimeUnit.SECONDS).cache();

    src.subscribe(e -> System.out.println("Observer 1: " + e));

    Thread.sleep(5000);

    // observer 2 will get the cache
    src.subscribe(e -> System.out.println("Observer 2: " + e));

    Thread.sleep(3000);
  }
}
