package rxjava3.chapter2.observerpattern;

import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import rxjava3.chapter2.observerpattern.interfaces.Observer;
import rxjava3.chapter2.observerpattern.interfaces.SubjectLibrary;

@Getter
@Setter
public class Book implements SubjectLibrary {

  private String name;
  private String type;
  private String author;
  private double price;
  private String inStock;
  private List<Observer> observerList = new ArrayList<>();

  public Book(String name, String type, String author, double price, String inStock) {
    this.name = name;
    this.type = type;
    this.author = author;
    this.price = price;
    this.inStock = inStock;
  }


  public void setInStock(String inStock) {
    this.inStock = inStock;
    System.out.println("Availability changed from Sold out to back in stock");
    notifyObserver();
  }

  @Override
  public void subscribeObserver(Observer ob) {
    observerList.add(ob);
  }

  @Override
  public void unsubscribeObserver(Observer ob) {
    observerList.remove(ob);
  }

  @Override
  public void notifyObserver() {
    System.out.println(String.format("Book name: %s, Book type: %s, Price: %f, Author: %s, is now %s", this.name, this.type, this.price, this.author, this.inStock));
    for (Observer observer : observerList) {
      observer.update(this.inStock);
    }
  }
}
