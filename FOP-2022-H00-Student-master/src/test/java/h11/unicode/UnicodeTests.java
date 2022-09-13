package h11.unicode;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UnicodeTests {
    /**
     * This method tests the apply method of CharFromUnicode.
     */
    @Test
    public void testCharFromUnicode() {
        CharFromUnicode test = new CharFromUnicode();

        assertEquals(Character.toChars(97)[0], test.apply(97)); //a
        assertEquals(Character.toChars(70)[0], test.apply(70)); //F
        assertEquals(Character.toChars(59)[0], test.apply(59)); //;

        try {
            test.apply(-10);
        }catch (FormatException exc) {
            assertEquals("-10 is a negative number and therefore not a valid code point", exc.getMessage());
        }
        try {
            test.apply(65539);
        } catch (FormatException exc) {
            assertEquals("65539 exceeds 0xFFFF and cannot be represented by Character", exc.getMessage());
        }
    }

    /**
     * This method tests the apply method of CharFromUnicodeCasesExchanged.
     */
    @Test
    public void testCharFromUnicodeCasesExchanged() {
        CharFromUnicodeCasesExchanged test = new CharFromUnicodeCasesExchanged();

        assertEquals(Character.toChars(65)[0], test.apply(97)); //a
        assertEquals(Character.toChars(102)[0], test.apply(70)); //F
        assertEquals(Character.toChars(59)[0], test.apply(59)); //;
        try {
            test.apply(-10);
        }catch (FormatException exc) {
            assertEquals("-10 is a negative number and therefore not a valid code point", exc.getMessage());
        }
        try {
            test.apply(65539);
        } catch (FormatException exc) {
            assertEquals("65539 exceeds 0xFFFF and cannot be represented by Character", exc.getMessage());
        }
    }
}
