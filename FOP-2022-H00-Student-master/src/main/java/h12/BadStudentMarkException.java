package h12;

public class BadStudentMarkException extends  RuntimeException {
    /**
     * This is the constructor of BadStudentException. It creates a message containing its parameter.
     * @param string message contains that string
     */
    public BadStudentMarkException(String string) {
        super("Bad student mark '" + string + "'");
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
