package manageHotel;

import chooseHotel.ChooseHotelModel;
import shared.AbstractController;
import Model.MainFrame;

/**
 * The Controller for Manage Hotel.
 * @author Angela Domingo
 */
public class ManageHotelController extends AbstractController {

    /**
     * The Constructor for Manage Hotel Controller
     * @param model the Model object of Manage Hotel
     * @param frame the main frame of the program
     */
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
     * Brings the user back to the Main Menu screen when the Cancel button is clicked.
     */
    public void cancel(){
        frame.switchView(((ManageHotelModel) model).mainMenu());
    }

    /**
     * Switches to the Choose Hotel view that will lead to the Add Rooms view
     */
    public void addRooms() {
        frame.switchView(((ManageHotelModel) model).chooseHotel(ChooseHotelModel.ADD_ROOMS));
    }

    /**
     * Switches to the Choose Hotel view that will lead to the Remove Rooms view
     */
    public void removeRooms() {
        frame.switchView(((ManageHotelModel) model).chooseHotel(ChooseHotelModel.REMOVE_ROOMS));
    }

    /**
     * Switches to the Choose Hotel view that will lead to the Enter Hotel Name view
     */
    public void changeHotelName() {
        frame.switchView(((ManageHotelModel) model).chooseHotel(ChooseHotelModel.CHANGE_HOTEL_NAME));
    }

    /**
     * Switches to the Choose Hotel view that will lead to the Update Base Price view
     */
    public void updateBasePrice() {
        frame.switchView(((ManageHotelModel) model).chooseHotel(ChooseHotelModel.UPDATE_BASE_PRICE));
    }

    /**
     * Switches to the Choose Hotel view that will lead to the Remove Reservation view
     */
    public void removeReservation() {
        frame.switchView(((ManageHotelModel) model).chooseHotel(ChooseHotelModel.REMOVE_RESERVATION));
    }

    /**
     * Switches to the Choose Hotel view that will lead to the Remove Hotel view
     */
    public void removeHotel() {
        frame.switchView(((ManageHotelModel) model).chooseHotel(ChooseHotelModel.REMOVE_HOTEL));
    }

    /**
     * Switches to the Choose Hotel view that will lead to the Change Room Type view
     */
    public void changeRoomType() {
        frame.switchView(((ManageHotelModel) model).chooseHotel(ChooseHotelModel.CHANGE_ROOM_TYPE));
    }

    /**
     * Switches to the Choose Hotel view that will lead to the DPM view
     */
    public void datePriceModifier() {
        frame.switchView(((ManageHotelModel) model).chooseHotel(ChooseHotelModel.DATE_PRICE_MODIFIER));
    }

}
