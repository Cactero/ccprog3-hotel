package createRoom;

import app.Hotel;
import app.Room;
import mainMenu.MainMenuModel;
import manageHotel.ManageHotelModel;

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
        selectedHotel.addRoom(room);
    }

    public void mainMenu(){
        new MainMenuModel(hotels);
    }

    public void manageHotel(){
        new ManageHotelModel(hotels);
    }

}
