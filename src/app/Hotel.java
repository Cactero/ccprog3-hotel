package app;

import discount.DatePriceModifier;

import java.util.ArrayList;

/**
 * Hotel class, where the details of a Hotel is
 * @author Ryan Gemal
 */
public class Hotel {
    private String name;
    private int roomCount;
    private Room[] rooms;
    private float basePrice;
    private ArrayList<Client> clients; //arraylist for clients for variable amount of clients
    private int clientCount;
    private DatePriceModifier datePriceModifier;

    /**
     * The constructor for the Hotel object.
     * @param name the Hotel's name
     */
    public Hotel(String name){
        this.name = name;
        this.roomCount = 0;
        this.rooms = new Room[50];
        this.basePrice = 1299; //default as stated in specs
        this.clients = new ArrayList<Client>();
        this.clientCount = 0;
        this.datePriceModifier = new DatePriceModifier();
    }

    
    /** 
     * This is a getter for name.
     * @return the Hotel name
     */
    public String getName() {
        return name;
    }

    /**
     * This is a getter for roomCount.
     * @return the room count of the Hotel
     */
    public int getRoomCount() {
        return roomCount;
    }

    /**
     * This is a getter for a single room in the rooms array.
     * @param option the index number of the selected Room
     * @return the selected Room
     */
    public Room getRoom(int option) {
        return rooms[option];
    }

    /**
     * This is a getter for basePrice.
     * @return the base price of the Hotel
     */
    public float getBasePrice() {
        return basePrice;
    }

    /**
     * This is a setter for name.
     * @param name the new name of the Hotel
     */
    public void setName(String name) {
        this.name = name;
        for (int i = 0; i < roomCount; i++) {
            rooms[i].setHotelName(name);
        }
    }

    /**
     * Adds a Room to the Hotel.
     * @param room the Room to be added
     */
    public void addRoom(Room room){
        rooms[roomCount] = room;
        rooms[roomCount].setHotelName(this.name);
        roomCount++;
    }

    /**
     * Removes a Room from the Hotel.
     * @param hotel the Hotel
     * @param room the Room to be removed
     */
    public void removeRoom(Hotel hotel, Room room){
        boolean noReservations = true;

        for(int i = 0; i < 31; i++){
            if(Utilities.isRoomOccupied(hotel, room, i+1)){
                noReservations = false;
            }
        }

        if(roomCount == 1){
            System.out.println("You cannot remove this room because it is the only room!");
        }
        else if (!noReservations){
            System.out.println("You cannot remove this room because there is currently a reservation!");
        }
        else {
            for (int i = 0; i < this.roomCount-1; i++) {
                if (rooms[i].getRoomFloor().equals(room.getRoomFloor()) && rooms[i].getRoomNumber() == room.getRoomNumber()) {
                    for (int k = i; k < this.roomCount; k++) {
                        rooms[k] = rooms[k + 1];
                    }
                    i--;
                }
            }
            this.roomCount--;
        }
    }

    /**
     * This is a getter for rooms.
     * @return the array of rooms of the Hotel
     */
    public Room[] getRooms() {
        return rooms;
    }

    /**
     * This is a setter for basePrice.
     * @param basePrice the new base price of the Hotel
     */
    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;

        for(int i = 0; i < roomCount; i++){
            rooms[i].setBasePrice(basePrice);
        }
    }

    /**
     * This is a getter of clients.
     * @return an ArrayList of Clients
     */
    public ArrayList<Client> getClients() {
        return clients;
    }

    /**
     * This adds a new client to the Hotel.
     * @param client the Client to be added
     */
    public void addClient(Client client) {
        this.clients.add(client);
        clientCount = clients.size();
    }

    /**
     * This removes a client from the Hotel.
     * @param client the Client to be removed
     */
    public void removeClient(Client client){
        this.clients.remove(client);
        clientCount = clients.size();
    }

    /**
     * This is a getter for clientCount.
     * @return the client count of the Hotel
     */
    public int getClientCount(){
        return clientCount;
    }

    /**
     * This calculates the total reservation prices of the Hotel
     * @return the total reservation prices of the Hotel
     */
    public float getTotalReservationPrices(){
        float sum = 0;
        for(int i = 0; i < clientCount; i++){
            sum += clients.get(i).getNormalPrice();
        }
        return sum;
    }

}