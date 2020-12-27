package rxjava3.chapter9.BufferThrottelSwitching;

import io.reactivex.rxjava3.core.Observable;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

public class BufferAndWindowDemo {

  public static void main(String[] args) throws InterruptedException {

    Observable.range(1, 30).buffer(4).subscribe(System.out::println);
    Observable.range(1, 30).buffer(4, HashSet::new).subscribe(System.out::println);
    Observable.range(1, 30).buffer(4, 5).subscribe(System.out::println);

    System.out.println("Timed buffering");
    Observable.interval(500, TimeUnit.MILLISECONDS)
        .buffer(1, TimeUnit.SECONDS, 3)
        .subscribe(System.out::println);
    Thread.sleep(5000);


    System.out.println("Observable boundary");
    Observable<Long> interval = Observable.interval(1, TimeUnit.SECONDS);
    Observable.interval(500, TimeUnit.MILLISECONDS).buffer(interval).subscribe(System.out::println);

    Thread.sleep(5000);

    System.out.println("Window operator");
    Observable<Long> interval1 = Observable.interval(1, TimeUnit.SECONDS);
    Observable.interval(500, TimeUnit.MILLISECONDS).window(interval1).subscribe(System.out::println);

    Thread.sleep(5000);

  }
}
