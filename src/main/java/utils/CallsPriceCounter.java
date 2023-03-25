package utils;


public class CallsPriceCounter {
    public float calculateThePrice(long tariffTime, long callTime, String callType, String tariff) {
        switch (tariff) {
            case "03":
                return (callTime / 60 + 1) * 1.5F;
            case "06":
                if (tariffTime - callTime >= 0) {
                    return 0;
                } else {
                    long paymentTime = (callTime - tariffTime);
                    return (paymentTime / 60 + 1) * 1F;

                }
            case "11":
                if (callType.equals("01")) {
                    if (tariffTime - callTime >= 0) {
                        return (callTime / 60 + 1) * 0.5F;
                    } else {
                        long paymentTime = (callTime - tariffTime);
                        return (paymentTime / 60 + 1) * 1.5F;
                    }
                }
        }
        return 0;
    }
}
