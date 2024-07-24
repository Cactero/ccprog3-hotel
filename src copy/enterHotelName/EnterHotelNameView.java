package enterHotelName;

import main.AbstractView;
import shared.TemplateHeaderLabel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/**
 * The View for Enter Hotel Name.
 * @author Angela Domingo
 */
public class EnterHotelNameView extends AbstractView {

    private Image bgImage;

    private JPanel headerHolder;
    private JLabel headerLabel;
    private ImageIcon headerImage;

    private String hotelName;

    private JPanel inputHolder;
    private JTextField hotelNameField;

    private JPanel buttonsHolder;
    private JButton mainMenuButton;
    private JButton createHotelButton;

    public EnterHotelNameView(){
        super("/assets/ENTER_HOTEL_NAME.png");

    }

    /**
     * Returns the current content inside JOptionPane.showInputDialog.
     * @return the String currently inside JOptionPane.showInputDialog
     */
    public String getHotelName() {
        return hotelName;
    }
}
