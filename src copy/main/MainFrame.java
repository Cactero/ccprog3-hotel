package main;

import Model.CentralModel;
import Model.Hotel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

// this does NOT get replicated, only one frame ever.
public class MainFrame extends JFrame {

    private JPanel contentHolder;

    public MainFrame(){

        CentralModel database = new CentralModel(this);
        contentHolder = database.getModel(CentralModel.MAIN_MENU).getContentHolder();

        setTitle("CCPROG3 MCO: Hotel Reservation System (S27 Group 5)");
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
        revalidate();
        repaint();

    }

}
