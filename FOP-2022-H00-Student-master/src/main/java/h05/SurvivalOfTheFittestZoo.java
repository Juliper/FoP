package h05;

public class SurvivalOfTheFittestZoo implements Zoo{
  /**
   * This method
   * @param animal first animal that gets checked
   * @param animal2 second animal that gets checked
   * @return returns always true
   */
  @Override
  public boolean canLiveTogether(Animal animal, Animal animal2) {
    return true;
  }

  /**
   * This method proves if the animal is allowed.
   * @param animal the animal that gets checked
   * @return returns true if it's not a bird
   */
  @Override
  public boolean isAllowed(Animal animal) {
    return animal.getAnimalType() != AnimalType.AVES;
  }
}
