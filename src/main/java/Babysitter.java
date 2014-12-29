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

        pay += Math.max(Math.min(bedTime, eTime) - Math.max(sTime, MIN_START_TIME), 0) * PRE_BEDTIME_PAY;
        pay += Math.max(Math.min(MIDNIGHT, eTime) - Math.max(bedTime, sTime), 0) * POST_BEDTIME_PAY;
        pay += Math.max(Math.min(eTime, MAX_END_TIME) - Math.max(sTime, MIDNIGHT), 0) * POST_MIDNIGHT_PAY;

        return pay;
    }
}
