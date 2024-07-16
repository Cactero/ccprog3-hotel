package chooseHotel;

import app.Hotel;
import createReservation.CreateReservationModel;
import createRoom.CreateRoomModel;
import enterHotelName.EnterHotelNameModel;
import mainMenu.MainMenuModel;
import manageHotel.ManageHotelModel;

import java.util.ArrayList;

public class ChooseHotelModel {

    private ArrayList<Hotel> hotels;

    public ChooseHotelModel(ArrayList<Hotel> hotels, boolean fromCreateReservation){
        this.hotels = hotels;
        new ChooseHotelController(this, fromCreateReservation);
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

    public void changeHotelName(){
        new EnterHotelNameModel(hotels, true);
    }

//    public void createRoom(Hotel selectedHotel){
//        new CreateRoomModel(hotels, selectedHotel, false);
//    }
//
//    public void removeRoom(Hotel selectedHotel){
//        new RemoveRoomModel(hotels, selectedHotel);
//    }
//
//    public void updateBasePrice(Hotel selectedHotel){
//        new UpdateBasePriceModel(hotels, selectedHotel);
//    }
//
//    public void removeReservation(Hotel selectedHotel){
//        new RemoveReservationModel(hotels, selectedHotel);
//    }
//
//    public void changeRoomType(Hotel selectedHotel){
//        new ChangeRoomTypeModel(hotels, selectedHotel);
//    }
}
