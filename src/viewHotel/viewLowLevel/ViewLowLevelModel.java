package viewHotel.viewLowLevel;

import Model.CentralModel;
import Model.Client;
import Model.Hotel;
import chooseHotel.ChooseHotelModel;
import shared.AbstractModel;
import Model.MainFrame;
import shared.SelectableHotel;
import shared.SelectableReservation;
import viewHotel.ViewHotelModel;
import viewHotel.viewReservation.ViewReservationModel;

import java.util.HashMap;

/**
 * The Model for View Room Availability
 * @author Ryan Gemal
 */
public class ViewLowLevelModel extends AbstractModel {

    String source;

    private Hotel selectedHotel;
    private ViewHotelModel viewHotelModel;

    private HashMap<String, AbstractModel> models;

    public static final String VIEW_RESERVATION = "View Reservation";

    public ViewLowLevelModel(ViewHotelModel viewHotelModel, CentralModel centralModel, MainFrame frame){
        super(centralModel);
        this.viewHotelModel = viewHotelModel;
        controller = new ViewLowLevelController(this, frame);

        models = new HashMap<>();
        models.put(VIEW_RESERVATION, new ViewReservationModel(this, centralModel, frame));
    }

    public AbstractModel mainMenu() {
        return centralModel.getModel(CentralModel.MAIN_MENU);
    }

    /**
     * The Model of View Hotel that is retrieved when the user clicks the Cancel button
     */
    public AbstractModel viewHotel(){
        return viewHotelModel;
    }

    /**
     * The Model of Choose Client that is retrieved when the user clicks one of the buttons
     */
    public AbstractModel chooseClient(String source){
        ViewLowLevelModel model = (ViewLowLevelModel) centralModel.getModel("View Low level");
        model.setSource(source);
        return model;
    }

    /**
     * Sets the selected hotel the user chose previously in the Choose Hotel screen
     * @param hotel the selected Hotel
     */
    public void setSelectedHotel(Hotel hotel) {
        this.selectedHotel = hotel;
    }

    /**
     * Gets the selected hotel the user chose previously in the Choose Hotel screen
     * @return the selected Hotel
     */
    public Hotel getSelectedHotel() {
        return selectedHotel;
    }

    /**
     * Retrieves the desired Model from a HashMap created in ViewLowLevel Model
     * @param client the Hotel selected by the user
     * @param key lookup value for desired Model, uses ViewLowLevel macros
     * @return the desired Model depending on the passed key value
     */
    public AbstractModel getModel(Client client, String key){
        SelectableReservation currentModel = (SelectableReservation) this.models.get(key);
        currentModel.setSelectedReservation(client);
        return (AbstractModel) currentModel;
    }

    /**
     * A setter for the source of where View Low Level was triggered.
     * @param source the source where View Low Level was triggered, used by passing through static final variables found inside View Model
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * A getter for the source of where View Low Level was triggered.
     * @return the source where View Low Level was triggered
     */
    public String getSource() {
        return source;
    }

}
