package h08.roommanagement;

public class Room {

    public final String name;
    public final int numberOfSeats;

    /**
     * This is the constructor of Room. It sets the name and the number of seats of the object.
     * @param name value of this.name
     * @param numberOfSeats value of this.numberOfSeats
     */
    public Room(String name, int numberOfSeats) {
        this.name = name;
        this.numberOfSeats = numberOfSeats;
    }

    /**
     * This method returns a String containing the values of this.name and this.numberOfSeats
     * @return returns String with attributes
     */
    @Override
    public String toString() {
        return "Room{" + "name='" + name + '\'' + ", numberOfSeats=" + numberOfSeats + '}';
    }
}
