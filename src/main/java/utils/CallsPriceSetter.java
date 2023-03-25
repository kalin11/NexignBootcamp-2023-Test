package utils;

import entity.Call;
import entity.PhoneNumber;
import manager.Manager;
import storages.Storage;

import java.util.List;

public class CallsPriceSetter {

    public void set(Manager manager) {
        Storage<PhoneNumber, List<Call>> numbersAndCalls = manager.getNumbersAndCalls();
        Storage<String, Long> numbersAndTariffTime = manager.getNumbersAndTariffTime();
        CallsPriceCounter counter = new CallsPriceCounter();

        for (PhoneNumber number : numbersAndCalls.keySet()) {
            if (number.getTariff().equals("06")) number.setTotalSum(100);
            for (Call call : numbersAndCalls.get(number)) {
                long callTime = (call.getCallEndTime().getTime() - call.getCallStartTime().getTime()) / 1000;
                long tariffTime = numbersAndTariffTime.get(number.getNumber());
                float price = counter.calculateThePrice(tariffTime, callTime, call.getCallType(), number.getTariff());
                call.setPrice(price);
                number.setTotalSum(number.getTotalSum() + call.getPrice());
                tariffTime -= callTime;
                if (tariffTime < 0) tariffTime = 0;
                numbersAndTariffTime.put(number.getNumber(), tariffTime);

            }
        }

    }
}
