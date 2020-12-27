package rxjava3.chapter8.ConcurrencyAndParallel;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ComputationSchedulersDemo {


  public static void main(String[] args) throws InterruptedException {

    System.out.println("Num of processors " + Runtime.getRuntime().availableProcessors());

    Observable<String> movies =
        Observable.just("HitMan", "John Wick", "Wanted").subscribeOn(Schedulers.computation());

    movies.subscribe(e -> compute("ob1"));
    movies.subscribe(e -> compute("ob2"));
    movies.subscribe(e -> compute("ob3"));
    movies.subscribe(e -> compute("ob4"));
    movies.subscribe(e -> compute("ob5"));
    movies.subscribe(e -> compute("ob6"));
    movies.subscribe(e -> compute("ob7"));
    movies.subscribe(e -> compute("ob8"));
    movies.subscribe(e -> compute("ob9"));
    movies.subscribe(e -> compute("ob10"));
    movies.subscribe(e -> compute("ob11"));
    movies.subscribe(e -> compute("ob12"));

    // My Laptop has 12 processors. So, inorder to compute the last observer the one thread is reused
    movies.subscribe(e -> compute("ob13"));


    Thread.sleep(5000);
  }

  public static void compute(String observerName) throws InterruptedException {
    // Simulates the computation job which takes 1 second
    Thread.sleep(1000);
    System.out.println(observerName + " Computation done by : " + Thread.currentThread().getName());
  }
}
