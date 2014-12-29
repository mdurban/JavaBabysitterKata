import java.util.HashMap;
import java.util.Map;

public class Babysitter {
    private static Map<Integer, Integer> map = new HashMap() {{
        put(1, 13);
        put(2, 14);
        put(3, 15);
        put(4, 16);
    }};

    public static int calculatePay(int startTime, int bedTime, int endTime) {
        int pay = 0;
        int sTime = map.getOrDefault(startTime, startTime);
        int bTime = map.getOrDefault(bedTime, bedTime);
        int eTime = map.getOrDefault(endTime, endTime);

        if (sTime == 12) {
            return (eTime - 12) * 16;
        }

        // pay between start and bed time
        pay += (bTime - sTime)*12;

        // pay between bed time and midnight
        if (eTime > bTime && sTime < 12) {
            if (eTime > 12 || eTime == 12) {
                return (12 - sTime) * 8;
            }
            pay += (eTime - bTime)*8;
        }

        // pay after midnight
        if (sTime > 12) {
            return (eTime - sTime)*16;
        }

        return pay;
    }
}
