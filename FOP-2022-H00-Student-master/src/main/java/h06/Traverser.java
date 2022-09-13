package h06;

public interface Traverser {
  /**
   * This method returns the first index depending on the used traverser.
   * @param array calculates the first index for that array depending on the used traverser
   * @return returns the first index depending on the used traverser
   */
  int getFirstIndex(double[] array);

  /**
   * This method returns the next index depending on the used traverser.
   * @param lastIndex is the current index
   * @return returns the next index after lastIndex
   */
  int getNextIndex(int lastIndex);
}
