package h06;

public class StrangeThings {

  /**
   * This method returns 1 when strange value is greater equal 0 otherwise it returns "1 + (computeStrangeValue(strangeValue - 1)"
   * when strangeValue is even otherwise it returns 1 + (computeStrangeValue(strangeValue - 3).
   * @param strangeValue is the in that gets computed
   * @return the computed value
   */
  static public int computeStrangeValue(int strangeValue) {
    return (strangeValue <= 0) ? 1 : ((0 == strangeValue % 2) ? (1 + (computeStrangeValue(strangeValue - 1))):(1 + (computeStrangeValue(strangeValue - 3))));
  }

  /**
   * This method returns 1 when strange value is greater equal 0 otherwise it returns "1 + (computeStrangeValue(strangeValue - 1)"
   * when strangeValue is even otherwise it returns 1 + (computeStrangeValue(strangeValue - 3).
   * @param strangeValue is the in that gets computed
   * @return the computed value
   */
  static public int computeStrangeValue2(int strangeValue) {
    int returnStrangeValue;
    if(strangeValue <= 0) {
      return 1;
    }else {
      if(0 == strangeValue % 2) {
        return (1 + computeStrangeValue2(strangeValue - 1));
      }else return (1 + (computeStrangeValue2(strangeValue - 3)));
    }
  }

  /**
   * This method returns 0 when m <= 0 or n <= 0 else if m < n it returns whatTheHellIsThat1(1 + m, n - m) else it returns
   * whatTheHellIsThat1(1 + n, m - n)
   * @param m is the first value that gets computed
   * @param n is the second value that gets computed
   * @return returns the computed value
   */
  static public int whatTheHellIsThat1(int m, int n) {
    return ((m <= 0) || (n <= 0)) ? 0 : ((m < n) ? (whatTheHellIsThat1(1 + m, n - m)) : (whatTheHellIsThat1(1 + n, m - n)));
  }

  /**
   * This method returns 0 when m <= 0 or n <= 0 else if m < n it returns whatTheHellIsThat1(1 + m, n - m) else it returns
   * whatTheHellIsThat1(1 + n, m - n).
   * @param m is the first value that gets computed
   * @param n is the second value that gets computed
   * @return returns the computed value
   */
  static public int whatTheHellIsThat2(int m, int n) {
    if((m <= 0) || (n <= 0)) {
      return 0;
    }else {
      if(m < n ) {
        return (whatTheHellIsThat1(1 + m, n - m));
      }else return (whatTheHellIsThat1(1 + n, m - n));
    }
  }

  /**
   * This method fills a new array from top or bottem(depends on the Traverser parameter) with 3.14 + 2 * array[i]
   * (array[i] is another array that contains values)
   * @param array is the value that gets transformed
   * @param traverser decides whether the array gets filled from top ot bottom
   * @return returns the new array
   */
  static public double[] transformArrayIteratively(double[] array, Traverser traverser) {
    double[] newArray = new double[array.length];
    if(array.length == 0) {
      return null;
    }else {
      int currentIndex = traverser.getFirstIndex(array);
      for(int i = 0; i < array.length; i++) {
        newArray[currentIndex] = 3.14 + 2 * array[i];
        currentIndex = traverser.getNextIndex(currentIndex);
      }
    }
    return newArray;
  }

  /**
   * This method fills a new array from top or bottem(depends on the Traverser parameter) with 3.14 + 2 * array[i]
   * (array[i] is another array that contains values)
   * @param array is the value that gets transformed
   * @param traverser decides whether the array gets filled from top ot bottom
   * @return returns the new array
   */
  static public double[] transformArrayRecursively(double[] array, Traverser traverser) {
    double[] newArray = new double[array.length];
    doTheRecursion(array, newArray, traverser, traverser.getFirstIndex(array));
    return newArray;
  }

  /**
   * This method handles the recursion of transformArrayRecursively().
   * @param array1 array that gets transformed
   * @param array2 new array
   * @param traverser decides whether the array gets filled from top ot bottom
   * @param index current index that gets transformed
   */
  static private void doTheRecursion(double[] array1, double[] array2, Traverser traverser, int index) {
    if(index < array1.length && index >= 0) {
      if(traverser instanceof UpTraverser) {
        array2[index] = 3.14 + 2 * array1[index];
        doTheRecursion(array1, array2, traverser, traverser.getNextIndex(index));
      }
      else if(traverser instanceof  DownTraverser) {
        array2[index] = 3.14 + 2 * array1[(array1.length - 1) - index];
        doTheRecursion(array1, array2, traverser, traverser.getNextIndex(index));
      }
    }
  }

  /**
   * This method evaluates prefix expressions that only contains subtractions of two values.
   * @param x array of characters that gets evaluated
   * @return returns the result
   */
  static public int evaluate(char[] x) {
    return evaluateRecursively(x, 0).result;
  }

  /**
   * This method handles the recursion part of evaluate(). If the array value at the start Index is this method returns
   * a returnData objective with the array value and the next Index(startIndex + 1). Otherwise, it calls itself for the
   * next two Indices and returns a returnData object that contains the difference of the next two array values and the
   * object also contains the next index which is the index after the subtrahend.
   * @param array contains the prefix notation expression
   * @param startIndex current index
   * @return returns a returnData object
   */
  static private ReturnData evaluateRecursively(char[] array, int startIndex) {
    ReturnData returnData = new ReturnData();
      if(array[startIndex] >= '0' && array[startIndex] <= '9') {
        returnData.result = array[startIndex] - 48;
        returnData.nextInt = startIndex + 1;
      }
      else{
        ReturnData x = evaluateRecursively(array,startIndex + 1);
        ReturnData y = evaluateRecursively(array,x.nextInt);
        returnData.result = x.result - y.result;
        returnData.nextInt = y.nextInt;
      }
    return returnData;
  }

  /**
   * This method test the evaluate() method
   * @param array contains the prefix notation expression
   * @param number correct result
   * @return true if the evaluated result equals the correct result
   */
  static public boolean testEvaluate(char[] array, int number) {
    return evaluate(array) == number;
  }
}
