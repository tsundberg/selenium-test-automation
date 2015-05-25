package se.thinkcode.selenium;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class VerifyTest {
    @Test
    public void verifyTestSetup() {
        assertThat(true, is(true));
        assertTrue(true);
        assertFalse(false);
    }
}
