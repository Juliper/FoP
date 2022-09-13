package h07.predicate;

import java.util.function.DoublePredicate;

public class EpsilonEnvironmentPred implements DoublePredicate {
  private final double x0;
  private final double epsilon;

  /**
   * This method ist the constructor of EpsilonEnvironmentPred and initializes the objectconstant with its parameters
   * @param x0 initial value of this.x0
   * @param epsilon initial value of this.epsilon
   */
  public EpsilonEnvironmentPred(double x0, double epsilon) {
    this.x0 = x0;
    this.epsilon = (epsilon < 0) ? 0 : epsilon;
  }

  /**
   * This method overrides the method test() of DoublePredicate. When the difference of value(parameter) and this.x0 is
   * smaller or equal this.epsilon this method returns true otherwise false.
   * @param value value that gets tested
   * @return true if the difference of value and this.xon is smaller or equal this.epsilon
   */
  @Override
  public boolean test(double value) {
    return Math.abs(this.x0 - value) <= this.epsilon;
  }
}
