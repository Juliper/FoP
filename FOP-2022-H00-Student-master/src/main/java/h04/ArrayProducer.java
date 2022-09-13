package h04;

public interface ArrayProducer {
  /**
   * This method produces an array of RepetitiveRobotImpl with the size of its parameter.
   * @param arraySize is the size the produced array of RepetitiveRobotImpl will be
   * @return returns the produced array of RepetitiveRobotImp
   */
  RepetitiveRobotImpl[] produceArray1(int arraySize);

  /**
   * This method produces an array of FloorVector with the size of its parameter.
   * @param arraySize is the size the produced array of FloorVector will be
   * @return returns the produced array of FloorVector
   */
  FloorVector[] produceArray2(int arraySize);

  /**
   * This method accepts a RepetitiveRobotImpl array(array1) and a FloorVector array(array2) as parameter and combines
   * them.
   * @param array1 first array of RepetitiveRobotImpl that gets combined
   * @param array2 second array of FloorVector that gets combined
   * @return returns the combination of array1 and array2
   */
  WithNaturalCoordinates[] produceArray3(RepetitiveRobotImpl[] array1, FloorVector[] array2);

  /**
   * This method accepts an array of WithNaturalCoordinates and switches positions of even and uneven indices.
   * @param array is the array that gets switched
   * @return returns the switched array
   */
  WithNaturalCoordinates[] produceArray4(WithNaturalCoordinates[] array);
}
