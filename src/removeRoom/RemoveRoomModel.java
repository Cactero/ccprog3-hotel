package removeRoom;

import Model.CentralModel;
import Model.Hotel;
import Model.Room;
import shared.AbstractModel;
import Model.MainFrame;
import shared.SelectableHotel;

/**
 * The Model for Remove Room.
 * @author Angela Domingo
 */
public class RemoveRoomModel extends AbstractModel implements SelectableHotel {

    private Hotel selectedHotel;

    public RemoveRoomModel(CentralModel centralModel, MainFrame frame) {
        super(centralModel);
        controller = new RemoveRoomController(this, frame);
    }

    public void removeRoom(Room room){
        int index = centralModel.getHotels().indexOf(selectedHotel);
        centralModel.getHotel(index).removeRoom(room);
    }

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
}
