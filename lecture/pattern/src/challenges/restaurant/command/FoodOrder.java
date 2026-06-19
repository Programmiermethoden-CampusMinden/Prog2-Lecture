package restaurant.command;

import restaurant.receiver.Receiver;

// Concrete Command 1: Bestellung für den Koch
public record FoodOrder(String dish) implements OrderCommand {
  @Override
  public void execute(Receiver receiver) {
    receiver.prepare(dish);
  }

  @Override
  public void undo(Receiver receiver) {
    receiver.cancel(dish);
  }
}
