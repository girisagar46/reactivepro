package observerPattern;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements IObservable {

  List<IObserver> observers = new ArrayList<>();
  int temperature = 98;

  @Override
  public void add(IObserver observer) {
    observers.add(observer);
  }

  @Override
  public void remove(IObserver observer) {
    observers.remove(observer);
  }

  @Override
  public void publish() {

    this.temperature = 100;

    for (IObserver observer : observers) {
      observer.update();
    }
  }

  int getTemperature() {
    return this.temperature;
  }
}
