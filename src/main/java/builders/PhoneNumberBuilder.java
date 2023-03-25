package builders;

import entity.PhoneNumber;

import java.util.List;

public class PhoneNumberBuilder {
    public PhoneNumber createPhoneNumber(List<String> list) {
        String phoneNumber = list.get(1);
        String tariff = list.get(4);
        long tariffTime = 0;
        if (list.get(4).equals("06")) {
            tariffTime = 300 * 60;
        } else if (list.get(4).equals("11")) {
            tariffTime = 100 * 60;
        }
        return new PhoneNumber(phoneNumber, tariff, tariffTime);
    }
}
