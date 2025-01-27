package Model;

import mainMenu.MainMenuModel;
import shared.AbstractController;
import shared.AbstractModel;
import shared.PopupScreen;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 * The main JFrame used in the entire program.
 * @author Angela Domingo
 */
public class MainFrame extends JFrame {

    private JPanel contentHolder;

    /**
     * The constructor of the main JFrame of the program.
     */
    public MainFrame(){
        CentralModel database = new CentralModel(this);
        MainMenuModel model = (MainMenuModel) database.getModel(CentralModel.MAIN_MENU);
        contentHolder = model.getContentHolder();

        setTitle("CCPROG3 MCO2: Hotel Reservation System (S27 Group 5)");
        setContentPane(contentHolder);
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("Thank you for using our system :)");
            }
        });
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Switches the current content of the JFrame.
     * @param model the Model of the associated frame
     */
    public void switchView(AbstractModel model){

        contentHolder = model.getContentHolder();
        setContentPane(contentHolder);
        contentHolder.setVisible(true);
        revalidate();
        repaint();

        SwingUtilities.invokeLater(() -> {

            AbstractController controller = model.getController();

            if (controller instanceof PopupScreen) {
                ((PopupScreen) controller).promptUser();
            }
            contentHolder.setVisible(true);
        });

    }

}
