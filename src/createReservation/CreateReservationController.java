package createReservation;

public class CreateReservationController {
    private CreateReservationModel createReservationModel;
    private CreateReservationView createReservationView;

    public CreateReservationController(CreateReservationModel createReservationModel){
        this.createReservationModel = createReservationModel;
        this.createReservationView = new CreateReservationView();
    }

}
