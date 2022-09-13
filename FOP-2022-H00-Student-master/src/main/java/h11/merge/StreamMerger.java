package h11.merge;

import h11.unicode.CharWithIndex;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class StreamMerger {
    private final Predicate<Integer> predicate;
    private final Comparator<Integer> comparator;
    private final Function<Integer, CharWithIndex> function;
    private final Collector<CharWithIndex, List<CharWithIndex>, CharWithIndex[]> collector;

    /**
     * This is the constructor of StreamMerger. It initializes all attributes with predefined objects.
     */
    public StreamMerger() {
        this.predicate = Objects::nonNull;
        this.comparator = (x, y) -> {
            Integer intX = 0;
            Integer intY = 0;

            for(char value : String.valueOf(x).toCharArray()) {
                intX += Character.digit(value, 10);
            }
            for(char value : String.valueOf(y).toCharArray()) {
                intY += Character.digit(value, 10);
            }

            return intX.compareTo(intY);
        };
        this.function = x -> {
            if(x > Character.MAX_VALUE || x < Character.MIN_VALUE) {
                return null;
            } else return new CharWithIndex((char) x.intValue(), x);
        };
        this.collector = Collector.of(
            LinkedList::new,
            (list, charWithIndex) -> {
                if(charWithIndex != null) {
                    list.add(charWithIndex);
                }
            },
            (list1, list2) -> {
                list1.addAll(list2);
                return list1;
            },
            finalList -> {
                CharWithIndex[] charWithIndices = new CharWithIndex[finalList.size()];

                for (int i = 0; i < charWithIndices.length; i++) {
                    charWithIndices[i] = finalList.get(i);
                }

                return charWithIndices;
            },
            Collector.Characteristics.UNORDERED
        );
    }

    /**
     * This method merges a Stream[] in one Stream. Afterwards that stream gets filtered of nulls, sorted in ascending order of the checksum, mapped to CharWithIndex objects
     * that have the Integer value and the according Character. Then the stream gets collected into an CharWithIndex[].
     * @param array array that gets merged
     * @return returns an array of the given streams
     */
    public CharWithIndex[] merge(Stream<Integer>[] array) {
        return streamConcat(array).filter(predicate).sorted(comparator).map(function).collect(collector);
    }

    /**
     * This method handles the concatenation of the Stream[].
     * @param array array that gets concatenated
     * @return returns the concatenated stream
     */
    public Stream<Integer> streamConcat(Stream<Integer>[] array) {
        Stream<Integer> all = array[0];

        for (int i = 1; i < array.length; i++) {
            all = Stream.concat(all, array[i]);
        }

        return all;
    }
}
