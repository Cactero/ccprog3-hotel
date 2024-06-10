public class Hotel {
    private String name;
    private int numOfRooms;
    private Room[] rooms;
    private float basePrice;

    public Hotel(String name, int numOfRooms, float basePrice, Room[] rooms){
        this.name = name;
        this.numOfRooms = numOfRooms;
        this.basePrice = basePrice;
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }

    public Room getRoom(int option) {
        return rooms[option];
    }

    public float getBasePrice(float basePrice) {
        return basePrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumOfRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    public void addRoom(Room room){
        rooms[numOfRooms] = room;
        rooms[numOfRooms].setHotelName(this.name);
        numOfRooms++;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }

}
