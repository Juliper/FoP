package h12;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

class StudentExamTableIOTest {
    final IOFactory ioFactory = new FileSystemIOFactory();

    /**
     * This test tests the writeStudentsExamTable method. It only tests that no exception gets thrown.
     */
    @Test
    public void testWriteStudentsExamTable() {
        assumeTrue(ioFactory.supportsWriter());

        TableWithTitle table = TableGenerator.createTable(50, 1234);
        TableWithTitle table2 = new TableWithTitle("", TableGenerator.createEntries(50, 1234));

        assertDoesNotThrow(() -> StudentExamTableIO.writeStudentExamTable(ioFactory.createWriter("output.txt"), table.getEntries(), table.getTitle()));
        assertDoesNotThrow(() -> StudentExamTableIO.writeStudentExamTable(ioFactory.createWriter("output2.txt"), table2.getEntries()));
    }

    /**
     * This test tests the readStudentExamTable method. It only tests that no exception gets thrown.
     */
    @Test
    public void testReadStudentExamTable() {
        assumeTrue(ioFactory.supportsReader());
        assumeTrue(ioFactory.supportsWriter());

        TableWithTitle table = TableGenerator.createTable(2, 1);
        TableWithTitle table2 = new TableWithTitle("", TableGenerator.createEntries(2, 2));
        assertDoesNotThrow(() -> StudentExamTableIO.writeStudentExamTable(ioFactory.createWriter("output3.txt"), table.getEntries(), table.getTitle()));
        assertDoesNotThrow(() -> StudentExamTableIO.writeStudentExamTable(ioFactory.createWriter("output4.txt"), table2.getEntries()));

        assertDoesNotThrow(() -> StudentExamTableIO.readStudentExamTable(ioFactory.createReader("output3.txt")));
        assertDoesNotThrow(() -> StudentExamTableIO.readStudentExamTable(ioFactory.createReader("output4.txt")));
    }

    /**
     * This test tests the readStudentExamEntry method.
     */
    @Test
    public void testReadStudentExamEntry() {


        Object[] serialisedStudentExamEntry = {"Julian", "Ewald", 1234, "1,0"};
        StudentExamEntry expectedEntry = new StudentExamEntry((String) serialisedStudentExamEntry[0], (String) serialisedStudentExamEntry[1], (int) serialisedStudentExamEntry[2], (String) serialisedStudentExamEntry[3]);
        StudentExamEntry actualEntry = StudentExamTableIO.readStudentExamEntry(serialisedStudentExamEntry[0] + ":" + serialisedStudentExamEntry[1] + ":" + serialisedStudentExamEntry[2] + ":" + serialisedStudentExamEntry[3]);
        assertEquals(expectedEntry, actualEntry);


        Object[] serialisedStudentExamEntry2 = {"J", "E", 1, "2,0"};
        StudentExamEntry expectedEntry2 = new StudentExamEntry((String) serialisedStudentExamEntry2[0], (String) serialisedStudentExamEntry2[1], (int) serialisedStudentExamEntry2[2], (String) serialisedStudentExamEntry2[3]);
        StudentExamEntry actualEntry2 = StudentExamTableIO.readStudentExamEntry(serialisedStudentExamEntry2[0] + ":" + serialisedStudentExamEntry2[1] + ":" + serialisedStudentExamEntry2[2] + ":" + serialisedStudentExamEntry2[3]);
        assertEquals(expectedEntry2, actualEntry2);


        Object[] serialisedStudentExamEntry3 = {"Ju", "Ew", 12, "3,0"};
        StudentExamEntry expectedEntry3 = new StudentExamEntry((String) serialisedStudentExamEntry3[0], (String) serialisedStudentExamEntry3[1], (int) serialisedStudentExamEntry3[2], (String) serialisedStudentExamEntry3[3]);
        StudentExamEntry actualEntry3 = StudentExamTableIO.readStudentExamEntry(serialisedStudentExamEntry3[0] + ":" + serialisedStudentExamEntry3[1] + ":" + serialisedStudentExamEntry3[2] + ":" + serialisedStudentExamEntry3[3]);
        assertEquals(expectedEntry3, actualEntry3);


        Object[] serialisedStudentExamEntry4 = {"Jul", "Ewa", 123, "4,0"};
        StudentExamEntry expectedEntry4 = new StudentExamEntry((String) serialisedStudentExamEntry4[0], (String) serialisedStudentExamEntry4[1], (int) serialisedStudentExamEntry4[2], (String) serialisedStudentExamEntry4[3]);
        StudentExamEntry actualEntry4 = StudentExamTableIO.readStudentExamEntry(serialisedStudentExamEntry4[0] + ":" + serialisedStudentExamEntry4[1] + ":" + serialisedStudentExamEntry4[2] + ":" + serialisedStudentExamEntry4[3]);
        assertEquals(expectedEntry4, actualEntry4);
    }

    /**
     * This test tests the result of writeStudentExamTable method.
     */
    @Test
    public void testWriteStudentExamTableComplex() {
        assumeTrue(ioFactory.supportsReader());
        assumeTrue(ioFactory.supportsWriter());

        try {
            BufferedWriter bufferedWriter = ioFactory.createWriter("output5.txt");
            BufferedReader bufferedReader = ioFactory.createReader("output5.txt");
            TableWithTitle table = TableGenerator.createTable(50, 9);
            StudentExamTableIO.writeStudentExamTable(bufferedWriter, table.getEntries(), table.getTitle());


            assertEquals("!" + table.getTitle(), bufferedReader.readLine());
            assertEquals("50", bufferedReader.readLine());
            for(StudentExamEntry entry : table.getEntries()) {
                assertEquals(entry.getFirstName() + ":" + entry.getLastName() + ":" + entry.getEnrollmentNumber() + ":" + (Objects.equals(entry.getMark(), "n/a") ? "" : entry.getMark()), bufferedReader.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This test tests the writeStudentExamTable and readStudentExamTable methods with a humongous table.
     */
    @Test
    public void testWriteAndReadStudentExamTable() {
        for (int i = 0; i < 100; i++) {
            TableWithTitle table = TableGenerator.createTable(200, 100 + i);
            try {
                BufferedWriter bufferedWriter = ioFactory.createWriter("output6.txt");
                BufferedWriter bufferedWriter1 = ioFactory.createWriter("output7.txt");
                StudentExamTableIO.writeStudentExamTable(bufferedWriter, table.getEntries());
                StudentExamTableIO.writeStudentExamTable(bufferedWriter1, table.getEntries(), table.getTitle());

                BufferedReader bufferedReader = ioFactory.createReader("output6.txt");
                BufferedReader bufferedReader1  = ioFactory.createReader("output7.txt");
                TableWithTitle tableWithoutTitle = StudentExamTableIO.readStudentExamTable(bufferedReader);
                TableWithTitle tableWithTitle = StudentExamTableIO.readStudentExamTable(bufferedReader1);


                assertNull(tableWithoutTitle.getTitle());
                assertEquals(200, tableWithoutTitle.getEntries().length);
                for (int j = 0; j < table.getEntries().length; j++) {
                    assertEquals(table.getEntries()[j].getFirstName(), tableWithoutTitle.getEntries()[j].getFirstName());
                    assertEquals(table.getEntries()[j].getLastName(), tableWithoutTitle.getEntries()[j].getLastName());
                    assertEquals(table.getEntries()[j].getEnrollmentNumber(), tableWithoutTitle.getEntries()[j].getEnrollmentNumber());
                    assertEquals(table.getEntries()[j].getMark(), tableWithoutTitle.getEntries()[j].getMark());
                }


                assertEquals(table.getTitle(), tableWithTitle.getTitle());
                assertEquals(200, tableWithTitle.getEntries().length);
                for (int j = 0; j < table.getEntries().length; j++) {
                    assertEquals(table.getEntries()[j].getFirstName(), tableWithTitle.getEntries()[j].getFirstName());
                    assertEquals(table.getEntries()[j].getLastName(), tableWithTitle.getEntries()[j].getLastName());
                    assertEquals(table.getEntries()[j].getEnrollmentNumber(), tableWithTitle.getEntries()[j].getEnrollmentNumber());
                    assertEquals(table.getEntries()[j].getMark(), tableWithTitle.getEntries()[j].getMark());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
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




