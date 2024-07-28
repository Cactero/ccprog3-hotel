package manageHotel;

import chooseHotel.ChooseHotelModel;
import main.AbstractController;
import main.MainFrame;

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

    /**
     * Switches to the Main Menu view.
     */
    public void cancel(){
        frame.switchView(((ManageHotelModel) model).mainMenu());
    }

    /**
     * Switches to the Choose Hotel view with the Add Rooms source.
     */
    public void addRooms() {
        frame.switchView(((ManageHotelModel) model).chooseHotel(ChooseHotelModel.ADD_ROOMS));
    }

    /**
     * Switches to the Choose Hotel view with the Remove Rooms source.
     */
    public void removeRooms() {
        frame.switchView(((ManageHotelModel) model).chooseHotel(ChooseHotelModel.REMOVE_ROOMS));
    }

    /**
     * Switches to the Choose Hotel view with the Change Hotel Name source.
     */
    public void changeHotelName() {
        frame.switchView(((ManageHotelModel) model).chooseHotel(ChooseHotelModel.CHANGE_HOTEL_NAME));
    }

    /**
     * Switches to the Choose Hotel view with the Update Base Price source.
     */
    public void updateBasePrice() {
        frame.switchView(((ManageHotelModel) model).chooseHotel(ChooseHotelModel.UPDATE_BASE_PRICE));
    }

    /**
     * Switches to the Choose Hotel view with the Remove Reservation source.
     */
    public void removeReservation() {
        frame.switchView(((ManageHotelModel) model).chooseHotel(ChooseHotelModel.REMOVE_RESERVATION));
    }

    /**
     * Switches to the Choose Hotel view with the Remove Hotel source.
     */
    public void removeHotel() {
        frame.switchView(((ManageHotelModel) model).chooseHotel(ChooseHotelModel.REMOVE_HOTEL));
    }

    /**
     * Switches to the Choose Hotel view with the Change Room Type source.
     */
    public void changeRoomType() {
        frame.switchView(((ManageHotelModel) model).chooseHotel(ChooseHotelModel.CHANGE_ROOM_TYPE));
    }

    /**
     * Switches to the Choose Hotel view with the Date Price Modifier source.
     */
    public void datePriceModifier() {
        frame.switchView(((ManageHotelModel) model).chooseHotel(ChooseHotelModel.DATE_PRICE_MODIFIER));
    }

}
