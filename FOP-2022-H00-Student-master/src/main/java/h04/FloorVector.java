package h04;
public class FloorVector implements WithNaturalCoordinates {
  private double x;
  private double y;
  private double z;
  private Axis firstAxis;
  private Axis secondAxis;

  /**
   * This method is the constructor of FloorVector and initializes the private attributes {x,y,z}. x is the value of the
   * parameter. And y gets initialized with 3.14 and z with 2.71.
   * @param initialX is the initial value of x
   */
  public FloorVector(double initialX) {
    x = initialX;
    y = 3.14;
    z = 2.71;
  }

  /**
   * This method returns the current value of x.
   * @return returns the value of x
   */
  public double getRealX() {
    return x;
  }

  /**
   * This method changes the current value of x to its parameter.
   * @param newRealX is the new value of x
   */
  public void setRealX(double newRealX) {
    x = newRealX;
  }

  /**
   * This method returns the current value of y.
   * @return returns the value of y
   */
  public double getRealY() {
    return y;
  }

  /**
   * This method changes the current value of y to its parameter.
   * @param newRealY is the new value of y
   */
  public void setRealY(double newRealY) {
    y = newRealY;
  }

  /**
   * This method returns the current value of z.
   * @return returns the value of z
   */
  public double getRealZ() {
    return z;
  }

  /**
   * This method changes the current value of z to its parameter.
   * @param newRealZ is the new value of z
   */
  public void setRealZ(double newRealZ) {
    z = newRealZ;
  }

  /**
   * This method returns the current value of firstAxis.
   * @return returns the value of firstAxis
   */
  public Axis getFirstAxis() {
    return firstAxis;
  }

  /**
   * This method changes the current value of firstAxis to its parameter
   * @param newFirstAxis is the new value of firstAxis
   */
  public void setFirstAxis(Axis newFirstAxis) {
    firstAxis = newFirstAxis;
  }

  /**
   * This method returns the current value of secondAxis.
   * @return returns the value of secondAxis
   */
  public Axis getSecondAxis() {
    return secondAxis;
  }

  /**
   * This method changes the current value of secondAxis to its parameter
   * @param newSecondAxis is the new value of secondAxis
   */
  public void setSecondAxis(Axis newSecondAxis) {
    secondAxis = newSecondAxis;
  }

  /**
   * This method returns depending on the current firstAxis the amount of the value of x,y,z which first gets converted
   * to an integer.
   * @return returns depending on the current firstAxis the amount of the value of x,y,z
   */
  public int getX() {
    if(firstAxis == Axis.X) {
      if(x >= 0) {
        return (int)x;
      }
      else return (int)-x;
    }
    else if(firstAxis == Axis.Y) {
      if(y >= 0) {
        return (int)y;
      }
      else return (int)-y;
    }
    else {
      if(z >= 0) {
        return (int)z;
      }
      else return (int)-z;
    }
  }

  /**
   * This method sets the value x,y,z depending on the current firstAxis to its parameter(newX).
   * @param newX the amount of newX is the new value of x,y,z depending on the current firstAxis
   */
  public void setX(int newX) {
    if(firstAxis == Axis.X) {
      x = newX;
    }
    else if(firstAxis == Axis.Y) {
      y = newX;
    }
    else z = newX;
  }

  /**
   * This method returns depending on the current secondAxis the amount of the value of x,y,z which first gets converted
   * to an integer.
   * @return returns depending on the current secondAxis the amount of the value of x,y,z
   */
  public int getY() {
    if(secondAxis == Axis.X) {
      if(x >= 0) {
        return (int)x;
      }
      else return (int)-x;
    }
    else if(secondAxis == Axis.Y) {
      if(y >= 0) {
        return (int)y;
      }
      else return (int)-y;
    }
    else {
      if(z >= 0) {
        return (int)z;
      }
      else return (int)-z;
    }
  }

  /**
   * This method sets the value x,y,z depending on the current secondAxis to its parameter(newY).
   * @param newY the amount of newY is the new value of x,y,z depending on the current secondAxis
   */
  public void setY(int newY) {
    if(secondAxis == Axis.X) {
      x = newY;
    }
    else if(secondAxis == Axis.Y) {
      y = newY;
    }
    else z = newY;
  }
}


