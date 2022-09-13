package h08;

import java.util.Calendar;
import java.lang.Exception;

public class BadUpdateTimeException extends Exception{
    /**
     * This is the constructor of BadUpdateTimeException, and it creates a new exception with a message depending on the
     * parameter
     * @param calendar provides the date and time
     * @param bool decides which message is used
     */
    public BadUpdateTimeException(Calendar calendar, boolean bool) {
        super((bool) ? "Update time is earlier than the last update: " + calendar.get(Calendar.DATE) + "." + calendar.get(Calendar.MONTH) + 1 + "." + calendar.get(Calendar.YEAR) + " / " + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND) + ":" + calendar.get(Calendar.MILLISECOND) + "!" : "Update time is in the future: " + calendar.get(Calendar.DATE) + "." + calendar.get(Calendar.MONTH) + 1 + "." + calendar.get(Calendar.YEAR) + " / " + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND) + ":" + calendar.get(Calendar.MILLISECOND) + "!");
    }
}
