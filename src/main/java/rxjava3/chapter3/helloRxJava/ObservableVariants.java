package rxjava3.chapter3.helloRxJava;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class ObservableVariants {

  public static void main(String[] args) {
    // Single -> return only a single result
    Observable<String> source = Observable.just("Alex", "Justin", "Jack");
    Observable<String> emptySource = Observable.empty();
    source.first("name").subscribe(System.out::println);

    Single.just("Alex").subscribe(System.out::println);

    // Maybe -> This may or may not emmit a value
    source.firstElement().subscribe(System.out::println);
    emptySource
        .firstElement()
        .subscribe(
            System.out::println,
            Throwable::printStackTrace,
            () -> System.out.println("Completed!"));

    // Completable -> Does not emmit any data. It's only concern if the action was success or
    // failure
    Completable completable = Completable.complete();
    completable.subscribe(() -> System.out.println("Completable Completed"));

    Completable
        .fromRunnable(() -> System.out.println("Some process executing"))
        .subscribe(() -> System.out.println("The process executed successfully"));
  }
}
