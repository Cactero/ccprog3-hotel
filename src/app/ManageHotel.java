package Model;

import Model.discount.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Manages a Hotel or a list of Hotels.
 * @author Ryan Gemal
 * @author Angela Domingo
 */
public class ManageHotel {
    private static Scanner sc = new Scanner(System.in);

    /**
     * Adds a room to the selected Hotel.
     * @param hotel the Hotel where the new Room will be added to
     */
    public static void addRooms(Hotel hotel){
        String floor;
        int number = 0;
        int type = 0;

        if (hotel.getRoomCount() >= 50) {
            System.out.println("Max amount of rooms in hotel reached.");
        } else {
            boolean hasConflict;
            do {
                hasConflict = false;
                System.out.print("What floor will the room be?: ");
                floor = sc.nextLine().toUpperCase();
                System.out.print("What room number will the room be? (Numbers): ");
                number = Utilities.intInput();

                for(int i = 0; i < hotel.getRoomCount(); i++){
                    if(roomsMatch(floor, number, hotel.getRoom(i).getRoomFloor(), hotel.getRoom(i).getRoomNumber())){
                        System.out.println("There is already a room with this name!");
                        hasConflict = true;
                    }
                }

                do {
                    System.out.println("What type of room do you want to create?");
                    System.out.println("[1] Standard (1x base rate)");
                    System.out.println("[2] Deluxe (20% more from base rate)");
                    System.out.println("[3] Executive (35% more from base rate)");
                    System.out.printf(": ");
                    type = Utilities.intInput(1, 3);
                } while(type < 1 || type > 3);

            } while(hasConflict);

            Room newRoom = new Room(floor, number, hotel.getBasePrice());
            switch(type){
                case 1:
                    newRoom.setRoomType("Standard");
                    break;
                case 2:
                    newRoom.setRoomType("Deluxe");
                    break;
                case 3:
                    newRoom.setRoomType("Executive");
                    break;
            }

            hotel.addRoom(newRoom);
        }
    }

    /**
     * Removes a room from the selected Hotel.
     * @param hotel the Hotel where the Room will be removed from
     */
    public static void removeRooms(Hotel hotel){
        String floor = new String();
        int number = 0;
        boolean notFound;
        do {
            notFound = false;
            DisplayManager.viewRooms(hotel);
            System.out.print("What floor is the room to be removed? ");
            floor = sc.nextLine();
            System.out.print("What room number is the room to be removed? ");
            number = Utilities.intInput();
            for(int i = 0; i < hotel.getRoomCount() && !notFound; i++){
                if(roomsMatch(floor, number, hotel.getRoom(i).getRoomFloor(), hotel.getRoom(i).getRoomNumber())){
                    notFound = false;
                    break;
                }
            }
            if(notFound) { System.out.println("Not found, try again."); }
        } while(notFound);

        Room room = new Room(floor, number, 0);
        hotel.removeRoom(hotel, room);

    }

    /**
     * Checks if two rooms are the same based on their names.
     * @param roomFloorA floor of the first room
     * @param roomNumberA number of the first room
     * @param roomFloorB floor of the second room
     * @param roomNumberB number of the second room
     * @return whether the rooms are the same or not
     */
    public static boolean roomsMatch(String roomFloorA, int roomNumberA, String roomFloorB, int roomNumberB){
        return roomFloorA.equals(roomFloorB) && (roomNumberA == roomNumberB); // Duplicate found
    }

    /**
     * Changes the name of a selected Hotel.
     * @param hotel the selected Hotel
     * @param newName the new name of the Hotel
     */
    public static void changeHotelName(Hotel hotel, String newName){
        if(hotel.getName().equals(newName)){
            System.out.println("This is already the hotel's name!");
        }
        else{
            hotel.setName(newName);
        }
    }

    /**
     * Updates the base price of the selected Hotel.
     * @param hotel the selected Hotel where the base price will be updated
     */
    public static void updateBasePrice(Hotel hotel){
        float newPrice = 0.0F;
        if(hotel.getClientCount() != 0){
            System.out.println("Sorry, but you cannot update the base price of a room while there are reservations.");
        }
        else{
            do {
                System.out.println("Enter a room price (Must be at least 100)");
                newPrice = (float) Utilities.intInput();
                if(newPrice < 100.0F) {
                    System.out.println("New price must be at least 100! Try again.");
                }
            } while(newPrice < 100.0F);

            hotel.setBasePrice(newPrice);
        }
    }

    /**
     * Removes a reservation from the hotel.
     * @param hotel the Hotel where the reservation will be removed from
     */
    public static void removeReservation(Hotel hotel){
        Client selectedClient;
        int choice = 0;

        if (hotel.getClientCount() == 0) {
            System.out.println("There are no reservations in this hotel.");
        } else {
            for (int i = 0; i < hotel.getClientCount(); i++) {
                System.out.printf("Reservation %d:", i+1);
                DisplayManager.viewClient(hotel.getClients().get(i));
            }
    
            do {
                System.out.println("\nInput:");
                choice = Utilities.intInput();
    
                if (!(1 <= choice && choice <= hotel.getClientCount())) {
                    System.out.println("Option is incorrect.\n");
                }
            } while (!(1 <= choice && choice <= hotel.getClientCount()));
    
            selectedClient = hotel.getClients().get(choice-1);
            hotel.removeClient(selectedClient);
        }
    }

    /**
     * Removes a hotel from the list of hotels.
     * @param hotels the list of hotels where a Hotel will be removed
     */
    public static void removeHotel(ArrayList<Hotel> hotels){
        Hotel selectedHotel;
        selectedHotel = DisplayManager.chooseHotel(hotels);
        hotels.remove(selectedHotel);
    }


    /**
     * Adds a reservation to a hotel.
     * @param hotels the list of Hotels created
     */
    public static void addReservation(ArrayList<Hotel> hotels){
        boolean ongoing = true;
        String lastName, firstName;
        int checkInDay, checkOutDay = 0, roomNumber;
        Hotel bookedHotel;
        Room bookedRoom;
        String option;
        String discountCode;
        Discount discount = null;
        outer:
        while(ongoing) {
            do {
                bookedHotel = DisplayManager.chooseHotel(hotels);
                DisplayManager.viewRooms(bookedHotel);
                do {
                    System.out.print("Enter room number to book into (0 to cancel): ");
                    roomNumber = Utilities.intInput();
                    if(roomNumber == 0){
                        break outer;
                    }
                    else if (!(1 <= roomNumber && roomNumber <= bookedHotel.getRoomCount())) {
                        System.out.println("Invalid room number, try again");
                    }
                } while (!(1 <= roomNumber && roomNumber <= bookedHotel.getRoomCount()));

                bookedRoom = bookedHotel.getRoom(roomNumber - 1);

                DisplayManager.viewRoomAvailability(bookedHotel, bookedRoom);

                System.out.print("Enter check-in date (0 to cancel): ");
                checkInDay = Utilities.intInput();
                if (checkInDay == 0) {
                    break outer;
                }
                System.out.print("Enter check-out date (0 to cancel): ");
                checkOutDay = Utilities.intInput();
                if (checkOutDay == 0) {
                    break outer;
                }

                if (!Utilities.isBookedDatesValid(bookedHotel, bookedRoom, checkInDay, checkOutDay)) {
                    System.out.println("Your booking dates are not valid, please try again!");
                } else if (Utilities.isRoomOccupied(bookedHotel, bookedRoom, checkInDay, checkOutDay)) {
                    System.out.println("Your room is occupied during these dates, please try again.");
                }

            } while (!Utilities.isBookedDatesValid(bookedHotel, bookedRoom, checkInDay, checkOutDay) || Utilities.isRoomOccupied(bookedHotel, bookedRoom, checkInDay, checkOutDay));

            System.out.print("Enter client's last name: ");
            lastName = sc.nextLine();
            System.out.print("Enter client's first name: ");
            firstName = sc.nextLine();
            if(lastName.isEmpty() || firstName.isEmpty()){
                System.out.println("Name empty, cancelling reservation.");
                break;
            }

            Client client = new Client(firstName, lastName, checkInDay, checkOutDay, bookedRoom);
            bookedHotel.addClient(client);

            System.out.println("Do you have a app.discount code?");
            System.out.println("[Y]es or [N]o?");
            System.out.print(": ");
            option = sc.nextLine();
            if (option.equalsIgnoreCase("Y")) {
                boolean isValid = false;
                do {
                    System.out.print("Enter app.discount code: ");
                    discountCode = sc.nextLine();
                    discount = getDiscountCode(discountCode);

                    if ((discountCode.equals("I_WORK_HERE") || discountCode.equals("STAY4_GET1") || discountCode.equals("PAYDAY"))) {

                        if (discountCode.equals("I_WORK_HERE")) {
                            System.out.println("Discount valid!");
                            System.out.println("You get a flat 10% app.discount to the final price of your reservation!");
                            //isValid = true;
                            break;
                        } else if (discountCode.equals("STAY4_GET1")) {
                            System.out.println("Discount valid!");
                            if (client.getNightsBooked() >= 5) {
                                System.out.println("Your first day of reservation is free!");
                                //isValid = true;
                                break;
                            }
                        } else {
                            if (Utilities.isPaydayDay(client)) {
                                System.out.println("Discount valid!");
                                System.out.println("You get a 7% app.discount to your overall price!");
                                //isValid = true;
                                break;
                            }
                        }

                    }
                    if (!isValid) {
                        System.out.println("Discount invalid! Try again?");
                        System.out.println("[Y]es or [N]o?");
                        String tryDiscountAgain = sc.nextLine();
                        if (tryDiscountAgain.equalsIgnoreCase("n")) {
                            isValid = true;
                        }
                    }
                } while (!isValid);
            }

            if (discount != null) {
                float discountPrice = discount.applyDiscount(client);
                System.out.printf("Discounted: $%.2f\n", discountPrice);
            }

            System.out.printf("Total reservation price: $%.2f\n", client.getNormalPrice());
        }
    }

    public static Discount getDiscountCode(String code){
        switch(code){
            case "I_WORK_HERE":
                return new IWorkHereDiscount();
            case "STAY4_GET1":
                return new Stay4Get1Discount();
            case "PAYDAY":
                return new PaydayDiscount();
            default:
                return null;
        }
    }

    public static void setRoomType(Hotel hotel){
        int type = 0;
        int number;
        Room room;

            DisplayManager.viewRooms(hotel);

            do {
                System.out.printf("Enter choice: ");
                number = Utilities.intInput();
                if (!(1 <= number && number <= hotel.getRoomCount())) {
                    System.out.println("Out of bounds, try again.");
                }
            } while (!(1 <= number && number <= hotel.getRoomCount()));

            room = hotel.getRoom(number-1);

            if(Utilities.isRoomOccupied(hotel, room, 1, 30));
            do {
                System.out.println("What type of room do you want to change this room to?");
                System.out.println("[1] Standard (1x base rate)");
                System.out.println("[2] Deluxe (20% more from base rate)");
                System.out.println("[3] Executive (35% more from base rate)");
                System.out.print(": ");
                type = Utilities.intInput(1, 3);
            } while(type < 1 || type > 3);

            switch(type){
                case 1:
                    room.setRoomType("Standard");
                    break;
                case 2:
                    room.setRoomType("Deluxe");
                    break;
                case 3:
                    room.setRoomType("Executive");
                    break;
            }

    }
}