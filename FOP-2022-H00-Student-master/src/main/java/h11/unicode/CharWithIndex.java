package h11.unicode;

public class CharWithIndex {
    private final char theChar;
    private final int index;

    /**
     * This is the constructor of CharWithIndex. It accepts two parameters and saves them to the according attributes.
     * @param theChar new value of this.theChar
     * @param index new value of this.index
     * @throws NullPointerException gets thrown when one of the parameters is null
     */
    public CharWithIndex(Character theChar, Integer index) throws NullPointerException {
        if(theChar == null || index == null) {
            throw new NullPointerException();
        }
        this.theChar = theChar;
        this.index = index;
    }

    /**
     * This method returns the current value of this.theChar.
     * @return returns this.theChar
     */
    public char getTheChar() {
        return theChar;
    }

    /**
     * This method returns the current value of this.index.
     * @return returns this.index
     */
    public int getIndex() {
        return index;
    }
}
