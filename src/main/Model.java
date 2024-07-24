package main;

import Model.Hotel;

import java.util.ArrayList;

public abstract class Model {

    private ArrayList<Hotel> hotels;

    public Model(ArrayList<Hotel> hotels){
        this.hotels = hotels;
    }

    public ArrayList<Hotel> getHotels() {
        return hotels;
    }
}
