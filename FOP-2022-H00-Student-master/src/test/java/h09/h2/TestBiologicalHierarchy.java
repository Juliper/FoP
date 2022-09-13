package h09.h2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.List;


public class TestBiologicalHierarchy {

    /**
     * This method tests getTypeOfVertebrate.
     */
    @Test
    public void testGetTypeOfVertebrate() {
        BiologyHierarchy biologyHierarchy = new BiologyHierarchy();
        Vertebrate[] animals = {new testVertebrate(), new testMammal(), new testBird(), new testPlacental(), new testMonotreme(), new testLagomorpha(), new testRodent(), new Rabbit()};
        String[] expected = {"testVertebrate", "Mammal", "Bird", "Mammal", "Mammal", "Mammal", "Mammal", "Mammal", };

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], biologyHierarchy.getTypeOfVertebrate(animals[i]));
        }
    }

    /**
     * This method tests filterLagomorphs.
     */
    @Test
    public void testFilterLagomorphs() {
        BiologyHierarchy biologyHierarchy = new BiologyHierarchy();
        java.util.List<Animal> animals = List.of(new Animal[]{new testVertebrate(), new testVertebrate(), new testVertebrate(), new testVertebrate(), new testLagomorpha(), new testLagomorpha(), new testLagomorpha(), new testLagomorpha(), new testLagomorpha()});

        java.util.List<Lagomorpha> actual = biologyHierarchy.filterLagomorphs(animals);
        java.util.List<Animal> expected = List.of(new Animal[]{animals.get(4), animals.get(5), animals.get(6), animals.get(7), animals.get(8)});

        assertEquals(expected, actual);
    }

    /**
     * This method tests getTypesOfMammals.
     */
    @Test
    public void testGetTypesOfMammals() {
        BiologyHierarchy biologyHierarchy = new BiologyHierarchy();
        java.util.List<Mammal> animals = List.of(new Mammal[]{new testMammal(), new testPlacental(), new testMonotreme(), new testLagomorpha(), new testRodent(), new Rabbit()});

        java.util.List<String> actual = biologyHierarchy.getTypeOfMammals(animals);
        java.util.List<String> expected = List.of(new String[]{"testMammal", "Placental", "Monotreme", "Placental", "Placental", "Placental"});

        assertEquals(expected, actual);
    }
}

class testAnimal implements Animal{
    /**
     * This method returns the type of animal.
     * @return type of animal
     */
    @Override
    public String getTypeOfAnimal() {
        return "testAnimal";
    }
}


class testVertebrate implements Vertebrate{
    /**
     * This method returns the type of animal.
     * @return type of animal
     */
    @Override
    public String getTypeOfAnimal() {
        return "Vertebrate";
    }

    /**
     * This method returns the type of vertebrate
     * @return type of vertebrate
     */
    @Override
    public String getTypeOfVertebrate() {
        return "testVertebrate";
    }
}


class testMammal implements Mammal{
    /**
     * This method returns the type of animal.
     * @return type of animal
     */
    @Override
    public String getTypeOfAnimal() {
        return "Vertebrate";
    }

    /**
     * This methodreturns the type of vertebrate
     * @return type of vertebrate
     */
    @Override
    public String getTypeOfVertebrate() {
        return "Mammal";
    }

    /**
     * This method returns the type of mammal.
     * @return type of mammal
     */
    @Override
    public String getTypeOfMammal() {
        return "testMammal";
    }
}



class testBird implements Bird{
    /**
     * This method returns the type of animal.
     * @return type of animal
     */
    @Override
    public String getTypeOfAnimal() {
        return "Vertebrate";
    }

    /**
     * This methodreturns the type of vertebrate
     * @return type of vertebrate
     */
    @Override
    public String getTypeOfVertebrate() {
        return "Bird";
    }

    /**
     * This method returns the type of bird
     * @return type of bird
     */
    @Override
    public String getTypeOfBird() {
        return "testBird";
    }
}



class testPlacental implements Placental{
    /**
     * This method returns the type of animal.
     * @return type of animal
     */
    @Override
    public String getTypeOfAnimal() {
        return "Vertebrate";
    }

    /**
     * This methodreturns the type of vertebrate
     * @return type of vertebrate
     */
    @Override
    public String getTypeOfVertebrate() {
        return "Mammal";
    }

    /**
     * This method returns the type of mammal.
     * @return type of mammal
     */
    @Override
    public String getTypeOfMammal() {
        return "Placental";
    }

    /**
     * This method returns the type of placental.
     * @return type of placental
     */
    @Override
    public String getTypeOfPlacental() {
        return "testPlacental";
    }
}



class testMonotreme implements Monotreme{
    /**
     * This method returns the type of animal.
     * @return type of animal
     */
    @Override
    public String getTypeOfAnimal() {
        return "Vertebrate";
    }

    /**
     * This methodreturns the type of vertebrate
     * @return type of vertebrate
     */
    @Override
    public String getTypeOfVertebrate() {
        return "Mammal";
    }

    /**
     * This method returns the type of mammal.
     * @return type of mammal
     */
    @Override
    public String getTypeOfMammal() {
        return "Monotreme";
    }

    /**
     * This method returns the type of monotreme.
     * @return type of monotreme
     */
    @Override
    public String getTypeOfMonotreme() {
        return "testMonotreme";
    }
}



class testLagomorpha implements Lagomorpha{
    /**
     * This method returns the type of animal.
     * @return type of animal
     */
    @Override
    public String getTypeOfAnimal() {
        return "Vertebrate";
    }

    /**
     * This methodreturns the type of vertebrate
     * @return type of vertebrate
     */
    @Override
    public String getTypeOfVertebrate() {
        return "Mammal";
    }

    /**
     * This method returns the type of mammal.
     * @return type of mammal
     */
    @Override
    public String getTypeOfMammal() {
        return "Placental";
    }

    /**
     * This method returns the type of placental.
     * @return type of placental
     */
    @Override
    public String getTypeOfPlacental() {
        return "Lagomorpha";
    }

    /**
     * This method returns the type of lagomorpha.
     * @return type of lagomorpha
     */
    @Override
    public String getTypeOfLagomorpha() {
        return "testLagomorpha";
    }
}



class testRodent implements Rodent{
    /**
     * This method returns the type of animal.
     * @return type of animal
     */
    @Override
    public String getTypeOfAnimal() {
        return "Vertebrate";
    }

    /**
     * This methodreturns the type of vertebrate
     * @return type of vertebrate
     */
    @Override
    public String getTypeOfVertebrate() {
        return "Mammal";
    }

    /**
     * This method returns the type of mammal.
     * @return type of mammal
     */
    @Override
    public String getTypeOfMammal() {
        return "Placental";
    }

    /**
     * This method returns the type of placental.
     * @return type of placental
     */
    @Override
    public String getTypeOfPlacental() {
        return "Lagomorpha";
    }

    /**
     * This method returns the type of rodent.
     * @return type of rodent
     */
    @Override
    public String getTypeOfRodent() {
        return "testRodent";
    }
}
