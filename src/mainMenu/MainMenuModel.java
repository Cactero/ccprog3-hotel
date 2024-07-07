package mainMenu;

import createHotel.CreateHotelModel;

public class MainMenuModel {
    private MainMenuController mainMenuController;

    public MainMenuModel(){
        this.mainMenuController = new MainMenuController(this);
    }

    public static void createHotel(){
        CreateHotelModel createHotelController = new CreateHotelModel();
    }


}
