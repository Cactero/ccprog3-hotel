public class Driver {
    public static void main(String[] args) {
        Room[] rooms = new Room[5];
        Room room1 = new Room("102", 1299);
        Hotel ryan = new Hotel("Ryan", 0, rooms);
        ryan.addRoom(room1);


        DisplayManager display = new DisplayManager();
        ManageHotel manageHotel = new ManageHotel();

        display.viewHotel(ryan);
        manageHotel.addRooms(ryan);
        display.viewHotel(ryan);
    }
}