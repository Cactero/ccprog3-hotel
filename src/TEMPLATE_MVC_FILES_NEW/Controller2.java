package TEMPLATE_MVC_FILES_NEW;

import Model.Hotel;
import main.MainFrame;

import javax.swing.*;
import java.util.ArrayList;

public class Controller2 {
    Model2 modelFileOfFolder;
    View2 viewFileOfController;

    private ActualFrame frame;

    public Controller2(Model2 model, ActualFrame frame){
        this.modelFileOfFolder = model;
        this.viewFileOfController = new View2();
        this.frame = frame;

        viewFileOfController.addMainMenuButtonListener(this::mainMenuListener);
    }

    // deconstruct the method so that it is its entire function
    private void mainMenuListener() {
        System.out.println("haiiiiiiiiii");
        frame.switchViews(viewFileOfController.getContentHolder());
    }

    public JPanel getContentHolder(){
        return viewFileOfController.getContentHolder();
    }
}
