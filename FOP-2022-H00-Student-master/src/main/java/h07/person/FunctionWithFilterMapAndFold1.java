package h07.person;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class FunctionWithFilterMapAndFold1 extends FunctionWithFilterMapAndFold{

  /**
   * This method is the constructor of FunctionWithFilterMapAndFold and initializes the attributes.
   * @param traits initial this.traits
   */
  public FunctionWithFilterMapAndFold1(Traits traits) {
    super(traits);
  }

  /**
   * This method saves the return values of filter(), map() and foldl() and returns the value of foldl().
   * @param people array that gets converted
   * @return value of foldl
   */
  @Override
  public int apply(Person[] people) {
    Person[] filteredPeople = filter(traits.getPred(), people);
    int[] mappedPeople = map(traits.getFct(), filteredPeople);
    int valueOfPeople = foldl(traits.getOp(), traits.getInit(), mappedPeople);
    return valueOfPeople;
  }

  /**
   * This method filters the given array with the given predicate and returns the filtered array.
   * @param personFilter predicate
   * @param people array that gets filtered
   * @return returns the filtered array
   */
  static public Person[] filter(PersonFilter personFilter, Person[] people) {
    int j = 0;
    for(Person person : people) {
      j = j + ((personFilter.test(person)) ? 1 : 0);
    }
    Person[] array = new Person[j];
    int help = 0;
    for(int i = 0; i < array.length; i++) {
      if(personFilter.test(people[i])) {
        array[help] = people[i];
        help++;
      }
    }
    return array;
  }

  /**
   * This method maps every element of the array to an int value and saves that value in a new array. It returns that
   * new array.
   * @param fct how the elements get mapped
   * @param people array that gets mapped
   * @return returns mapped array
   */
  static public int[] map(PersonToIntFunction fct, Person[] people) {
    int[] array = new int[people.length];
    for(int i = 0; i < array.length; i++) {
      array[i] = fct.apply(people[i]);
    }
    return array;
  }

  /**
   * This method combines a given int value if an array and returns a single int.
   * @param op operator for init and array
   * @param init initial value
   * @param values array of values
   * @return returns a single int
   */
  static public int foldl(IntBinaryOperator op, int init, int[] values) {
    int value = init;
    for(int i = 0; i < values.length; i++) {
      value = op.applyAsInt(value, values[i]);
    }
    return value;
  }
}
