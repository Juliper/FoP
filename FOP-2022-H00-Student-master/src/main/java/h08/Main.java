package h08;

import h08.roommanagement.InsufficientNumberOfSeatsException;
import h08.roommanagement.NoCertificateException;
import h08.roommanagement.Room;
import h08.roommanagement.Student;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {
    }

    /**
     * This method checks a given Student[] and Room if the room is big enough for all students and if every student has a certificate.
     * @param students student array that gets checked
     * @param room room that gets checked
     * @throws InsufficientNumberOfSeatsException gets thrown when there are too fewer seats
     * @throws NoCertificateException gets thrown when there are student without a certificate
     */
    public static void checkRegistration(Student[] students, Room room) throws InsufficientNumberOfSeatsException, NoCertificateException {
        if((double)room.numberOfSeats / 2 < students.length) {
            throw new InsufficientNumberOfSeatsException(room, (int) (2 * ((double)students.length - (double)(room.numberOfSeats) / 2)));
        } else {
            int j = 0;
            for(int i = 0; i < students.length; i++) {
                if (!students[i].hasCertificate) {
                    j++;
                }
            }
            Student[] hasNoCertificate = new Student[j];
            int k = 0;
            for(int i = 0; i < students.length; i++) {
                if (!students[i].hasCertificate) {
                    hasNoCertificate[k] = students[i];
                    k++;
                }
            }
            if(hasNoCertificate.length != 0) {
                throw new NoCertificateException(hasNoCertificate);
            }
        }
    }
}
