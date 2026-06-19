package restaurant;

import restaurant.client.Guest;
import restaurant.invoker.Waiter;
import restaurant.receiver.Bartender;
import restaurant.receiver.Chef;

public class RestaurantDemo {
  public static void main(String[] args) {
    Chef chef = new Chef();
    Bartender bartender = new Bartender();
    Waiter waiter = new Waiter(chef, bartender);
    Guest guest = new Guest(waiter);

    System.out.println("**Neue Bestellungen:**");
    guest.orderFood("Steak");
    guest.orderDrink("Wein");

    System.out.println("\n**Stornieren:**");
    waiter.undoLastOrder(); // Storniert den Wein
  }
}
