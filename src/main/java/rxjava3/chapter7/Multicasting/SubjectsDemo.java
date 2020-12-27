package rxjava3.chapter7.Multicasting;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class SubjectsDemo {

  // Subject act as both Observable and Observer
  // Subjects suitable for input and output
  // Subject are multicast i.e. they are hot

  public static void main(String[] args) throws InterruptedException {
    Observable<Integer> src1 = Observable.just(5, 10, 15, 20).subscribeOn(Schedulers.computation());
    Observable<Integer> src2 =
        Observable.just(50, 100, 150, 200).subscribeOn(Schedulers.computation());

    // src1.subscribe(System.out::println);
    // src2.subscribe(System.out::println);

    PublishSubject<Object> subject = PublishSubject.create();

    subject.subscribe(System.out::println);

    src1.subscribe(subject);
    src2.subscribe(subject);

    Thread.sleep(9000);
  }
}
