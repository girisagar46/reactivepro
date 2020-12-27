package rxjava3.chapter8.ConcurrencyAndParallel;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class NewThreadSchedulerDemo {
  public static void main(String[] args) throws InterruptedException {

    Observable<String> movies =
        Observable.just("HitMan", "John Wick", "Wanted").subscribeOn(Schedulers.newThread());

    // Every task gets a new thread and once task is complete the thread exits
    movies.subscribe(e -> task("ob1"));
    movies.subscribe(e -> task("ob2"));
    movies.subscribe(e -> task("ob3"));
    Thread.sleep(10000);
  }

  public static void task(String observerName) throws InterruptedException {
    // Simulates the computation job which takes 1 second
    Thread.sleep(1000);
    System.out.println(observerName + " Computation done by : " + Thread.currentThread().getName());
  }
}
