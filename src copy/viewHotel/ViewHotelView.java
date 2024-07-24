package viewHotel;

import main.AbstractView;
import shared.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * The View of Create Room.
 * @author Angela Domingo
 */
public class ViewHotelView extends AbstractView {

    private Image bgImage;

    private JPanel headerHolder;
    private JLabel headerLabel;
    private ImageIcon headerImage;

    private JPanel centerHolder;
    private JLabel textDisplay;

    private JPanel buttonsHolder;
    private JButton mainMenuButton;
    private JButton lowLevelOptionsButton;


    public ViewHotelView(){
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

        headerHolder = new JPanel();
        headerHolder.setOpaque(false);
        headerImage = new ImageIcon(this.getClass().getResource("/assets/CHOOSE_HOTEL_NAME.png"));
        headerLabel = new TemplateHeaderLabel(headerImage, headerHolder);
        headerHolder.add(headerLabel);
        contentHolder.add(headerHolder, BorderLayout.NORTH);



        // cancel hotel creation and create hotel buttons
        buttonsHolder = new JPanel();
        buttonsHolder.setOpaque(false);
        mainMenuButton = new TemplateButton("Exit");
        lowLevelOptionsButton = new TemplateButton("Show Low Level");
        buttonsHolder.add(mainMenuButton);
        buttonsHolder.add(lowLevelOptionsButton);
        contentHolder.add(buttonsHolder, BorderLayout.SOUTH);

    }

    public void addLowLevelButtonListener(ActionListener listener) { lowLevelOptionsButton.addActionListener(listener); }
    public void addMainMenuButtonListener(ActionListener listener) { mainMenuButton.addActionListener(listener); }
}
