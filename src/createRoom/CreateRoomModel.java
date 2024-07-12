package createRoom;

import app.Hotel;

import java.util.ArrayList;

public class CreateRoomModel {

    private CreateRoomController createRoomController;
    private ArrayList<Hotel> hotels;

    public CreateRoomModel(ArrayList<Hotel> hotels, boolean fromCreateHotel){
        this.hotels = hotels;
        createRoomController = new CreateRoomController(this, fromCreateHotel);
    }

    public ArrayList<Hotel> getHotels(){
        return this.hotels;
    }
}
