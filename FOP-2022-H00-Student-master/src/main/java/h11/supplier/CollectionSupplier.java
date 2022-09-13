package h11.supplier;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Supplier;


public class CollectionSupplier <T> implements Supplier <T> {
    private final Collection<T> collection;
    private Collection<T> tmp;

    /**
     * This is the constructor of CollectionSupplier. It accepts a Collection and saves it as an attribute
     * @param collection new value of the attributes
     */
    public CollectionSupplier(Collection<T> collection) {
        this.collection = collection;
        this.tmp = this.collection;
    }

    /**
     * This method returns all objects in the collection. When all objects are returned the next calls return null.
     * @return returns object of the collection
     */
    @Override
    public T get() {
        if(tmp.iterator().hasNext()) {

            Iterator<T> iterator = tmp.iterator();
            T result = iterator.next();
            iterator.remove();
            return result;

        }else return null;
    }
}
