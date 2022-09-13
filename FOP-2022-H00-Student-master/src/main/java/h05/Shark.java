package h05;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntConsumer;

public class Shark extends Animal implements Swimming, IntConsumer {
  private short specificSpecies;
  private int x;
  private int y;
  private int degreeOfHunger;

  /**
   * This method is the constructor of Shark.
   * @param specificSpecies is the new this.specificSpecies value
   */
  public Shark(short specificSpecies) {
    setSpecificSpecies(specificSpecies);
    animalType = AnimalType.CHONDRICHTHYES;
    degreeOfHunger = 10;
  }

  /**
   * This method returns the current value of specificSpecies.
   * @return returns a short of the value of specificSpecies
   */
  public short getSpecificSpecies() {
    return specificSpecies;
  }

  /**
   * This method returns the current value of x.
   * @return returns an int of the value of x
   */
  public int getX() {
    return x;
  }

  /**
   * This method returns the current value of y.
   * @return returns an int of the value of y
   */
  public int getY() {
    return y;
  }

  /**
   * This method returns the current value of degreeOfHunger.
   * @return returns an int of the value of degreeOfHunger
   */
  public int getDegreeOfHunger() {
    return degreeOfHunger;
  }

  /**
   * This method returns true when the specificSpecies is 2,5 or 9. Otherwise, it returns false.
   * @return returns true if the object can live in salt water otherwise false
   */
  @Override
  public boolean canLiveInSaltWater() {
    return (specificSpecies == 2 || specificSpecies == 5 || specificSpecies == 9);
  }

  /**
   * This method returns true when specificSpecies can be divided by 2 but not by 4. Otherwise, it returns false.
   * @return returns true if the object can live in fresh water otherwise false
   */
  @Override
  public boolean canLiveInFreshWater() {
    return (specificSpecies % 2 == 0 && specificSpecies % 4 != 0);
  }

  /**
   * This method adds the product of x(parameter) and distance(parameter) to this.x and adds the product of
   * y(parameter) and distance(parameter) to this.y and increases degreeOfHunger by one.
   * @param distance first factor
   * @param x second factor
   * @param y third factor
   */
  @Override
  public void letMeSwim(char distance, double x, double y) {
    this.x += distance * x;
    this.y += distance * y;
    this.degreeOfHunger++;
  }

  /**
   * This method calls letMeMove() and returns the values of x and y before letMeMove() and after.
   * @return returns a String that contains the old and new values of x and y
   */
  @Override
  public String letMeMove() {
    int oldX = x;
    int oldY = y;
    letMeSwim((char)(1 + ThreadLocalRandom.current().nextInt(5)), (1 + ThreadLocalRandom.current().nextInt(5)), (1 + ThreadLocalRandom.current().nextInt(5)));
    return oldX + " -> " + x + " and " + oldY + " -> " + y;
  }

  /**
   * This method decreases the value of degreeOfHunger by its parameter(reductionOfHUnger) if degreeOfHunger stays
   * positive and reductionOfHunger is positive otherwise nothing happens.
   * @param reductionOfHunger is the value degreeOfHunger gets decreased by
   */
  @Override
  public void accept(int reductionOfHunger) {
    degreeOfHunger -= (reductionOfHunger >= 0) && ((degreeOfHunger -= reductionOfHunger) >= 0) ? reductionOfHunger : 0;
  }

  /**
   * This method changes this.specificSpecies to its parameter if the parameter is between 0 and 10. For every
   * parameter value above this.specificSpecies is changed to 10 and for every parameter below this.specificSpecies
   * is changed to 0.
   * @param specificSpecies is the new value of this.specificSpecies
   * @return returns the value of specificSpecies before the method was called
   */
  public short setSpecificSpecies(short specificSpecies) {
    short oldSpecificSpecies = this.specificSpecies;
    if(specificSpecies < 0) {
      this.specificSpecies = 0;
    }
    else if(specificSpecies > 10) {
      this.specificSpecies = 10;
    }else this.specificSpecies = specificSpecies;
    return oldSpecificSpecies;
  }
}
