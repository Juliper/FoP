package h07.person;

public class Person {
  private String lastName;
  private String firstName;
  private String street;
  private int houseNumber;
  private int postalCode;

  /**
   * This method is the constructor of Person. The method initializes every attribute with the according parameter.
   * @param lastName initial value of this.lastName
   * @param firstName initial value of this.firstName
   * @param street initial value of this.street
   * @param houseNumber initial value of this.houseNumber
   * @param postalCode initial value of this.postalCode
   */
  public Person(String lastName, String firstName, String street, int houseNumber, int postalCode) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.street = street;
    this.houseNumber = houseNumber;
    this.postalCode = postalCode;
  }

  /**
   * This method returns this.lastName.
   * @return returns this.lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * This method changes the value of this.lastName to its parameter.
   * @param lastName new this.lastName value
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * This method returns this.firstName.
   * @return returns this.firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * This method changes the value of this.firstName to its parameter.
   * @param firstName new this.lastName value
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * This method returns this.houseNumber.
   * @return returns this.houseNumber
   */
  public int getHouseNumber() {
    return houseNumber;
  }

  /**
   * This method changes the value of this.houseNumber to its parameter.
   * @param houseNumber new this.lastName value
   */
  public void setHouseNumber(int houseNumber) {
    this.houseNumber = houseNumber;
  }

  /**
   * This method returns this.postalCode.
   * @return returns this.postalCode
   */
  public int getPostalCode() {
    return postalCode;
  }

  /**
   * This method changes the value of this.postalCode to its parameter.
   * @param postalCode new this.lastName value
   */
  public void setPostalCode(int postalCode) {
    this.postalCode = postalCode;
  }
}
