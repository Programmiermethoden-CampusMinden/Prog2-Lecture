package junit6;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ShoppingCart {

    public static class Item {
        private final String id;
        private final String name;
        private final int unitPriceInCents;

        public Item(String id, String name, int unitPriceInCents) {
            this.id = Objects.requireNonNull(id);
            this.name = Objects.requireNonNull(name);
            if (unitPriceInCents < 0) {
                throw new IllegalArgumentException("Price must not be negative");
            }
            this.unitPriceInCents = unitPriceInCents;
        }

        public String getId() {
            return id;
        }

        public int getUnitPriceInCents() {
            return unitPriceInCents;
        }
    }

    private final Map<String, Integer> quantitiesByItemId = new HashMap<>();
    private final Map<String, Item> itemsById = new HashMap<>();
    private int percentageDiscount = 0;

    public void addItem(Item item, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        itemsById.putIfAbsent(item.getId(), item);
        quantitiesByItemId.merge(item.getId(), quantity, Integer::sum);
    }

    public void removeItem(String itemId, int quantity) {
        Integer current = quantitiesByItemId.get(itemId);
        if (current == null || quantity <= 0) {
            return;
        }
        int newQuantity = current - quantity;
        if (newQuantity <= 0) {
            quantitiesByItemId.remove(itemId);
        } else {
            quantitiesByItemId.put(itemId, newQuantity);
        }
    }

    public void applyPercentageDiscount(int discount) {
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Discount must be between 0 and 100");
        }
        this.percentageDiscount = discount;
    }

    public int getTotalPriceInCents() {
        int sum = 0;
        for (Map.Entry<String, Integer> entry : quantitiesByItemId.entrySet()) {
            Item item = itemsById.get(entry.getKey());
            int quantity = entry.getValue();
            sum += item.getUnitPriceInCents() * quantity;
        }
        int discountAmount = sum * percentageDiscount / 100;
        return sum - discountAmount;
    }

    public boolean isEmpty() {
        return quantitiesByItemId.isEmpty();
    }

    public void clear() {
        quantitiesByItemId.clear();
        percentageDiscount = 0;
    }
}
