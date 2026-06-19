package restaurant.command;

import restaurant.receiver.Receiver;

// Concrete Command 2: Bestellung für den Barkeeper
public record DrinkOrder(String drink) implements OrderCommand {
  @Override
  public void execute(Receiver receiver) {
    receiver.prepare(drink);
  }

  @Override
  public void undo(Receiver receiver) {
    receiver.cancel(drink);
  }
}
