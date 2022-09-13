package h11.unicode;

public class FormatException extends RuntimeException {

    /**
     * This is the constructor of FormatException. It creates an Exception with a message depending on the parameter value.
     * @param i decides which message the exception has
     */
    public FormatException(int i) {
        super(i + (i > Character.MAX_CODE_POINT ? " exceeds 0x10FFFF and is not a valid Unicode code point" :
                i > Character.MAX_VALUE && i < Character.MAX_CODE_POINT ? " exceeds 0xFFFF and cannot be represented by Character" :
                    i < Character.MIN_VALUE ? " is a negative number and therefore not a valid code point" : null
        ));
    }
}
