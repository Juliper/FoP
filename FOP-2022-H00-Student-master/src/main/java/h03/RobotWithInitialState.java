package h03;

import fopbot.*;

import java.lang.reflect.Method;

public class RobotWithInitialState extends Robot {
  private final int initialX;
  private final int initialY;
  private final Direction initialDirection;
  private final int initialNumberOfCoins;

  /**
   * This is the constructor of RobotWithInitialState which uses the constructor of
   * robot and saves every parameter of it in the "initial*" attributes.
   * @param x is the column in which the robot spawns
   * @param y is the row in which the robot spawns
   * @param direction is the direction in which the robot looks at the beginning
   * @param numberOfCoins is the number of coins the robot starts with
   */
  public RobotWithInitialState(int x, int y, Direction direction, int numberOfCoins) {
    super(x,y, direction, numberOfCoins);
    initialX = x;
    initialY = y;
    initialDirection = direction;
    initialNumberOfCoins = numberOfCoins;
  }

  /**
   * This method returns the initial X-coordinate of the object.
   * @return returns the int value of initialX
   */
  public int getInitialX() {
    return initialX;
  }

  /**
   * This method returns the initial Y-coordinate of the object.
   * @return returns the int value of initialY
   */
  public int getInitialY() {
    return initialY;
  }

  /**
   * This method returns the initial Direction value of the object.
   * @return returns the Direction value of initialDirection
   */
  public Direction getInitialDirection() {
    return initialDirection;
  }

  /**
   * This method returns the initial int value of the object.
   * @return returns the int value of initialNumberOfCoins
   */
  public int getInitialNumberOfCoins() {
    return initialNumberOfCoins;
  }



  /**
   * This method returns the difference of the current x-value and the initialX value.
   * This difference represents the number of steps the robot has made in the x-direction relative to its initial
   * x-coordinate.
   * @return returns the difference of the current x-value and the initialX value
   */
  public int getRelativeX() {
    return getX() - initialX;
  }

  /**
   * This method changes the current x-coordinate to the sum of initialX and newRelativeX. If your input changes
   * the current x-coordinate to a coordinate which is out of the world the method calls the method crash().
   * @param newRelativeX is the new value getRelativeX() returns
   */
  public void setRelativeX(int newRelativeX){
    if(newRelativeX > Main.WORLD_SIZE_X) {
      crash();
    }
    else setX(initialX + newRelativeX);
  }

  /**
   * This method returns the difference of the current y-value and the initialY value.
   * This difference represents the number of steps the robot has made in the y-direction relative to its initial
   * y-coordinate.
   * @return returns the difference of the current y-value and the initialY value
   */
  public int getRelativeY() {
    return getY() - initialY;
  }

  /**
   * This method changes the current y-coordinate to the sum of initialY and newRelativeY. If your input changes
   * the current y-coordinate to a coordinate which is out of the world the method calls the method crash().
   * @param newRelativeY is the new value getRelativeY() returns
   */
  public void setRelativeY(int newRelativeY) {
    if(newRelativeY > Main.WORLD_SIZE_Y) {
      crash();
    }
    else setY(initialY + newRelativeY);
  }

  /**
   * This method returns a Direction value which value depends on the current direction. If the objects current
   * direction equals the initial direction the method returns Direction.UP.
   * If the difference of the initial direction and the current direction is one right turn the method returns
   * Direction.RIGHT.
   * If the difference of the initial direction and the current direction is two right turns the method returns
   * Direction.DOWN.
   * Else it returns Direction.LEFT.
   * @return returns the relativeDirection which depends on the current direction
   */
  public Direction getRelativeDirection() {
    if(getDirection() == initialDirection) {
      return Direction.UP;
    }
    else if ((getDirection() == Direction.RIGHT && initialDirection == Direction.UP) || (getDirection() == Direction.DOWN && initialDirection == Direction.RIGHT) || (getDirection() == Direction.LEFT && initialDirection == Direction.DOWN) || (getDirection() == Direction.UP && initialDirection == Direction.LEFT)) {
      return Direction.RIGHT;
    }
    else if ((getDirection() == Direction.DOWN && initialDirection == Direction.UP) || (getDirection() == Direction.LEFT && initialDirection == Direction.RIGHT) || (getDirection() == Direction.UP && initialDirection == Direction.DOWN) || (getDirection() == Direction.RIGHT && initialDirection == Direction.LEFT)) {
      return Direction.DOWN;
    }
    else return Direction.LEFT;
  }

  /**
   * This method turns the object until getRelativeDirection() == newRelativeDirection.
   * @param newRelativeDirection
   */
  public void setRelativeDirection(Direction newRelativeDirection) {
    while (!(getRelativeDirection() == newRelativeDirection)) {
      turnLeft();
    }
  }

  /**
   * This method returns the difference of the current number of coins and the initial number of coins.
   * @return returns the difference of the current number of coins and the initial number of coins
   */
  public int getRelativeNumberOfCoins() {
    return getNumberOfCoins() - initialNumberOfCoins;
  }

  /**
   * This method calls the method putCoin() until the current number of coins equals the sum of newRelativeNumberOfCoins
   * and initialNumberOfCoins.
   * @param newRelativeNumberOfCoins
   */
  public void setRelativeNumberOfCoins(int newRelativeNumberOfCoins) {
    if(newRelativeNumberOfCoins > getRelativeNumberOfCoins() || 0 > (initialNumberOfCoins + newRelativeNumberOfCoins)) {
      crash();
    }
    else {
      while (getNumberOfCoins() != (newRelativeNumberOfCoins + initialNumberOfCoins)) {
        putCoin();
      }
    }
  }
}
