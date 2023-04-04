package challenges.visitor.card;

import static java.util.Objects.requireNonNull;

/**
 * A card for a Quartets game, representing different vehicles.
 *
 * @param cardType type of the card (must not be {@code null})
 * @param name name of the vehicle on the card (must not be {@code null})
 * @param weight weight of the vehicle on the card
 * @param maxDistance maximal travel distance of the vehicle on the card
 * @param fuelConsumption fuel consumption (100km) of the vehicle on the card
 * @param price price of the vehicle on the card
 */
public record Card(
        CardType cardType, String name, int weight, int maxDistance, int fuelConsumption, int price)
        implements Comparable<Card> {

    /**
     * Extend the default ctor: reject {@code null} in {@link #cardType} and {@link #name}
     *
     * @param cardType type of the card (must not be {@code null})
     * @param name name of the vehicle on the card (must not be {@code null})
     * @param weight weight of the vehicle on the card
     * @param maxDistance maximal travel distance of the vehicle on the card
     * @param fuelConsumption fuel consumption (100km) of the vehicle on the card
     * @param price price of the vehicle on the card
     * @throws NullPointerException if cardType and/or name are/is {@code null}
     */
    public Card {
        requireNonNull(cardType);
        requireNonNull(name);
    }

    /**
     * Implement the {@link Comparable} interface.
     *
     * <p>Compares two cards according to the rules of Quartets game: Use {@link #price} (unless
     * equal), then compare {@link #maxDistance} (unless equal), then compare {@link
     * #fuelConsumption} (unless equal), then compare {@link #weight} (unless equal) and as last
     * resort compare the {@link #cardType} field (enum).
     *
     * @param otherCard to be compared to {@code this} card ({@code otherCard} must not be {@code
     *     null})
     * @return {@code 0} if {@code this == otherCard}, {@code <0} if {@code this < otherCard},
     *     {@code >0} else
     * @throws NullPointerException if {@code otherCard} is {@code null}
     */
    @Override
    public int compareTo(Card otherCard) {
        requireNonNull(otherCard);

        int compareValue = Integer.compare(price(), otherCard.price());
        if (compareValue != 0) {
            return compareValue;
        }
        compareValue = Integer.compare(maxDistance(), otherCard.maxDistance());
        if (compareValue != 0) {
            return compareValue;
        }
        compareValue = Integer.compare(fuelConsumption(), otherCard.fuelConsumption());
        if (compareValue != 0) {
            return compareValue;
        }
        compareValue = Integer.compare(weight(), otherCard.weight());
        if (compareValue != 0) {
            return compareValue;
        }
        return cardType().compareTo(otherCard.cardType());
    }

    /** Returns a string built from {@link #cardType} and {@link #name}. */
    @Override
    public String toString() {
        return cardType() + ": '" + name() + "'; ";
    }
}
