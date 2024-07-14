package createHotel;

import app.*;
import createRoom.CreateRoomModel;
import mainMenu.MainMenuModel;

import java.util.ArrayList;

public class CreateHotelModel {
    private ArrayList<Hotel> hotels;

    public CreateHotelModel(ArrayList<Hotel> hotels){
        this.hotels = hotels;
        new CreateHotelController(this);
    }

    public ArrayList<Hotel> getHotels(){
        return this.hotels;
    }

    public void addHotel(Hotel hotel){
        this.hotels.add(hotel);
    }

    public void mainMenu(){
        new MainMenuModel(this.hotels);
    }

    public void createRoom(Hotel hotel, boolean fromCreateHotel){
        new CreateRoomModel(this.hotels, hotel, fromCreateHotel);
    }

}
