package h06;

public class Main {
  /**
   * This method creates 10 distinct prefix notations and test them. All even array test should return false and
   * all uneven true.
   * @param args idk
   */
  public static void main(String[] args) {
    char[] array = {'-', '1', '2'};
    char[] array2 = {'-', '1', '4'};
    char[] array3 = {'-', '-', '1', '2', '3'};
    char[] array4 = {'-', '-', '3', '4', '6'};
    char[] array5 = {'-', '-', '1', '2', '-', '4', '5'};
    char[] array6 = {'-', '-', '3', '4', '-', '4', '6'};
    char[] array7 = {'-', '-', '9', '4', '-', '-', '3', '7', '7'};
    char[] array8 = {'-', '-', '6', '3', '-', '-', '5', '8', '2'};
    char[] array9 = {'-', '-', '1', '6', '-', '-', '3', '4', '-', '9', '6'};
    char[] array10 = {'-', '-', '5', '5', '-', '-', '3', '5', '-', '3', '9'};
    System.out.println(StrangeThings.testEvaluate(array, -1));
    System.out.println(StrangeThings.testEvaluate(array2, 14));
    System.out.println(StrangeThings.testEvaluate(array3, -4));
    System.out.println(StrangeThings.testEvaluate(array4, 64));
    System.out.println(StrangeThings.testEvaluate(array5, 0));
    System.out.println(StrangeThings.testEvaluate(array6, -4));
    System.out.println(StrangeThings.testEvaluate(array7, 16));
    System.out.println(StrangeThings.testEvaluate(array8, -61));
    System.out.println(StrangeThings.testEvaluate(array9, -1));
    System.out.println(StrangeThings.testEvaluate(array10, 6));
  }
}
