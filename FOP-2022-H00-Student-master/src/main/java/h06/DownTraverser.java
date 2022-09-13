package h06;

public class DownTraverser implements Traverser{

  /**
   * This method accepts an int and returns the next Index. In this case the next int is parameter - 1.
   * @param lastIndex current index
   * @return next index
   */
  @Override
  public int getNextIndex(int lastIndex) {
    return lastIndex - 1;
  }

  /**
   * This method returns the first index. In this case the first index is the last index of the array.
   * @param array is the array the first index gets calculated for
   * @return returns the first index
   */
  @Override
  public int getFirstIndex(double[] array) {
    return array.length - 1;
  }
}
