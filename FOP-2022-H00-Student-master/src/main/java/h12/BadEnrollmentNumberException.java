package h12;

public class BadEnrollmentNumberException extends RuntimeException {
    /**
     * This is the constructor of BadEnrollNumberException. It creates a message containing its parameter.
     * @param integer not valid enrollmentnumber
     */
    public BadEnrollmentNumberException(int integer) {
        super("Bad enrollment number '" + integer + "'");
    }
}
/*
 _____
/     \
vvvvvvv  /|__/|
   I   /O,O   |
   I /_____   |      /|/|
  J|/^ ^ ^ \  |    /00  |    _//|
   |^ ^ ^ ^ |W|   |/^^\ |   /oo |
   \m___m__|_|    \m_m_|   \mm_|
 */
