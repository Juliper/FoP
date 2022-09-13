package h07.person;

import java.util.Objects;
import java.util.function.IntBinaryOperator;

public class PersonFunctionFactory {
  static private boolean firstImplementationActive;

  /**
   * This method returns the value of firstImplementationActive.
   * @return returns this.firstImplementationActive
   */
  public static boolean isFirstImplementationActive() {
    return firstImplementationActive;
  }

  /**
   * This method sets this.firstImplementationActive to a new value(parameter).
   * @param firstImplementationActive new value of this.firstImplementationActive
   */
  public static void setFirstImplementationActive(boolean firstImplementationActive) {
    PersonFunctionFactory.firstImplementationActive = firstImplementationActive;
  }

  /**
   * This method is the constructor of FunctionWithFilterMapAndFold it creates a FunctionWithFilterMapAndFold1 object
   * with the given traits when firstImplementationActive is true otherwise it creates a FunctionWithFilterMapAndFold2
   * object.
   * @param traits creates the object with that trait
   * @return returns the created object
   */
  static public FunctionWithFilterMapAndFold createFunctionWithFilterMapAndFold(Traits traits){
    if(firstImplementationActive) {
      FunctionWithFilterMapAndFold functionWithFilterMapAndFold1 = new FunctionWithFilterMapAndFold1(traits);
      return functionWithFilterMapAndFold1;
    }else {
      FunctionWithFilterMapAndFold functionWithFilterMapAndFold2 = new FunctionWithFilterMapAndFold2(traits);
      return functionWithFilterMapAndFold2;
    }
  }

  /**
   * This method creates a strange function and returns a FunctionWithFilterMapAndFold object.
   * @param name is the name the given array gets filtered by
   * @return returns a FunctionWithFilterMapAndFold with the created traits object
   */
  static public FunctionWithFilterMapAndFold createStrangeFunction(String name) {
    IntBinaryOperator op = (x, y) -> (x + y + 1);
    int init = 357;
    PersonToIntFunction fct = (Person person) -> person.getPostalCode();
    PersonFilter pred = (Person person) -> Objects.equals(person.getLastName(), name);
    Traits traits = new Traits(op, init, fct, pred, null);
    return createFunctionWithFilterMapAndFold(traits);
  }

  /**
   * This method creates a myFunctionWithAdjacent object and returns it. That object calculates the distance for a given
   * Person array.
   * @return returns the myFunctionWithAdjacent object
   */
  static public FunctionWithFilterMapAndFold distance() {
    IntBinaryOperator op = (x , y) -> x + y;
    int init = 0;
    PersonFilter pred = (Person person) -> person.getPostalCode() != 64289;
    PersonToIntFunction fct = (Person person) -> person.getPostalCode();
    IntBinaryOperator combine = (x, y) -> (Math.abs(x - y));
    Traits traits = new Traits(op, 0, fct, pred, combine);

    FunctionWithFilterMapAndFold myFunctionWithAdjacent = new MyFunctionWithAdjacent(traits);
    return myFunctionWithAdjacent;
  }
}
