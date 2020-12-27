package rxjava3.chapter5.Operators;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
  private Integer id;
  private String name;
  double salary, rating;

  @Override
  public String toString() {
    return "Employee{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", salary="
        + salary
        + ", rating="
        + rating
        + '}';
  }
}
