package createRoom;

import createHotel.CreateHotelModel;
import createHotel.CreateHotelView;

public class CreateRoomController {

    private CreateRoomModel createRoomModel;
    private CreateRoomView createRoomView;

    public CreateRoomController(CreateRoomModel createRoomModel, boolean fromCreateHotel) {
        this.createRoomModel = createRoomModel;
        this.createRoomView = new CreateRoomView(fromCreateHotel);
    }
}
