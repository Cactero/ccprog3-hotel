public class Room {
    private String roomFloor;
    private int roomNumber;
    private String hotelName;

    public Room(String roomFloor, int roomNumber) {
        this.roomFloor = roomFloor;
        this.roomNumber = roomNumber;
    }

    public String getRoomFloor() {
        return roomFloor;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomName(String roomFloor, int roomNumber) {
        this.roomFloor = roomFloor;
        this.roomNumber = roomNumber;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
}
