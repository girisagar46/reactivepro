package rxjava3.chapter6.CombiningObservables;

import io.reactivex.rxjava3.core.Observable;
import java.util.List;

public class FlatMapDemo {

  public static void main(String[] args) {
    List<String> list = List.of("Hello", "Reactive", "Programming");

    Observable.fromIterable(list)
        .flatMap(
            e ->
                Observable.fromArray(
                    e.split(
                        ""))) // if it's being processed in different thread, the output would be in
                              // interleaved fashion
        .subscribe(System.out::println);

    Observable.fromIterable(list)
        .concatMap(
            e ->
                Observable.fromArray(
                    e.split(
                        ""))) // if it's being processed in different thread, the output would be in
        // interleaved fashion
        .subscribe(System.out::println);
  }
}
