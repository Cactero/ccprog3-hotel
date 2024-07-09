package mainMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuController {
    private JButton createHotelButton;
    private JPanel panel1;
    private final MainMenuModel mainMenuModel;
    private MainMenuView mainMenuView;

    public MainMenuController(MainMenuModel mainMenuModel) {
        this.mainMenuModel = mainMenuModel;
        this.mainMenuView = new MainMenuView();

        mainMenuView.addCreateHotelButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, "Create hotel");
                MainMenuModel.createHotel();
            }
        });
    }


}
