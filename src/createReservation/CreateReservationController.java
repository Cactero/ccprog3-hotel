package createReservation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateReservationController {
    private CreateReservationModel createReservationModel;
    private CreateReservationView createReservationView;

    public CreateReservationController(CreateReservationModel createReservationModel){
        this.createReservationModel = createReservationModel;
        this.createReservationView = new CreateReservationView();

        createReservationView.addCreateClientButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        createReservationView.addManageHotelButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createReservationView.dispose();
                createReservationModel.manageHotel();
            }
        });

    }

}
