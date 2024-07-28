package main;

import javax.swing.*;

/**
 * Parent abstract class for all controllers in the program.
 * @author Angela Domingo
 */
public abstract class AbstractController {

    protected AbstractModel model;
    protected AbstractView view;
    protected MainFrame frame;

    public AbstractController(AbstractModel model, MainFrame frame){
        this.model = model;
        this.frame = frame;
    }

    /**
     * Returns the content holder panel.
     * @return the JPanel that holds the content.
     */
    public JPanel getContentHolder(){
        return view.getContentHolder();
    }

}
