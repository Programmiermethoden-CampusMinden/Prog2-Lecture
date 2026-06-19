package restaurant.receiver;

import java.util.ArrayDeque;
import java.util.Deque;

// Receiver 1
public final class Chef implements Receiver {
  private final Deque<String> orderHistory = new ArrayDeque<>();

  public void prepare(String dish) {
    orderHistory.push(dish);
    System.out.println("Koch bereitet zu: " + dish);
  }

  public void cancel(String dish) {
    if (orderHistory.remove(dish)) {
      System.out.println("Koch storniert: " + dish);
    }
  }
}
