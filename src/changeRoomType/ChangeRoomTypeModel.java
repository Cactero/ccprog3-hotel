package changeRoomType;

import Model.CentralModel;
import Model.Hotel;
import Model.Room;
import manageHotel.ManageHotelModel;
import shared.AbstractModel;
import Model.MainFrame;
import shared.SelectableHotel;

/**
 * The Model for Change Room Type
 * @author Ryan Gemal
 */
public class ChangeRoomTypeModel extends AbstractModel implements SelectableHotel {

    private Hotel selectedHotel;

    /**
     * The Constructor for Change Room Type Model
     * @param centralModel the object of the Central Model
     * @param frame the main frame of the program
     */
    public ChangeRoomTypeModel(CentralModel centralModel, MainFrame frame){
        super(centralModel);
        controller = new ChangeRoomTypeController(this, frame);
    }

    /**
     * The Model of Manage Hotel that is retrieved when the user clicks the Cancel button.
     * @return Manage Hotel Model from the Central Model
     */
    public ManageHotelModel manageHotel(){
        return (ManageHotelModel) centralModel.getModel(CentralModel.MANAGE_HOTEL);
    }

    /**
     * Sets the selected hotel the user chose previously in the Choose Hotel screen
     * @param hotel the selected Hotel
     */
    @Override
    public void setSelectedHotel(Hotel hotel) {
        this.selectedHotel = hotel;
    }

    /**
     * Gets the selected hotel the user chose previously in the Choose Hotel screen
     * @return the selected Hotel
     */
    @Override
    public Hotel getSelectedHotel() {
        return selectedHotel;
    }

    /**
     * Sets the new room type of the selected Room.
     * @param room the Room with the type to be changed
     * @param type the new type of the Room
     */
    public void setRoomType(Room room, String type) {
        int index = getHotels().indexOf(selectedHotel);
        for(int i  = 0; i < getHotels().get(index).getRoomCount(); i++){
            if(getHotels().get(index).getRoom(i).getFormattedName().equals(room.getFormattedName())){
                getHotels().get(index).getRoom(i).setRoomType(type);
            }
        }
    }

}
