package h07.person;

public abstract class FunctionWithFilterMapAndFold {
  protected final Traits traits;

  /**
   * This method is the constructor of FunctionWithFilterMapAndFold and initializes the attributes.
   * @param traits initial this.traits
   */
  public FunctionWithFilterMapAndFold(Traits traits) {
    this.traits = traits;
  }

  /**
   * This method accepts an array of Person and returns an int.
   * @param people array
   * @return int
   */
  public abstract int apply(Person[] people);
}
