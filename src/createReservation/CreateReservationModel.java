package createReservation;

import app.Client;
import app.Hotel;
import mainMenu.MainMenuModel;
import manageHotel.ManageHotelModel;

import java.util.ArrayList;

public class CreateReservationModel {
    private ArrayList<Hotel> hotels;
    private Hotel selectedHotel;

    public CreateReservationModel(ArrayList<Hotel> hotels, Hotel selectedHotel){
        this.hotels = hotels;
        this.selectedHotel = selectedHotel;
        new CreateReservationController(this);
    }

    public ArrayList<Hotel> getHotels(){
        return this.hotels;
    }

    public Hotel getSelectedHotel(){
        return selectedHotel;
    }

    public void addClient(Client client){
        selectedHotel.addClient(client);
    }

    public void mainMenu(){
        new MainMenuModel(hotels);
    }

}
