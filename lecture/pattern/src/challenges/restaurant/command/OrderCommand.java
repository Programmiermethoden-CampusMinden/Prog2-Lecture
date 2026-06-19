package restaurant.command;

import restaurant.receiver.Receiver;

public sealed interface OrderCommand permits FoodOrder, DrinkOrder {
  void execute(Receiver receiver); // Bestellung aufgeben

  void undo(Receiver receiver); // Bestellung stornieren
}
