package rxjava3.chapter2.observerpattern.interfaces;

public interface SubjectLibrary {
  public void subscribeObserver(Observer ob);

  public void unsubscribeObserver(Observer ob);

  public void notifyObserver();
}
