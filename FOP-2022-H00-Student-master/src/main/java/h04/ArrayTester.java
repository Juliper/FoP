package h04;

public interface ArrayTester {
  /**
   * This method accepts as paramter a ArrayProducer obejct(producer) and an int that determines the size of the
   * arrays(arraySize). The method creates four variables(producesArray1, producesArray2, producesArray3, producesArray4)
   * and assignes the value of producer.produceArray1(arraySize), producer.produceArray2(arraySize),
   * producer.produceArray3(producedArray1, producedArray2), producer.produceArray4(producedArray3) to them. Afterward
   * it determines if all three test methods(test1, test3, test4) are true. If so it returns true otherwise false.
   * @param producer is the onject of ArrayProducer that prodcuces every array
   * @param arraySize determines the size of producedArray1 and producedArray2
   * @return returns the result of allTest(true if all tests return true)
   */
  default boolean testAll(ArrayProducer producer, int arraySize){
    RepetitiveRobotImpl[] producedArray1 = producer.produceArray1(arraySize);
    FloorVector[] producedArray2 = producer.produceArray2(arraySize);
    WithNaturalCoordinates[] producedArray3 = producer.produceArray3(producedArray1, producedArray2);
    WithNaturalCoordinates[] producedArray4 = producer.produceArray4(producedArray3);
    return test1(producedArray1) && test3(producedArray3)  && test4(producedArray4);
  }

  /**
   * Tests if each object of the array put the right amount of coins(RepetitionOfPutCoins = i).
   * @param array1 is the array of the type RepetitiveRobot which gets tested
   * @return returns true if the test was successfully and otherwise false
   */
  boolean test1(RepetitiveRobot[] array1);

  /**
   * Tests if the attributes of each object are right
   * @param array3 is the array of the type WithNaturalCoordinates which gets tested
   * @return returns true if the test was successfully and otherwise false
   */
  boolean test3(WithNaturalCoordinates[] array3);
  /**
   * Tests if the attributes of each object are right
   * @param array4 is the array which gets tested
   * @return returns true if the test was successfully and otherwise false
   */
  boolean test4(WithNaturalCoordinates[] array4);
}
