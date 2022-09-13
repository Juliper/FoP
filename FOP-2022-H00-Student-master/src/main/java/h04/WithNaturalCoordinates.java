package h04;

public interface WithNaturalCoordinates {
  /**
   * This method returns the amount of that gets associated with x.
   * @return returns the current x amount
   */
  int getX();

  /**
   * This method returns the amount of that gets associated with y.
   * @return returns the current y amount
   */
  int getY();

  /**
   * This method changes the current variable that is associated with x to the amount of newX.
   * @param newX the amount of newX is the new value of x
   */
  void setX(int newX);
  /**
   * This method changes the current variable that is associated with y to the amount of newY.
   * @param newY the amount of newY is the new value of y
   */
  void setY(int newY);
}
