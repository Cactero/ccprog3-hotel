package Model;

import java.util.ArrayList;

/**
 * Client class, where the client's reservation details are held.
 * @author Angela Domingo
 */

public class Client {

    private String firstName;
    private String lastName;
    private int checkInDay;
    private int checkOutDay;
    private Room bookedRoom;
    private float normalPrice;
    private float finalPrice;
    private ArrayList<String> discountsUsed;

    /**
     * Constructor of the Client object.
     * @param firstName Client's first name
     * @param lastName Client's last name
     * @param checkInDay Client's check in day
     * @param checkOutDay Client's check out day
     * @param bookedRoom Client's booked room
     */
    public Client(String firstName, String lastName, int checkInDay, int checkOutDay, Room bookedRoom) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.checkInDay = checkInDay;
        this.checkOutDay = checkOutDay;
        this.bookedRoom = bookedRoom;
        this.normalPrice = bookedRoom.getBasePrice() * (checkOutDay - checkInDay);
        this.finalPrice = this.normalPrice;
        this.discountsUsed = new ArrayList<>();
    }

    /**
     * This method is a getter for the variable bookedRoom.
     * @return the booked room of the Client
     */
    public Room getBookedRoom() {
        return bookedRoom;
    }

    /**
     * This is a getter for the variable firstName
     * @return the first name of the Client
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * This is a getter for the variable lastName
     * @return the last name of the Client
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This is a getter for the variable checkInDay
     * @return the check in day of the Client
     */
    public int getCheckInDay() {
        return checkInDay;
    }

    /**
     * This is a getter for the variable checkOutDay
     * @return the check-out day of the Client
     */
    public int getCheckOutDay() {
        return checkOutDay;
    }

    /**
     * This calculates the number of nights the client has booked.
     * @return the number of nights the client booked the Room
     */
    public int getNightsBooked(){
        return checkOutDay - checkInDay;
    }

    /**
     * This calculates the original reservation cost of the Client without the discounts.
     * @return the original reservation cost of the Client
     */
    public float getNormalPrice(){
        return normalPrice;
    }

    /**
     * Sets the final price for the client.
     * @param finalPrice the final price to be set for the client
     */
    public void setFinalPrice(float finalPrice){
        this.finalPrice = finalPrice;
    }

    /**
     * Returns the final price for the client.
     * @return the final price of the client
     */
    public float getFinalPrice() {
        return this.finalPrice;
    }

    /**
     * Adds multiple discount names to the list of discounts used by the client.
     * @param names a list of discount names to be added to the client's discounts used
     */
    public void addDiscountsUsed(ArrayList<String> names){
        this.discountsUsed.addAll(names);
    }

    /**
     * Adds a single discount name to the list of discounts used by the client.
     * @param name the discount name to be added to the client's discounts used
     */
    public void addDiscountsUsed(String name){
        this.discountsUsed.add(name);
    }

    /**
     * Returns the list of discount names used by the client.
     * @return an ArrayList containing the names of the discounts used by the client
     */
    public ArrayList<String> getDiscountsUsed(){
        return discountsUsed;
    }

}
