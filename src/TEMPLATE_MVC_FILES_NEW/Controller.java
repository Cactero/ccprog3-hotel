package TEMPLATE_MVC_FILES_NEW;

import app.Hotel;
import main.MainFrame;


import javax.swing.*;
import java.util.ArrayList;

public abstract class Controller {
    private Model model;
    private View view;

    private MainFrame frame;

    public Controller(ArrayList<Hotel> hotels, MainFrame frame){
        this.frame = frame;
    }

    // deconstruct the method so that it is its entire function
    private void mainMenuListener() {
        System.out.printf("hallo");
        frame.switchToModel2();
    }

    public JPanel getContentHolder(){
        return view.getContentHolder();
    }
}
