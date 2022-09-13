package h05;

public abstract class Animal {
  protected static AnimalType animalType;

  /**
   * This method returns the animal type.
   * @return returns the value of animalType
   */
  public AnimalType getAnimalType(){
    return animalType;
  }

  /**
   * This method lets the animal move.
   * @return returns a String
   */
  public abstract String letMeMove();

  /**
   *
   * @return returns a string that contains the class of this object and its animalType
   */
  public String toString() {
    if (animalType != null) {
      return "My species is called " + this.getClass().getSimpleName() + " which is part of animal type " + (animalType.toString()).substring(0, 1) + ((animalType.toString()).substring(1)).toLowerCase() + ".";
    }
    else return "My species is called " + this.getClass().getSimpleName() + " which is part of animal type Null.";
  }

}
