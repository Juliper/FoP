package h12;

import java.util.Random;

class TableGenerator {
    /**
     * This method creates a random but deterministic array of StudentExamEntry.
     * @param size size of the array
     * @param seed seed that gets used for random but deterministic values
     * @return returns the created array
     */
    static StudentExamEntry[] createEntries(int size, long seed) {
        Random random = new Random(seed);
        StudentExamEntry[] array = new StudentExamEntry[size];

        for (int i = 0; i < array.length; i++) {
            StringBuilder firstName = new StringBuilder();
            for (int j = 0; j < random.nextInt(21) + 5; j++) {
                firstName.append((char) (random.nextInt(26) + 97));
            }

            StringBuilder lastName = new StringBuilder();
            for (int j = 0; j < random.nextInt(21) + 5; j++) {
                lastName.append((char) (random.nextInt(26) + 97));
            }


            Integer enrollmentNumber = random.nextInt(9999000) + 1000;


            String mark = null;
            int j = random.nextInt(12);
            if(j == 0) mark = "1,0";
            if(j == 1) mark = "1,3";
            if(j == 2) mark ="1,7";
            if(j == 3) mark = "2,0";
            if(j== 4) mark = "2,3";
            if(j == 5) mark = "2,7";
            if(j == 6) mark = "3,0";
            if(j == 7) mark = "3,3";
            if(j == 8) mark = "3,7";
            if(j == 9) mark = "4,0";
            if(j == 10) mark = "5,0";
            if(j == 11) mark = "n/a";


            array[i] = new StudentExamEntry(firstName.toString(), lastName.toString(), enrollmentNumber, mark);
        }
        return array;
    }

    /**
     * This method creates a random but deterministic TableWithTitle object.
     * @param size size of the array
     * @param seed seed that gets used for random but deterministic values
     * @return returns the created TableWithTitle object
     */
    static TableWithTitle createTable(int size, long seed) {
        Random random = new Random(seed);


        StudentExamEntry[] studentExamEntries = createEntries(size, seed);


        StringBuilder title = new StringBuilder();
        for (int j = 0; j < random.nextInt(21) + 5; j++) {
            title.append((char) (random.nextInt(26) + 97));
        }


        return new TableWithTitle(title.toString(), studentExamEntries);
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
