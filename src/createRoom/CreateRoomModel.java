package createRoom;

import app.Hotel;
import app.Room;
import mainMenu.MainMenuModel;

import java.util.ArrayList;

public class CreateRoomModel {

    private ArrayList<Hotel> hotels;
    private Hotel selectedHotel;

    public CreateRoomModel(ArrayList<Hotel> hotels, Hotel selectedHotel, boolean fromCreateHotel){
        this.hotels = hotels;
        this.selectedHotel = selectedHotel;
        new CreateRoomController(this, fromCreateHotel);
    }

    public ArrayList<Hotel> getHotels(){
        return this.hotels;
    }

    public Hotel getSelectedHotel(){
        return selectedHotel;
    }

    public void addRoom(Room room){
        for (Hotel hotel : hotels){
            if (hotel == selectedHotel){
                hotel.addRoom(room);
            }
        }
    }

    public void mainMenu(){
        new MainMenuModel(hotels);
    }



}
