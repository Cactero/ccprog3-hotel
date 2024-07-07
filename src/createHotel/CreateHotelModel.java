package createHotel;

import app.*;

public class CreateHotelModel {
    private CreateHotelController createHotelController;
    private Hotel hotel;

    public CreateHotelModel(){
        this.createHotelController = new CreateHotelController(this, hotel);
    }


}
