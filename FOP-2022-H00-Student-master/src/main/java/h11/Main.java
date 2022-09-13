package h11;

import h11.merge.StreamMerger;
import h11.unicode.CharFromUnicode;
import h11.unicode.CharWithIndex;
import h11.unicode.FormatException;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Main entry point in executing the program.
 */
public class Main {

    /**
     * Main entry point in executing the program.
     *
     * @param args program arguments, currently ignored
     */
    public static void main(String[] args) {

        System.out.println(Character.toChars(60)[0]);

        CharFromUnicode charFromUnicode = new CharFromUnicode();

        System.out.println(Character.MAX_VALUE - 1);
        System.out.println(Character.MAX_CODE_POINT);
        try {
            charFromUnicode.apply(Character.MAX_CODE_POINT - 1);
        } catch (FormatException exc) {
            System.out.println(exc.getMessage());
        }

//        double[] doubles = {};
//        System.out.println(doubles[0]);
//        "Hello world!\n"
//            .chars()
//            .mapToObj(i -> (char) i)
//            .forEach(System.out::print);
    }
}
