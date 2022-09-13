package h05;

public interface Walking {

  /**
   * This method returns the number of legs of the object.
   * @return returns a byte which represents the number of legs
   */
  byte getNumberOfLegs();

  /**
   * This method returns the average Speed for a given distance.
   * @param distance specifies what average speed gets returned
   * @return returns a double which represents the average speed
   */
  double getAverageSpeed(double distance);
}
