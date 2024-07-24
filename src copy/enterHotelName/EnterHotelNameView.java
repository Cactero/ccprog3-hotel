package enterHotelName;

import main.AbstractView;
import shared.TemplateHeaderLabel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * The View for Enter Hotel Name.
 * @author Angela Domingo
 */
public class EnterHotelNameView extends AbstractView {

    private JPanel contentHolder;
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
        // background image
        try {
            bgImage = ImageIO.read(this.getClass().getResource("/assets/WINDOW_BACKGROUND.png"));
            contentHolder = new JPanel(new BorderLayout()) {
                @Override public void paintComponent(Graphics g) {
                    g.drawImage(bgImage, 0, 0, this.getWidth(), this.getHeight(), this);
                }
            };
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // app name image
        headerHolder = new JPanel();
        headerHolder.setOpaque(false);
        headerImage = new ImageIcon(this.getClass().getResource("/assets/ENTER_HOTEL_NAME.png"));
        headerLabel = new TemplateHeaderLabel(headerImage, headerHolder);
        headerHolder.add(headerLabel);
        contentHolder.add(headerHolder, BorderLayout.NORTH);

//        // text field for hotel name input
//        hotelName = JOptionPane.showInputDialog("Enter your hotel name:");

    }

    /**
     * Returns the current content inside JOptionPane.showInputDialog.
     * @return the String currently inside JOptionPane.showInputDialog
     */
    public String getHotelName() {
        return hotelName;
    }
}
