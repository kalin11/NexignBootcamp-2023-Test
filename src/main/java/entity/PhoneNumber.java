package entity;

import java.util.Objects;

public class PhoneNumber {
    private String number;
    private String tariff;
    private long tariffTime;
    private double totalSum;

    public PhoneNumber(String number, String tariff, long tariffTime) {
        this.number = number;
        this.tariff = tariff;
        this.tariffTime = tariffTime;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTariff() {
        return tariff;
    }

    public void setTariff(String tariff) {
        this.tariff = tariff;
    }

    public long getTariffTime() {
        return tariffTime;
    }

    public void setTariffTime(int tariffTime) {
        this.tariffTime = tariffTime;
    }

    public void setTariffTime(long tariffTime) {
        this.tariffTime = tariffTime;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "number='" + number + '\'' +
                ", tariff='" + tariff + '\'' +
                ", tariffTime=" + tariffTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return number.equals(that.number) && tariff.equals(that.tariff);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, tariff);
    }
}
