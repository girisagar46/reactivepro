package basics;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.io.BufferedReader;

public class RxReader {

  @NonNull Observable<Object> lines(BufferedReader reader) {
    return Observable.create(
        subscriber -> {
          String line;
          while ((line = reader.readLine()) != null) {
            subscriber.onNext(line);
            if (subscriber.isDisposed()) {
              break;
            }
          }

          subscriber.onComplete();
        }).subscribeOn(Schedulers.io());
  }
}
