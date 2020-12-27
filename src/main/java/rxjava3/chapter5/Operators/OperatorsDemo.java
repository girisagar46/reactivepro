package rxjava3.chapter5.Operators;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.List;

public class OperatorsDemo {

  /*
   * Operators takes upstream observable and return downstream observable
   * Types:
   * - Suppressing operator
   *    - filter(predicate)
   *    - take(int n) - take first n elements and emmit
   *    - skip(int n) - skip first n elements and emit the rest
   *    - distinct() - only emmit unique values
   *    - elementAt(index n) - emit only the element on specified index. ignore the rest.
   * - Transforming operator
   *    - map(function) - convert the type
   *    - cast() - cast each elements
   *    - delay(), delaySubscription()
   *    - scan(function) - apply function to the first item and feed result to next (ex. cumulative sum)
   *    - sorted() - sorts the upstream emission
   *    - repeat()
   * - Reducing operator - takes series and reduce to one and only works with finite number
   *    - count()
   *    - reduce() - identical to scan()
   *    - contains()
   *    - any()
   *    - all()
   * - Collection operators
   *    - toList()
   *    - toSortedList()
   *    - toMap()
   *    - collect()
   * - Error-recovery operator - handle errors and try to recover from it
   *    - onErrorReturnItem()
   *    - onErrorReturn(lambda) - take lambda to yield default value
   *    - onErrorResumeNext() - emit multiple values instead of single when exception occurs
   *    - retry() - re-subscribe to observable
   * - Action operator - used for debugging
   *    - doOnNext()
   *    - doOnError()
   *    - doOnSubscribe()
   *    - doOnComplete()
   */

  public static void main(String[] args) {
    Disposable d =
        Observable.just(50, 98, 76, 56, 99)
            .filter(e -> e > 75)
            .sorted()
            .subscribe(e -> System.out.println("Grade A with " + e));
    d.dispose();

    Observable<Employee> employees =
        Observable.just(
            new Employee(101, "Test1", 60000, 4.0),
            new Employee(102, "Test2", 94000, 4.7),
            new Employee(103, "Test3", 56000, 3.0),
            new Employee(104, "Test4", 20000, 3.5),
            new Employee(105, "Test5", 30000, 4.1),
            new Employee(106, "Test6", 30000, 4.23),
            new Employee(107, "Test7", 30000, 3.9));

    Disposable employeeDisposable =
        employees
            .filter(e -> e.getRating() > 4.0)
            .sorted((e1, e2) -> Double.compare(e2.getRating(), e1.getRating()))
            .map(Employee::getName)
            .take(2)
            .toList()
            .subscribe(System.out::println);

    employeeDisposable.dispose();

    List<Integer> expenses = List.of(200, 500, 300, 324, 645, 789);
    Disposable expenseDisposable =
        Observable.fromIterable(expenses).scan(Integer::sum).subscribe(System.out::println);

    expenseDisposable.dispose();
  }
}
