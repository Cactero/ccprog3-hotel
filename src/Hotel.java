import java.util.ArrayList;

public class Hotel {
    private String name;
    private int roomCount;
    private Room[] rooms;
    private float basePrice;
    private ArrayList<Client> clients; //arraylist for clients for variable amount of clients
    private int clientCount;

    public Hotel(String name){
        this.name = name;
        this.roomCount = 0;
        this.rooms = new Room[50];
        this.basePrice = 1299; //default as stated in specs
        this.clients = new ArrayList<Client>();
        this.clientCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getRoomCount() {
        return roomCount;
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

    public void addRoom(Room room){
        rooms[roomCount] = room;
        rooms[roomCount].setHotelName(this.name);
        roomCount++;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void addClient(Client client) {
        this.clients.add(client);
        clientCount = clients.size();
    }

    public int getClientCount(){
        return clientCount;
    }

}