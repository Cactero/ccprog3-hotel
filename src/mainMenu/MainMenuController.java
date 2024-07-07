package mainMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuController {
    private JButton button1;
    private JPanel panel1;
    private final MainMenuModel mainMenuModel;

    public MainMenuController(MainMenuModel mainMenuModel) {
        this.mainMenuModel = mainMenuModel;

        JFrame frame = new JFrame("App");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, "Create hotel");
                MainMenuModel.createHotel();
            }
        });
    }


}
