public class Babysitter {
    public static int calculatePay(int startTime, int bedTime, int endTime) {
        if (bedTime < startTime) {
            return (12 - startTime)*8;
        } else if (startTime < 5) {
            return (endTime - startTime)*16;
        }


        return (bedTime - startTime)*12;
    }
}
