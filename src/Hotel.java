import java.util.ArrayList;

public class Hotel {
    private String name;
    private int numOfRooms;
    private Room[] rooms;
    private float basePrice;
    private ArrayList<Client> clients;
    private int numOfClients;

    public Hotel(String name){
        this.name = name;
        this.numOfRooms = 0;
        this.rooms = new Room[50];
        this.basePrice = 1299;
        this.clients = new ArrayList<Client>(); //making this an ArrayList for a variable amt of clients in a hotel
        this.numOfClients = 0;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void addClient(Client client){
        clients.add(client);
        numOfClients = clients.size();
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

    public float getBasePrice() {
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

    public void setRoomName(String name) {
        rooms[numOfRooms].setRoomName(name);
    }

    public int getNumOfClients() {
        return numOfClients;
    }

    public void setNumOfClients(int numOfClients) {
        this.numOfClients = numOfClients;
    }
}
