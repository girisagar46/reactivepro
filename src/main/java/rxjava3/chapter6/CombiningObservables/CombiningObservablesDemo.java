package rxjava3.chapter6.CombiningObservables;

import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

public class CombiningObservablesDemo {

  public static void main(String[] args) throws InterruptedException {
    //    Observable<Integer> source1 = Observable.just(1, 2, 3, 4);
    //    Observable<Integer> source2 = Observable.just(5, 6, 7, 8);

    Observable<String> source1 = Observable.interval(1, TimeUnit.SECONDS).map(e -> "src1 " + e);
    Observable<String> source2 = Observable.interval(1, TimeUnit.SECONDS).map(e -> "src2 " + e);

    Observable.merge(source1, source2).subscribe(System.out::println); // the output can be jumbled
    System.out.println("---");
    Observable.concat(source1, source2)
        .subscribe(
            System.out::println); // concat maintains the output order or observable we concat

    Thread.sleep(20000);
  }
}
