package rxjava3.chapter3.helloRxJava;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.TimeUnit;

public class UnsubscribeDemo {

  private static final CompositeDisposable disposal = new CompositeDisposable();

  public static void main(String[] args) throws InterruptedException {
    Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS);

    //    Disposable d = source.subscribe(e -> System.out.println("Observer 1 : " + e));
    //    Thread.sleep(5000);
    //    d.dispose(); // I want to unsubscribe observable 1 after 5 seconds
    //    source.subscribe(e -> System.out.println("Observer 2 : " + e));

    Disposable d1 = source.subscribe(e -> System.out.println("Disposable 1 " + e));
    Disposable d2 = source.subscribe(e -> System.out.println("Disposable 2 " + e));
    Thread.sleep(5000);
    disposal.addAll(d1, d2);
    disposal.dispose(); // both Disposable will be disposed after 5 secs

    Thread.sleep(10000);
  }
}
