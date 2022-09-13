package h12;

public class TableWithTitle {
    private final String title;
    private final StudentExamEntry[] entries;

    /**
     * This is the constructor of TableWithTitle. It initializes all attributes.
     * @param title initial value of this.title
     * @param entries initial value of this.entries
     */
    public TableWithTitle(String title, StudentExamEntry[] entries) {
        this.entries = entries;
        this.title = title;
    }

    /**
     * Getter of title
     * @return returns title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter of entries
     * @return returns entries
     */
    public StudentExamEntry[] getEntries() {
        return entries;
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
