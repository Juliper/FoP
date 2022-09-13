package h04;

import fopbot.Direction;
import fopbot.Robot;

public class RepetitiveRobotImpl extends Robot implements WithNaturalCoordinates, RepetitiveRobot {
  private int moveRepetitions = 0;
  private int turnLeftRepetitions = 0;
  private int putCoinRepetitions = 0;
  private int pickCoinRepetitions = 0;

  /**
   * This is the constructor of RepetitiveRobotImpl. The constructor accepts an int parameter which is the number of
   * coins a new created object of the type RepetitiveRobotImpl puts down. Every new object of the type
   * RepetitiveRobotImpl is initialized with the coordinates 0,0 and the direction UP and with 100 Coins.
   * @param numberOfCoinsToPut is the number of coins a new RepetitiveRobotImpl puts down
   */
  public RepetitiveRobotImpl(int numberOfCoinsToPut) {
    super(0,0, Direction.UP, 100);
    putCoin(numberOfCoinsToPut);
  }

  /**
   * This method calls the method move() numberOfSteps times and counts up the value of moveRepetitions for everytime
   * the  method move() is called. When the value of numberOfSteps is negative the method crash() is called.
   * @param numberOfSteps is the amount of steps the robot does
   */
  public void move(int numberOfSteps) {
    if(numberOfSteps >= 0) {
      for(int i = 0; i < numberOfSteps; i++) {
        move();
      }
    } else crash();
  }

  /**
   * This method calls the move() method of Robot and counts moveRepetitions up.
   */
  public void move() {
    super.move();
    moveRepetitions++;
  }

  /**
   * This method calls the method turnLeft() numberOfTurns times and counts up the value of turnLeftRepetitions for
   * everytime the  method turnLeft() is called. When the value of numberOfTurns is negative the method crash() is
   * called.
   * @param numberOfTurns is the amount of turns the robot does
   */
  public void turnLeft(int numberOfTurns)  {
    if(numberOfTurns >= 0) {
      for(int i = 0; i < numberOfTurns; i++) {
        turnLeft();
      }
    } else crash();
  }

  /**
   * This method calls the turnLeft() method of Robot and counts turnLeftRepetitions up.
   */
  public void turnLeft() {
    super.turnLeft();
    turnLeftRepetitions++;
  }

  /**
   * This method calls the method putCoin() numberOfCoins times and counts up the value of putCoinRepetitions for
   * everytime the  method putCoin() is called. When the value of numberOfCoins is negative the method crash() is
   * called.
   * @param numberOfCoins is the amount of coins the robot puts down
   */
  public void putCoin(int numberOfCoins) {
    if(numberOfCoins >= 0) {
      for(int i = 0; i < numberOfCoins; i++) {
        putCoin();
      }
    } else crash();
  }

  /**
   * This method calls the putCoin() method of Robot and counts putCoinRepetitions up.
   */
  public void putCoin() {
    super.putCoin();
    putCoinRepetitions++;
  }

  /**
   * This method calls the method pickCoin() numberOfCoins times and counts up the value of pickCoinRepetitions for
   * everytime the  method pickCoin() is called. When the value of numberOfCoins is negative the method crash() is
   * called.
   * @param numberOfCoins is the amount of coins the robot picks up
   */
  public void pickCoin(int numberOfCoins) {
    if(numberOfCoins >= 0) {
      for(int i = 0; i < numberOfCoins; i++) {
        pickCoin();
      }
    } else crash();
  }

  /**
   * This method calls the pickCoin() method of Robot and counts pickCoinRepetitions up.
   */
  public void pickCoin() {
    super.pickCoin();
    pickCoinRepetitions++;
  }

  /**
   * This method returns the number of times move() was called.
   * @return returns the current value of moveRepetitions;
   */
  public int getMoveRepetitions() {
    return moveRepetitions;
  }

  /**
   * This method returns the number of times turnLeft() was called.
   * @return returns the current value of turnLeftRepetitions;
   */
  public int getTurnLeftRepetitions() {
    return turnLeftRepetitions;
  }

  /**
   * This method returns the number of times putCoin() was called.
   * @return returns the current value of putCoinRepetitions;
   */
  public int getPutCoinRepetitions() {
    return putCoinRepetitions;
  }

  /**
   * This method returns the number of times pickCoin() was called.
   * @return returns the current value of pickCoinRepetitions;
   */
  public int getPickCoinRepetitions() {
    return pickCoinRepetitions;
  }

  /**
   * This method sets the value of x to the amount of its parameter.
   * @param newX is the new value of x
   */
  public void setX(int newX) {
    if(newX >= 0) {
      super.setX(newX);
    }
    else super.setX(-newX);
  }

  /**
   * This method sets the value of y to the amount of its parameter.
   * @param newY is the new value of y
   */
  public void setY(int newY) {
    if(newY >= 0) {
      super.setY(newY);
    }
    else super.setY(-newY);
  }
}
