package rxjava3.chapter7.Multicasting;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.AsyncSubject;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.ReplaySubject;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.concurrent.TimeUnit;

public class SubjectsTypeDemo {

  /*
   * Types of subjects:
   *  - PublishSubject (Most basic)
   *    - Starts to emit the source observables items from the moment observer subscribe to it.
   *    - Example: watching a movie in TV. Once you open a channel, you can only watch it from that moment onwards
   *  - ReplaySubject
   *    - emits all the items of the source observable, regardless of when the subscriber subscribers
   *    - Internally it's just a publisher with cache operator
   *    - Example: Watching a movie in Netflix. If your friend joins you while you're watching a movie, you can go to the beginning and watch it again with your friend from the beginning
   *  - BehaviourSubject
   *    - emit the most recent item with the subsequent items of the source observable from the point of subscription
   *    - Receive all emissions with the most recent one
   *    - Example: Watching a movie in Netflix. If your friend joins you while you're watching a movie, your friend get the context and can begin watching from at the same moment.
   *  - AsyncSubject
   *    - Emits only the last value of the source observable
   *    - Example: You and your friend is only interested on how the movie ends i.e. onComplete()
   *  - UnicastSubject
   *    - buffers all the emissions received by the sources, until an observer subscribes to it.
   *    - Only allows one observer
   */

  public static void main(String[] args) throws InterruptedException {
    PublishSubject<String> subject = PublishSubject.create();
    // this subscriber will get all the data
    subject.subscribe(e -> System.out.println("Subscriber 1: " + e));
    subject.onNext("a");
    subject.onNext("b");
    subject.onNext("c");

    // this subscriber came next and will not the get emission that happened before
    subject.subscribe(e -> System.out.println("Subscriber 2: " + e));
    subject.onNext("d");
    subject.onNext("e");
    subject.onNext("f");

    System.out.println("Reply Subject~~~");
    ReplaySubject<String> replaySubject = ReplaySubject.create();
    replaySubject.subscribe(e -> System.out.println("Subscriber 1: " + e));
    replaySubject.onNext("a");
    replaySubject.onNext("b");
    replaySubject.onNext("c");

    // this subscriber came next and will not the get emission that happened before
    replaySubject.subscribe(e -> System.out.println("Subscriber 2: " + e));
    replaySubject.onNext("d");
    replaySubject.onNext("e");
    replaySubject.onNext("f");

    System.out.println("Behaviour Subject~~~");
    BehaviorSubject<String> behaviourSubject = BehaviorSubject.create();
    behaviourSubject.subscribe(e -> System.out.println("Subscriber 1: " + e));
    behaviourSubject.onNext("a");
    behaviourSubject.onNext("b");
    behaviourSubject.onNext("c");

    // this subscriber came next and will only get the last emission wgucg happened before
    behaviourSubject.subscribe(e -> System.out.println("Subscriber 2: " + e));
    behaviourSubject.onNext("d");
    behaviourSubject.onNext("e");
    behaviourSubject.onComplete();

    System.out.println("Async Subject~~~");
    AsyncSubject<String> asyncSubject = AsyncSubject.create();
    asyncSubject.subscribe(e -> System.out.println("Subscriber 1: " + e));
    asyncSubject.onNext("a");
    asyncSubject.onNext("b");

    asyncSubject.subscribe(e -> System.out.println("Subscriber 2: " + e));
    asyncSubject.onNext("c");
    asyncSubject.onNext("d");
    asyncSubject.onComplete(); // only outputs the last emission when onComplete() is complete

    System.out.println("UniCast Subject~~~");
    UnicastSubject<Long> unicastSubject = UnicastSubject.create();
    Observable.interval(1000, TimeUnit.MILLISECONDS).subscribe(unicastSubject);

    Thread.sleep(2000);
    unicastSubject.subscribe(
        e -> System.out.println(" Subscriber " + e)); // buffers the first emissions

    Thread.sleep(2000);
  }
}
