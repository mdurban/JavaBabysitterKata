public class Babysitter {
    public static int calculatePay(int startTime, int bedTime, int endTime) {

        // pay after midnight
        if (startTime < 5) {
            return (endTime - startTime)*16;
        }




        // pay between bed time and midnight
        if (bedTime <= startTime) {
            if (endTime < 5 || endTime == 12) {
                return (12 - startTime) * 8;
            }
            return (endTime - bedTime)*8;
        }

        // pay between start and bed time
        return (bedTime - startTime)*12;
    }
}
