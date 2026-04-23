package junit6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ShoppingCartTest {

    @Test
    void calculates_total_for_multiple_items_without_discount() {
        // given
        ShoppingCart cart = new ShoppingCart();
        ShoppingCart.Item book = new ShoppingCart.Item("book1", "Java Book", 2500); // 25,00 €
        ShoppingCart.Item pen = new ShoppingCart.Item("pen1", "Blue Pen", 150); // 1,50 €

        cart.addItem(book, 2); // 2 * 25,00 = 50,00 €
        cart.addItem(pen, 3); // 3 * 1,50  = 4,50 €

        // when
        int totalInCents = cart.getTotalPriceInCents();

        // then
        assertEquals(5450, totalInCents); // 54,50 €
    }

    @Test
    void applies_percentage_discount_to_total_price() {
        // given
        ShoppingCart cart = new ShoppingCart();
        ShoppingCart.Item item = new ShoppingCart.Item("item1", "Fancy Mug", 2000); // 20,00 €

        cart.addItem(item, 2); // 40,00 €
        cart.applyPercentageDiscount(25); // 25 % Rabatt

        // when
        int totalInCents = cart.getTotalPriceInCents();

        // then
        assertEquals(3000, totalInCents); // 40,00 € - 25 % = 30,00 €
    }

    @Test
    void removing_items_reduces_total_and_can_empty_cart() {
        // given
        ShoppingCart cart = new ShoppingCart();
        ShoppingCart.Item item = new ShoppingCart.Item("item1", "Notebook", 1000); // 10,00 €

        cart.addItem(item, 3); // 30,00 €

        // when
        cart.removeItem("item1", 2); // es bleiben 1 * 10,00 €
        int totalAfterPartialRemoval = cart.getTotalPriceInCents();

        cart.removeItem("item1", 1); // jetzt 0, Wagen leer
        int totalAfterFullRemoval = cart.getTotalPriceInCents();

        // then
        assertEquals(1000, totalAfterPartialRemoval);
        assertEquals(0, totalAfterFullRemoval);
        assertTrue(cart.isEmpty());
    }

    @Test
    void clear_resets_cart_and_removes_discounts() {
        // given
        ShoppingCart cart = new ShoppingCart();
        ShoppingCart.Item item = new ShoppingCart.Item("item1", "Headphones", 5000);

        cart.addItem(item, 1); // 50,00 €
        cart.applyPercentageDiscount(10); // 10 %

        // when
        cart.clear();

        // then
        assertTrue(cart.isEmpty());
        assertEquals(0, cart.getTotalPriceInCents());
    }

    // ------------------------------------------------------------------------
    // Parametrisierte Tests
    // ------------------------------------------------------------------------

    @ParameterizedTest(name = "addItem: {1} * {2} cents => expected total {3} cents")
    @CsvSource({
        // itemName,  unitPriceInCents, quantity, expectedTotalInCents
        "Cheap Pen,          100,      1,    100",
        "Fancy Pen,          250,      4,   1000",
        "Notebook,          1500,      2,   3000",
        "Expensive Mouse,   4999,      3,  14997"
    })
    void calculates_total_for_single_item_with_various_quantities(
            String itemName, int unitPriceInCents, int quantity, int expectedTotalInCents) {

        // given
        ShoppingCart cart = new ShoppingCart();
        ShoppingCart.Item item = new ShoppingCart.Item("item1", itemName, unitPriceInCents);
        cart.addItem(item, quantity);

        // when
        int totalInCents = cart.getTotalPriceInCents();

        // then
        assertEquals(expectedTotalInCents, totalInCents);
    }

    @ParameterizedTest(name = "discount {0}% on 10000 cents => expected {1} cents")
    @CsvSource({
        // discountPercent, expectedTotalAfterDiscount
        "0,    10000", // kein Rabatt
        "10,    9000",
        "25,    7500",
        "50,    5000",
        "100,      0"
    })
    void applies_various_discounts_to_fixed_base_amount(
            int discountPercent, int expectedTotalInCents) {
        // given
        ShoppingCart cart = new ShoppingCart();
        ShoppingCart.Item item = new ShoppingCart.Item("item1", "Some Item", 10000); // 100,00 €
        cart.addItem(item, 1); // Basisbetrag: 10000 Cent

        cart.applyPercentageDiscount(discountPercent);

        // when
        int totalInCents = cart.getTotalPriceInCents();

        // then
        assertEquals(expectedTotalInCents, totalInCents);
    }
}
