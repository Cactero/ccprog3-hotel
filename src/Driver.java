import java.util.Scanner;

public class Driver {
    static int hotelCount = 0;

    static private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean programStatus = true;
        Hotel hotels[] = new Hotel[100];

        ManageHotel manageHotel = new ManageHotel();

        while(programStatus){

            int option = DisplayManager.mainMenuOptions();
            switch(option){
                case 1: // Create Hotel
                    //String name = DisplayManager.enterHotelName();

                    System.out.printf("Enter hotel name: ");
                    String name = sc.nextLine();
                    Room[] rooms = new Room[50];
                    hotels[hotelCount] = new Hotel(name, 0,1299, rooms);

                    manageHotel.addRooms(hotels[hotelCount]);
                    hotelCount++;
                    break;
                case 2: // View Hotel
                    Hotel hotelOption = DisplayManager.showHotels(hotels);
                    DisplayManager.viewHotel(hotelOption);
                    DisplayManager.viewRooms(hotelOption);
                    break;
                case 3: // Manage Hotel
                    DisplayManager.viewHotel(hotels[0]);
                    int manageOption = DisplayManager.manageHotelOptions();
                    switch(manageOption){
                        case 1: // Change the name of the hotel
                            break;
                        case 2: // Add rooms
                            manageHotel.addRooms(hotels[0]);
                            break;
                    }
                    DisplayManager.viewHotel(hotels[0]);
                    DisplayManager.viewRooms(hotels[0]);
                    break;
            }
        }
    }
}