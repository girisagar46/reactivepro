package observerPattern;

public interface IObservable {
  void add(IObserver observer);
  void remove(IObserver observer);

  void publish();
}
