package rxjava3.chapter6.CombiningObservables;

import io.reactivex.rxjava3.core.Observable;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class AmbiguousObservableDemo {

  public static void main(String[] args) throws InterruptedException {
    Observable<String> ob1 = Observable.interval(1, TimeUnit.SECONDS).take(10).map(e -> "ob1 " + e);
    Observable<String> ob2 =
        Observable.interval(10, TimeUnit.MILLISECONDS).take(10).map(e -> "ob2 " + e);

    Observable.amb(Arrays.asList(ob1, ob2)) // this emits from ob2 because it's faster
        .subscribe(System.out::println);

    Thread.sleep(2000);
  }
}
