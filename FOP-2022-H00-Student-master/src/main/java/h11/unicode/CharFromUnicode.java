package h11.unicode;

import java.util.function.Function;

public class CharFromUnicode implements Function<Integer, Character> {

    /**
     * This method accepts an Integer and returns a Character of this Integer.
     * @param integer unicode value of the returned Character
     * @return returns the character
     * @throws NullPointerException gets thrown when the parameter is null
     * @throws FormatException gets thrown when the integer value is outside the Character values
     */
    @Override
    public Character apply(Integer integer) throws NullPointerException, FormatException {
        if(integer == null) {
            throw new NullPointerException();
        }
        else if(integer > Character.MAX_VALUE || integer < Character.MIN_VALUE) {
            throw new FormatException(integer);
        }else {
            return Character.toChars(integer)[0];
        }
    }
}
