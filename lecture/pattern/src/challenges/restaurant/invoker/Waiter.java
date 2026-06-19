package restaurant.invoker;

import java.util.ArrayDeque;
import java.util.Deque;
import restaurant.command.DrinkOrder;
import restaurant.command.FoodOrder;
import restaurant.command.OrderCommand;
import restaurant.receiver.Bartender;
import restaurant.receiver.Chef;

// Invoker
public final class Waiter {
  private final Chef chef;
  private final Bartender bartender;
  private final Deque<OrderCommand> orderHistory = new ArrayDeque<>();

  public Waiter(Chef chef, Bartender bartender) {
    this.chef = chef;
    this.bartender = bartender;
  }

  // Neue Bestellung entgegennehmen
  public void takeOrder(OrderCommand order) {
    switch (order) {
      case DrinkOrder o -> o.execute(bartender);
      case FoodOrder o -> o.execute(chef);
    }
    orderHistory.push(order);
  }

  // Letzte Bestellung stornieren
  public void undoLastOrder() {
    if (!orderHistory.isEmpty())
      switch (orderHistory.pop()) {
        case DrinkOrder o -> o.undo(bartender);
        case FoodOrder o -> o.undo(chef);
      }
  }
}
