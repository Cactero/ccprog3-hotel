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
        for (Room room : rooms) {
            room.setHotelName(name);
        }
    }

    public void addRoom(Room room){
        rooms[roomCount] = room;
        rooms[roomCount].setHotelName(this.name);
        roomCount++;
    }

    public void removeRoom(Room room){
        for(int i = 0; i < this.roomCount; i++){
            if(rooms[i].getRoomFloor().equals(room.getRoomFloor()) && rooms[i].getRoomNumber() == room.getRoomNumber()){
                for(int k = i; k < this.roomCount; k++){
                    rooms[k] = rooms[k+1];
                }
                i--;
            }
        }
        this.roomCount--;
    }
    public Room[] getRooms() {
        return rooms;
    }

    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;

        for(int i = 0; i < roomCount; i++){
            rooms[i].setBasePrice(basePrice);
        }
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void addClient(Client client) {
        this.clients.add(client);
        clientCount = clients.size();
    }

    public void removeClient(Client client){
        this.clients.remove(client);
        clientCount = clients.size();
    }

    public int getClientCount(){
        return clientCount;
    }

    public float getTotalReservationPrices(){
        float sum = 0;
        for(int i = 0; i < clientCount; i++){
            sum += clients.get(i).getReservationCost();
        }
        return sum;
    }

}