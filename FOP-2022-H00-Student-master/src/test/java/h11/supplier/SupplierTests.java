package h11.supplier;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;


public class SupplierTests {

    /**
     * This method test the get method of ArraySupplier
     */
    @Test
    public void testArraySupplier() {
        Integer[] array = buildIntegerArray(0, 0, 1);
        Object[] expected = Arrays.stream(array).sorted().toArray();
        Integer[] array2 = buildIntegerArray(1, 0, 1);
        Object[] expected2 = Arrays.stream(array2).sorted().toArray();
        Integer[] array3 = buildIntegerArray(100, 0, 5);
        Object[] expected3 = Arrays.stream(array3).sorted().toArray();
        Integer[] array4 = buildIntegerArray(100, 0, -5);
        Object[] expected4 = Arrays.stream(array4).sorted().toArray();
        Integer[] array5 = buildIntegerArray(100, 0, 0);
        Object[] expected5 = Arrays.stream(array5).sorted().toArray();

        ArraySupplier<Integer> actualArray = new ArraySupplier<>(array);
        ArraySupplier<Integer> actualArray2 = new ArraySupplier<>(array2);
        ArraySupplier<Integer> actualArray3 = new ArraySupplier<>(array3);
        ArraySupplier<Integer> actualArray4 = new ArraySupplier<>(array4);
        ArraySupplier<Integer> actualArray5 = new ArraySupplier<>(array5);



        for (Object o : expected) {
            assertEquals(o, actualArray.get());
        }
        assertNull(actualArray.get());



        for (Object o : expected2) {
            assertEquals(o, actualArray2.get());
        }
        assertNull(actualArray2.get());



        for (Object o : expected3) {
            assertEquals(o, actualArray3.get());
        }
        assertNull(actualArray3.get());



        for (Object o : expected4) {
            assertEquals(o, actualArray4.get());
        }
        assertNull(actualArray4.get());



        for (Object o : expected5) {
            assertEquals(o, actualArray5.get());
        }
        assertNull(actualArray5.get());
    }

    /**
     * This method tests the get Method of CollectionSupplier
     */
    @Test
    public void tesCollectionSupplier() {
        List<Integer> integerList = buildIntegerList(0, 0, 0);
        Object[] expected = integerList.toArray();
        List<Integer> integerList2 = buildIntegerList(1, 0, 5);
        Object[] expected2 = integerList2.toArray();
        List<Integer> integerList3 = buildIntegerList(100, 5, 5);
        Object[] expected3 = integerList3.toArray();
        List<Integer> integerList4 = buildIntegerList(100, 5, 16);
        Object[] expected4 = integerList4.toArray();
        List<Integer> integerList5 = buildIntegerList(100, 5, 2000);
        Object[] expected5 = integerList5.toArray();

        CollectionSupplier<Integer> actualCollection = new CollectionSupplier<>(integerList);
        CollectionSupplier<Integer> actualCollection2 = new CollectionSupplier<>(integerList2);
        CollectionSupplier<Integer> actualCollection3 = new CollectionSupplier<>(integerList3);
        CollectionSupplier<Integer> actualCollection4 = new CollectionSupplier<>(integerList4);
        CollectionSupplier<Integer> actualCollection5 = new CollectionSupplier<>(integerList5);



        for (Object o : expected) {
            assertEquals(o, actualCollection.get());
        }
        assertNull(actualCollection.get());



        for (Object o : expected2) {
            assertEquals(o, actualCollection2.get());
        }
        assertNull(actualCollection2.get());



        for (Object o : expected3) {
            assertEquals(o, actualCollection3.get());
        }
        assertNull(actualCollection3.get());



        for (Object o : expected4) {
            assertEquals(o, actualCollection4.get());
        }
        assertNull(actualCollection4.get());



        for (Object o : expected5) {
            assertEquals(o, actualCollection5.get());
        }
        assertNull(actualCollection5.get());
    }

    /**
     * This method tests the get method of CyclicRangeSupplier.
     */
    @Test
    public void testCyclicRangeSupplier() {
        Integer[] expectedIntegers = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32 , 33, 34, 35, 36, 37, 38, 39, 40};
        CyclicRangeSupplier actualCyclicRange = new CyclicRangeSupplier(10, 40);


        for (Integer expectedInteger : expectedIntegers) {
            assertEquals(expectedInteger, actualCyclicRange.get());
        }
        for (Integer expectedInteger : expectedIntegers) {
            assertEquals(expectedInteger, actualCyclicRange.get());
        }
        for (Integer expectedInteger : expectedIntegers) {
            assertEquals(expectedInteger, actualCyclicRange.get());
        }
    }

    /**
     * This method returns an array of Integer with the length of the given parameter. The values are calculated with the remaining parameters.
     * @param length determines the length of the array
     * @param start start value of every int value
     * @param offset index * offset gets added to the start value for every element of the array
     * @return returns the constructed array
     */
    private Integer[] buildIntegerArray(int length, int start, int offset) {
        Integer[] integers = new Integer[length];

        for (int i = 0; i < integers.length; i++) {
            integers[i] = start + i * offset;
        }

        return integers;
    }

    /**
     * This method returns a List with the length of the first parameter and the values are between min and max.
     * @param length determines the length of the list
     * @param min min value of each Integer
     * @param max max value of each Integer
     * @return returns the constructed List
     */
    private List<Integer> buildIntegerList(int length, int min, int max) {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            list.add(ThreadLocalRandom.current().nextInt(min, max + 1));
        }

        return list.stream().sorted(Integer::compareTo).collect(Collectors.toList());
    }
}
