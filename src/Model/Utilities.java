package Model;

/**
 * Holds helper functions used in DisplayManager and ManageHotel.
 * @author Ryan Gemal
*/
public class Utilities {

    /**
     * Checks if the given check in and out dates are valid booking dates.
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
                    (checkInDay <= client.getCheckOutDay() && client.getCheckOutDay() < checkOutDay))) { // checks if new client's range of dates contains current client's check in day {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the selected Room is occupied on a given date.
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
     * Checks if two rooms are the same based on their names.
     * @param roomFloorA  floor of the first room
     * @param roomNumberA number of the first room
     * @param roomFloorB  floor of the second room
     * @param roomNumberB number of the second room
     * @return whether the rooms are the same or not
     */
    public static boolean roomsMatch(String roomFloorA, int roomNumberA, String roomFloorB, int roomNumberB) {
        return roomFloorA.equals(roomFloorB) && (roomNumberA == roomNumberB); // Duplicate found
    }

    /**
     * Checks if a specific day is within the client's booking period.
     * @param client the client whose booking period is being checked
     * @param day the day to check if it falls within the booking period
     * @return true if the day is within the booking period; false otherwise
     */
    public static boolean isDayBooked(Client client, int day){
        return (client.getCheckInDay() <= day && client.getCheckOutDay() > day);
    }

    /**
     * Determines if the current day is a payday for the client.
     * A day is considered a payday if the client's booking covers either the 15th or the 30th day of the month,
     * and the check-out day is not on the 15th or 30th, respectively.
     *
     * @param client the client for whom payday status is being checked
     * @return true if the current day is a payday for the client; false otherwise
     */
    public static boolean isPaydayDay(Client client){
        boolean coversDay15 = isDayBooked(client, 15);
        boolean coversDay30 = isDayBooked(client, 30);

        return (coversDay15 && client.getCheckOutDay() != 15) || (coversDay30 && client.getCheckOutDay() != 30);
    }
}
