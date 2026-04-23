package junit6;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Test;

class DemoResults {

    @Test
    void passes_when_assertion_is_true() {
        assertEquals(0, 1 - 1); // assert() ist ok -> test ist "grün"
    }

    @Test
    void fails_when_assertion_is_false() {
        assertEquals(0, 1); // assert() ist NOK -> test ist "rot"
    }

    @Test
    void fails_when_unexpected_exception_is_thrown() {
        throw new RuntimeException(); // nicht gefangene exception -> test ist "rot"
    }

    @Test
    void passes_when_no_assertion_fails_and_no_exception_occurs() {
        int x = 42; // kein fehlschlagendes assert(), keine exception -> test ist "grün"
    }

    @Test
    void is_skipped_when_assumption_is_not_met() {
        assumeTrue(1 == 0); // bricht ab und ignoriert den test

        assertEquals(0, 1);
    }
}
