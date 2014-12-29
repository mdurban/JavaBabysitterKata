import org.junit.Test;

import static org.junit.Assert.*;

public class BabysitterTests {

    @Test
    public void workMoreThanOneHourBetweenStartAndBedTimeCalculatesPayProperly() {
        assertEquals(12 * 3, Babysitter.calculatePay(5, 8, 8));
    }

    @Test
    public void workMoreThanOneHourBetweenBedtimeAndMidnight() {
        assertEquals(12 * 2, Babysitter.calculatePay(9, 7, 12));
    }

    @Test
    public void workMoreThanOneHourStartingBeforeBedtimeAndFinishBeforeMidnight() {
        assertEquals(8 * 2, Babysitter.calculatePay(9, 9, 11));
    }

    @Test
    public void workTwoHoursAfterMidnightStartingAtMidnight() {
        assertEquals(16 * 2, Babysitter.calculatePay(12, 8, 2));
    }

    @Test
    public void workOneHourBeforeBedtimeAndOneHourAfterBedtimeBeforeMidnight() {
        assertEquals(12 + 8, Babysitter.calculatePay(8, 9, 10));
    }

    @Test
    public void workOneHourBeforeMidnightAfterBedtimeAndOneHourAfterMidnight() {
        assertEquals(16 + 8, Babysitter.calculatePay(11, 8, 1));
    }

    @Test
    public void workMaxHoursWithBedtimeAt8() {
        assertEquals((12 * 3) + (8 * 4) + (16 * 4), Babysitter.calculatePay(5, 8, 4));
    }
}
