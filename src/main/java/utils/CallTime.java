package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CallTime {

    public Date getTime(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        return format.parse(date);
    }

    public String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(date);
    }

    public String formatCallTime(Date start, Date end) {
        long callTime = end.getTime() - start.getTime();
        long seconds_difference = (callTime / 1000) % 60;
        long minutes_difference = (callTime / (1000 * 60)) % 60;
        long hours_difference = (callTime / (1000 * 60 * 60)) % 24;
        String seconds = "";
        String minutes = "";
        String hours = "";
        seconds = (seconds_difference < 10) ? "0" + seconds_difference : String.valueOf(seconds_difference);
        minutes = (minutes_difference < 10) ? "0" + minutes_difference : String.valueOf(minutes_difference);
        hours = (hours_difference < 10) ? "0" + hours_difference : String.valueOf(hours_difference);
        return hours + ":" + minutes + ":" + seconds;
    }
}
