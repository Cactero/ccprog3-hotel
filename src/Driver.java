/**
 * @author Ryan Gemal
 * @author Angela Domingo
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    static private int hotelCount = 0;

    static private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean programStatus = true;
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        //Hotel hotels[] = new Hotel[100];

        ManageHotel manageHotel = new ManageHotel();

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
                    manageHotel.addRooms(hotels.get(hotelCount));
                    break;

                case 2: // View Hotel
                    if(hotels.size() == 0){
                        System.out.println("There are currently no hotels.");
                    }
                    else{
                        Hotel hotelOption = DisplayManager.showHotels(hotels);
                        DisplayManager.viewHotel(hotelOption);
                        DisplayManager.viewRooms(hotelOption);
                    }
                    break;

                case 3: // Manage Hotel
                    if(hotels.size() == 0){
                        System.out.println("There are currently no hotels.");
                    }
                    else {
                        Hotel hotelOption = DisplayManager.showHotels(hotels);

                        int manageOption = DisplayManager.manageHotelOptions();
                        switch (manageOption) {
                            case 1: // Change the name of the hotel
                                String newName = DisplayManager.enterHotelName();
                                manageHotel.changeHotelName(hotelOption, newName);
                                break;
                            case 2: // Add rooms
                                manageHotel.addRooms(hotelOption);
                                break;
                            case 3:
                                manageHotel.removeRooms(hotelOption);
                                break;
                            case 4:
                                manageHotel.updateBasePrice(hotelOption);
                                break;
                        }
                    }
                    break;
                case 4: // Simulate Booking
                    DisplayManager.addReservation(hotels);
                    break;
                
            }
        }
    }
}