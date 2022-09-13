package h01;

import fopbot.Direction;
import fopbot.Robot;

import java.util.concurrent.ThreadLocalRandom;

import static fopbot.Direction.*;

public class RookAndBishop {
  private final int NUMBER_OF_ROWS;
  private final int NUMBER_OF_COLUMNS;
  private final int nextFrameDelay;
  private final boolean uiVisible;

  public RookAndBishop(int rows, int columns, int nextFrameDelay, boolean uiVisible) {
    this.nextFrameDelay = nextFrameDelay;
    this.uiVisible = uiVisible;
    this.NUMBER_OF_ROWS = rows > 0 ? rows : Task1.readProperty("NUMBER_OF_ROWS", Task1.TO_INTEGER);
    this.NUMBER_OF_COLUMNS = columns > 0 ? columns : Task1.readProperty("NUMBER_OF_COLUMNS", Task1.TO_INTEGER);
  }

  public RookAndBishop(int nextFrameDelay, boolean uiVisible) {
    this(-1, -1, nextFrameDelay, uiVisible);
  }

  public RookAndBishop() {
    this(20, true);
  }

  public void execute() {
    Task1.initializeTask(NUMBER_OF_ROWS, NUMBER_OF_COLUMNS, nextFrameDelay, uiVisible);
    int numberOfCoins = ThreadLocalRandom.current().nextInt(12, 20);

    Robot rook = new Robot(randomColumn(), randomRow(), randomDirection(),numberOfCoins);
    Robot bishop = new Robot(randomColumn(), randomRow(), randomDirection(),0);

    while(true) {
      rookMovement(rook);
      bishopMovement(rook, bishop);
      //beendet Schleife wenn rook keine Münzen mehr hat oder rook und bishop zusammen sind
      if(!rook.hasAnyCoins()){
        System.out.println( "Der Turm hat gewonnen!");
        break;
      }
      else if(rook.getY() == bishop.getY() && rook.getX() == bishop.getX()) {
        System.out.println( "Der Läufer hat gewonnen!");
        break;
      }
    }
  }

  /**
   * Exercise 3.1 of H01
   */
  private void rookMovement(Robot rook) {
        rook.putCoin();
        //Wenn Rook am Abgrund steht
        if (isNearAbyss(rook)) {
          int randomFour = ThreadLocalRandom.current().nextInt(0, 3);
          if (randomFour == 0 || randomFour == 1) {
            turnAround(rook);
          }
          else if (randomFour == 2) {
            rook.turnLeft();
          }
          else if (randomFour == 3) {
            turnRight(rook);
          }
        }
        //Wenn rook nicht am abgrund steht
        else {
          rook.move();
          int randomFour = ThreadLocalRandom.current().nextInt(0, 3);
          if (randomFour == 0) {
            rook.turnLeft();
          }
          else if(randomFour == 1) {
            turnRight(rook);
          }
        }

  }

  /**
   * Exercise 3.2 of H01
   */
  private void bishopMovement(Robot rook, Robot bishop) {
      boolean notFinished = true;
      //Wenn bishop am Abgrund steht beende bishopschleife
      while(notFinished) {
        if (isNearAbyss(bishop)) {
          bishop.turnLeft();
          notFinished = false;
        }
        //Wenn bishop nicht am Abgrund steht
        else {
          bishop.move();
          bishop.turnLeft();
          //wenn bishop am abgrund beende bishopschleife
          if (isNearAbyss(bishop)) {
            turnAround(bishop);
            notFinished = false;
          } else {
            bishop.move();
            turnRight(bishop);
          }
        }
        //beendet Schleife wenn rook und bishop zusammen oder bishop eine Münze aufheben kann
        if (rook.getY() == bishop.getY() && rook.getX() == bishop.getX()) {
          notFinished = false;
        } else if (bishop.isNextToACoin()) {
          bishop.pickCoin();
          notFinished = false;
        }
      }
  }
    //Überprüft ob Roboter in Richtung und an Abgrund steht. Die Roboter und die Wild benutzen unterschiedliche systeme was die Postionen angeht deshalb -1.

  private boolean isNearAbyss(Robot x) {
    return x.getDirection() == UP && x.getY() == NUMBER_OF_ROWS - 1 || x.getDirection() == RIGHT && x.getX() ==
      NUMBER_OF_COLUMNS - 1 || x.getDirection() == DOWN && x.getY() == 0 || x.getDirection() == LEFT && x.getX() == 0;
  }
    //zufällige Richtung
  private Direction randomDirection() {
    int randomFour = ThreadLocalRandom.current().nextInt(0, 3);
    if(randomFour == 0) {
      return UP;
    }
    else if (randomFour == 1) {
      return RIGHT;
    }
    else if (randomFour == 2) {
      return  DOWN;
    }
    else return LEFT;
  }
  //gibt einen zufälligen x Wert der auf der Karte ist
  private Integer randomColumn() {
    return ThreadLocalRandom.current().nextInt(0, NUMBER_OF_COLUMNS);
  }
  //gibt einen zufälligen y Wert der auf der Karte ist
  private Integer randomRow() {
    return ThreadLocalRandom.current().nextInt(0, NUMBER_OF_ROWS);
  }

  private void turnRight(Robot x) {
    x.turnLeft();
    x.turnLeft();
    x.turnLeft();
  }

  private void turnAround(Robot x) {
    x.turnLeft();
    x.turnLeft();
  }
}
