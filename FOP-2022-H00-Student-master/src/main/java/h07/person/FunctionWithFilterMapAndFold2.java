package h07.person;

import java.util.function.IntBinaryOperator;

public class FunctionWithFilterMapAndFold2 extends FunctionWithFilterMapAndFold{

  /**
   * This method is the constructor of FunctionWithFilterMapAndFold2 and initializes the attributes.
   * @param traits initial value of this.traits
   */
  public FunctionWithFilterMapAndFold2(Traits traits) {
    super(traits);
  }

  /**
   * This method filters, maps and folds a given array.
   * @param people array that gets converted
   * @return returns a single int
   */
  @Override
  public int apply(Person[] people) {
    int value = traits.getInit();
    for(int i = 0; i < people.length; i++) {
      if(traits.getPred().test(people[i])) {
        value = traits.getOp().applyAsInt(value, traits.getFct().apply(people[i]));
      }
    }
    return value;
  }
}
