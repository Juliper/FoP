package h04;

public interface RepetitiveRobot {

  /**
   * This method executes move() numberOfSteps times.
   * @param numberOfSteps is the amount of steps the robot does
   */
  void move(int numberOfSteps);

  /**
   * This method executes turnLeft() numberOfTurns times.
   * @param numberOfTurns is the amount of turns the robot does
   */
  void turnLeft(int numberOfTurns);

  /**
   * This method executes putCoin() numberOfCoins times.
   * @param numberOfCoins is the amount of coins the robot puts down
   */
  void putCoin(int numberOfCoins);

  /**
   * This method executes pickCoin() numberOfCoins times.
   * @param numberOfCoins is the amount of coins the robot picks up
   */
  void pickCoin(int numberOfCoins);

  /**
   * This method returns the number of times the move() method has been called.
   * @return returns the value of moveRepetitions
   */
  int getMoveRepetitions();

  /**
   * This method returns the number of times the turnLeft() method has been called.
   * @return returns the value of turnLeftRepetitions
   */
  int getTurnLeftRepetitions();

  /**
   * This method returns the number of times the putCoin() method has been called.
   * @return returns the value of putCoinRepetitions
   */
  int getPutCoinRepetitions();

  /**
   * This method returns the number of times the pickCoin() method has been called.
   * @return returns the value of pickCoinRepetitions
   */
  int getPickCoinRepetitions();
}
