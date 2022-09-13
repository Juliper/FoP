package h07.person;

@FunctionalInterface
public interface PersonToIntFunction {
  /**
   * Applies this method to a given person.
   * @param person used value
   * @return returns something
   */
  int apply(Person person);
}
