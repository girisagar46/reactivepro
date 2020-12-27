package rxjava3.chapter8.ConcurrencyAndParallel;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomSchedulerDemo {

  public static void main(String[] args) throws InterruptedException {
    ExecutorService executor = Executors.newFixedThreadPool(20);

    // unlike other schedulers, the thread created by custom scheduler is not daemon in nature
    Scheduler scheduler = Schedulers.from(executor);

    Observable<String> movies =
        Observable.just("HitMan", "John Wick", "Wanted")
            .subscribeOn(scheduler)
            .doFinally(executor::shutdown); // this is necessary

    movies.subscribe(e -> compute("ob1"));
    movies.subscribe(e -> compute("ob2"));
    movies.subscribe(e -> compute("ob3"));
  }

  public static void compute(String observerName) throws InterruptedException {
    // Simulates the computation job which takes 1 second
    Thread.sleep(1000);
    System.out.println(observerName + " Computation done by : " + Thread.currentThread().getName());
  }
}
