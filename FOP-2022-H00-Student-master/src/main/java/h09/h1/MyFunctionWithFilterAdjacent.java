package h09.h1;

public class MyFunctionWithFilterAdjacent<X, Y, Z> extends FunctionWithFilterMapAndFold<X, Y, Z> {

    /**
     * This is the constructor of MyFunctionWithAdjacent and sets traits to its value.
     * @param traits initial value of this.traits
     */
    public MyFunctionWithFilterAdjacent(Traits<X, Y, Z> traits) {
        super(traits);
    }

    /**
     * This method implements the abstract method and accepts an X[] filters, maps, combines and folds it and returns the fold value.
     * @param array array that gets filtered, mapped, combined and folded
     * @return returns fold value
     */
    @Override
    public Z apply(X[] array) {
        Y mappedValue = null;
        Y combinedValue;
        Z endValue = traits.getInit();
        int steps= 0;
        if(array.length == 0) {
            return  null;
        }
        for(Object object : array) {
            if(!(traits.getPred().test((X)object))) {
                continue;
            }

            if(steps == 0) {
                mappedValue = (Y)traits.getFct().apply((X)object);
                steps++;
                continue;
            }
            else{
                combinedValue = (Y) traits.getCombine().apply(mappedValue, (Y)traits.getFct().apply((X)object));
                mappedValue = (Y)traits.getFct().apply((X)object);
            }
            endValue = (Z)traits.getOp().apply(endValue, combinedValue);
        }
        return endValue;
    }
}
