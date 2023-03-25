package entity;

import java.util.Date;

public abstract class AbstractCall {
    private String callType;
    private Date callStartTime;
    private Date callEndTime;

    public AbstractCall(String callType, Date callStartTime, Date callEndTime) {
        this.callType = callType;
        this.callStartTime = callStartTime;
        this.callEndTime = callEndTime;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public Date getCallStartTime() {
        return callStartTime;
    }

    public void setCallStartTime(Date callStartTime) {
        this.callStartTime = callStartTime;
    }

    public Date getCallEndTime() {
        return callEndTime;
    }

    public void setCallEndTime(Date callEndTime) {
        this.callEndTime = callEndTime;
    }

    @Override
    public String toString() {
        return "AbstractCall{" +
                "callType=" + callType +
                ", callStartTime=" + callStartTime +
                ", callEndTime=" + callEndTime +
                '}';
    }
}
