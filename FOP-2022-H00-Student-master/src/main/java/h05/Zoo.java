package h05;

public interface Zoo {
  /**
   * This method checks if animal and animal2 can live together.
   * @param animal first animal that gets checked
   * @param animal2 second animal that gets checked
   * @return returns a boolean value
   */
  boolean canLiveTogether(Animal animal, Animal animal2);

  /**
   * This method checks if the animal is allowed and returns true or false.
   * @param animal the animal that gets checked
   * @return returns a boolean value
   */
  boolean isAllowed(Animal animal);
}
