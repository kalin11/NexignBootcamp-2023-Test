package entity;

import java.util.Date;

public class Call extends AbstractCall {
    private float price;

    public Call(String callType, Date callStartTime, Date callEndTime) {
        super(callType, callStartTime, callEndTime);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCallType() {
        return super.getCallType();
    }

    public void setCallType(String callType) {
        super.setCallType(callType);
    }

    public Date getCallStartTime() {
        return super.getCallStartTime();
    }

    public void setCallStartTime(Date callStartTime) {
        super.setCallStartTime(callStartTime);
    }

    public Date getCallEndTime() {
        return super.getCallEndTime();
    }

    public void setCallEndTime(Date callEndTime) {
        super.setCallStartTime(callEndTime);
    }

    @Override
    public String toString() {
        return "AbstractCall{" +
                ", callType=" + super.getCallType() +
                ", callStartTime=" + super.getCallStartTime() +
                ", callEndTime=" + super.getCallEndTime() +
                ", price=" + this.price +
                '}';
    }
}
