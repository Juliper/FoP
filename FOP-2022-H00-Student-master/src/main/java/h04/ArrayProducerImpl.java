package h04;

public class ArrayProducerImpl implements ArrayProducer {

  /**
   * This method implements the produceArray1 method of the ArrayProducer interface. The method accepts an int
   * parameter which determines the size of the produced array. Every index of the array has a reference to a
   * new RepetitiveRobotImpl Object. Every object of this array has the x-coordinate = 2i and the y-coordinate = i
   * (i is the index of the object in the array).
   * @param arraySize is the size the produced array of RepetitiveRobotImpl will be
   * @return returns the produced array
   */
  public RepetitiveRobotImpl[] produceArray1(int arraySize) {
    RepetitiveRobotImpl[] repetitiveRobots = new RepetitiveRobotImpl[arraySize];
    for(int i = 0; i < arraySize; i++) {
      repetitiveRobots[i] = new RepetitiveRobotImpl(0);
      repetitiveRobots[i].setX(2 * i);
      repetitiveRobots[i].setY(i);
      repetitiveRobots[i].putCoin(i);
    }
    return repetitiveRobots;
  }

  /**
   * This method implements the produceArray2 method of the ArrayProducer interface. The method accepts an int
   * parameter which determines the size of the produced array. Every index of the array gets a reference to a
   * floorVector object. Said object of floorVector gets initialized with x = 3i + 0.1, y = 4i +0.2, z = 5i + 0.3. Also,
   * the Attributes firstAxis and secondAxis of this object gets initialized. For the object that gets referred with
   * floorVectors[0] the first Axis is X. For the next index its Y and for the next index its Z. firstAxis starts by X
   * and cycles through X,Y,Z. Same with secondAxis. SecondAxis starts by Y and cycles through Y,Z,X. The method returns
   * the produced array.
   * @param arraySize is the size the produced array of FloorVector will be
   * @return returns the produces array of FloorVector objects.
   */
  public FloorVector[] produceArray2(int arraySize) {
    FloorVector[] floorVectors = new FloorVector[arraySize];
    for(int i = 0; i < arraySize; i++) {
      floorVectors[i] = new FloorVector(3 * i + 0.1);
      floorVectors[i].setRealY(4 * i + 0.2);
      floorVectors[i].setRealZ(5 * i + 0.3);
      if(i == 0) {
        floorVectors[0].setFirstAxis(Axis.X);
        floorVectors[0].setSecondAxis(Axis.Y);
        continue;
      }
      if((floorVectors[i - 1].getFirstAxis() == Axis.X) && (floorVectors[i - 1].getSecondAxis() == Axis.Y)) {
        floorVectors[i].setFirstAxis(Axis.Y);
        floorVectors[i].setSecondAxis(Axis.Z);
      }
      else if((floorVectors[i - 1].getFirstAxis() == Axis.Y) && (floorVectors[i - 1].getSecondAxis() == Axis.Z)) {
        floorVectors[i].setFirstAxis(Axis.Z);
        floorVectors[i].setSecondAxis(Axis.X);
      }
      else if((floorVectors[i - 1].getFirstAxis() == Axis.Z) && (floorVectors[i - 1].getSecondAxis() == Axis.X)){
        floorVectors[i].setFirstAxis(Axis.X);
        floorVectors[i].setSecondAxis(Axis.Y);
      }
    }
    return floorVectors;
  }

  /**
   * This method implements the produceArray3 method of the ArrayProducer interface. It accepts a
   * RepetitiveRobot array(array1) and a FloorVector array(array2). The method combines both arrays in a new
   * WithNaturalCoordinates array(array3) which is double the length of array1. The objects of array1 get
   * chronologically referred by the even indices of array3. The objects of array2 get chronologically referred by the
   * uneven indices of array3. The method returns the new created array(array3).
   * @param array1 first array of RepetitiveRobotImpl that gets combined
   * @param array2 second array of FloorVector that gets combined
   * @return returns the combination of array1 and array2
   */
  public WithNaturalCoordinates[] produceArray3(RepetitiveRobotImpl[] array1, FloorVector[] array2) {
    WithNaturalCoordinates[] array3 = new WithNaturalCoordinates[2 * array1.length];
    for(int i = 0; i < array1.length; i++) {
      array3[2 * i] = array1[i];
      array3[2 * i + 1] = array2[i];
    }
    return array3;
  }

  /**
   * This method implements the produceArray4 method of the ArrayProducer interface. It accepts a WithNaturalCoordinates
   * array(array) and switches the referenced objects for all even and uneven indices and assigns them to a new
   * WithNaturalCoordinates array(array4). array4[0] = array[1], array4[1] = array[0], array4[2] = array[3],
   * array4[3] = array[2]... It takes a pair of two and switches them.
   * @param array is the array that gets switched
   * @return returns the switches array
   */
  public WithNaturalCoordinates[] produceArray4(WithNaturalCoordinates[] array) {
    WithNaturalCoordinates[] array4 = new WithNaturalCoordinates[array.length];
    for(int i = 0; i < (array.length/2); i++) {
      array4[2 * i] = array[2 * i + 1];
      array4[2 * i + 1] = array[2 * i];
    }
    return array4;
  }
}
