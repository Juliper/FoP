package h05;

import java.util.concurrent.ThreadLocalRandom;

public class FamilyFriendlyZoo implements Zoo{
  /**
   * This method checks if animal(first parameter) and animal2(second parameter) can live together. Sharks can't live
   * with animals of the type CHONDRICHTHYES, animals of the type CHONDRICHTHYES can't live with animals of the type
   * MAMMALIA and animals of the type AVES only can live with animals which can walk slower than 3m/s.
   * @param animal first animal that gets compared
   * @param animal2 second animal that gets compared
   * @return returns true when the animal can live together false otherwise
   */
  @Override
  public boolean canLiveTogether(Animal animal, Animal animal2) {
    if(animal.getClass() == Shark.class && animal2.getAnimalType() == AnimalType.CHONDRICHTHYES || animal2.getClass() == Shark.class && animal.getAnimalType() == AnimalType.CHONDRICHTHYES) {
      return false;
    }
    else if(animal.getAnimalType() == AnimalType.CHONDRICHTHYES && animal2.getAnimalType() == AnimalType.MAMMALIA || animal2.getAnimalType() == AnimalType.CHONDRICHTHYES && animal.getAnimalType() == AnimalType.MAMMALIA) {
      return false;
    }
    else if(animal.getAnimalType() == AnimalType.AVES && animal2 instanceof Walking) {
      Walking walkingAnimal = (Walking) animal2;
      return walkingAnimal.getAverageSpeed(10) < 3;
    }
    else if(animal2.getAnimalType() == AnimalType.AVES && animal instanceof Walking) {
      Walking walkingAnimal = (Walking) animal;
      return walkingAnimal.getAverageSpeed(10) < 3;
    }
    return true;
  }

  /**
   * This method checks if the animal(parameter) is allowed in that Zoo.
   * @param animal that gets checked
   * @return returns true if the animal is allowed otherwise false
   */
  @Override
  public boolean isAllowed(Animal animal) {
    return animal.getClass() != Shark.class || ((Shark) animal).getSpecificSpecies() != 4;
  }

  /**
   * This method returns a random char between 97 and 122(a-z).
   * @return returns the random char between 97 and 122
   */
  public char getLetterOfTheDay() {
    return (char)ThreadLocalRandom.current().nextInt(97, 123);
  }
}
