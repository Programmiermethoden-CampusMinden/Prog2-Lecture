package observer;

import java.util.ArrayList;
import java.util.List;

public class LSF {
  private final List<Observer> observers = new ArrayList<>();

  public String getGradings(Observer p, String myModule) {
    return "2.0";
  }

  public void register(Observer p) {
    observers.add(p);
  }

  public void notifyGradings() {
    for (var o : observers) o.update(getGradings(o, "wuppie"));
  }
}
