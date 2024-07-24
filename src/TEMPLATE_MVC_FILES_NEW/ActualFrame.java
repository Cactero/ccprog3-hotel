package TEMPLATE_MVC_FILES_NEW;

import Model.Hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

// this does NOT get replicated, only one frame ever.
public class ActualFrame extends JFrame {

    private Model model1;
    private Model2 model2;

    private Controller controller1;
    private Controller2 controller2;
    private JPanel contentHolder;

    private ArrayList<Hotel> hotels;

    public ActualFrame(){

        hotels = new ArrayList<>();

        model1 = new Model(hotels, this);
        model2 = new Model2(hotels, this);

        contentHolder = model1.getController().getContentHolder();

//        controller1 = new Controller(hotels, this);
//        controller2 = new Controller2(hotels, this);
//        contentHolder = controller1.getContentHolder();

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

    public void switchViews(JPanel contentHolder){
        setContentPane(contentHolder);
        revalidate();
        repaint();
    }

    public void switchToModel1(){
//        contentHolder = controller1.getContentHolder();
        contentHolder = model1.getController().getContentHolder();
        setContentPane(contentHolder);
        revalidate();
        repaint();
    }


    public void switchToModel2(){
//        contentHolder = controller2.getContentHolder();
        contentHolder = model2.getController().getContentHolder();
        setContentPane(contentHolder);
        revalidate();
        repaint();
    }

}
