package h11.merge;


import h11.supplier.ArraySupplier;
import h11.unicode.CharWithIndex;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

public class StreamMergerTest {
    /**
     * This method tests the merge method of StreamMerger.
     */
    @Test
    public void testMerge() {
        StreamMerger streamMerger = new StreamMerger();
        ArraySupplier<Integer> arraySupplier = new ArraySupplier(new Integer[]{6, 8, 9});
        Stream<Integer>[] streams = (Stream<Integer>[]) new Stream<?>[]{Stream.of(-5, null , 1000000000, 1), Stream.generate(() -> 1).limit(1), IntStream.range(50, 55).boxed()};

        CharWithIndex[] actualArray = streamMerger.merge(streams);
        CharWithIndex[] expectedArray = {new CharWithIndex((char) 1, 1), new CharWithIndex((char) 1, 1), new CharWithIndex((char) 50, 50), new CharWithIndex((char) 51, 51), new CharWithIndex((char) 52, 52), new CharWithIndex((char) 53, 53), new CharWithIndex((char) 54, 54)};

        for (int i = 0; i < expectedArray.length; i++) {
            assertEquals(expectedArray[i].getIndex(), actualArray[i].getIndex());
            assertEquals(expectedArray[i].getTheChar(), actualArray[i].getTheChar());
        }
    }
}
