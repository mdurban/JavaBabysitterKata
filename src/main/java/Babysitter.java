public class Babysitter {
    public static int calculatePay(int startTime, int bedTime, int endTime) {
        int pay = 0;

        // pay between start and bed time
        pay += (bedTime - startTime)*12;

        // pay between bed time and midnight
        if (endTime > bedTime && startTime < 12) {
            if (endTime < 5 || endTime == 12) {
                return (12 - startTime) * 8;
            }
            pay += (endTime - bedTime)*8;
        }

        // pay after midnight
        if (startTime < 5) {
            return (endTime - startTime)*16;
        }

        return pay;
    }
}
