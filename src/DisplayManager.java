import java.util.Scanner;

public class DisplayManager {

    private Scanner sc;

    public DisplayManager(){
        this.sc = new Scanner(System.in);
    }

    /**
     * Displays the options to the user and asks the user to select an option.
     * This function assumes that the input given by the user is an integer and
     * has no error handling built in.
     * @return the choice the user selected
     */
    public int promptOptions(){
        System.out.printf("Input one of the following options:\n");
        System.out.printf("  1 - Create Hotel\n");
        System.out.printf("  2 - View Hotel\n");
        System.out.printf("  3 - Manage Hotel\n");

        System.out.printf("Input: ");
        int option = sc.nextInt();

        while(option<1 || option>3){
            System.out.printf("Option is incorrect!\nInput: ");
            option = sc.nextInt();
        }
        return option;
    }

    public void viewHotel(Hotel hotel){
        System.out.printf("Name of the hotel: %s\n", hotel.getName());
        System.out.printf("Total number of rooms: %d\n", hotel.getNumOfRooms());
    }
}
