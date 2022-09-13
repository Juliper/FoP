package h07.person;

@FunctionalInterface
public interface PersonFilter {
  /**
   * This method is applied to a given argument.
   * @param person the function argument
   * @return function result
   */
  boolean test(Person person);
}
