package propertybased;

public class TaxCalculator {

    public static int calculateTax(int income) {
        if (income < 0) throw new IllegalArgumentException("Income must be >= 0");

        double tax = 0.0;

        if (income <= 10_000) tax = 0.0;
        else if (income <= 20_000) tax = 0.10 * (income - 10_000);
        else if (income <= 50_000) tax = 0.10 * 10_000 + 0.20 * (income - 20_000);
        else tax = 0.10 * 10_000 + 0.20 * 30_000 + 0.30 * (income - 50_000);

        return (int) Math.floor(tax);
    }
}
