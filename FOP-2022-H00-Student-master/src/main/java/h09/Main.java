package h09;

import h09.h1.Traits;
import java.util.*;


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
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(6);
        list2.add(7);
        list2.add(8);
        list2.add(9);
        list2.add(10);

        List<Integer> result = foo(list1, list2);

        for(int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }



    }

    public <T> void foo(ListItem<T> lst1, ListItem<T> lst2, ListItem<T> tail) {
        ListItem<T> last = tail;

        if(lst1 != null) {
            ListItem<T> item1 = new ListItem<T>;
            item1.key = lst1.key;

            last.next = item1;
            last = last.next;
        }

        if(lst2 != null) {
            ListItem<T> item2 = new ListItem<T>;
            item2.key = lst2.key;

            last.next = item2;
            last = last.next;
        }

        if(lst1 == null && lst2 == null) {
            return;
        }
        else if(lst1 != null && lst2 == null) {
            foo(lst1.next, null, last);
        }
        else if(lst1 == null && lst2 != null) {
            foo(null, lst2.next, last);
        }
        else if(lst1 != null && lst2 != null) {
            foo(lst1.next, lst2.next, last);
        }
    }

    /**
     * Each of the statement in this method should pass through the compiler without error or
     * warning.
     */
    static void shouldWork() {
        final Traits<Number, Number, Number> t1 = new Traits<>(
            Integer.class::isInstance,
            Object::hashCode,
            (number, o) -> number.intValue() * o.hashCode(),
            12.2
        );
        final Traits<Integer, Integer, Integer> t2 = new Traits<>(
            integer -> integer > 0,
            integer -> integer + 1,
            (i1, i2) -> i1 * i2,
            0
        );
        final Traits<Integer, Integer, Integer> t3 = new Traits<>(
            (Object o) -> o.hashCode() > 1255477819,
            integer -> integer + 1,
            (i1, i2) -> i1 * i2,
            0
        );
        final Traits<Integer, Integer, Integer> t4 = new Traits<>(
            integer -> integer > 0,
            (Object o) -> o.hashCode(),
            (i1, i2) -> i1 * i2,
            0
        );
        final Traits<Integer, Object, Integer> t5 = new Traits<>(
            integer -> integer > 0,
            integer -> 52,
            (i, o) -> i * o.hashCode(),
            0
        );
        final Traits<Integer, Object, Integer> t6 = new Traits<>(
            integer -> integer > 0,
            integer -> "Test",
            (i, o) -> i * o.hashCode(),
            0
        );
        final Traits<Integer, Integer, Integer> t7 = new Traits<Integer, Integer, Integer>(
            integer -> integer > 0,
            integer -> 52,
            (Integer i, Object o) -> 2 * o.hashCode(),
            0
        );
        final Traits<Integer, Integer, Integer> t8 = new Traits<Integer, Integer, Integer>(
            integer -> integer > 0,
            integer -> 52,
            (Integer i, Number n) -> 2 * n.intValue(),
            0
        );
    }

    /**
     * Every single statement of this method should cause a compiler error. Make sure that this
     * requirement is met by commenting each statement in this method individually, and making sure
     * that the code is no longer accepted by the compiler.
     */

/**
    static void shouldNotWork() {
        final Traits<Number, Number, Number> t1 = new Traits<>(
            (Integer i) -> i.compareTo(5) > 0,
            Object::hashCode,
            (number, o) -> number.intValue() * o.hashCode(),
            12.2
        );
        final Traits<Number, Number, Number> t2 = new Traits<>(
            Integer.class::isInstance,
            (Double d) -> 5,
            (number, o) -> number.intValue() * o.hashCode(),
            12.2
        );
        final Traits<Number, Number, Number> t3 = new Traits<>(
            Integer.class::isInstance,
            number -> new Object(),
            (number, o) -> number.intValue() * o.hashCode(),
            12.2
        );
        final Traits<Number, Number, Number> t4 = new Traits<>(
            Integer.class::isInstance,
            (Double d) -> 5,
            (Number n, Integer i) -> n.intValue() * i,
            12.2
        );
        final Traits<Number, Number, Number> t5 = new Traits<>(
            Integer.class::isInstance,
            number -> number.intValue() * 10,
            (Object o, Number number) -> o.hashCode() * number.doubleValue(),
            12.2
        );
    }
 */

}
