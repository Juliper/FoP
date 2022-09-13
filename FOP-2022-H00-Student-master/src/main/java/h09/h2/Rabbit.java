package h09.h2;

public class Rabbit implements Leporidae{
    private static int classCounter = 1;
    private int objectCounter;

    public Rabbit() {
        this.objectCounter = classCounter;
        classCounter++;
    }

    /**
     * This method returns a String containing the animaltype
     * @return returns animaltype
     */
    @Override
    public String getTypeOfAnimal() {
        return "Vertebrate";
    }

    /**
     * This method returns vertebratetype
     * @return returns vertebratetype
     */
    @Override
    public String getTypeOfVertebrate() {
        return "Mammal";
    }

    /**
     * This method returns mammaltype
     * @return returns mammaltype
     */
    @Override
    public String getTypeOfMammal() {
        return "Placental";
    }

    /**
     * This method returns placentaltype
     * @return returns placentaltype
     */
    @Override
    public String getTypeOfPlacental() {
        return "Lagomorpha";
    }

    /**
     * This method returns lagomorphatype
     * @return returns lagomorphatype
     */
    @Override
    public String getTypeOfLagomorpha() {
        return "Leporidae";   //Placental
    }

    /**
     * This method returns Name of Individual
     * @return returns Name of Individual
     */
    @Override
    public String getNameOfIndividual() {
        return String.valueOf(objectCounter);
    }
}
