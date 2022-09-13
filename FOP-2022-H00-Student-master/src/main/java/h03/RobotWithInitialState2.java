package h03;

import fopbot.*;

public class RobotWithInitialState2 extends RobotWithInitialState{

  private int relativeNumberOfCoins;

  /**
   * This is the constructor of RobotWithInitialState2 which uses the constructor of
   * RobotWithInitialState and initializes relativeNumberOfCoins with 0.
   * @param x is the column in which the robot spawns
   * @param y is the row in which the robot spawns
   * @param direction is the direction in which the robot looks at the beginning
   * @param numberOfCoins is the number of coins the robot starts with
   */
  public RobotWithInitialState2(int x, int y, Direction direction, int numberOfCoins) {
    super(x,y, direction, numberOfCoins);
    relativeNumberOfCoins = 0;
  }

  /**
   * This method subtracts 1 from relativeNumberOfCoins.
   */
  public void putCoin() {
    super.putCoin();
    relativeNumberOfCoins -= 1;
  }

  /**
   * This method adds 1 to relativeNumberOfCoins.
   */
  public void pickCoin() {
    super.pickCoin();
    relativeNumberOfCoins += 1;
  }

  /**
   * This method returns the value of relativeNumberOfCoins.
   * @return returns the value of relativeNumberOfCoins
   */
  public int getRelativeNumberOfCoins(){
    return relativeNumberOfCoins;
  }
}
