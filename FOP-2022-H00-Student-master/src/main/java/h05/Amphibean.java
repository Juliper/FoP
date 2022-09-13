package h05;

public interface Amphibean extends Walking,Swimming {

  /**
   * This method returns the preferred environment type.
   * @return returns the environment type
   */
  public EnvironmentType getPreferredEnvironmentType();
}
