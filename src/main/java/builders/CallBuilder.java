package builders;

import entity.Call;
import utils.CallTime;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class CallBuilder {
    public Call createCall(List<String> list) throws ParseException {
        CallTime callTime = new CallTime();
        String callType = list.get(0);
        Date startTime = callTime.getTime(list.get(2));
        Date endTime = callTime.getTime(list.get(3));
        return new Call(callType, startTime, endTime);
    }
}
