package rxjava3.chapter3.helloRxJava;

import io.reactivex.rxjava3.core.Observable;

public class CreateObserver {
  public static void main(String[] args) {
    Observable<String> colorSource = Observable.just("Orange", "Red", "Blue");

    colorSource.subscribe(
        System.out::println, // this is onNext
        Throwable::printStackTrace, // this is onError
        () -> System.out.println("Completed!") // this is onComplete
        );
    System.out.println("---");
    colorSource.subscribe(
        System.out::println, // this is onNext
        Throwable::printStackTrace // this is onError
        // can ignore onComplete
        );

    System.out.println("---");
    colorSource.subscribe(
        System.out::println // this is onNext
        // can ignore onError and onComplete
        );
  }
}
