package h08;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TimeStamp {
    private java.util.Calendar lastUpdate;

    /**
     * This is the constructor of TimeStamp it just calls the update() method.
     */
    public TimeStamp() {
        update();
    }

    /**
     * This method creates a new GregorianCalender object and lets the attribute lastUpdate refer to it.
     */
    public void update() {
        this.lastUpdate = new GregorianCalendar();
    }

    /**
     * This method returns the current value of lastUpdate.
     * @return returns this.lastUpdate
     */
    public Calendar getTimeStamp() {
        return lastUpdate;
    }

    /**
     * This method updates this.lastUpdate to its parameter if the parameter is not before or after the current value
     * of this.lastUpdate.
     * @param calendar new value of this.lastUpdate
     */
    public void update(Calendar calendar) {
        assert(!(calendar.before(this.lastUpdate)) && !(calendar.after(Calendar.getInstance())));
        this.lastUpdate = calendar;
    }

    /**
     * This method does the same as update(Calendar calendar) but throws appropriate exceptions.
     * @param calendar provides time and date
     * @throws UpdateTimeBeforeLastUpdateException this exception gets thrown when the calendar parameter is before lastUpdate
     * @throws UpdateTimeInTheFutureException this exception gets thrown when the calendar parameter is after lastUpdate
     */
    public void updateWithExc1(Calendar calendar) throws UpdateTimeBeforeLastUpdateException,UpdateTimeInTheFutureException{
        if(this.lastUpdate.after(calendar)) {
            throw new UpdateTimeBeforeLastUpdateException(calendar);
        }
        else if(this.lastUpdate.before(calendar)) {
            throw new UpdateTimeInTheFutureException(calendar);
        }
        this.lastUpdate = calendar;
    }

    /**
     * This method does the same as update(Calendar calendar) but throws appropriate exceptions.
     * @param calendar provides time and date
     * @throws BadUpdateTimeException this exceptions gets thrown when the calendar parameter is after or before lastUpdate
     */
    public void updateWithExc2(Calendar calendar) throws BadUpdateTimeException{
        if(this.lastUpdate.after(calendar)) {
            throw new UpdateTimeBeforeLastUpdateException(calendar);
        }
        else if(this.lastUpdate.before(calendar)) {
            throw new UpdateTimeInTheFutureException(calendar);
        }
        this.lastUpdate = calendar;
    }

    /**
     * This method does the same as update(Calendar calendar) but throws appropriate exceptions.
     * @param calendar provides time and date
     * @throws Exception this exceptions gets thrown when the calendar parameter is after or before lastUpdate
     */
    public void updateWithExc3(Calendar calendar) throws Exception{
        if(this.lastUpdate.after(calendar)) {
            throw new UpdateTimeBeforeLastUpdateException(calendar);
        }
        else if(this.lastUpdate.before(calendar)) {
            throw new UpdateTimeInTheFutureException(calendar);
        }
        this.lastUpdate = calendar;
    }

    /**
     * This method does the same as update(Calendar calendar) but throws appropriate exceptions.
     * @param calendar provides time and date
     * @throws Exception this exceptions gets thrown when the calendar parameter is after or before lastUpdate
     */
    public void updateWithExc4(Calendar calendar) throws Exception{
        if(calendar.after(this.lastUpdate)) {
            throw new BadUpdateTimeException(calendar, false);
        }
        else if(calendar.before(this.lastUpdate)) {
            throw new BadUpdateTimeException(calendar, true);
        }
        this.lastUpdate = calendar;
    }

    /**
     * This method does the same as update(Calendar calendar) but throws appropriate exceptions.
     * @param calendar provides time and date
     * @throws Exception this exceptions gets thrown when the calendar parameter is after or before lastUpdate
     */
    public void updateWithExc5(Calendar calendar) throws Exception{
        if(calendar.after(this.lastUpdate)) {
            throw new Exception("Update time is in the future: " + calendar.get(Calendar.DATE) + "." + calendar.get(Calendar.MONTH) + 1 + "." + calendar.get(Calendar.YEAR) + " / " + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND) + ":" + calendar.get(Calendar.MILLISECOND) + "!");
        }
        else if(calendar.before(this.lastUpdate)) {
            throw new Exception("Update time is earlier than the last update: " + calendar.get(Calendar.DATE) + "." + calendar.get(Calendar.MONTH) + 1 + "." + calendar.get(Calendar.YEAR) + " / " + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND) + ":" + calendar.get(Calendar.MILLISECOND) + "!");
        }
        this.lastUpdate = calendar;
    }
}
