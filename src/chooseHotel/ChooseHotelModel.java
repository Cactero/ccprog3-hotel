package chooseHotel;

import app.Hotel;
import createReservation.CreateReservationModel;
import mainMenu.MainMenuModel;
import manageHotel.ManageHotelModel;

import java.util.ArrayList;

public class ChooseHotelModel {

    private ArrayList<Hotel> hotels;
    private ChooseHotelController chooseHotelController;

    public ChooseHotelModel(ArrayList<Hotel> hotels, boolean fromCreateReservation){
        this.hotels = hotels;
        chooseHotelController = new ChooseHotelController(this, fromCreateReservation);
    }

    public ArrayList<Hotel> getHotels(){
        return this.hotels;
    }

    public void manageHotel(){
        new ManageHotelModel(hotels);
    }

    public void mainMenu(){
        new MainMenuModel(this.hotels);
    }

    public void createReservation(Hotel hotel){
        new CreateReservationModel(hotels, hotel);
    }
}
