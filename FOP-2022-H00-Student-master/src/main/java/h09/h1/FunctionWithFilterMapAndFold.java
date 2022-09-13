package h09.h1;

abstract public class FunctionWithFilterMapAndFold<X,Y,Z> {
    protected final Traits<X, Y, Z> traits;

    /**
     * This is the Constructor of FunctionWithFilterMapAndFold and sets this.traits to its parameter.
     * @param traits initial value of this.traits
     */
    public FunctionWithFilterMapAndFold(Traits<X, Y, Z> traits) {
        this.traits = traits;
    }

    /**
     * This  is an abstract method that accepts an X[] and returns a Z value.
     * @param x given array
     * @return Z value
     */
    abstract public Z apply(X[] x);
}
