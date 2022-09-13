package h07.person;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class MyFunctionWithAdjacent extends FunctionWithFilterMapAndFold{

  /**
   * This method is the constructor of FunctionWithFilterMapAndFold and initializes the attributes.
   * @param traits initial this.traits
   */
  public MyFunctionWithAdjacent(Traits traits) {
    super(traits);
  }

  /**
   * This method applies the methods of this class to a given Person array and returns an int value.
   * @param people array
   * @return returns an int value
   */
  @Override
  public int apply(Person[] people) {
    Person[] filteredPeople = filter(traits.getPred(), people);
    int[] mappedPeople = map(traits.getFct(), filteredPeople);
    int[] combinedPeople = combine(traits.getCombine(), mappedPeople);
    int foldedPeople = foldl(traits.getOp(), traits.getInit(), combinedPeople);
    return foldedPeople;
  }

  /**
   * This method filters the given array with the given predicate and returns the filtered array
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

  /**
   * This method combines a given array into a new one. Combinations are (0,1;1,2;2,3;...). The method returns that
   * new int array.
   * @param combine the function of the combination
   * @param values array that gets combined
   * @return returns the combined array
   */
  static public int[] combine(IntBinaryOperator combine, int[] values) {
    if(values.length == 0 || values.length == 1) {
      int []combinedValues = {};
      return combinedValues;
    } else {
    int[] combinedValues = new int[values.length - 1];
      for(int i = 0; i < combinedValues.length; i++) {
        combinedValues[i] = combine.applyAsInt(values[i], values[i + 1]);
      }
      return combinedValues;
    }
  }
}
