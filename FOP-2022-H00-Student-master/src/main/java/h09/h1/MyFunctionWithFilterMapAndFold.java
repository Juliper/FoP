package h09.h1;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyFunctionWithFilterMapAndFold<X, Y, Z> extends FunctionWithFilterMapAndFold<X, Y, Z> {

    /**
     * This is the constructor of MyFunctionWithFilterMapAndFold. It initializes this.traits with its parameter.
     * @param traits initial value of this.traits
     */
    public MyFunctionWithFilterMapAndFold(Traits<X, Y, Z> traits) {
        super(traits);
    }

    /**
     * This method implements the abstract method and filters, map and fold the given array and saves the results and returns fold.
     * @param array array that gets filtered, mapped and folded
     * @return returns the folded value
     */
    @Override
    public Z apply(X[] array) {
        X[] filteredObjects = filter(array, traits.getPred());
        Y[] mappedValues = map(filteredObjects, traits.getFct());
        Z value = fold(traits.getOp(), traits.getInit(), mappedValues);
        return value;
    }

    /**
     * This method filters a given array with the given predicate.
     * @param objects given array
     * @param predicate array gets tested with that predicate
     * @return returns an array only containing the objects that passed test
     */
    private X[] filter(X[] objects, Predicate predicate) {
        int j = 0;
        for(Object object : objects) {
            j = j + ((predicate.test(object)) ? 1 : 0);
        }
        X[] array = (X[])new Object[j];

        int help = 0;
        for(int i = 0; i < array.length; i++) {
            if(predicate.test(objects[i])) {
                array[help] = objects[i];
                help++;
            }
        }
        return array;
    }

    /**
     * This method maps a given array to its Y values with the given function.
     * @param objects array that gets tested
     * @param functions function that gets used for mapping
     * @return returns a array containing all mapped values
     */
    private Y[] map(X[] objects, Function functions) {
        Y[] array = (Y[]) new Object[objects.length];
        for(int i = 0; i < array.length; i++) {
            array[i] = (Y) functions.apply(objects[i]);
        }
        return array;
    }

    /**
     * This method folds a given array with the given function
     * @param op contains the needed function
     * @param init is the initial value
     * @param values contains all mapped values
     * @return returns a single Z value
     */
    private Z fold(BiFunction op, Z init, Y[] values) {
        Z value = init;
        for(int i = 0; i < values.length; i++) {
            value = (Z) op.apply(value, values[i]);
        }
        return value;
    }
}
