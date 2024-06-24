/**
 * @author Ryan Gemal
 * @author Angela Domingo
 */

import java.util.Scanner;

public class Driver {
    static private int hotelCount = 0;

    static private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean programStatus = true;
        Hotel hotels[] = new Hotel[100];

        ManageHotel manageHotel = new ManageHotel();

        while(programStatus){

            int option = DisplayManager.mainMenuOptions();
            switch(option){
                case 1: // Create Hotel
                    String name = DisplayManager.enterHotelName();
                    hotels[hotelCount] = new Hotel(name);

                    System.out.println("Since you just created a hotel, you must add a room.");
                    manageHotel.addRooms(hotels[hotelCount]);
                    hotelCount++;
                    break;

                case 2: // View Hotel
                    if(hotelCount == 0){
                        System.out.println("There are currently no hotels.");
                    }
                    else{
                        Hotel hotelOption = DisplayManager.showHotels(hotels);
                        DisplayManager.viewHotel(hotelOption);
                        DisplayManager.viewRooms(hotelOption);
                    }
                    break;

                case 3: // Manage Hotel
                    if(hotelCount == 0){
                        System.out.println("There are currently no hotels.");
                    }
                    else {
                        Hotel hotelOption = DisplayManager.showHotels(hotels);
                        DisplayManager.viewHotel(hotelOption);

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
                        DisplayManager.viewHotel(hotels[0]);
                        DisplayManager.viewRooms(hotels[0]);
                    }
                    break;
            }
        }
    }
}