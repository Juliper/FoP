package h11.supplier;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ArraySupplier <T> implements Supplier<T> {
    private T[] ts;
    private int counter = 0;

    /**
     * This is the constructor of ArraySupplier. It accepts an Array and sets the attribute to it.
     * @param ts new value of this.ts
     */
    public ArraySupplier(T[] ts) {
        this.ts = ts;
    }

    /**
     * This method returns the values of this.ts is ascending order. When all values where returned the next calls of this method returns null.
     * @return returns the value of the attribute or null
     */
    @Override
    public T get() {
        Stream<T> sorted = Arrays.stream(ts).sorted();
        T[] tSorted = (T[]) sorted.toArray();
        if(ts.length != 0 && counter < ts.length) {
            counter++;
            return tSorted[counter - 1];
        } else return null;
    }
}
