import java.util.Scanner;

public class Utilities {
    private static Scanner sc = new Scanner(System.in);

    /**
     * Checks if the given check in and out dates are valid booking dates.
     * @author Angela Domingo
     * @param hotel the selected Hotel of the Client
     * @param bookedRoom the booked room of the Client
     * @param checkInDay check in day of the Client
     * @param checkOutDay check out day of the Client
     * @return if the booked dates are valid or not
     */
    public static boolean isBookedDatesValid(Hotel hotel, Room bookedRoom, int checkInDay, int checkOutDay){

        if ((1 <= checkInDay && checkInDay <= 30) && (2 <= checkOutDay && checkOutDay <= 31) && (checkInDay < checkOutDay)) {
            if (isRoomOccupied(hotel, bookedRoom, checkInDay, checkOutDay)) {
                return false;
            }
            return true;
        }
        return false;

    }

    /**
     * Checks if the selected Room is occupied based on the given check in and check out days of the new Client
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
                    (client.getCheckInDay() <= checkOutDay && checkOutDay < client.getCheckOutDay()) ||
                    (checkInDay < client.getCheckInDay() && client.getCheckInDay() <= checkOutDay) || // checks if current client's range of dates contains new client's check in day
                    (checkInDay <= client.getCheckOutDay() && client.getCheckOutDay() < checkOutDay))) { // checks if new client's range of dates contains current client's check in day) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the selected Room is occupied on a given date.
     * @author Ryan Gemal
     * @param hotel the selected Hotel
     * @param bookedRoom the booked room
     * @param date the date to check if the Room is occupied or not
     * @return if the room is occupied or not
     */
    public static boolean isRoomOccupied(Hotel hotel, Room bookedRoom, int date){
        for (Client client : hotel.getClients()){
            if((client.getCheckInDay() <= date && date <= client.getCheckOutDay()) && (client.getBookedRoom() == bookedRoom))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * A fool-proof integer input function that ensures only integers will pass.
     * @author Ryan Gemal
     * @return the integer that was correctly inputted
     */
    public static int intInput(){
        boolean invalidInput;
        int integer = 0;
        do {
            invalidInput = true;
            try {
                integer = Integer.parseInt(sc.nextLine());
                invalidInput = false;
            } catch (Exception NumberFormatException) {
                System.out.println("You must input a number. Try again.");
            }
        } while(invalidInput);
        return integer;
    }

}
