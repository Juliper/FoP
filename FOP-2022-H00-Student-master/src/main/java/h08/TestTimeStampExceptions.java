package h08;

import java.util.Calendar;

public class TestTimeStampExceptions {

    /**
     * This method calls an updateWithExc() depending on n (parameter) on the TimeStamp object and catches the according Exception.
     * @param stamp object that updateWithExc() is called on
     * @param calendar parameter of updateWithExc()
     * @param n determines the updateWithExc() method
     */
    public void testCatch1(TimeStamp stamp, Calendar calendar, int n) {
        try {
            switch(n) {
                case 1:
                    stamp.updateWithExc1(calendar);
                case 2:
                    stamp.updateWithExc2(calendar);
                case 3:
                    stamp.updateWithExc3(calendar);
                case 4:
                    stamp.updateWithExc4(calendar);
                case 5:
                    stamp.updateWithExc5(calendar);
                default:
                    break;
            }
        } catch (UpdateTimeBeforeLastUpdateException exc) {
            System.out.println(n + " : UpdateTimeBeforeLastUpdateException : " + exc.getClass().getSimpleName() + " " + exc.getMessage() + "\n");
        } catch (UpdateTimeInTheFutureException exc) {
            System.out.println(n + " : UpdateTimeInTheFutureException : " + exc.getClass().getSimpleName() + " " + exc.getMessage() + "\n");
        } catch (Exception exc) {
        }
    }

    /**
     * This method calls an updateWithExc() depending on n (parameter) on the TimeStamp object and catches the according Exception.
     * @param stamp object that updateWithExc() is called on
     * @param calendar parameter of updateWithExc()
     * @param n determines the updateWithExc() method
     */
    public void testCatch2(TimeStamp stamp, Calendar calendar, int n) {
        try {
            switch(n) {
                case 1:
                    stamp.updateWithExc1(calendar);
                case 2:
                    stamp.updateWithExc2(calendar);
                case 3:
                    stamp.updateWithExc3(calendar);
                case 4:
                    stamp.updateWithExc4(calendar);
                case 5:
                    stamp.updateWithExc5(calendar);
                default:
                    break;
            }
        } catch (UpdateTimeBeforeLastUpdateException | UpdateTimeInTheFutureException exc) {
            System.out.println(n + " : " + "UpdateTimeBeforeLastUpdateException oder UpdateTimeInTheFutureException" + " : " + exc.getClass().getSimpleName() + " "+ exc.getMessage());
        } catch (Exception exc) {
        }
    }

    /**
     * This method calls an updateWithExc() depending on n (parameter) on the TimeStamp object and catches the according Exception.
     * @param stamp object that updateWithExc() is called on
     * @param calendar parameter of updateWithExc()
     * @param n determines the updateWithExc() method
     */
    public void testCatch3(TimeStamp stamp, Calendar calendar, int n) {
        try {
            switch(n) {
                case 1:
                    stamp.updateWithExc1(calendar);
                case 2:
                    stamp.updateWithExc2(calendar);
                case 3:
                    stamp.updateWithExc3(calendar);
                case 4:
                    stamp.updateWithExc4(calendar);
                case 5:
                    stamp.updateWithExc5(calendar);
                default:
                    break;
            }
        } catch (UpdateTimeBeforeLastUpdateException exc) {
            System.out.println(n + " : UpdateTimeBeforeLastUpdateException : " + exc.getClass().getSimpleName() + " " + exc.getMessage());
        } catch (BadUpdateTimeException exc) {
            System.out.println(n + " : BadUpdateTimeException : " + exc.getClass().getSimpleName() + " " + exc.getMessage());
        } catch (Exception exc) {
        }
    }

    /**
     * This method calls an updateWithExc() depending on n (parameter) on the TimeStamp object and catches the according Exception.
     * @param stamp object that updateWithExc() is called on
     * @param calendar parameter of updateWithExc()
     * @param n determines the updateWithExc() method
     */
    public void testCatch4(TimeStamp stamp, Calendar calendar, int n) {
        try {
            switch(n) {
                case 1:
                    stamp.updateWithExc1(calendar);
                case 2:
                    stamp.updateWithExc2(calendar);
                case 3:
                    stamp.updateWithExc3(calendar);
                case 4:
                    stamp.updateWithExc4(calendar);
                case 5:
                    stamp.updateWithExc5(calendar);
                default:
                    break;
            }
        } catch (BadUpdateTimeException exc) {
            System.out.println(n + " : BadUpdateTimeException : " + exc.getClass().getSimpleName() + " " + exc.getMessage());
        } catch (Exception exc) {
        }
    }

    /**
     * This method calls an updateWithExc() depending on n (parameter) on the TimeStamp object and catches the according Exception.
     * @param stamp object that updateWithExc() is called on
     * @param calendar parameter of updateWithExc()
     * @param n determines the updateWithExc() method
     */
    public void testCatch5(TimeStamp stamp, Calendar calendar, int n) {
        try {
            switch(n) {
                case 1:
                    stamp.updateWithExc1(calendar);
                case 2:
                    stamp.updateWithExc2(calendar);
                case 3:
                    stamp.updateWithExc3(calendar);
                case 4:
                    stamp.updateWithExc4(calendar);
                case 5:
                    stamp.updateWithExc5(calendar);
                default:
                    break;
            }
        } catch (Exception exc) {
            System.out.println(n + " : Exception : " + exc.getClass().getSimpleName() + " " + exc.getMessage());
        }
    }

    /**
     * This method calls updateWithExc1() without a try-catch block.
     * @param stamp TimeStamp on that updateWithExc1() is called on
     * @param calendar parameter of updateWithExc1()
     * @throws BadUpdateTimeException exception that gets thrown by updateWithExc1()
     */
    public void testPass(TimeStamp stamp, Calendar calendar) throws BadUpdateTimeException{
        stamp.updateWithExc1(calendar);
    }

    /**
     * This method calls testPass() in a try-catch block.
     * @param stamp first parameter of testPass
     * @param calendar second parameter of testPass
     */
    public void testCatchPassed(TimeStamp stamp, Calendar calendar) {
        try {
            testPass(stamp, calendar);
        } catch (BadUpdateTimeException exc) {
            System.out.println("UpdateTimeInTheFutureException" + exc.getMessage());
        }
    }
}
