package rxjava3.chapter6.CombiningObservables;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.GroupedObservable;
import rxjava3.chapter5.Operators.Employee;

public class GroupedObservableDemo {

  public static void main(String[] args) {
    // use .groupBy(keySelector)

    Observable<Employee> employees =
        Observable.just(
            new Employee(101, "Test1", 60000, 4.0),
            new Employee(102, "Test2", 94000, 4.0),
            new Employee(103, "Test3", 56000, 3.0),
            new Employee(104, "Test4", 20000, 3.5),
            new Employee(105, "Test5", 30000, 4.1),
            new Employee(106, "Test6", 30000, 4.23),
            new Employee(107, "Test7", 30000, 3.9));

    employees
        .groupBy(Employee::getRating)
        .flatMapSingle(e -> e.toMultimap(key -> e.getKey(), Employee::getName))
        .subscribe(System.out::println);
  }
}
