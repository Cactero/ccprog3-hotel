package TEMPLATE_MVC_FILES_NEW;

import Model.Hotel;
import main.MainFrame;


import javax.swing.*;
import java.util.ArrayList;

public class Controller {
    private Model model;
    private View view;

    private ActualFrame frame;

    public Controller(Model model, ActualFrame frame){
        this.frame = frame;
        this.model = model;
        this.view = new View();

        view.addMainMenuButtonListener(this::mainMenuListener);
    }

    // deconstruct the method so that it is its entire function
    private void mainMenuListener() {
        System.out.println("hallo");
        frame.switchViews(view.getContentHolder());
    }

    public JPanel getContentHolder(){
        return view.getContentHolder();
    }
}
