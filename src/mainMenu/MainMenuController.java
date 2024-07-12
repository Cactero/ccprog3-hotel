package mainMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuController {
    private MainMenuModel mainMenuModel;
    private MainMenuView mainMenuView;

    public MainMenuController(MainMenuModel mainMenuModel) {
        this.mainMenuModel = mainMenuModel;
        this.mainMenuView = new MainMenuView();

        mainMenuView.addCreateHotelButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenuView.dispose();
                mainMenuModel.createHotel();
            }
        });

        mainMenuView.addManageHotelButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenuView.dispose();
                mainMenuModel.manageHotel();
            }
        });

        mainMenuView.addCreateReservationButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenuView.dispose();
                mainMenuModel.createReservation();
            }
        });

        mainMenuView.addExitButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }


}
