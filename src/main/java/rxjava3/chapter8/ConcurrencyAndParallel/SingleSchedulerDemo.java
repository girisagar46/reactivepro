package rxjava3.chapter8.ConcurrencyAndParallel;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SingleSchedulerDemo {
  public static void main(String[] args) throws InterruptedException {
    Observable<String> movies =
        Observable.just("HitMan", "John Wick", "Wanted").subscribeOn(Schedulers.single());

    // Thread is executed synchronously just by a single thread
    movies.subscribe(e -> sensitiveTask("ob1"));
    movies.subscribe(e -> sensitiveTask("ob2"));
    movies.subscribe(e -> sensitiveTask("ob3"));
    Thread.sleep(10000);
  }

  public static void sensitiveTask(String observerName) throws InterruptedException {
    // Simulates this task is not thread safe hence it's sensitive
    Thread.sleep(1000);
    System.out.println(observerName + " Computation done by : " + Thread.currentThread().getName());
  }


}
