/**
 * @author Ryan Gemal
 */
public class Room {
    private String roomFloor;
    private int roomNumber;
    private String hotelName;
    private float basePrice;

    public Room(String roomFloor, int roomNumber, float basePrice) {
        this.roomFloor = roomFloor;
        this.roomNumber = roomNumber;
        this.basePrice = basePrice;
    }

    /**
     * This is a getter for the variable roomFloor
     * @return the floor where the Room is located in the Hotel
     */
    public String getRoomFloor() {
        return roomFloor;
    }

    /**
     * This is a getter for the variable roomNumber
     * @return the room number of the Room
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * This is a setter for the room floor and number of the Room
     * @param roomFloor the floor of the Room
     * @param roomNumber the number of the Room
     */
    public void setRoomName(String roomFloor, int roomNumber) {
        this.roomFloor = roomFloor;
        this.roomNumber = roomNumber;
    }

    /**
     * This is a getter for the variable hotelName
     * @return the Hotel name the Room is associated with
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * This is a setter for the variable hotelName
     * @param hotelName the name of the Hotel the Room is associated with
     */
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
}