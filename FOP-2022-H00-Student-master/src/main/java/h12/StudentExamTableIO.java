package h12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

public class StudentExamTableIO {

    /**
     * This method accepts a writer and a StudentExamEntry object. That objects gets written to a file with the writer.
     * @param writer writer containing the file path
     * @param studentExamEntry object that gets written to the file
     * @throws IOException gets thrown bei failed I/O operation
     */
    public static void writeStudentExamEntry(Writer writer, StudentExamEntry studentExamEntry) throws IOException {
        writer.write(studentExamEntry.getFirstName() + ":" + studentExamEntry.getLastName() + ":" + studentExamEntry.getEnrollmentNumber() + ":" + (Objects.equals(studentExamEntry.getMark(), "n/a") ? "" : studentExamEntry.getMark()));
        writer.flush();
    }

    /**
     * This method accepts a writer and a StudentExamEntry[]. The whole array gets written to a file with the provided writer.
     * The length of the provided array is written before the actual contents of StudentExamEntry[].
     * @param writer writer containing the file path
     * @param studentExamEntries object that gets written to the file
     * @throws IOException gets thrown bei failed I/O operation
     */
    public static void writeStudentExamTable(Writer writer, StudentExamEntry[] studentExamEntries) throws IOException {
        writer.write(studentExamEntries.length + "\n");
        for(StudentExamEntry entries : studentExamEntries) {
            writeStudentExamEntry(writer, entries);
            writer.write("\n");
        }
        writer.flush();
    }

    /**
     * This method accepts a writer and a StudentExamEntry[]. The whole array gets written to a file with the provided writer.
     * The length of the provided array and the title(last parameter) is written before the actual contents of StudentExamEntry[].
     * @param writer writer containing the file path
     * @param studentExamEntries object that gets written to the file
     * @param string title of the file
     * @throws IOException gets thrown bei failed I/O operation
     */
    public static void writeStudentExamTable(Writer writer, StudentExamEntry[] studentExamEntries, String string) throws IOException {
        writer.write("!" + string + "\n" + studentExamEntries.length + "\n");
        for(StudentExamEntry entries : studentExamEntries) {
            writeStudentExamEntry(writer, entries);
            writer.write("\n");
        }
        writer.flush();
    }

    /**
     *This method converts a string to a StudentExamEntry object.
     * @param string string that gets converted
     * @return returns created StudentExamEntry object
     */
    public static StudentExamEntry readStudentExamEntry(String string) {
        char[] chars = string.toCharArray();

        StringBuilder firstName = new StringBuilder();
        StringBuilder lastName = new StringBuilder();
        StringBuilder enrollmentNumber = new StringBuilder();
        StringBuilder mark = new StringBuilder();
        int j = 0;

        for (char aChar : chars) {
            if (aChar == ':') {
                j++;
                continue;
            }

            if (j == 0) {
                firstName.append(aChar);
            }

            if(j == 1) {
                lastName.append(aChar);
            }
            if(j == 2) {
                enrollmentNumber.append(aChar);
            }

            if(j == 3) {
                mark.append(aChar);
            }
        }

        return new StudentExamEntry(firstName.toString(), lastName.toString(), Integer.parseInt(enrollmentNumber.toString()), mark.toString().equals("") ? "n/a" : mark.toString());
    }

    /**
     * This method creates a TableWithTitle object with the data of the file in BufferedReader.
     * @param bufferedReader reader containing the file path
     * @return returns the created TableWithTitle object
     * @throws IOException gets thrown when an I/O error occurs
     */
    public static TableWithTitle readStudentExamTable(BufferedReader bufferedReader) throws IOException{
        String titel = null;
        StudentExamEntry[] entries;
        String firstLine = bufferedReader.readLine();

        if(firstLine.contains("!")) {
            titel = firstLine.replaceAll("!", "");
            entries = new StudentExamEntry[Integer.parseInt(bufferedReader.readLine())];
        } else entries = new StudentExamEntry[Integer.parseInt(firstLine)];


        for (int i = 0; i < entries.length; i++) {
            entries[i] = readStudentExamEntry(bufferedReader.readLine());
        }


        return new TableWithTitle(titel, entries);
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
