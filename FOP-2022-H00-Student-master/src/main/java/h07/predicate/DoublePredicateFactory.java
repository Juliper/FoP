package h07.predicate;

import java.util.function.DoublePredicate;

public class DoublePredicateFactory {

  /**
   * This method combines every element of the given array with .or() and returns a DoublePredicate containing these chained
   * condition. Also, it can chain from top to bottom or bottom to top depending on the bool(parameter) value
   * @param doublePredicate predicates that get chained
   * @param bool decides if elements get chained top to bottom or bottom to top
   * @return returns the predicate containing that chained condition
   */
  static public DoublePredicate buildDisjunction(DoublePredicate[] doublePredicate, boolean bool) {
    DoublePredicate predicate = doublePredicate[0];
    if(bool) {
      for(int i = 1; i < doublePredicate.length; i++) {
        predicate = predicate.or(doublePredicate[i]);
      }
    }else {
      for(int i = doublePredicate.length - 1; i >= 0; i--) {
        predicate = predicate.or(doublePredicate[i]);
      }
    }
    return predicate;
  }

  /**
   * This method recursively composes a new predicate with the given array of predicates.
   * @param doublePredicate used array
   * @return composed array
   */
  static public DoublePredicate buildConjunction(DoublePredicate[] doublePredicate) {
    DoublePredicate predicate;
    predicate = doRecursion(0, doublePredicate);
    return predicate;
  }

  /**
   * This method handles the recursive part.
   * @param index saves which index gets chained
   * @param doublePredicate array that delivers the needed elements
   * @return returns the composed predicate
   */
  static private DoublePredicate doRecursion(int index, DoublePredicate[] doublePredicate) {
    DoublePredicate returnPredicate;
    DoublePredicate x = doublePredicate[index];
    returnPredicate = x;
    if(index + 1 < doublePredicate.length) {
      returnPredicate = x.and(doRecursion(index + 1, doublePredicate));
    }
    return returnPredicate;
  }

  /**
   * This method creates a new predicate with the given array and returns it. The method calls buildDisjunction on every
   * singlearray of the mainarray and saves the returned predicate in a new array. Afterwards the buildConjunction() gets
   * called on the new array. The result gets returned.
   * @param doublePredicate Main array that gets chained
   * @return returns the new chained predicate
   */
  static public DoublePredicate buildComplexPredicate(DoublePredicate[][] doublePredicate) {
    DoublePredicate[] predicate = new DoublePredicate[doublePredicate.length];
    boolean switcher = true;
    for(int i = 0; i < doublePredicate.length; i++) {
      predicate[i] = buildDisjunction(doublePredicate[i], switcher);
      switcher = !switcher;
    }
    return buildConjunction(predicate);
  }

  /**
   * This method calls buildComplexPredicate() on an already defined mainarray. The mainarray contains 3 singlearrays.
   * @return returns a complexPredicate
   */
  static public DoublePredicate getDefaultComplexPredicate() {
    EpsilonEnvironmentPred[] array1 = new EpsilonEnvironmentPred[1000];
    for(int i = 0; i < array1.length; i++) {
      array1[i] = new EpsilonEnvironmentPred(i + 0.5, i/50000.0);
    }

    DoublePredicate[] array2 = new DoublePredicate[1000];
    for(int i = 1; i <= array2.length; i++) {
      int j = i;
      array2[1000 - i] = n -> Math.abs((1000 - j + 0.5) - n) <= (j/50000.0);
    }

    DoublePredicate[] array3 = new DoublePredicate[3];
    array3[0] = n -> !(n < (-20 * Math.PI)) && !(n > (10 * Math.E));
    array3[1] = n -> Math.sin(n) > Math.cos(n);
    array3[2] = n -> n < (Math.pow(Math.log(n), 3.0));

    DoublePredicate[][] array = {array1, array2, array3};

    return buildComplexPredicate(array);
  }

  /**
   * This method returns a predicate which is true when decimalPlease(parameter) decimals checksum of a given double
   * is divisible with the divisor(parameter).
   * @param decimalPlaces takes checksum of that number of decimals
   * @param divisor divides checksum
   * @return returns a predicate which is true when the checksum is divisible by the divisor
   */
  static public DoublePredicate getChecksumPredicate(int decimalPlaces, int divisor) {
    String[] decimal = new String[decimalPlaces];
    DoublePredicate test = (double n) ->
    {
      String numberString = String.valueOf(n).split("\\.")[1].concat("0".repeat((String.valueOf(n).split("\\.")[1].length() < decimalPlaces) ? (decimalPlaces - String.valueOf(n).split("\\.")[1].length()) : 0)).substring(0, decimalPlaces);
      char[] numberChar = new char[numberString.length()];
      for(int i = 0; i < numberChar.length; i++) {
        numberChar[i] = numberString.charAt(i);
      }
      int checksum = 0;
      for(int i = 0; i < numberChar.length; i++) {
        checksum = checksum + (numberChar[i] - 48);
      }
      return (checksum % divisor) == 0;
    };
    return test;
  }
}
