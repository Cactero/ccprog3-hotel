/**
 * @author Ryan Gemal
 * @author Angela Domingo
 */

import java.util.ArrayList;
import java.util.Scanner;

public class DisplayManager {

    private static Scanner sc = new Scanner(System.in);
    private static Utilities util = new Utilities();

    /**
     * @author Ryan Gemal
     * Displays the options to the user and asks the user to select an option.
     * This function assumes that the input given by the user is an integer and
     * has no error handling built in.
     * @return the choice the user selected
     */
    static public int mainMenuOptions(){
        System.out.println("Main Menu:");
        System.out.println("  1 - Create Hotel");
        System.out.println("  2 - View Hotel");
        System.out.println("  3 - Manage Hotel");
        System.out.println("  4 - Simulate Booking");
        System.out.println("  5 - Exit Program");

        System.out.printf("Input: ");
        int option = util.intInput();

        while(option<1 || option>5){
            System.out.printf("Option is incorrect!\nInput: ");
            option = util.intInput();
        }
        return option;
    }

    /**
     * @author Ryan Gemal
     * Displays the options to the user and asks the user to select an option.
     * This function assumes that the input given by the user is an integer and
     * has no error handling built in.
     * @return the choice the user selected
     */
    static public int manageHotelOptions(){
        System.out.println("Input one of the following options:");
        System.out.println("  1 - Change the name of the hotel");
        System.out.println("  2 - Add rooms");
        System.out.println("  3 - Remove rooms");
        System.out.println("  4 - Update the base price for a room");
        System.out.println("  5 - Remove reservation");
        System.out.println("  6 - Remove Hotel");
        System.out.println("  7 - Back to main menu");

        System.out.printf("Input: ");
        int option = util.intInput();

        while(option<1 || option>7) {
            System.out.printf("Option is incorrect!\nInput: ");
            option = util.intInput();

            return option;
        }
        return option;
    }

    /**
     * @author Ryan Gemal
     * Prompts the user to enter a hotel name.
     * @return the hotel name entered
     */
    public static String enterHotelName() {
            System.out.printf("Enter hotel name: ");
            String name = sc.nextLine();
            return name;
    }

    /**
     * @author Ryan Gemal
     * Shows a list of hotels to choose from.
     * @param hotels the list of Hotels created
     * @return the selected Hotel
     */
    static public Hotel showHotels(ArrayList<Hotel> hotels){

        int option;

        System.out.println("Choose a hotel: ");
        for(int i = 0; i < hotels.size(); i++){
            System.out.printf("  %d - %s\n", i+1, hotels.get(i).getName());
        }

        do {
            System.out.printf("Input: ");
            option = util.intInput();
            if (option<1 || option>hotels.size())
                System.out.println("Option is incorrect!");
        } while (option<1 || option>hotels.size());

        return hotels.get(option-1);
    }

    /**
     * @author Ryan Gemal
     * Shows the high-level information and selected low-level information of the selected Hotel.
     * @param hotel the Hotel to be viewed
     */
    static public void viewHotel(Hotel hotel){
        System.out.printf("Name of the hotel: %s\n", hotel.getName());
        System.out.printf("Room Count: %d\n", hotel.getRoomCount());
        System.out.printf("Base Price: %.2f\n", hotel.getBasePrice());
        System.out.printf("Client Count: %d\n", hotel.getClientCount());
        System.out.printf("Estimated earnings for the month: $%.2f\n\n", hotel.getTotalReservationPrices());

        System.out.println("Select low-level information to see:");
        System.out.println("1 - Total number of available and booked rooms for a selected date");
        System.out.println("2 - Information about a selected room");
        System.out.println("3 - Information about a selected reservation");
        System.out.println("4 - Back to main menu");

        int choice;

        do {
            System.out.printf("Input: ");
            choice = util.intInput();
            if (!(1 <= choice && choice <= 4)) {
                System.out.println("Option is incorrect!");
            }
        } while (!(1 <= choice && choice <= 4));
        

        switch (choice) {
            case 1:
                System.out.printf("Enter a date: ");
                int date = util.intInput();
                DisplayManager.viewRoomsDate(hotel, date);
                break;
        
            case 2:
                int number;
                viewRooms(hotel);

                do {
                    System.out.printf("Enter choice: ");
                    number = util.intInput();
                    if (!(1 <= number && number <= hotel.getRoomCount())) {
                        System.out.println("Out of bounds, try again.");
                    }
                } while (!(1 <= number && number <= hotel.getRoomCount()));

                viewRoom(hotel, hotel.getRoom(number - 1));
                
                break;

            case 3:
                System.out.printf("Enter client last name: ");
                String lastName = sc.nextLine();

                System.out.printf("Enter client first name: ");
                String firstName = sc.nextLine();
                
                for (Client client : hotel.getClients()) {
                    if (client.getFirstName().equals(firstName) && client.getLastName().equals(lastName)) {
                        DisplayManager.viewClient(client);
                    }
                }
                break;
        }        
    }

    /**
     * @author Ryan Gemal
     * Shows the number of available and booked rooms of the selected hotel and date.
     * @param hotel the selected Hotel to be checked
     * @param date the date to check how many Clients booked on that date
     */
    static public void viewRoomsDate(Hotel hotel, int date){
        int availableRooms = 0;
        int bookedRooms = 0;
        
        for (Client client : hotel.getClients()) {
            if ((client.getCheckInDay() <= date && date <= client.getCheckOutDay())) {
                bookedRooms++;
            } else {
                availableRooms++;
            }
        }

        System.out.printf("Available rooms: %d\n", availableRooms);
        System.out.printf("Booked rooms: %d\n", bookedRooms);
    }

    /**
     * @author Ryan Gemal
     * 
     * @param hotel
     * @param room
     */
    static public void viewRoom(Hotel hotel, Room room){
        System.out.printf("Room name: %s%d\n", room.getRoomFloor(), room.getRoomNumber());
        System.out.printf("Base price: %.2f\n", room.getBasePrice());
        for(int i = 0; i < 31; i++){
            System.out.printf("%d-", i+1);
            if(util.isRoomOccupied(hotel, room, i+1)){
                System.out.printf("B");
            }
            else{
                System.out.printf("A");
            }
            System.out.printf(" ");
            if((i+1)%7 == 0){
                System.out.printf("\n");
            }
        }
        System.out.printf("\n");
    }

    /**
     * @author Ryan Gemal
     * @param hotel the Hotel's rooms to be viewed
     */
    static public void viewRooms(Hotel hotel){
        System.out.printf("Hotel: %s\n", hotel.getName());
        for(int i = 0; i < hotel.getRoomCount(); i++){
            System.out.printf("Room %d: %s%d\n", i+1, hotel.getRoom(i).getRoomFloor(), hotel.getRoom(i).getRoomNumber());
        }
    }

    /**
     * @author Angela Domingo
     * @param client the Client to be viewed
     */
    static public void viewClient(Client client){
        System.out.printf("\nClient Name: %s, %s\n", client.getLastName(), client.getFirstName());
        System.out.printf("Booked Room: %s%d\n", client.getBookedRoom().getRoomFloor(), client.getBookedRoom().getRoomNumber());
        System.out.printf("Base Reservation Price: %.2f\n", client.getBookedRoom().getBasePrice());
        System.out.printf("Check-in Date: %d\n", client.getCheckInDay());
        System.out.printf("Check-out Date: %d\n", client.getCheckOutDay());
        System.out.printf("Breakdown of Cost/Night: %d nights * $.2f = \n", client.getDaysBooked(), client.getBookedRoom().getBasePrice());
        System.out.printf("Total Reservation Price: %.2f\n\n", client.getReservationCost());
    }

}