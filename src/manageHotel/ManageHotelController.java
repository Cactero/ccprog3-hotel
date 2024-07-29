package manageHotel;

import chooseHotel.ChooseHotelModel;
import shared.AbstractController;
import Model.MainFrame;

/**
 * The Controller for Manage Hotel.
 * @author Angela Domingo
 */
public class ManageHotelController extends AbstractController {

    public ManageHotelController(ManageHotelModel model, MainFrame frame) {
        super(model, frame);
        this.view = new ManageHotelView();

        ((ManageHotelView) view).addMainMenuButtonListener(_ -> cancel());
        ((ManageHotelView) view).addAddRoomsButtonListener(_ -> addRooms());
        ((ManageHotelView) view).addRemoveRoomsButtonListener(_ -> removeRooms());
        ((ManageHotelView) view).addChangeHotelNameButtonListener(_ -> changeHotelName());
        ((ManageHotelView) view).addUpdateBasePriceButtonListener(_ -> updateBasePrice());
        ((ManageHotelView) view).addRemoveReservationButtonListener(_ -> removeReservation());
        ((ManageHotelView) view).addRemoveHotelButtonListener(_ -> removeHotel());
        ((ManageHotelView) view).addChangeRoomTypeButtonListener(_ -> changeRoomType());
        ((ManageHotelView) view).addDPMButtonListener(_ -> datePriceModifier());

    }

    public void cancel(){
        frame.switchView(((ManageHotelModel) model).mainMenu());
    }

    public void addRooms() {
        frame.switchView(((ManageHotelModel) model).chooseHotel(ChooseHotelModel.ADD_ROOMS));
    }

    public void removeRooms() {
        frame.switchView(((ManageHotelModel) model).chooseHotel(ChooseHotelModel.REMOVE_ROOMS));
    }

    public void changeHotelName() {
        frame.switchView(((ManageHotelModel) model).chooseHotel(ChooseHotelModel.CHANGE_HOTEL_NAME));
    }

    public void updateBasePrice() {
        frame.switchView(((ManageHotelModel) model).chooseHotel(ChooseHotelModel.UPDATE_BASE_PRICE));
    }

    public void removeReservation() {
        frame.switchView(((ManageHotelModel) model).chooseHotel(ChooseHotelModel.REMOVE_RESERVATION));
    }

    public void removeHotel() {
        frame.switchView(((ManageHotelModel) model).chooseHotel(ChooseHotelModel.REMOVE_HOTEL));
    }

    public void changeRoomType() {
        frame.switchView(((ManageHotelModel) model).chooseHotel(ChooseHotelModel.CHANGE_ROOM_TYPE));
    }

    public void datePriceModifier() {
        frame.switchView(((ManageHotelModel) model).chooseHotel(ChooseHotelModel.DATE_PRICE_MODIFIER));
    }

}
