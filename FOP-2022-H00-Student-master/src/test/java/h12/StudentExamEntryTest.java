package h12;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentExamEntryTest {
    /**
     * This test tests the constructors of StudentExamEntry
     */
    @Test
    public void testConstructorsWork() {
        assertDoesNotThrow(() -> new StudentExamEntry("J", "E", 123));
        assertDoesNotThrow(() -> new StudentExamEntry("J", "E", 123, "1,7"));
    }

    /**
     * This test tests if the constructors of StudentExamEntry throws exception at the right time.
     */
    @Test
    public void testConstructorsThrow() {
        assertThrows(NullPointerException.class, () -> new StudentExamEntry(null, "E", 123, "1,7"));
        try{
            new StudentExamEntry(null, "E", 123, "1,7");
        } catch (NullPointerException exc) {
            assertNull(exc.getMessage());
        }

        assertThrows(NullPointerException.class, () -> new StudentExamEntry("J", null, 123, "1,7"));
        try{
            new StudentExamEntry("J", null, 123, "1,7");
        } catch (NullPointerException exc) {
            assertNull(exc.getMessage());
        }

        assertThrows(NullPointerException.class, () -> new StudentExamEntry("J", "E", 123, null));
        try {
            new StudentExamEntry("J", "E", 123, null);
        }catch (NullPointerException exc) {
            assertNull(exc.getMessage());
        }

        assertThrows(BadEnrollmentNumberException.class, () -> new StudentExamEntry("J", "E", -123, "1,7"));
        try {
            new StudentExamEntry("J", "E", -123, "1,7");
        }catch (BadEnrollmentNumberException exc) {
            assertEquals("Bad enrollment number '-123'", exc.getMessage());
        }

        assertThrows(BadCharException.class, () -> new StudentExamEntry("J:", "E", 123, "1,7"));
        try {
            new StudentExamEntry("J:", "E", 123, "1,7");
        }catch (BadCharException exc) {
            assertEquals("Bad char ':' at position 1", exc.getMessage());
        }

        assertThrows(BadCharException.class, () -> new StudentExamEntry("J", "E:", 123, "1,7"));
        try {
            new StudentExamEntry("J", "E:", 123, "1,7");
        } catch (BadCharException exc) {
            assertEquals("Bad char ':' at position 1", exc.getMessage());
        }
    }

    /**
     * This test tests if the attribute mark gets set right.
     */
    @Test
    public void testMarks() {
        StudentExamEntry studentExamEntry = new StudentExamEntry("J", "E", 1234);
        assertEquals("n/a", studentExamEntry.getMark());
        String[] expected = {"1,0", "1,3", "1,7", "2,0", "2,3", "2,7", "3,0", "3,3", "3,7", "4,0", "5,0"};

        for(String expec : expected) {
            studentExamEntry.setMark(expec);
            assertEquals(expec, studentExamEntry.getMark());
        }

        try {
            studentExamEntry.setMark(null);
        } catch (NullPointerException exc) {
            assertEquals(null, exc.getMessage());
        }

        try {
            studentExamEntry.setMark("-1");
        } catch (BadStudentMarkException exc) {
            assertEquals("Bad student mark '-1'", exc.getMessage());
        }
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
