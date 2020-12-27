package rxjava3.chapter8.ConcurrencyAndParallel;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class IOSchedulersDemo {
  public static void main(String[] args) throws InterruptedException {

    Observable<String> movies =
        Observable.just("HitMan", "John Wick", "Wanted").subscribeOn(Schedulers.io());

    movies.subscribe(e -> ioOperation("ob1"));
    movies.subscribe(e -> ioOperation("ob2"));
    movies.subscribe(e -> ioOperation("ob3"));
    // If I have 20 subscribers, there will be 20 threads regardless of how many processors my
    // machine has because this is IO scheduler

    Thread.sleep(50000);
  }

  public static void ioOperation(String observerName) throws InterruptedException {
    // Simulates the computation job which takes 1 second
    Thread.sleep(1000);
    System.out.println(observerName + " Computation done by : " + Thread.currentThread().getName());
  }
}
