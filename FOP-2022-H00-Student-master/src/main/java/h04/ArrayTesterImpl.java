package h04;

public class ArrayTesterImpl implements ArrayTester{

  /**
   * This method tests if every object put the right number of coins. Ever object should put i coins. i is the index of
   * the object.
   * @param array1 is the array of the type RepetitiveRobot which gets tested
   * @return returns true or false whether the test is successfully or not
   */
  public boolean test1(RepetitiveRobot[] array1) {
    for(int i = 0; i < array1.length; i++) {
      if(array1[i].getPutCoinRepetitions() != i) {
        return false;
      }
    }
    return true;
  }


  /**
   * This method tests if every object that gets referred by all even indices have the right {x,y}-coordinates and if
   * every object that gets referred by all uneven indices has the right {x,y}-coordinates. The x value of all even
   * indices should be 2 * j. j number of the even index(0 = 0, 2 = 1, 4 = 2,...). The {x,y} value of the uneven
   * indices should be (int)((3 * j) + 0.1),(int)((4 * j) + 0.2); (int)((4 * j) + 0.2),(int)((5 * j) + 0.3) or
   * (int)((5 * j) + 0.3),(int)((3 * j) + 0.1). j number of the uneven index(1 = 0, 3 = 1, 5 = 2,...).
   * @param array3 is the array of the type WithNaturalCoordinates which gets tested
   * @return returns true or false whether the test is successfully or not
   */
  public boolean test3(WithNaturalCoordinates[] array3) {
    Axis currentFirstAxis = Axis.X;
    int j = 0;
    for(int i = 0; i < array3.length; i++) {
      if(i % 2 == 0) {
        if((array3[i].getX() != 2 * j) || (array3[i].getY() != j)) {
          return false;
        }
      }
      else {
        if(currentFirstAxis == Axis.X && ((array3[i].getX() != (int)((3 * j) + 0.1)) || (array3[i].getY() != (int)((4 * j) + 0.2)))) {
          return false;
        }
        else if(currentFirstAxis == Axis.Y && ((array3[i].getX() != (int)((4 * j) + 0.2)) || (array3[i].getY() != (int)((5 * j) + 0.3)))) {
          return false;
        }
        else if(currentFirstAxis == Axis.Z && ((array3[i].getX() != (int)((5 * j) + 0.3)) || (array3[i].getY() != (int)((3 * j) + 0.1)))) {
          return false;
        }
        if(currentFirstAxis == Axis.X) {
          currentFirstAxis = Axis.Y;
        }
        else if(currentFirstAxis == Axis.Y) {
          currentFirstAxis = Axis.Z;
        }
        else {
          currentFirstAxis = Axis.X;
        }
        j++;
      }
    }
    return true;
  }

  /**
   * This method tests if every object that gets referred by all even indices have the right {x,y}-coordinates and if
   * every object that gets referred by all uneven indices has the right {x,y}-coordinates. The x value of all uneven
   * indices should be 2 * j. j number of the uneven index(1 = 0, 3 = 1, 5 = 2,...). The {x,y} value of the even
   * indices should be (int)((3 * j) + 0.1),(int)((4 * j) + 0.2); (int)((4 * j) + 0.2),(int)((5 * j) + 0.3) or
   * (int)((5 * j) + 0.3),(int)((3 * j) + 0.1). j number of the even index(0 = 0, 2 = 1, 4 = 2,...).
   * @param array4 is the array of the type WithNaturalCoordinates which gets tested
   * @return returns true or false whether the test is successfully or not
   */
  public boolean test4(WithNaturalCoordinates[] array4) {
    Axis currentFirstAxis = Axis.X;
    int j = 0;
    for(int i = 0; i < array4.length; i++) {
      if(i % 2 == 0) {
        if(currentFirstAxis == Axis.X && ((array4[i].getX() != (int)((3 * j) + 0.1)) || (array4[i].getY() != (int)((4 * j) + 0.2)))) {
          return false;
        }
        else if(currentFirstAxis == Axis.Y && ((array4[i].getX() != (int)((4 * j) + 0.2)) || (array4[i].getY() != (int)((5 * j) + 0.3)))) {
          return false;
        }
        else if(currentFirstAxis == Axis.Z && ((array4[i].getX() != (int)((5 * j) + 0.3)) || (array4[i].getY() != (int)((3 * j) + 0.1)))) {
          return false;
        }
        if(currentFirstAxis == Axis.X) {
          currentFirstAxis = Axis.Y;
        }
        else if(currentFirstAxis == Axis.Y) {
          currentFirstAxis = Axis.Z;
        }
        else {
          currentFirstAxis = Axis.X;
        }
      }
      else {
        if((array4[i].getX() != 2 * j) || (array4[i].getY() != j)) {
          return false;
        }
        j++;
      }
    }
    return true;
  }


}
