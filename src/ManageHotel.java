import java.util.Scanner;

public class ManageHotel {
    private Hotel hotel;

    Scanner sc = new Scanner(System.in);

    public void addRooms(Hotel hotel){
        String roomName;
        boolean hasConflict = false;
        do {
            hasConflict = false;
            if (hotel.getNumOfRooms() < 49) {
                System.out.println("What floor will the room be? ");
                String floor = sc.nextLine();
                System.out.println("What room number will the room be? ");
                String number = sc.nextLine();
                roomName = floor + number;

                for(int i = 0; i < hotel.getNumOfRooms(); i++){
                    if(hasNameConflict(roomName, hotel.getRoom(i).getName())){
                        System.out.println("There is already a room with this name!");
                        hasConflict = true;
                    }
                }

            }
        } while(hasConflict);
    }

    public boolean hasNameConflict(String name1, String name2){
        return name1.equals(name2); // Duplicate found
    }

    public void changeHotelName(Hotel hotel, String newName){
        if(hotel.getName() == newName){
            System.out.println("This is already the hotel's name!");
        }
        else{
            hotel.setName(newName);
        }
    }
}
