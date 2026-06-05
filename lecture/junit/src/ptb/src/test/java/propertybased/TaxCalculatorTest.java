package propertybased;

import static org.junit.jupiter.api.Assertions.*;

import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.api.Test;

class TaxCalculatorTest {

    // E1: Ungültige Eingabe
    @Test
    void negative_income_throws_exception() {
        // given
        int invalidIncome = -1;

        // when & then
        assertThrows(
                IllegalArgumentException.class, () -> TaxCalculator.calculateTax(invalidIncome));
    }

    // E2: 0 <= income < 10_000
    @Test
    void income_below_10k_is_tax_free() {
        // given
        int income1 = 0;
        int income2 = 5_000;
        int income3 = 9_999;

        // when & then
        assertEquals(0, TaxCalculator.calculateTax(income1));
        assertEquals(0, TaxCalculator.calculateTax(income2));
        assertEquals(0, TaxCalculator.calculateTax(income3));
    }

    // E3: 10_000 <= income <= 20_000
    @Test
    void income_between_10k_and_20k_taxed_at_10_percent_above_10k() {
        // given
        int incomeAtLowerBoundary = 10_000;
        int incomeMiddle = 15_000;
        int incomeAtUpperBoundary = 20_000;

        // when & then
        // Genau bei 10_000: noch keine Steuer
        assertEquals(0, TaxCalculator.calculateTax(incomeAtLowerBoundary));

        // 15_000: 10% von 5_000 = 500
        assertEquals(500, TaxCalculator.calculateTax(incomeMiddle));

        // 20_000: 10% von 10_000 = 1_000
        assertEquals(1_000, TaxCalculator.calculateTax(incomeAtUpperBoundary));
    }

    // E4: 20_000 < income <= 50_000
    @Test
    void income_between_20k_and_50k_has_two_brackets() {
        // given
        int incomeJustAboveLowerBoundary = 20_001;
        int incomeMiddle = 30_000;
        int incomeAtUpperBoundary = 50_000;

        // when & then
        // 20_001: 10% von 10_000 + 20% von 1 = 1_000 + 0.2 -> floor = 1_000
        assertEquals(1_000, TaxCalculator.calculateTax(incomeJustAboveLowerBoundary));

        // 30_000: 10% von 10_000 + 20% von 10_000 = 1_000 + 2_000 = 3_000
        assertEquals(3_000, TaxCalculator.calculateTax(incomeMiddle));

        // 50_000: 10% von 10_000 + 20% von 30_000 = 1_000 + 6_000 = 7_000
        assertEquals(7_000, TaxCalculator.calculateTax(incomeAtUpperBoundary));
    }

    // E5: income > 50_000
    @Test
    void income_above_50k_has_third_bracket() {
        // given
        int incomeJustAboveLowerBoundary = 50_001;
        int incomeHigher = 80_000;

        // when & then
        // 50_001: 7_000 + 30% von 1 = 7_000 + 0.3 -> floor = 7_000
        assertEquals(7_000, TaxCalculator.calculateTax(incomeJustAboveLowerBoundary));

        // 80_000: 7_000 + 30% von 30_000 = 7_000 + 9_000 = 16_000
        assertEquals(16_000, TaxCalculator.calculateTax(incomeHigher));
    }

    @Property
    void tax_is_never_negative(@ForAll @IntRange(min = 0, max = 1_000_000) int income) {
        // given, when
        int tax = TaxCalculator.calculateTax(income);

        // then
        assertTrue(tax >= 0);
    }
}
