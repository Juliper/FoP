package h11.supplier;

import java.util.function.Supplier;

public class CyclicRangeSupplier implements Supplier<Integer> {
    private int first;
    private int last;
    private int getSmall;
    private int getBig;

    /**
     * This is the constructor of CyclicRangeSupplier. It initializes the attributes with its parameters.
     * @param first new value of this.first and this.getSmall
     * @param last new value of this.last and this.getBig
     */
    public CyclicRangeSupplier(int first, int last) {
        this.first = first;
        this.last = last;
        this.getSmall = first;
        this.getBig = last;
    }

    /**
     * This method returns the values between this.first and this.last in ascending oreder. When all vlaues were returned it starts from the beginning.
     * @return returns values between this.first and this.last in ascending order
     */
    @Override
    public Integer get() {
        if(first == last) {
            return first;
        }else {
            if(first < last) {
                if(getSmall == last) {
                    getSmall = first;
                    return last;
                }
                return getSmall++;
            }else {
                if(getBig == last) {
                    getBig = first;
                    return last;
                }
                return getBig++;
            }
        }
    }
}
