import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {

  public static Observable<Integer> fakeUserInput() {
    // stream numbers to simulate user input
    var random = new Random();
    //    return Observable.just(10, 20, 30, 40).map(number -> number * random.nextInt(20));

    // Every 500ms
    //    return Observable.intervalRange(0, 20, 500, 500, TimeUnit.MILLISECONDS)
    //        .map(number -> random.nextInt(20));

    // Introduce some jitters
    return Observable.intervalRange(0, 20, 500, 500, TimeUnit.MILLISECONDS)
        .concatMap(
            number ->
                Observable.just(random.nextInt(20))
                    .delay(random.nextInt(500), TimeUnit.MILLISECONDS));
  }

  public static void main(String[] args) {
    Flowable.just("Hello world").subscribe(System.out::println);
    Observable.just("Hello World12").subscribe(System.out::println);
    // Observable.range(10, 20).subscribe(System.out::println);

    // fakeUserInput().subscribe(System.out::println);
    fakeUserInput().blockingSubscribe(System.out::println);

    fakeUserInput()
        .observeOn(Schedulers.trampoline())
        .flatMapMaybe(x -> RxFibonacci.fibs().elementAt(x)) // elementAt returns a Maybe
        .blockingSubscribe(System.out::println);
  }
}
