package rxjava3.chapter2.observerpattern;

public class ObserverPattern {

  public static void main(String[] args) {
    Book book = new Book("Beyond Legacy Code", "Engineering practice", "David Scott", 200, "SoldOut");

    EndUser user1 = new EndUser("Bob", book);
    EndUser user2 = new EndUser("Rob", book);

    System.out.println(book.getInStock());
    book.setInStock("InStock");
  }
}
