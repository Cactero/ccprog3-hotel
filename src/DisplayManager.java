import java.util.Scanner;

public class DisplayManager {

    static private Scanner sc = new Scanner(System.in);

    /**
     * Displays the options to the user and asks the user to select an option.
     * This function assumes that the input given by the user is an integer and
     * has no error handling built in.
     * @return the choice the user selected
     */
    static public int mainMenuOptions(){
        System.out.println("Input one of the following options:");
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

    static public int manageHotelOptions(){
        System.out.println("Input one of the following options:");
        System.out.println("  1 - Change the name of the hotel");
        System.out.println("  2 - Add rooms");
        System.out.println("  3 - Remove rooms");
        System.out.println("  4 - Update the base price for a room");
        System.out.println("  5 - Remove reservation");
        System.out.println("  6 - Remove Hotel");

        System.out.printf("Input: ");
        int option = sc.nextInt();

        while(option<1 || option>3){
            System.out.printf("Option is incorrect!\nInput: ");
            option = sc.nextInt();
        }
        return option;
    }

    static public String enterHotelName(){
        System.out.printf("Enter hotel name: ");
        String name = sc.nextLine();
        return name;
    }

    static public Hotel showHotels(Hotel[] hotels){
        System.out.println("Choose a hotel: ");
        for(int i = 0; i < hotels.length; i++){
            if(hotels[i] != null){
                System.out.printf("  %d - %s\n", i+1, hotels[i].getName());
            }
        }

        System.out.printf("Input: ");
        int option = sc.nextInt();

        while(option<1 || option>3){
            System.out.printf("Option is incorrect!\nInput: ");
            option = sc.nextInt();
        }
        return hotels[option-1];
    }
    static public void viewHotel(Hotel hotel){
        System.out.printf("Name of the hotel: %s\n", hotel.getName());
        System.out.printf("Total number of rooms: %d\n", hotel.getNumOfRooms());
    }

    static public void viewRooms(Hotel hotel){
        System.out.printf("Hotel: %s\n", hotel.getName());
        for(int i = 0; i < hotel.getNumOfRooms(); i++){
            System.out.printf("Room %d: %s%d\n", i+1, hotel.getRoom(i).getRoomFloor(), hotel.getRoom(i).getRoomNumber());
        }
    }
}
