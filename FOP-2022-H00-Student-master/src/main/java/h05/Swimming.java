package h05;

public interface Swimming {

  /**
   * This method checks if the object can swim in salt water.
   * @return returns true when the animal can swim in salt water otherwise false
   */
  public boolean canLiveInSaltWater();

  /**
   * This method checks if the object can swim in fresh water.
   * @return returns true when the animal can swim in fresh water otherwise false
   */
  public boolean canLiveInFreshWater();

  /**
   * This method calculates the new x and y.
   * @param distance first factor
   * @param x second factor
   * @param y third factor
   */
  public void letMeSwim(char distance, double x, double y);
}
