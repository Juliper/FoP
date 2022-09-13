package h08.roommanagement;

import java.util.Arrays;

public class NoCertificateException extends Exception{

    /**
     * This method returns a String containing all names of given array of students.
     * @param students containing needed names
     * @return returns String containing all names
     */
    private static String studentsToString(Student[] students) {
        String finalString = students[0].name;
        for(int i = 1; i < students.length; i++) {
            finalString = finalString + ", " + students[i].name;
        }
        return finalString;
    }

    /**
     * This constructor creates a new NoCertificateException object. It's message contains all names of not certificated students.
     * @param students provides names of not certificated students
     */
    public NoCertificateException(Student[] students) {
        super(studentsToString(students) + " has/have no certificate(s)");
    }
}
