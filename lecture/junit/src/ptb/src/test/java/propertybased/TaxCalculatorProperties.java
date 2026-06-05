package propertybased;

import static org.junit.jupiter.api.Assertions.assertTrue;

import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;

class TaxCalculatorProperties {

    @Property
    void tax_is_never_negative(@ForAll @IntRange(min = 0, max = 1_000_000) int income) {
        // given, when
        int tax = TaxCalculator.calculateTax(income);

        // then
        assertTrue(tax >= 0);
    }

    @Property
    void tax_is_monotone_non_decreasing(
            @ForAll @IntRange(min = 0, max = 1_000_000) int a,
            @ForAll @IntRange(min = 0, max = 1_000_000) int b) {

        // given
        int lower = Math.min(a, b);
        int higher = Math.max(a, b);

        // when
        int taxLower = TaxCalculator.calculateTax(lower);
        int taxHigher = TaxCalculator.calculateTax(higher);

        // then
        assertTrue(taxLower <= taxHigher);
    }

    @Property
    void within_bracket_10k_to_20k_tax_grows_with_roughly_10_percent(
            @ForAll @IntRange(min = 10_000, max = 19_000) int base,
            @ForAll @IntRange(min = 0, max = 1_000) int delta) {

        // given
        int income1 = base;
        int income2 = base + delta;
        if (income2 > 20_000) {
            income2 = 20_000;
        }

        // when
        int tax1 = TaxCalculator.calculateTax(income1);
        int tax2 = TaxCalculator.calculateTax(income2);

        int diffIncome = income2 - income1;
        int diffTax = tax2 - tax1;

        int expected = (int) Math.floor(0.10 * diffIncome);

        // then
        // Wegen Rundung erlauben wir +/- 1 Euro Toleranz
        assertTrue(diffTax >= expected - 1 && diffTax <= expected + 1);
    }
}
