package h09.h1;

public final class FunctionFactory {

    /**
     * This is the constructor of FunctionFactory and does nothing :D
     */
    private FunctionFactory() {
    }

    /**
     * This method creates a new FunctionWithFilterMapAndFold and returns this object.
     * @param traits contais all functions
     * @return returns a FunctionWithFilterMapAndFold with the created traits object
     */
    public static <X, Y, Z> FunctionWithFilterMapAndFold<X, Y, Z> createFunctionWithFilterMapAndFold(Traits<X, Y, Z> traits) {
        return new MyFunctionWithFilterMapAndFold<X, Y, Z>(traits);
    }

    /**
     * This method creates a strange FunctionWithFilterMapFoldAndCombine and returns this object.
     * @param traits contais all functions
     * @return returns a FunctionWithFilterMapAndFold with the created traits object
     */
    public static <X, Y, Z> FunctionWithFilterMapAndFold<X, Y, Z> createFunctionWithFilterMapFoldAndCombine(Traits<X, Y, Z> traits) {
        return new MyFunctionWithFilterAdjacent<>(traits);
    }
}
