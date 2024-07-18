package chooseHotel;

import app.Hotel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Controller for Choose Hotel.
 * @author Angela Domingo
 */
public class ChooseHotelController {

    private ChooseHotelModel chooseHotelModel;
    private ChooseHotelView chooseHotelView;

    public ChooseHotelController(ChooseHotelModel chooseHotelModel, boolean fromCreateReservation){
        this.chooseHotelModel = chooseHotelModel;
        chooseHotelView = new ChooseHotelView(this.chooseHotelModel.getHotels());

        chooseHotelView.addChooseHotelButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hotel selectedHotel = null;
                String selectedHotelName = chooseHotelView.getHotelName();
                for (Hotel hotel : chooseHotelModel.getHotels()){
                    if (hotel.getName().equals(selectedHotelName))
                        selectedHotel = hotel;
                }

                chooseHotelView.dispose();
                if (fromCreateReservation)
                    chooseHotelModel.createReservation(selectedHotel);
            }
        });

        chooseHotelView.addMainMenuButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseHotelView.dispose();
                if (fromCreateReservation)
                    chooseHotelModel.mainMenu();
                else
                    chooseHotelModel.manageHotel();
            }
        });

    }

}
