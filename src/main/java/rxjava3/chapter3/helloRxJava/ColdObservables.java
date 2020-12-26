package rxjava3.chapter3.helloRxJava;

import io.reactivex.rxjava3.core.Observable;
import java.util.ArrayList;
import java.util.List;

//
public class ColdObservables {

  public static void main(String[] args) {
    List<Integer> nums = new ArrayList<>();
    nums.add(10);
    nums.add(20);
    nums.add(30);

    Observable<Integer> source = Observable.fromIterable(nums);
    source.subscribe(System.out::println);
    nums = modify(nums);
    System.out.println("---");
    source.subscribe(System.out::println);
  }

  private static List<Integer> modify(List<Integer> nums) {
    nums.add(40);
    return nums;
  }
}

