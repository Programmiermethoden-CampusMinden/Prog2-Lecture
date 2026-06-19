package restaurant.client;

import restaurant.command.DrinkOrder;
import restaurant.command.FoodOrder;
import restaurant.invoker.Waiter;

// Client
public final class Guest {
  private final Waiter waiter;

  public Guest(Waiter waiter) {
    this.waiter = waiter;
  }

  public void orderFood(String dish) {
    waiter.takeOrder(new FoodOrder(dish));
  }

  public void orderDrink(String drink) {
    waiter.takeOrder(new DrinkOrder(drink));
  }
}
