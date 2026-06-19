package restaurant.receiver;

import java.util.ArrayDeque;
import java.util.Deque;

// Receiver 2
public final class Bartender implements Receiver {
  private final Deque<String> drinkHistory = new ArrayDeque<>();

  public void prepare(String drink) {
    drinkHistory.push(drink);
    System.out.println("Barkeeper bereitet zu: " + drink);
  }

  public void cancel(String drink) {
    if (drinkHistory.remove(drink)) {
      System.out.println("Barkeeper storniert: " + drink);
    }
  }
}
