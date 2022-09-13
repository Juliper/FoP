package h12;

public class BadCharException extends RuntimeException {
    /**
     * This is the constructor of BadCharException. It creates a message containing its parameter.
     * @param character bad character
     * @param integer position of bad character
     */
    public BadCharException(char character, int integer) {
        super("Bad char '" + character + "' at position " + integer);
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
