import java.util.Scanner;

public class ManageHotel {
    Scanner sc = new Scanner(System.in);

    public void addRooms(Hotel hotel){
        String floor = new String();
        int number = 0;
        boolean hasConflict;
        do {
            hasConflict = false;
            if (hotel.getRoomCount() < 49) {
                System.out.println("What floor will the room be? ");
                floor = sc.nextLine();
                System.out.println("What room number will the room be? ");
                number = Integer.parseInt(sc.nextLine());

                for(int i = 0; i < hotel.getRoomCount(); i++){
                    if(roomsMatch(floor, number, hotel.getRoom(i).getRoomFloor(), hotel.getRoom(i).getRoomNumber())){
                        System.out.println("There is already a room with this name!");
                        hasConflict = true;
                    }
                }

            }
        } while(hasConflict);
        
        Room newRoom = new Room(floor, number, hotel.getBasePrice());
        hotel.addRoom(newRoom);
    }

    public void removeRooms(Hotel hotel){
        String floor = new String();
        int number = 0;
        boolean notFound;
        do {
            notFound = false;
            DisplayManager.viewRooms(hotel);
            System.out.println("What floor will the room be? ");
            floor = sc.nextLine();
            System.out.println("What room number will the room be? ");
            number = Integer.parseInt(sc.nextLine());
            for(int i = 0; i < hotel.getRoomCount() && !notFound; i++){
                if(roomsMatch(floor, number, hotel.getRoom(i).getRoomFloor(), hotel.getRoom(i).getRoomNumber())){
                    notFound = false;
                    break;
                }
            }
            if(notFound) { System.out.println("Not found, try again."); }
        } while(notFound);

        Room room = new Room(floor, number, 0);
        hotel.removeRoom(room);

    }

    public boolean roomsMatch(String roomFloorA, int roomNumberA, String roomFloorB, int roomNumberB){
        return roomFloorA.equals(roomFloorB) && roomNumberA == roomNumberB; // Duplicate found
    }

    public void changeHotelName(Hotel hotel, String newName){
        if(hotel.getName().equals(newName)){
            System.out.println("This is already the hotel's name!");
        }
        else{
            hotel.setName(newName);
        }
    }

    public void updateBasePrice(Hotel hotel){
        float newPrice = 0.0F;
        if(hotel.getClientCount() != 0){
            System.out.println("Sorry, but you cannot update the base price of a room while there are reservrations.");
        }
        else{
            do {
                System.out.println("Enter a room price (Must be at least 100)");
                newPrice = sc.nextInt();

                if(newPrice < 100.0F) {
                    System.out.println("New price must be at least 100! Try again.");
                }
            } while(newPrice < 100.0F);

            hotel.setBasePrice(newPrice);
        }
    }
}