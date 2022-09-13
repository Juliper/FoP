package h12;

import java.util.Objects;

public class StudentExamEntry {
    private final String lastName;
    private final String firstName;
    private final int enrollmentNumber;
    private String mark;

    /**
     * This is the constructor of StudentExamEntry. It accepts two Strings and one Integer. This constructor calls the second
     * constructor with "n/a" as last parameter.
     * @param firstName firstName of this
     * @param lastName lastName of this
     * @param enrollmentNumber enrollmentNumber of this
     * @throws NullPointerException gets thrown when one parameter is null
     * @throws BadEnrollmentNumberException gets thrown when the enrollment number is negative
     * @throws BadCharException gets thrown when one of the strings contains a ":" or "!"
     */
    public StudentExamEntry(String firstName, String lastName, Integer enrollmentNumber) throws NullPointerException, BadEnrollmentNumberException, BadCharException {
        this(firstName, lastName, enrollmentNumber, "n/a");
    }

    /**
     * This is the constructor of StudentExamEntry. It accepts three Strings and one Integer. It creates a StudentExamEntry
     * with the according attributes.
     * @param firstName firstName of this
     * @param lastName lastName of this
     * @param enrollmentNumber enrollmentNumber of this
     * @param mark mark of this
     * @throws NullPointerException gets thrown when one parameter is null
     * @throws BadEnrollmentNumberException gets thrown when the enrollment number is negative
     * @throws BadCharException gets thrown when one of the strings contains a ":" or "!"
     */
    public StudentExamEntry(String firstName, String lastName, Integer enrollmentNumber, String mark) throws NullPointerException, BadEnrollmentNumberException, BadCharException {
        if(firstName == null || lastName == null || enrollmentNumber == null || mark == null) {
            throw new NullPointerException();
        }

        if(enrollmentNumber < 0) throw new BadEnrollmentNumberException(enrollmentNumber);

        char[] chars = firstName.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == ':') {
                throw new BadCharException(':', i);
            }
            if(chars[i] == '!') {
                throw new BadCharException('!', i);
            }
        }

        char[] chars2 = lastName.toCharArray();
        for(int i = 0; i < chars2.length; i++) {
            if(chars2[i] == ':') {
                throw new BadCharException(':', i);
            }
            if(chars2[i] == '!') {
                throw new BadCharException('!', i);
            }
        }

        if(!(mark.equals("1,0") || mark.equals("1,3") || mark.equals("1,7") || mark.equals("2,0") || mark.equals("2,3") || mark.equals("2,7") || mark.equals("3,0") || mark.equals("3,3") || mark.equals("3,7") || mark.equals("4,0") || mark.equals("5,0") || mark.equals("n/a"))) {
            throw new BadStudentMarkException(mark);
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.enrollmentNumber = enrollmentNumber;
        this.mark = mark;
    }

    /**
     * Getter of enrollmentNumber.
     * @return returns enrollmentNumber
     */
    public int getEnrollmentNumber() {
        return enrollmentNumber;
    }

    /**
     * Getter of firstName.
     * @return returns firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Getter of lastName.
     * @return returns lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Getter of mark
     * @return returns mark
     */
    public String getMark() {
        return mark;
    }

    /**
     * Setter of mark.
     * @param mark new value of this.mark
     * @throws NullPointerException gets thrown when the parameter is null
     * @throws BadStudentMarkException gets thrown when the parameter is not a valid mark value
     */
    public void setMark(String mark) throws NullPointerException, BadStudentMarkException {
        if(mark == null) {
            throw new NullPointerException();
        }
        if(!(mark.equals("1,0") || mark.equals("1,3") || mark.equals("1,7") || mark.equals("2,0") || mark.equals("2,3") || mark.equals("2,7") || mark.equals("3,0") || mark.equals("3,3") || mark.equals("3,7") || mark.equals("4,0") || mark.equals("5,0") || mark.equals("n/a"))) {
            throw new BadStudentMarkException(mark);
        }
        this.mark = mark;
    }

    /**
     * Overrides equals(). Now the method compares StudentExamEntry objects by its attribute values.
     * @param o object that gets tested
     * @return returns true or false whether the attribute values are equal
     */
    @Override
    public boolean equals(Object o) {
        if(o.getClass() == this.getClass()) {
            StudentExamEntry object = (StudentExamEntry) o;
            return Objects.equals(object.getFirstName(), this.getFirstName()) && Objects.equals(object.getLastName(), this.getLastName()) && object.getEnrollmentNumber() == this.getEnrollmentNumber() && Objects.equals(object.getMark(), this.getMark());
        }
        return false;
    }
}
/*
 _____
/     \
vvvvvvv  /|__/|
   I   /O,O   |
   I /_____   |      /|/|
  J|/^ ^ ^ \  |    /00  |    _//|
   |^ ^ ^ ^ |W|   |/^^\ |   /oo |
   \m___m__|_|    \m_m_|   \mm_|
 */
