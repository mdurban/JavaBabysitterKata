import java.util.HashMap;
import java.util.Map;

public class Babysitter {

    private static final int MIDNIGHT = 12;
    private static final int MIN_START_TIME = 5;
    private static final int MAX_END_TIME = 16;
    private static final int PRE_BEDTIME_PAY = 12;
    private static final int POST_BEDTIME_PAY = 8;
    private static final int POST_MIDNIGHT_PAY = 16;

    private static Map<Integer, Integer> map = new HashMap() {{
        put(1, 13);
        put(2, 14);
        put(3, 15);
        put(4, 16);
    }};

    public static int calculatePay(int startTime, int bedTime, int endTime) {
        int pay = 0;
        int sTime = map.getOrDefault(startTime, startTime);
        int eTime = map.getOrDefault(endTime, endTime);

        pay += determineHoursWorked(eTime, bedTime, MIN_START_TIME, sTime) * PRE_BEDTIME_PAY;
        pay += determineHoursWorked(MIDNIGHT, eTime, bedTime, sTime) * POST_BEDTIME_PAY;
        pay += determineHoursWorked(eTime, MAX_END_TIME, sTime, MIDNIGHT) * POST_MIDNIGHT_PAY;

        return pay;
    }

    private static int determineHoursWorked(int minTime1, int minTime2, int maxTime1, int maxTime2){
        int start = Math.max(maxTime1, maxTime2);
        int end = Math.min(minTime1, minTime2);

        return Math.max(end - start, 0);
    }
}
