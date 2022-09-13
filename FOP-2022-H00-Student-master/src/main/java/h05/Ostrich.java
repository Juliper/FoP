package h05;

public class Ostrich extends Animal implements Walking{
  private int distanceSoFar;

  /**
   * This method is the constructor of Ostrich and initializes animalType with AnimalType.AVES.
   */
  public Ostrich() {
    animalType = AnimalType.AVES;
  }

  /**
   * This method returns the distanceSoFar of this object.
   * @return returns the value of distanceSoFar
   */
  public int getDistanceSoFar() {
    return distanceSoFar;
  }

  /**
   * This method increases distanceSoFar by 1 and returns a String containing its new value.
   * @return returns a String containing the new value of distanceSoFar
   */
  public String letMeMove() {
    distanceSoFar++;
    return "Distance so far: " + distanceSoFar;
  }

  /**
   * This method returns the number of legs of this object.
   * @return returns an int representing the number of legs
   */
  public byte getNumberOfLegs() {
    return 2;
  }

  /**
   * This method returns an average speed depending on its parameter(distance).
   * @param distance specifies what average speed gets returned
   * @return returns the average speed for the given distance
   */
  public double getAverageSpeed(double distance) {
    if(distance > 0.000 && distance <= 1.337){
      return 6.900;
    }
    else if(distance > 1.337 && distance <= 4.200) {
      return 3.140;
    }
    else if(distance > 4.200) {
      return 1.000;
    }
    else return 0.000;
  }
}
