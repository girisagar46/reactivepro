package rxjava3.chapter7.Multicasting;

import io.reactivex.rxjava3.subjects.PublishSubject;

public class EmitSubjectDemo {

  public static void main(String[] args) {
    // Subjects are in disposable
    // Subjects are not thread safe
    // Subjects should not be exposed because someone might invoke `onNext`
    PublishSubject<String> subject = PublishSubject.create();

    subject.subscribe(System.out::println);
    subject.subscribe(e -> System.out.println("Observer 2 " + e));


    // Should be passed only after subscribe
    subject.onNext("Hello");
    subject.onNext("World");
    subject.onComplete();
  }
}
