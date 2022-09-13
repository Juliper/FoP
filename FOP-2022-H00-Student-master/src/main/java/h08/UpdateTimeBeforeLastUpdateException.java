package h08;

import java.util.Calendar;

public class UpdateTimeBeforeLastUpdateException extends BadUpdateTimeException{
    /**
     * This constructor of UpdateTimeBeforeLastUpdateException just uses the constructor of BadUpdateTimeException but
     * the boolean is always true
     * @param calendar provides date and time
     */
    public UpdateTimeBeforeLastUpdateException(Calendar calendar) {
        super(calendar, true);
    }
}
