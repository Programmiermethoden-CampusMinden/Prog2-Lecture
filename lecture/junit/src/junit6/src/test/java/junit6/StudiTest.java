package junit6;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StudiTest {

    @Test
    void stores_name_when_setName_is_called_with_non_null_value() {
        // given
        var studi = new Studi();
        var expectedName = "Alex Example";

        // when
        studi.setName(expectedName);

        // then
        assertEquals(expectedName, studi.getName());
    }

    @Test
    void accumulates_credits_within_upper_limit() {
        // given
        var studi = new Studi();
        var startCredits = 2;
        assumeTrue(studi.getCredits() == 0, "initial credits should be 0");

        // when
        studi.addToCredits(startCredits);

        // then
        assertEquals(startCredits, studi.getCredits());
    }

    @Test
    void accumulates_credits_up_to_upper_limit() {
        // given
        var studi = new Studi();
        studi.addToCredits(10); // bisher 10 Credits

        // when
        studi.addToCredits(200); // insgesamt 210 Credits

        // then
        assertEquals(210, studi.getCredits());
    }

    @Test
    void throws_exception_when_adding_negative_or_too_many_credits() {
        // given
        var studi = new Studi();
        studi.addToCredits(200); // steht kurz vor dem Limit

        // when & then
        assertThrows(
                IllegalArgumentException.class,
                () -> studi.addToCredits(-5),
                "negative credits not feasible");

        assertThrows(
                IllegalArgumentException.class,
                () -> studi.addToCredits(20),
                "more than 210 credits not possible");

        try {
            studi.addToCredits(-5);
            fail("negative credits not feasible");
        } catch (IllegalArgumentException iae) {
            assertEquals("Negative Credits nicht erlaubt", iae.getMessage());
        } catch (Exception e) {
            fail("wrong exception");
        }
    }

    @ParameterizedTest(name = "start={0}, add={1} => expected total={2}")
    @CsvSource({
        // startCredits, creditsToAdd, expectedTotal
        "0,    30,   30",
        "30,   60,   90",
        "100,  50,  150",
        "200,  10,  210"
    })
    void adds_credits_within_allowed_range(int startCredits, int creditsToAdd, int expectedTotal) {
        // given
        var studi = new Studi();
        studi.addToCredits(startCredits);

        // when
        studi.addToCredits(creditsToAdd);

        // then
        assertEquals(expectedTotal, studi.getCredits());
    }
}
