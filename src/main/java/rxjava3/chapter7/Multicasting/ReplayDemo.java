package rxjava3.chapter7.Multicasting;

import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

public class ReplayDemo {

  /*
  Multicasting is a way reduce duplicated works for example network request
  Can be done using:
    - Replaying
    - Caching
    - Subjects
  */

  public static void main(String[] args) throws InterruptedException {

    Observable<Long> src = Observable.interval(1, TimeUnit.SECONDS).replay().autoConnect();

    src.subscribe(e -> System.out.println("Observer 1: " + e));

    Thread.sleep(5000);

    // observer 2 will get upto 5 elements because of replay
    src.subscribe(e -> System.out.println("Observer 2: " + e));

    Thread.sleep(3000);
  }
}
