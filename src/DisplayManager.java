import java.util.Scanner;

public class DisplayManager {

    static private Scanner sc = new Scanner(System.in);

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

        System.out.printf("Input: ");
        int option = sc.nextInt();

        while(option<1 || option>3){
            System.out.printf("Option is incorrect!\nInput: ");
            option = sc.nextInt();
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
        int option = sc.nextInt();

        while(option<1 || option>7){
            System.out.printf("Option is incorrect!\nInput: ");
            option = sc.nextInt();
        }
        return option;
    }

    /**
     * @author Ryan Gemal
     * Prompts the user to enter a hotel name.
     * @return the hotel name entered
     */
    static public String enterHotelName(){
        System.out.printf("Enter hotel name: ");
        sc.nextLine();
        String name = sc.nextLine();
        return name;
    }

    /**
     * @author Ryan Gemal
     * @param hotels the list of Hotels created
     * @return the selected Hotel
     */
    static public Hotel showHotels(Hotel[] hotels){
        System.out.println("Choose a hotel: ");
        for(int i = 0; i < hotels.length; i++){
            if(hotels[i] != null){
                System.out.printf("  %d - %s\n", i+1, hotels[i].getName());
            }
        }

        System.out.printf("Input: ");
        int option = sc.nextInt();

        while(option<1 || option>hotels.length){
            System.out.printf("Option is incorrect!\nInput: ");
            option = sc.nextInt();
        }
        return hotels[option-1];
    }

    /**
     * @author Ryan Gemal
     * @param hotel the Hotel to be viewed
     */
    static public void viewHotel(Hotel hotel){
        System.out.printf("Name of the hotel: %s\n", hotel.getName());
        System.out.printf("Room Count: %d\n", hotel.getRoomCount());
        System.out.printf("Base Price: %.2f\n", hotel.getBasePrice());
        System.out.printf("Client Count: %d\n", hotel.getClientCount());
        System.out.printf("Estimated earnings for the month: \n");
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
        System.out.printf("Client name: %s, %s\n", client.getLastName(), client.getFirstName());
        System.out.printf("Booked room: %s%d\n", client.getBookedRoom().getRoomFloor(), client.getBookedRoom().getRoomNumber());
        System.out.printf("Check-in date: %d\n", client.getCheckInDay());
        System.out.printf("Check-out date: %d\n", client.getCheckOutDay());
    }

    /**
     * @author Angela Domingo
     * @param hotels the list of Hotels created
     * @return a new Client object
     */
    static public Client createClient(Hotel[] hotels){

        String lastName, firstName;
        int checkInDay, checkOutDay, roomNumber;
        Hotel bookedHotel;
        Room bookedRoom;

        do {
            bookedHotel =  DisplayManager.showHotels(hotels);
            viewRooms(bookedHotel);
            System.out.print("Enter room number to book into: ");
            roomNumber = sc.nextInt();
            bookedRoom = bookedHotel.getRoom(roomNumber - 1);

            System.out.print("Enter check-in date: ");
            checkInDay = sc.nextInt();
            System.out.print("Enter check-out date: ");
            checkOutDay = sc.nextInt();

            if (!isBookedDatesValid(bookedHotel, bookedRoom, checkInDay, checkOutDay)) {
                System.out.println("Your booking dates are not valid, please try again!");
            } else if (isRoomOccupied(bookedHotel, bookedRoom, checkInDay, checkOutDay)) {
                System.out.println("Your room is occupied during these dates, please try again.");
            }

        } while (!isBookedDatesValid(bookedHotel, bookedRoom, checkInDay, checkOutDay) && isRoomOccupied(bookedHotel, bookedRoom, checkInDay, checkOutDay));

        System.out.print("Enter client's last name: ");
        lastName = sc.nextLine();
        System.out.print("Enter client's first name: ");
        firstName = sc.nextLine();

        return new Client(firstName, lastName, checkInDay, checkOutDay, bookedRoom);

    }

    /**
     * @author Angela Domingo
     * @param hotel the selected Hotel of the Client
     * @param bookedRoom the booked room of the Client
     * @param checkInDay check in day of the Client
     * @param checkOutDay check out day of the Client
     * @return if the booked dates are valid or not
     */
    private static boolean isBookedDatesValid(Hotel hotel, Room bookedRoom, int checkInDay, int checkOutDay){

        if ((1 <= checkInDay && checkInDay <= 30) && (2 <= checkOutDay && checkOutDay <= 30) && (checkInDay <= checkOutDay)) {
            if (isRoomOccupied(hotel, bookedRoom, checkInDay, checkOutDay)) {
                return false;
            }
            return true;
        }
        return false;
        
    }

    /**
     * @author Angela Domingo
     * @param hotel the selected Hotel of the Client
     * @param bookedRoom the booked room of the Client
     * @param checkInDay check in day of the Client
     * @param checkOutDay check out day of the Client
     * @return if the room is occupied or not
     */
    private static boolean isRoomOccupied(Hotel hotel, Room bookedRoom, int checkInDay, int checkOutDay){
        
        for (Client client : hotel.getClients()) {
            if ((client.getBookedRoom() == bookedRoom) && // checks if the rooms booked are the same rooms
            ((client.getCheckInDay() <= checkInDay && checkInDay <= client.getCheckOutDay()) || // checks if current client's range of dates contains new client's check in day
            (checkInDay <= client.getCheckInDay() && client.getCheckInDay() <= checkOutDay))) { // checks if new client's range of dates contains current client's check in day) {
                return false;
            }
        }
        return true;
    }
}