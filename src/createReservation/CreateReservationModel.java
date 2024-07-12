package createReservation;

import app.Hotel;

import java.util.ArrayList;

public class CreateReservationModel {
    private ArrayList<Hotel> hotels;

    public CreateReservationModel(ArrayList<Hotel> hotels){
        this.hotels = hotels;
        new CreateReservationController(this);
    }



}
