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

    /**
     * This is a getter for the variable basePrice.
     * @return the base price of the Room
     */
    public float getBasePrice() {
        return basePrice;
    }

    /**
     * This is a setter for the variable basePrice.
     * @param basePrice the new base price of the Room
     */
    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }
}