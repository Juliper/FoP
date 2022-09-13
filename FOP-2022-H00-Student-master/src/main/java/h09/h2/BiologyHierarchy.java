package h09.h2;

import java.util.*;



public class BiologyHierarchy {

    /**
     * this method returns the vertebratetype of a given object that extends vertebrate.
     * @param t object the method is called on
     * @param <T> Type that extends Vertebrate
     * @return returns the vertebratetype
     */
    public <T extends Vertebrate> String getTypeOfVertebrate(T t) {
        return t.getTypeOfVertebrate();
    }

    /**
     * This method accepts a List and filters it for lagomorphas or subclasses.
     * @param lagomorphas List that gets filtered
     * @return returns the filtered List
     */
    public java.util.List<Lagomorpha> filterLagomorphs(java.util.List<? super Lagomorpha> lagomorphas) {
        java.util.ArrayList<Lagomorpha> lago = new ArrayList<Lagomorpha>();
        if(lagomorphas.isEmpty()) {
            return lago;
        } else {
            int i = 0;
            for(Object object : lagomorphas) {
                if(object instanceof Lagomorpha) {
                    lago.add((Lagomorpha) object);
                }
            }
            return lago;
        }
    }

    /**
     * This method accepts a List and returns a new List containing all results of getTypeOfMammal
     * @param mammals given List
     * @return List of all getTypeOfMammal
     */
    public java.util.List<String> getTypeOfMammals(java.util.List<? extends Mammal> mammals) {
        java.util.ArrayList<String> newMammals = new ArrayList<>();
        if(mammals.isEmpty()) {
            return newMammals;
        }
        for(Mammal mammal: mammals) {
            newMammals.add(mammal.getTypeOfMammal());
        }
        return newMammals;
    }
}
