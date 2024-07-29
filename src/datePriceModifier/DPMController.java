package datePriceModifier;

import shared.AbstractController;
import shared.AbstractModel;
import Model.MainFrame;

public class DPMController extends AbstractController {
    public DPMController(AbstractModel model, MainFrame frame) {
        super(model, frame);
        view = new DPMView();

        ((DPMView) view).addMainMenuButtonListener(_ -> cancel());
        ((DPMView) view).addAddDPMButtonListener(_ -> createDPM());
    }

    public void cancel(){
        frame.switchView(((DPMModel) model).manageHotel());
    }

    public void createDPM(){

    }

}
