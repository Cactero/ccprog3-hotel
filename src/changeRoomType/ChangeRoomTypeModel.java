package changeRoomType;

import Model.CentralModel;
import Model.Hotel;
import Model.Room;
import shared.AbstractModel;
import Model.MainFrame;
import shared.SelectableHotel;

/**
 * The Model for Change Room Type
 * @author Ryan Gemal
 */
public class ChangeRoomTypeModel extends AbstractModel implements SelectableHotel {

    private Hotel selectedHotel;

    public ChangeRoomTypeModel(CentralModel centralModel, MainFrame frame){
        super(centralModel);
        controller = new ChangeRoomTypeController(this, frame);
    }

    /**
     * The Model of Main Menu that is created when the user clicks the Cancel button
     */
    public AbstractModel manageHotel(){
        return centralModel.getModel(CentralModel.MANAGE_HOTEL);
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

    public void setRoomType(Room inputRoom, String type) {
        for(int i  = 0; i < selectedHotel.getRoomCount(); i++){
            if(selectedHotel.getRoom(i).getFormattedName().equals(inputRoom.getFormattedName())){
                selectedHotel.getRoom(i).setRoomType(type);
            }
        }
    }

}
