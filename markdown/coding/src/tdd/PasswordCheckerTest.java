package tdd;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PasswordCheckerTest {
    @Test
    public void testStringType() {
        assertTrue(PasswordChecker.isValid("abcdef"));
    }

    @Test
    public void testStringNotEmpty() {
        assertFalse(PasswordChecker.isValid(""));
    }

    @Test
    public void testStringNotNull() {
        assertFalse(PasswordChecker.isValid(null));
    }

    @Test
    public void testStringTooShortOneChar() {
        assertFalse(PasswordChecker.isValid("a"));
    }

    @Test
    public void testStringTooShortTwoChar() {
        assertFalse(PasswordChecker.isValid("aa"));
    }

    @Test
    public void testStringTooShortThreeChar() {
        assertFalse(PasswordChecker.isValid("aaa"));
    }

    @Test
    public void testMinPWLength() {
        assertTrue(PasswordChecker.isValid("aaaa"));
    }

    @Test
    public void testMaxPWLength() {
        assertTrue(PasswordChecker.isValid("aaaaabbbbb"));
    }

    @Test
    public void testStringTooLongOneChar() {
        assertFalse(PasswordChecker.isValid("aaaaabbbbbC"));
    }
}
