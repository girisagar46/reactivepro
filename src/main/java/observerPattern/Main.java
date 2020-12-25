package observerPattern;

public class Main {

  public static void main(String[] args) {
    WeatherStation station = new WeatherStation();
    PhoneDisplay pd1 = new PhoneDisplay(station);
    PhoneDisplay pd2 = new PhoneDisplay(station);
    station.add(pd1);
    station.add(pd2);

    System.out.println(pd1.getUpdate());
    System.out.println(pd2.getUpdate());
    station.publish();  // after publish the data is changed and published to all subscribers
    System.out.println(pd1.getUpdate());
    System.out.println(pd2.getUpdate());
  }
}
