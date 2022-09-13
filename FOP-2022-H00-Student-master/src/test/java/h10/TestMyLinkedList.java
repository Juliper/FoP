package h10;

import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

public class TestMyLinkedList {
    /**
     * This method tests extractRecursively and extractIteratively on 3 Lists. The first two get extracted as wanted and
     * the last one should throw an exception.
     */
    @Test
    public void testExtract() {
        Predicate<Integer> predU = x -> x <= 0;

        try{
            MyLinkedList<Integer[]> linkedList = new MyLinkedList<>();
            linkedList.add(new Integer[] {3, 3, 6});
            linkedList.add(new Integer[] {4, 5, 6});
            linkedList.add(new Integer[] {3, 3, 6});
            linkedList.add(new Integer[] {4, 5, 6});
            linkedList.add(new Integer[] {3, 3, 6});
            linkedList.add(new Integer[] {4, 5, 6});
            Integer[] expected = new Integer[]{12,12,12};

            MyLinkedList<Integer> extractedI = linkedList.extractIteratively(new predT1(), new fct1(), new predU1());
            Integer[] actual = new Integer[]{extractedI.head.key, extractedI.head.next.key, extractedI.head.next.next.key};
            assertArrayEquals(expected, actual);
        } catch (MyLinkedListException exc) {
            System.out.println(exc.getMessage());
        }
        try{
            MyLinkedList<Integer[]> linkedList = new MyLinkedList<>();
            linkedList.add(new Integer[] {3, 3, 6});
            linkedList.add(new Integer[] {4, 5, 6});
            linkedList.add(new Integer[] {3, 3, 6});
            linkedList.add(new Integer[] {4, 5, 6});
            linkedList.add(new Integer[] {3, 3, 6});
            linkedList.add(new Integer[] {4, 5, 6});
            Integer[] expected = new Integer[]{12,12,12};

            MyLinkedList<Integer> extractedR = linkedList.extractRecursively(new predT1(), new fct1(), new predU1());
            Integer[] actual = new Integer[]{extractedR.head.key, extractedR.head.next.key, extractedR.head.next.next.key};
            assertArrayEquals(expected, actual);
        } catch (MyLinkedListException exc) {
            System.out.println(exc.getMessage());
        }



        try {
            MyLinkedList<Integer[]> linkedList2 = new MyLinkedList<>();
            linkedList2.add(new Integer[] {4, 5, 6});
            linkedList2.add(new Integer[] {3, 3, 6});
            linkedList2.add(new Integer[] {4, 5, 6});
            linkedList2.add(new Integer[] {3, 3, 6});
            linkedList2.add(new Integer[] {4, 5, 6});
            linkedList2.add(new Integer[] {3, 3, 6});
            Integer[] expected2 = new Integer[]{12,12,12};
            MyLinkedList<Integer> extractedIteratively = linkedList2.extractIteratively(new predT1(), new fct1(), new predU1());
            Integer[] actualIteratively = new Integer[] {extractedIteratively.head.key, extractedIteratively.head.next.key, extractedIteratively.head.next.next.key};

            assertArrayEquals(expected2, actualIteratively);
        } catch (MyLinkedListException exc) {
            System.out.println(exc.getMessage());
        }
        try {
            MyLinkedList<Integer[]> linkedList2 = new MyLinkedList<>();
            linkedList2.add(new Integer[] {4, 5, 6});
            linkedList2.add(new Integer[] {3, 3, 6});
            linkedList2.add(new Integer[] {4, 5, 6});
            linkedList2.add(new Integer[] {3, 3, 6});
            linkedList2.add(new Integer[] {4, 5, 6});
            linkedList2.add(new Integer[] {3, 3, 6});
            Integer[] expected2 = new Integer[]{12,12,12};
            MyLinkedList<Integer> extractedRecursively = linkedList2.extractRecursively(new predT1(), new fct1(), new predU1());
            Integer[] actualRecursively = new Integer[] {extractedRecursively.head.key, extractedRecursively.head.next.key, extractedRecursively.head.next.next.key};

            assertArrayEquals(expected2, actualRecursively);
        } catch (MyLinkedListException exc) {
            System.out.println(exc.getMessage());
        }


        try{
            MyLinkedList<Integer[]> linkedList3 = new MyLinkedList<>();
            linkedList3.add(new Integer[] {3, 3, 6});
            linkedList3.add(new Integer[] {3, 3, 6});
            linkedList3.add(new Integer[] {3, 3, 6});
            linkedList3.add(new Integer[] {3, 3, 6});
            linkedList3.add(new Integer[] {-30, 2, 4});
            linkedList3.add(new Integer[] {3, 3, 6});

            linkedList3.extractIteratively(new predT1(), new fct1(), new predU1());
        } catch (MyLinkedListException exc) {
            assertEquals("(4,-24)", exc.getMessage());
        }
        try{
            MyLinkedList<Integer[]> linkedList3 = new MyLinkedList<>();
            linkedList3.add(new Integer[] {3, 3, 6});
            linkedList3.add(new Integer[] {3, 3, 6});
            linkedList3.add(new Integer[] {3, 3, 6});
            linkedList3.add(new Integer[] {3, 3, 6});
            linkedList3.add(new Integer[] {-30, 2, 4});
            linkedList3.add(new Integer[] {3, 3, 6});

            linkedList3.extractRecursively(new predT1(), new fct1(), new predU1());
        } catch (MyLinkedListException exc) {
            assertEquals("(4,-24)", exc.getMessage());
        }
    }

    /**
     * This method tests mixinIteratively and mixinRecursively on 3 listPairs. The first two get mixed as wanted and
     * the last one should throw an exception.
     */
    @Test
    public void testMixin() {
        Predicate<String> predU = x -> {
            try {
                Double.valueOf(x);
                return true;
            } catch (Exception exc) {
                return false;
            }
        };
        BiPredicate<Double, String> biPred = (i1, i2) -> i1 > Double.valueOf(i2);
        Function<String, Double> fct = x -> Double.parseDouble(x);

        try {
            MyLinkedList<String> listPair = new MyLinkedList<>();
            listPair.add("10.10");
            listPair.add("20.20");
            listPair.add("30.30");
            listPair.add("40.40");

            MyLinkedList<Double> listPair1 = new MyLinkedList<>();
            listPair1.add(10.0);
            listPair1.add(20.0);
            listPair1.add(30.0);
            listPair1.add(40.0);

            Double[] expected = new Double[]{10.0, 10.10, 20.0, 20.20, 30.0, 30.30, 40.0, 40.40};
            listPair1.mixinIteratively(listPair, biPred, fct, predU);

            Double[] actual = new Double[]{listPair1.head.key, listPair1.head.next.key, listPair1.head.next.next.key, listPair1.head.next.next.next.key, listPair1.head.next.next.next.next.key, listPair1.head.next.next.next.next.next.key, listPair1.head.next.next.next.next.next.next.key, listPair1.head.next.next.next.next.next.next.next.key};

            assertArrayEquals(expected, actual);
        } catch (MyLinkedListException exc) {
            System.out.println(exc.getMessage());
        }
        try {
            MyLinkedList<String> listPair = new MyLinkedList<>();
            listPair.add("10.10");
            listPair.add("20.20");
            listPair.add("30.30");
            listPair.add("40.40");

            MyLinkedList<Double> listPair1 = new MyLinkedList<>();
            listPair1.add(10.0);
            listPair1.add(20.0);
            listPair1.add(30.0);
            listPair1.add(40.0);

            Double[] expected = new Double[]{10.0, 10.10, 20.0, 20.20, 30.0, 30.30, 40.0, 40.40};
            listPair1.mixinRecursively(listPair, biPred, fct, predU);

            Double[] actual = new Double[]{listPair1.head.key, listPair1.head.next.key, listPair1.head.next.next.key, listPair1.head.next.next.next.key, listPair1.head.next.next.next.next.key, listPair1.head.next.next.next.next.next.key, listPair1.head.next.next.next.next.next.next.key, listPair1.head.next.next.next.next.next.next.next.key};;

            assertArrayEquals(expected, actual);

        } catch (MyLinkedListException exc) {
            System.out.println(exc.getMessage());
        }



        try {
            MyLinkedList<String> listPair = new MyLinkedList<>();
            listPair.add("9.10");
            listPair.add("19.20");
            listPair.add("29.30");
            listPair.add("39.40");

            MyLinkedList<Double> listPair1 = new MyLinkedList<>();
            listPair1.add(10.0);
            listPair1.add(20.0);
            listPair1.add(30.0);
            listPair1.add(40.0);

            Double[] expected = new Double[]{9.10, 10.0, 19.2, 20.0, 29.30, 30.0, 39.40, 40.0};
            listPair1.mixinIteratively(listPair, biPred, fct, predU);
            Double[] actual = new Double[]{listPair1.head.key, listPair1.head.next.key, listPair1.head.next.next.key, listPair1.head.next.next.next.key, listPair1.head.next.next.next.next.key, listPair1.head.next.next.next.next.next.key, listPair1.head.next.next.next.next.next.next.key, listPair1.head.next.next.next.next.next.next.next.key};;

            assertArrayEquals(expected, actual);


        } catch (MyLinkedListException exc) {
            System.out.println(exc.getMessage());
        }
        try {
            MyLinkedList<String> listPair = new MyLinkedList<>();
            listPair.add("9.10");
            listPair.add("19.20");
            listPair.add("29.30");
            listPair.add("39.40");

            MyLinkedList<Double> listPair1 = new MyLinkedList<>();
            listPair1.add(10.0);
            listPair1.add(20.0);
            listPair1.add(30.0);
            listPair1.add(40.0);

            Double[] expected = new Double[]{9.10, 10.0, 19.2, 20.0, 29.30, 30.0, 39.40, 40.0};
            listPair1.mixinRecursively(listPair, biPred, fct, predU);
            Double[] actual = new Double[]{listPair1.head.key, listPair1.head.next.key, listPair1.head.next.next.key, listPair1.head.next.next.next.key, listPair1.head.next.next.next.next.key, listPair1.head.next.next.next.next.next.key, listPair1.head.next.next.next.next.next.next.key, listPair1.head.next.next.next.next.next.next.next.key};;

            assertArrayEquals(expected, actual);


        } catch (MyLinkedListException exc) {
            System.out.println(exc.getMessage());
        }


        try {
            MyLinkedList<String> listPair = new MyLinkedList<>();
            listPair.add("10.2");
            listPair.add("10.1");
            listPair.add("b");
            listPair.add("40.12");

            MyLinkedList<Double> listPair1 = new MyLinkedList<>();
            listPair1.add(10.0);
            listPair1.add(20.0);
            listPair1.add(30.0);
            listPair1.add(40.0);

            listPair1.mixinIteratively(listPair, biPred, fct, predU);

        } catch (MyLinkedListException exc) {
            assertEquals("(2,b)", exc.getMessage());
        }
        try {
            MyLinkedList<String> listPair = new MyLinkedList<>();
            listPair.add("10.1");
            listPair.add("19.20");
            listPair.add("2.1");
            listPair.add("d");

            MyLinkedList<Double> listPair1 = new MyLinkedList<>();
            listPair1.add(10.0);
            listPair1.add(20.0);
            listPair1.add(30.0);
            listPair1.add(40.0);

            listPair1.mixinRecursively(listPair, biPred, fct, predU);

        } catch (MyLinkedListException exc) {
            assertEquals("(3,d)", exc.getMessage());
        }
    }


    private class predT1 implements Predicate<Integer[]> {
        /**
         * This is the constructor of predT1. It returns a predicate that tests the first three integer values in an array if one divedes another.
         * @param integers array that gets tested
         * @return returns the according boolean
         */
        @Override
        public boolean test(Integer[] integers) {
            return 0 == integers[0] % integers[1] || 0 == integers[0] % integers[2] || 0 == integers[1] % integers[2] || 0 == integers[1] % integers[0] || 0 == integers[2] % integers[0] || 0 == integers[2] % integers[1];
        }
    }

    private class fct1 implements Function<Integer[], Integer> {
        /**
         * This method is the constructor of fct1. It returns a function that returns the sum of the first three integer values in an array.
         * @param integers array that gets tested
         * @return returns the sum of the parameter
         */
        @Override
        public Integer apply(Integer[] integers) {
            return integers[0] + integers[1] + integers[2];
        }
    }

    private class predU1 implements Predicate<Integer> {
        /**
         * This method is the constructor of predU1. It returns a predicate that is true when a given integer is positive.
         * @param integer array that gets tested
         * @return returns the according boolean
         */
        @Override
        public boolean test(Integer integer) {
            return integer >= 0;
        }
    }
}
