package h05;

public class SaltWaterCrocodile extends Animal implements Walking,Swimming{
  static private double averageSpeed;

  /**
   * This method is the constructor of SaltWaterCrocodile and initializes animalType with AnimalType.CROCODYLIDAE.
   */
  public SaltWaterCrocodile(){
    animalType = AnimalType.CROCODYLIDAE;
  }

  /**
   * This method returns an empty String.
   * @return returns null
   */
  @Override
  public String letMeMove() {
    return "";
  }

  /**
   * This method returns the number of legs this animal has.
   * @return returns 4
   */
  @Override
  public byte getNumberOfLegs() {
    return 4;
  }

  /**
   * This method returns true when the animal can live in fresh water.
   * @return returns true
   */
  @Override
  public boolean canLiveInFreshWater() {
    return true;
  }

  /**
   * This method returns true when the animal can live in salt water.
   * @return returns true
   */
  @Override
  public boolean canLiveInSaltWater() {
    return true;
  }

  /**
   * This method does nowt.
   * @param distance first factor
   * @param x second factor
   * @param y third factor
   */
  @Override
  public void letMeSwim(char distance, double x, double y) {
  }

  /**
   * This method returns the average speed SaltWaterCrocodile which is independent of the distance.
   * @param distance specifies what average speed gets returned
   * @return returns the average speed SaltWaterCrocodile which is independent of the distance
   */
  @Override
  public double getAverageSpeed(double distance) {
    return averageSpeed;
  }

  /**
   * This method sets the average speed SaltWaterCrocodile which is independent of the distance.
   * @param averageSpeed is the new averageSpeed
   */
  public void setAverageSpeed(double averageSpeed) {
    SaltWaterCrocodile.averageSpeed = averageSpeed;
  }
}
