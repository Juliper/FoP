package h10;

public class MyLinkedListException extends Exception{
    /**
     * This is the Constructor of MyLinkedException. It creates an exception containing its parameters
     * @param integer current index
     * @param object key value that gets tested
     */
    public MyLinkedListException(Integer integer, Object object) {
        super("(" + integer + "," + object.toString() + ")");
    }
}
