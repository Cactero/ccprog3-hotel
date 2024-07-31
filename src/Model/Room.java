package Model;

/**
 * Room class, where details of a Hotel's Room is
 * @author Ryan Gemal
 */
public class Room {
    private String roomFloor;
    private int roomNumber;
    private String hotelName;
    private float basePrice;
    private String type;

    /**
     * The constructor for a Room object.
     * @param roomFloor the floor of the Room
     * @param roomNumber the number of the Room
     * @param basePrice the base price of the Room
     * @param type the room type
     */
    public Room(String roomFloor, int roomNumber, float basePrice, String type) {
        this.roomFloor = roomFloor;
        this.roomNumber = roomNumber;
        this.basePrice = basePrice;
        this.type = type;

        switch (this.type) {
            case "Standard (1.0x)" -> this.basePrice *= 1.0F;
            case "Deluxe (1.2x)" -> this.basePrice *= 1.2F;
            case "Executive (1.35x)" -> this.basePrice *= 1.35F;
        }
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
     * Returns the formatted room name of the Room
     * @return the Room name in FloorNumber (ex. AG1701) format
     */
    public String getFormattedName() {
        return roomFloor + roomNumber;
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
        switch (this.type) {
            case "Standard" -> this.basePrice *= 1.0F;
            case "Deluxe" -> this.basePrice *= 1.2F;
            case "Executive" -> this.basePrice *= 1.35F;
        }
    }

    /**
     * This is a setter for the variable type.
     * @param type the type of the room
     */
    public void setRoomType(String type){
        this.type = type;
        switch (type) {
            case "Standard" -> basePrice *= 1.0F;
            case "Deluxe" -> basePrice *= 1.2F;
            case "Executive" -> basePrice *= 1.35F;
        }
    }

    /**
     * This is a getter for the variable type.
     * @return the type of the room
     */
    public String getType(){ return type; }
}