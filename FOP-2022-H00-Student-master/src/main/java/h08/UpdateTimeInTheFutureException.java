package h08;

import java.util.Calendar;

public class UpdateTimeInTheFutureException extends BadUpdateTimeException{
    /**
     * This constructor of UpdateTimeInTheFutureException just uses the constructor of BadUpdateTimeException but
     * the boolean is always false
     * @param calendar provides date and time
     */
    public UpdateTimeInTheFutureException(Calendar calendar) {
        super(calendar, false);
    }
}
