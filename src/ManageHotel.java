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
                    if(hasNameConflict(floor, number, hotel.getRoom(i).getRoomFloor(), hotel.getRoom(i).getRoomNumber())){
                        System.out.println("There is already a room with this name!");
                        hasConflict = true;
                    }
                }

            }
        } while(hasConflict);
        
        Room newRoom = new Room(floor, number);
        hotel.addRoom(newRoom);
    }

    public boolean hasNameConflict(String roomFloorA, int roomNumberA, String roomFloorB, int roomNumberB){
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
}