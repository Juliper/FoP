package h08.roommanagement;

public class InsufficientNumberOfSeatsException extends RuntimeException{
    private final int numberOfMissingSeats;

    /**
     * This constructor creates a new InsufficientNumberOfSeatsException object. It's message contains the room name of
     * the given parameter. Also, numberOfMissingSeats gets saved in an attribute.
     * @param room provides room name
     * @param numberOfMissingSeats the provided number of missing seats
     */
    public InsufficientNumberOfSeatsException(Room room, int numberOfMissingSeats) {
        super(room.name + " has not enough seats");
        this.numberOfMissingSeats = numberOfMissingSeats;
    }

    /**
     * This method returns the number of missing seats.
     * @return returns this.numberOfMissingSeats
     */
    public int getNumberOfMissingSeats() {
        return numberOfMissingSeats;
    }
}
