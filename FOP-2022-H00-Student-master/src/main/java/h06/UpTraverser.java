package h06;

public class UpTraverser implements Traverser{

  /**
   * This method returns the first index. This time 0.
   * @param array array the first index gets returned
   * @return returns 0
   */
  @Override
  public int getFirstIndex(double[] array) {
    return 0;
  }

  /**
   * This method returns the next Index. This time parameter + 1.
   * @param lastIndex current index
   * @return returns the next index
   */
  @Override
  public int getNextIndex(int lastIndex) {
    return lastIndex + 1;
  }
}
