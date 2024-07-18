package mainMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Controller for Main Menu
 * @author Angela Domingo
 * @author Ryan Gemal
 */
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

        mainMenuView.addViewHotelButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean hotelListEmpty = mainMenuModel.getHotels().isEmpty();

                if (!hotelListEmpty){
                    mainMenuView.dispose();
                    mainMenuModel.viewHotel();
                }
                else {
                    JOptionPane.showMessageDialog(null, "No hotel exists in the system, please make a new one first.", "No hotels found", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

        mainMenuView.addManageHotelButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean hotelListEmpty = mainMenuModel.getHotels().isEmpty();

                if (!hotelListEmpty){
                    mainMenuView.dispose();
                    mainMenuModel.manageHotel();
                }
                else {
                    JOptionPane.showMessageDialog(null, "No hotel exists in the system, please make a new one first.", "No hotels found", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

        mainMenuView.addCreateReservationButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean hotelListEmpty = mainMenuModel.getHotels().isEmpty();

                if (!hotelListEmpty){
                    mainMenuView.dispose();
                    mainMenuModel.createReservation();
                }
                else {
                    JOptionPane.showMessageDialog(null, "No hotel exists in the system, please make a new one first.", "No hotels found", JOptionPane.PLAIN_MESSAGE);
                }
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
