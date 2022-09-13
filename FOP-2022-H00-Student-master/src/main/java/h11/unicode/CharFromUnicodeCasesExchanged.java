package h11.unicode;

import java.util.function.Function;

public class CharFromUnicodeCasesExchanged implements Function<Integer, Character> {

    /**
     * This method accepts an Integer and returns the according Character of Unicode. When the character is letter the cases get swapped.
     * @param integer determines the Character by unicode
     * @return returns the according character
     * @throws NullPointerException gets thrown when the parameter is null
     * @throws FormatException gets thrown when the parameter is outside the Character values
     */
    @Override
    public Character apply(Integer integer) throws NullPointerException, FormatException {
        if(integer == null) {
            throw new NullPointerException();
        }
        else if(integer > Character.MAX_VALUE || integer < Character.MIN_VALUE) {
            throw new FormatException(integer);
        }

        Character character = Character.toChars(integer)[0];

        if(Character.isLetter(character)) {
            if(Character.isUpperCase(character)) {
                return Character.toLowerCase(character);
            }else return Character.toUpperCase(character);
        }
        return character;

    }
}
