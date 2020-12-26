package rxjava3.chapter3.helloRxJava;

import io.reactivex.rxjava3.core.Observable;
import java.util.ArrayList;
import java.util.List;
import lombok.NonNull;

public class CreatingObservable {

  public static void main(String[] args) {

    /*
        Methods we can use to create observables
        Popular ones:
        Observable.create(source)
        Observable.just(upto 9 items)
        Observable.fromIterable(iterableSource)

        Other ones:
        Observable.range(startValue, totalCount)/rangeLong(startValue, totalCount)
        Observable.interval(period, TIMEUNIT)
        Observable.future(future)
        Observable.empty()
        Observable.never()
        Observable.error(exception)
        Observable.defer(supplier)
        Observable.fromCallable(Callable)
    */

    // using create method
    Observable<Integer> source1 =
        Observable.create(
            e -> {
              e.onNext(10);
              e.onNext(11);
              e.onComplete();
            });
    source1.subscribe(System.out::println);

    // using just()
    Observable<Integer> source2 = Observable.just(1, 2, 3); // only can pass 10 elements
    source2.subscribe(System.out::println);

    // using fromIterable()
    List<String> list = List.of("Hello", "World");

    @NonNull Observable<String> source3 = Observable.fromIterable(list);
    source3.subscribe(System.out::println);

    // using range()
    @NonNull Observable<Integer> source4 = Observable.range(0, 10);
    source4.subscribe(System.out::println); // here System.out::println is observer

    /*
        @NonNull Observable<Long> source5 = Observable.interval(1, TimeUnit.SECONDS);
        source5.subscribe(System.out::println);
        Thread.sleep(1000);
    */

    List<String> movies = new ArrayList<>();
    movies.add("Sherlock Holmes");
    movies.add("Mad Max: Fury Road");

    Observable<String> source6 = Observable.defer(() -> Observable.fromIterable(movies));
    source6.subscribe(System.out::println);
    movies.add("WW84");
    source6.subscribe(System.out::println);
  }
}
