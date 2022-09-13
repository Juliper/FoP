package h03;

import fopbot.*;

public class TwinRobots {
  private Robot twin1;
  private Robot twin2;
  private boolean firstTwinIsCurrent;

  /**
   * This is the constructor of TwinRobots. It initializes two objects of the class Robot with the names twin1 and twin2.
   * It also initializes the boolean variable firstTwinIsCurrent with true.
   */
  public TwinRobots(){
    twin1 = new Robot(0,0,Direction.UP,0);
    twin2 = new Robot(1,1,Direction.RIGHT,0);
    firstTwinIsCurrent = true;
  }

  /**
   * This method changes the value of firstTwinIsCurrent to the opposite value.
   */
  public void toggleCurrentRobot() {
    firstTwinIsCurrent = !firstTwinIsCurrent;
  }

  /**
   * This method returns twin1 when the value of firstTwinCurrent is true and returns twin 2 when the value of
   * firstTwinCurrent is false.
   * @return returns twin1 or twin2
   */
  public Robot getCurrentRobot() {
    if(firstTwinIsCurrent) {
      return twin1;
    } else return twin2;
  }
}
