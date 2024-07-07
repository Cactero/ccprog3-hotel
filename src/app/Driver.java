package app;

import java.util.ArrayList;

/**
 * The main file of the entire program, which contains the main function.
 * @author Ryan Gemal
 * @author Angela Domingo
 */
public class Driver {
    
    /**
     * The main function of the program.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        boolean programStatus = true;
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();

        while(programStatus){
            int option = DisplayManager.mainMenuOptions();
            switch(option){
                case 1: // Create Hotel
                    boolean hasConflict;
                    do {
                        String name = DisplayManager.enterHotelName();
                        hasConflict = false;

                        for (int i = 0; i < hotels.size(); i++) {
                            if (name.equals(hotels.get(i).getName())) {
                                hasConflict = true;
                            }       
                        }

                        if (!hasConflict) {
                            hotels.add(new Hotel(name));
                        } else {
                            System.out.println("Name conflict found, enter a new name.");
                        }
                    } while (hasConflict);
                    

                    System.out.println("Since you just created a hotel, you must add a room.");
                    ManageHotel.addRooms(hotels.getLast());
                    break;

                case 2: // View Hotel
                    if(hotels.isEmpty()){
                        System.out.println("There are currently no hotels.");
                    }
                    else {
                        Hotel hotelOption = DisplayManager.chooseHotel(hotels);
                        DisplayManager.viewHotel(hotelOption);
                    }
                    break;

                case 3: // Manage Hotel
                    if(hotels.isEmpty()){
                        System.out.println("There are currently no hotels.");
                    }
                    else {
                        Hotel hotelOption = DisplayManager.chooseHotel(hotels);

                        int manageOption = DisplayManager.manageHotelOptions();
                        switch (manageOption) {
                            case 1: // Change the name of the hotel
                                String newName = DisplayManager.enterHotelName();
                                ManageHotel.changeHotelName(hotelOption, newName);
                                break;
                            case 2: // Add rooms
                                ManageHotel.addRooms(hotelOption);
                                break;
                            case 3:
                                ManageHotel.removeRooms(hotelOption);
                                break;
                            case 4:
                                ManageHotel.updateBasePrice(hotelOption);
                                break;
                            case 5:
                                ManageHotel.removeReservation(hotelOption);
                                break;
                            case 6:
                                ManageHotel.removeHotel(hotels);
                                break;
                            case 7:
                                ManageHotel.setRoomType(hotelOption);
                        }
                    }
                    break;
                case 4: // Simulate Booking
                    if (hotels.isEmpty()) {
                        System.out.println("There are currently no hotels.");
                    } else {
                        ManageHotel.addReservation(hotels);
                    }
                    break;
                case 5: // exit program
                    programStatus = false;
                    System.out.println("Exiting the program...");
                    break;
            }
        }
    }
}