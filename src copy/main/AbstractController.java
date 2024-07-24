package main;

import javax.swing.*;

public abstract class AbstractController {

    protected AbstractModel model;
    protected AbstractView view;
    protected MainFrame frame;

    public AbstractController(AbstractModel model, MainFrame frame){
        this.model = model;
        this.frame = frame;
    }

    public JPanel getContentHolder(){
        return view.getContentHolder();
    }

}
