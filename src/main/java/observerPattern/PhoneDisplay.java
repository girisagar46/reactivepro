package observerPattern;

public class PhoneDisplay implements IObserver {

  WeatherStation station;
  int temperature = 0;

  public PhoneDisplay(WeatherStation station) {
    this.station = station;
  }

  @Override
  public int update() {
    this.temperature = this.station.getTemperature();
    return this.temperature;
  }

  public int getUpdate(){
    return update();
  }
}
