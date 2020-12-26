package rxjava3.chapter3.helloRxJava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import java.util.concurrent.TimeUnit;

public class ConnectableObservableDemo {

  public static void main(String[] args) throws InterruptedException {
    ConnectableObservable<@NonNull Long> source =
        Observable.interval(1, TimeUnit.SECONDS)
            .publish(); // publish will return a ConnectableObservable which makes hot observable
                        // (i.e. new subs will pick up the data from where 1st one left off)
    source.connect();
    System.out.println("First Subscriber");
    source.subscribe(System.out::println);
    Thread.sleep(10000);

    System.out.println("Second Subscriber");
    source.subscribe(System.out::println);
    Thread.sleep(10000);
  }
}
