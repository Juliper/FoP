package h09.h1;


import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.BiFunction;

public class Traits <X, Y, Z> {
    private final Predicate<? super X> pred;
    private final Function<? super X,? super Y> fct;
    private final BiFunction<Z, ? super Y, Z> op;
    private final Z init;
    private final BiFunction<? super Y, ? super Y, ? super Y> combine;

    /**
     * This is the constructor of Traits. It initializes all attributes with the given parameters except combine that gets initialized with null.
     * @param predicate predicate for filter
     * @param function function for mapping
     * @param op operator for folding
     * @param z initial value for folding
     */
    public Traits(Predicate<? super X> predicate, Function<? super X, ? super Y> function, BiFunction<Z, ? super Y,Z> op, Z z) {
        this.pred = predicate;
        this.fct = function;
        this.op = op;
        this.init = z;
        this.combine = null;
    }

    /**
     * This is the constructor of Traits. It initializes all attributes with the given parameters.
     * @param predicate predicate for filter
     * @param function function for mapping
     * @param op operator for folding
     * @param z initial value for folding
     * @param combine operator for combine
     */
    public Traits(Predicate<? super X> predicate, Function<? super X, ? super Y> function, BiFunction<Z, ? super Y, Z> op, Z z, BiFunction<? super Y,? super Y,? super Y> combine) {
        this.pred = predicate;
        this.fct = function;
        this.op = op;
        this.init = z;
        this.combine = combine;
    }

    /**
     * Getter for the predicate.
     * @return returns this.pred
     */
    public Predicate<? super X> getPred() {
        return pred;
    }

    /**
     * Getter for the function.
     * @return returns this.fct
     */
    public Function<? super X, ? super Y> getFct() {
        return fct;
    }

    /**
     * Getter for BiFunction.
     * @return returns this.op
     */
    public BiFunction<? super Z, ? super Y, ? super Z> getOp() {
        return op;
    }

    /**
     * Getter for Init.
     * @return returns this.init
     */
    public Z getInit() {
        return init;
    }

    /**
     * Getter for BiFunction.
     * @return returns this.combine
     */
    public BiFunction<? super Y, ? super Y, ? super Y> getCombine() {
        return combine;
    }
}
