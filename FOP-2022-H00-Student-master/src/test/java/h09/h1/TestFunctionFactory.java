package h09.h1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class TestFunctionFactory {

    /**
     * This method tests createFunctionWithFilterMapAndFold.
     */
    @Test
    public void testCreateFunctionWithFilterMapAndFold1() {
        assertEquals(0, FunctionFactory.createFunctionWithFilterMapAndFold(new Traits<Integer, Integer, Integer>(
            integer -> integer > 10,
            integer -> integer * 3,
            (i1, i2) -> (i1 + i2) % 100,
            0
        )).apply(new Integer[]{1, 2, 3, 4, 5, 6}));
    }

    /**
     * This method tests createFunctionWithFilterMapAndFold.
     */
    @Test
    public void testCreateFunctionWithFilterMapAndFold2() {
        Traits<String, Integer, Boolean> traits = new Traits<String, Integer, Boolean>(
            string -> (Character.toUpperCase(string.replaceAll(" ", "").toLowerCase().charAt(0)) + string.replaceAll(" ", "").toLowerCase().substring(1)).equals(string.replaceAll(" ", "")),
            string -> string.replaceAll(" ", "").length(),
            (bool, integer) -> bool && (integer <= 3),
            true
        );
        FunctionWithFilterMapAndFold<String, Integer, Boolean> function = FunctionFactory.createFunctionWithFilterMapAndFold(traits);
        String[] strings = {"Hal", "Hal", "Hal", "Hal"};
        Boolean applyValue = function.apply(strings);
        assertEquals(applyValue ,  true);
    }

    /**
     * This method tests createFunctionWithFilterMapFoldAndCombine.
     */
    @Test
    public void testCreateFunctionWithFilterMapFoldAndCombine() {
        Traits<Person, Integer, Integer> traits = new Traits<Person, Integer, Integer>(
            Person::isPostalCodeValid,
            Person::getPostalCode,
            Integer::sum,
            0,
            Person::distanceBetweenPostalCode
        );
        FunctionWithFilterMapAndFold<Person, Integer, Integer> function = FunctionFactory.createFunctionWithFilterMapFoldAndCombine(traits);
        Person[] people = {
            new Person("Ewald", "Julian", "Hauptstraße", 6, 5),
            new Person("Ewald", "Julian", "Hauptstraße", 6, 60),
            new Person("Ewald", "Julian", "Hauptstraße", 6, 10),
            new Person("Ewald", "Julian", "Hauptstraße", 6, 15)
        };
        assertEquals(110, function.apply(people));
    }

}

class Person {
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
     * This method checks if the postal code is not 64289.
     * @return returns the boolean value
     */
    public boolean isPostalCodeValid() {
        return this.getPostalCode() != 64289;
    }

    /**
     * This method accepts two values and returns the difference.
     * @param i1 value one
     * @param i2 value two
     * @return difference
     */
    public static Integer distanceBetweenPostalCode(Integer i1, Integer i2) {
        return Math.abs(i1 - i2);
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

    /**
     * This method returns the value of this.street.
     * @return returns this.street
     */
    public String getStreet() {
        return street;
    }

    /**
     * This method changes the value of this.street to its parameter
     * @param street new this.street value
     */
    public void setStreet(String street) {
        this.street = street;
    }
}
