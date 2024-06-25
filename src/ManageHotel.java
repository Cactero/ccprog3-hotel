import java.util.ArrayList;
import java.util.Scanner;

public class ManageHotel {
    private static Scanner sc = new Scanner(System.in);

    public static void addRooms(Hotel hotel){
        String floor;
        int number = 0;

        if (hotel.getRoomCount() >= 50) {
            System.out.println("Max amount of rooms in hotel reached.");
        } else {
            boolean hasConflict;
            do {
                hasConflict = false;
                    System.out.println("What floor will the room be? ");
                    floor = sc.nextLine();
                    System.out.println("What room number will the room be? ");
                    number = Integer.parseInt(sc.nextLine());
    
                    for(int i = 0; i < hotel.getRoomCount(); i++){
                        if(roomsMatch(floor, number, hotel.getRoom(i).getRoomFloor(), hotel.getRoom(i).getRoomNumber())){
                            System.out.println("There is already a room with this name!");
                            hasConflict = true;
                        }
                    }
            } while(hasConflict);
            
            Room newRoom = new Room(floor, number, hotel.getBasePrice());
            hotel.addRoom(newRoom);
        }

       
    }

    public static void removeRooms(Hotel hotel){
        String floor = new String();
        int number = 0;
        boolean notFound;
        do {
            notFound = false;
            DisplayManager.viewRooms(hotel);
            System.out.println("What floor is the room to be removed? ");
            floor = sc.nextLine();
            System.out.println("What room number is the room to be removed? ");
            number = Integer.parseInt(sc.nextLine());
            for(int i = 0; i < hotel.getRoomCount() && !notFound; i++){
                if(roomsMatch(floor, number, hotel.getRoom(i).getRoomFloor(), hotel.getRoom(i).getRoomNumber())){
                    notFound = false;
                    break;
                }
            }
            if(notFound) { System.out.println("Not found, try again."); }
        } while(notFound);

        Room room = new Room(floor, number, 0);
        hotel.removeRoom(room);

    }

    public static boolean roomsMatch(String roomFloorA, int roomNumberA, String roomFloorB, int roomNumberB){
        return roomFloorA.equals(roomFloorB) && (roomNumberA == roomNumberB); // Duplicate found
    }

    public static void changeHotelName(Hotel hotel, String newName){
        if(hotel.getName().equals(newName)){
            System.out.println("This is already the hotel's name!");
        }
        else{
            hotel.setName(newName);
        }
    }

    public static void updateBasePrice(Hotel hotel){
        float newPrice = 0.0F;
        if(hotel.getClientCount() != 0){
            System.out.println("Sorry, but you cannot update the base price of a room while there are reservrations.");
        }
        else{
            do {
                System.out.println("Enter a room price (Must be at least 100)");
                newPrice = sc.nextInt();

                if(newPrice < 100.0F) {
                    System.out.println("New price must be at least 100! Try again.");
                }
            } while(newPrice < 100.0F);

            hotel.setBasePrice(newPrice);
        }
    }

    public static void removeReservation(Hotel hotel){
        Client selectedClient;
        int choice;

        for (int i = 0; i < hotel.getClientCount(); i++) {
                System.out.printf("Reservation %d:", i+1);
                DisplayManager.viewClient(hotel.getClients().get(i));
        }

        do {
            System.out.println("\nInput:");
            choice = Integer.parseInt(sc.nextLine());
            if (1 <= choice && choice <= hotel.getClientCount()) {
                System.out.println("Option is incorrect.\n");
            }
        } while (1 <= choice && choice <= hotel.getClientCount());

        selectedClient = hotel.getClients().get(choice-1);
        hotel.removeClient(selectedClient);
    }

    public static void removeHotel(ArrayList<Hotel> hotels){
        int choice;

        for (int i = 0; i < hotels.size(); i++) {
                System.out.printf("Hotel %d: %s\n", i+1, hotels.get(i).getName());
        }

        do {
            System.out.println("\nInput:");
            choice = Integer.parseInt(sc.nextLine());
            if (!(1 <= choice && choice <= hotels.size())) {
                System.out.println("Option is incorrect.\n");
            }
        } while (!(1 <= choice && choice <= hotels.size()));

        hotels.remove(choice);
    }


    /**
     * @author Angela Domingo
     * @param hotels the list of Hotels created
     * @return a new Client object
     */
    public static void addReservation(ArrayList<Hotel> hotels){

        String lastName, firstName;
        int checkInDay, checkOutDay, roomNumber;
        Hotel bookedHotel;
        Room bookedRoom;

        do {
            bookedHotel =  DisplayManager.showHotels(hotels);
            DisplayManager.viewRooms(bookedHotel);
            System.out.print("Enter room number to book into: ");
            roomNumber = Integer.parseInt(sc.nextLine());
            bookedRoom = bookedHotel.getRoom(roomNumber - 1);

            System.out.print("Enter check-in date: ");
            checkInDay = Integer.parseInt(sc.nextLine());
            System.out.print("Enter check-out date: ");
            checkOutDay = Integer.parseInt(sc.nextLine());

            if (!isBookedDatesValid(bookedHotel, bookedRoom, checkInDay, checkOutDay)) {
                System.out.println("Your booking dates are not valid, please try again!");
            } else if (isRoomOccupied(bookedHotel, bookedRoom, checkInDay, checkOutDay)) {
                System.out.println("Your room is occupied during these dates, please try again.");
            }

        } while (!isBookedDatesValid(bookedHotel, bookedRoom, checkInDay, checkOutDay) || isRoomOccupied(bookedHotel, bookedRoom, checkInDay, checkOutDay));

        System.out.print("Enter client's last name: ");
        lastName = sc.nextLine();
        System.out.print("Enter client's first name: ");
        firstName = sc.nextLine();

        bookedHotel.addClient(new Client(firstName, lastName, checkInDay, checkOutDay, bookedRoom));

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

        if ((1 <= checkInDay && checkInDay <= 30) && (2 <= checkOutDay && checkOutDay <= 31) && (checkInDay < checkOutDay)) {
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
    public static boolean isRoomOccupied(Hotel hotel, Room bookedRoom, int checkInDay, int checkOutDay){
        
        if (hotel.getClientCount() == 0) {
            return false;
        }

        for (Client client : hotel.getClients()) {
            if ((client.getBookedRoom() == bookedRoom) && // checks if the rooms booked are the same rooms
            ((client.getCheckInDay() < checkInDay && checkInDay <= client.getCheckOutDay()) || // checks if current client's range of dates contains new client's check in day
            (client.getCheckInDay() <= checkOutDay && checkOutDay < client.getCheckOutDay()))) { // checks if new client's range of dates contains current client's check in day) {
                return true;
            }
        }
        return false;
    }

    public static boolean isRoomOccupied(Hotel hotel, Room bookedRoom, int date){
        for (Client client : hotel.getClients()){
            if((client.getCheckInDay() <= date && date <= client.getCheckOutDay()) && (client.getBookedRoom() == bookedRoom))
            {
                return true;
            }
        }
        return false;
    }
}