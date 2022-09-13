package h02;

import fopbot.Direction;
import fopbot.Robot;
import fopbot.World;

import java.sql.Array;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static fopbot.Direction.*;
import static fopbot.Direction.LEFT;

public class Main {
  public static final byte NUMBER_OF_STEPS_BETWEEN_REDUCTIONS = 10;

  public static int getRandomWorldSize() {
    return 4 + ThreadLocalRandom.current().nextInt(6);
  }

  // ---------------- DO NOT CHANGE ANYTHING ABOVE THIS LINE ---------------


  public static void main(String[] args) {
    int cols = 5;
    int rows = 5;
    World.setSize(cols, rows);
    World.setDelay(10);
    World.setVisible(true);
    System.out.println("Size of world: " + cols + "x" + rows);
    Robot [] allRobots = initializeRobots(cols, rows);
    int [] paces = initializePaces(allRobots);
    int numberOfSteps = 0;


    while(allRobots.length != 0) {
      numberOfSteps++;
      moveForward(allRobots, paces);

      if(allRobots.length >= 3 && paces.length >= 3) {
        int[] threeDistinctInts = generateThreeDistinctInts(allRobots);
        swapPaces(paces, threeDistinctInts[0], threeDistinctInts[1], threeDistinctInts[2]);
      }

      if(numberOfSteps % NUMBER_OF_STEPS_BETWEEN_REDUCTIONS == 0) {
          int deleteIndex = ThreadLocalRandom.current().nextInt(0, paces.length);
          allRobots = reduceRobots(allRobots, deleteIndex);
          paces = reducePaces(paces, deleteIndex);
      }
    }


  }

  /**
   * Initializes allRobots array for given World size.
   *
   * @param cols number of columns in World
   * @param rows number of rows in World
   * @return correctly initialized allRobots array (i.e. correct size, correct positions, correct directions)
   */
  public static Robot[] initializeRobots(int cols, int rows) {
    //bestimmt die Größe des allRobots Array
    int numberOfRobots;
    if(cols <= rows) {
      if(cols % 2 == 0) {
        numberOfRobots = cols;
      }
      else numberOfRobots = cols - 1;
    }
    else if(rows % 2 == 0) {
      numberOfRobots = rows;
    }
    else numberOfRobots =  rows - 1;
    Robot [] allRobots = new Robot[numberOfRobots];

    //füllt das Array mit Robotern
    for(int i = 0; i < allRobots.length / 2; i++) {
      allRobots[i] = new Robot(i, i, RIGHT, 1000);
    }
    for(int i = allRobots.length / 2 ; i < allRobots.length; i++) {
      allRobots[i] = new Robot(i, i, LEFT, 1000);
    }
    return allRobots;
  }

  /**
   * Initializes paces array for given allRobots array.
   * <p>
   * Assumes allRobots array was initialized correctly.
   * </p>
   *
   * @param allRobots previously initialized allRobots array
   * @return correctly initialized paces array (i.e. correct size, filled w/ random integers from [1...5])
   */
  public static int[] initializePaces(Robot[] allRobots) {
    int [] paces = new int[allRobots.length];
    for (int i = 0; i < paces.length; i++) {
      paces[i] = 1 + ThreadLocalRandom.current().nextInt(5);
    }
    return paces;
  }

  /**
   * Moves all robots from allRobots array corresponding to the number of steps to take for each robot (from paces).
   *
   * @param allRobots allRobots array from _main, contains all robots which should be moved by moveForward
   * @param paces     corresponding paces array to allRobots
   */
  public static void moveForward(Robot[] allRobots, int[] paces) {
    for(int i = 0; i < allRobots.length; i++) {
      for (int j = 0; j < paces[i]; j++) {
        while (!allRobots[i].isFrontClear()) {
          allRobots[i].turnLeft();
        }
        allRobots[i].move();
      }
    }
  }

  /**
   * Generates three distinct integers from index set of allRobots.
   *
   * @param allRobots allRobots array from main method
   * @return array containing three distinct integers as described above
   */
  public static int[] generateThreeDistinctInts(Robot[] allRobots) {
    int [] randomIndices = new int[3];
    for(int i = 0; i < 3; i++) {
      randomIndices[i] = ThreadLocalRandom.current().nextInt(allRobots.length);
    }

    while(randomIndices[1] == randomIndices[0]) {
      randomIndices[1] = ThreadLocalRandom.current().nextInt(allRobots.length);
    }
    while(randomIndices[2] == randomIndices[0] || randomIndices[2] == randomIndices[1]) {
      randomIndices[2] = ThreadLocalRandom.current().nextInt(allRobots.length);
    }

    return randomIndices;
  }

  /**
   * Returns an integer array of size 3, in which i1, i2 and i3 are sorted in ascending order.
   * <p>
   * Assumes that i1, i2 and i3 are distinct.
   * </p>
   *
   * @param i1 first number
   * @param i2 second number
   * @param i3 third number
   * @return sorted array of i1, i2, i3 in ascending order
   */
  public static int[] orderThreeInts(int i1, int i2, int i3) {
    int [] orderedArray = new int[3];
    orderedArray[0] = i1;
    orderedArray[1] = i2;
    orderedArray[2] = i3;

    if(orderedArray[0] > orderedArray[1]) {
      int tmp = orderedArray[0];
      orderedArray[0] = orderedArray[1];
      orderedArray[1] = tmp;
    }

    if(orderedArray[1] > orderedArray[2]) {
      int tmp = orderedArray[1];
      orderedArray[1] = orderedArray[2];
      orderedArray[2] = tmp;
    }

    if(orderedArray[0] > orderedArray[1]) {
      int tmp = orderedArray[0];
      orderedArray[0] = orderedArray[1];
      orderedArray[1] = tmp;
    }

    return orderedArray;
  }

  /**
   * Swaps entries from paces array as described in exercise sheet.
   * <p>
   * Assumes i1, i2 and i3 are three distinct indices from the index set of paces array.
   * Note that i1, i2 and i3 are not ordered.
   * </p>
   *
   * @param paces current paces array
   * @param i1    first index
   * @param i2    second index
   * @param i3    third index
   * @return paces array with identical entries as before, but in order as described in exercise sheet
   */
  public static int[] swapPaces(int[] paces, int i1, int i2, int i3) {
    int [] orderedInts = orderThreeInts(i1, i2, i3);
    int [] swappedPaces = orderThreeInts(paces[orderedInts[0]], paces[orderedInts[1]], paces[orderedInts[2]]);
    for(int i = 0; i < 3; i++) {
      paces[orderedInts[i]] = swappedPaces[i];
    }
    return paces;
  }

  /**
   * Reduces returns new array of robots which contains the same elements as allRobots, without the
   * robot at deleteIndex.
   * <p>
   * The new array's length is smaller by one compared to allRobots
   * </p>
   *
   * @param allRobots   allRobots array from _main
   * @param deleteIndex index at which the robot should be removed
   * @return reduced array (as described above)
   */
  public static Robot[] reduceRobots(Robot[] allRobots, int deleteIndex) {

    int j = 0;
    Robot[] newAllRobots = new Robot[allRobots.length - 1];
    for(int i = 0; i < allRobots.length; i++) {
      if(i == deleteIndex) {
        continue;
      }
      newAllRobots[j] = allRobots[i];
      j++;
    }
    return newAllRobots;

  }

  /**
   * Reduces returns new array of paces which contains the same elements as given paces array, without the
   * paces entry at deleteIndex.
   * <p>
   * The new array's length is smaller by one compared to given paces array
   * </p>
   *
   * @param paces       paces array from _main
   * @param deleteIndex index at which the paces entry should be removed
   * @return reduced array (as described above)
   */
  public static int[] reducePaces(int[] paces, int deleteIndex) {
    int j = 0;
    int[] newPaces = new int[paces.length - 1];
    for(int i = 0; i < paces.length; i++) {
      if(i == deleteIndex) {
        continue;
      }
      newPaces[j] = paces[i];
      j++;
    }
    return newPaces;
  }
}
