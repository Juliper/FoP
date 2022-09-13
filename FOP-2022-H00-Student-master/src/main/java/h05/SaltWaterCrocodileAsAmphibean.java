package h05;

import java.util.Objects;

public class SaltWaterCrocodileAsAmphibean implements Amphibean{
  private SaltWaterCrocodile salty;

  /**
   * This method is the constructor of SaltWaterCrocodileAsAmphibean. The constructor saves the parameter(animal) in
   * the objectattribut salty if the parameters class is SaltWaterCrocodile or a subclass.
   * @param animal gets saved in salty if its SaltWaterCrocodile or a subclass
   */
  public SaltWaterCrocodileAsAmphibean(Animal animal) {
    if(animal instanceof SaltWaterCrocodile) {
      salty = (SaltWaterCrocodile) animal;
    }
  }

  /**
   * This method returns the preferred environment type. In this case its EnvironmentType.IN_WATER.
   * @return returns the preferred environment type.
   */
  @Override
  public EnvironmentType getPreferredEnvironmentType() {
    return EnvironmentType.IN_WATER;
  }

  /**
   * This method returns the number of legs of the reference saved in salty.
   * @return returns the number of legs if salty
   */
  @Override
  public byte getNumberOfLegs() {
    return salty.getNumberOfLegs();
  }

  /**
   * This method accepts one double parameter(distance) and returns the average speed for that distance of salty.
   * @param distance specifies what average speed gets returned
   * @return returns the average speed of salty
   */
  @Override
  public double getAverageSpeed(double distance) {
    return salty.getAverageSpeed(distance);
  }

  /**
   * This method returns true if the reference in salty can live in freshwater.
   * @return returns true if salty can live in freshwater otherwise false
   */
  @Override
  public boolean canLiveInFreshWater() {
    return salty.canLiveInFreshWater();
  }

  /**
   * This method returns true if the reference in salty can live in saltwater.
   * @return returns true if salty can live in saltwater otherwise false
   */
  @Override
  public boolean canLiveInSaltWater() {
    return salty.canLiveInSaltWater();
  }

  /**
   * This method calls the letMeSwim() for salty.
   * @param distance first factor
   * @param x second factor
   * @param y third factor
   */
  @Override
  public void letMeSwim(char distance, double x, double y) {
    salty.letMeSwim(distance, x, y);
  }

  /**
   * This method returns true if the parameter(o) is not null, is SaltWaterCrocodile or a subclass of it and the
   * attribute salty has the same reference in the parameter object and the object the method is called in.
   * @param o is the object that is compared with
   * @return returns true or false
   */
  @Override
  public boolean equals(Object o) {
    boolean first =  (o != null) && (o instanceof SaltWaterCrocodileAsAmphibean);
    boolean second = first && this.salty == ((SaltWaterCrocodileAsAmphibean)o).salty;
    if(!first) {
      return false;
    }
    else if(second) {
      return true;
    }
    else return false;
  }

  /**
   * This method returns a SaltWaterCrocodileAsAmphibean object with the same salty reference.
   * @return returns a SaltWaterCrocodileAsAmphibean object with the same salty reference
   */
  @Override
  public Object clone(){
    return new SaltWaterCrocodileAsAmphibean(this.salty);
  }
}
