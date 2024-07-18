package chooseHotel;

import app.Hotel;
import createReservation.CreateReservationModel;
import createRoom.CreateRoomModel;
import enterHotelName.EnterHotelNameModel;
import mainMenu.MainMenuModel;
import manageHotel.ManageHotelModel;

import java.util.ArrayList;

/**
 * The Model for Choose Hotel
 * @author Angela Domingo
 */
public class ChooseHotelModel {

    private ArrayList<Hotel> hotels;

    public ChooseHotelModel(ArrayList<Hotel> hotels, boolean fromCreateReservation){
        this.hotels = hotels;
        new ChooseHotelController(this, fromCreateReservation);
    }

    /**
     * Returns an ArrayList of hotels present in the system.
     * @return the ArrayList of hotels
     */
    public ArrayList<Hotel> getHotels(){
        return this.hotels;
    }

    /**
     * The Model of Manage Hotel that is created when the user clicks the Choose Hotel button
     */
    public void manageHotel(){
        new ManageHotelModel(hotels);
    }

    /**
     * The Model of Main Menu that is created when the user clicks the Cancel button
     */
    public void mainMenu(){
        new MainMenuModel(this.hotels);
    }

    /**
     * The Model of Create Reservation that is created when the user clicks the Choose Hotel button
     * @param hotel the chosen Hotel
     */
    public void createReservation(Hotel hotel){
        new CreateReservationModel(hotels, hotel);
    }

    /**
     * The Model of Enter Hotel Name that is created when the user clicks the Choose Hotel button
     */
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
