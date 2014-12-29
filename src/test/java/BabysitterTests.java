import org.junit.Test;

import static org.junit.Assert.*;

public class BabysitterTests {

    @Test
    public void workOneHourAfterFiveShouldGetPaidTwelveDollars() {
        assertEquals(12, Babysitter.calculatePay(6, 7, 7));
    }

    @Test
    public void workMoreThanOneHourBetweenStartAndBedTimeCalculatesPayProperly() {
        assertEquals(36, Babysitter.calculatePay(5, 8, 8));
    }

    @Test
    public void workOneHourBetweenBedtimeAndMidnight() {
        assertEquals(8, Babysitter.calculatePay(11, 8, 12));
    }

    @Test
    public void workMoreThanOneHourBetweenBedtimeAndMidnight() {
        assertEquals(24, Babysitter.calculatePay(9, 7, 12));
    }

    @Test
    public void workOneHourAfterMidnightUntilEndTime() {
        assertEquals(16, Babysitter.calculatePay(1, 9, 2));
    }

    @Test
    public void workMoreThanOneHourAfterMidnightUntilEndTime() {
        assertEquals(32, Babysitter.calculatePay(1, 9, 3));
    }
}
