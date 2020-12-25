package rxjava3.chapter2.observerpattern;

import lombok.Data;
import rxjava3.chapter2.observerpattern.interfaces.Observer;
import rxjava3.chapter2.observerpattern.interfaces.SubjectLibrary;

@Data
public class EndUser implements Observer {

  String name;

  EndUser(String name, SubjectLibrary subject) {
    this.name = name;
    subject.subscribeObserver(this);
  }

  @Override
  public void update(String available) {
    System.out.println(String.format("Hello %s, the book is now %s", name, available));
  }
}
