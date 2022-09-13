package h07.person;
import java.util.function.IntBinaryOperator;

public class Traits {
  private final IntBinaryOperator op;
  private final int init;
  private final PersonToIntFunction fct;
  private final PersonFilter pred;
  private final IntBinaryOperator combine;

  /**
   * This method is the constructor of Traits an initializes all objectconstants.
   * @param op initial this.op
   * @param init initial this.init
   * @param fct initial this.fct
   * @param pred initial this.pred
   * @param combine initial this.combine
   */
  public Traits(IntBinaryOperator op, int init, PersonToIntFunction fct, PersonFilter pred, IntBinaryOperator combine) {
    this.op = op;
    this.init = init;
    this.fct = fct;
    this.pred = pred;
    this.combine = combine;
  }

  /**
   * This method returns the value of this.init.
   * @return this.init value
   */
  public int getInit() {
    return init;
  }

  /**
   * This method returns the value of this.op.
   * @return this.op value
   */
  public IntBinaryOperator getOp() {
    return op;
  }

  /**
   * This method returns the value of this.pred.
   * @return this.pred value
   */
  public PersonFilter getPred() {
    return pred;
  }

  /**
   * This method returns the value of this.fct.
   * @return this.fct value
   */
  public PersonToIntFunction getFct() {
    return fct;
  }

  /**
   * This method returns the value of this.pred.
   * @return this.combine value
   */
  public IntBinaryOperator getCombine() {
    return combine;
  }
}
