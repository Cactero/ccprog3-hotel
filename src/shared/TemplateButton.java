package shared;

import java.awt.*;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * A template for the button visuals seen in the views.
 * @author Angela Domingo
 */
public class TemplateButton extends JButton{

    /**
     * The Constructor for Template Button.
     * @param text the text shown on the button
     */
    public TemplateButton(String text){
        setText(text);
        setFont(new Font("Sans Serif", Font.BOLD, 17));
        setHorizontalTextPosition(JButton.CENTER);
        ImageIcon image = new ImageIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/assets/BUTTON.png"))).getImage().getScaledInstance((int) (442/1.9),(int) (121/1.9), Image.SCALE_SMOOTH));
        setIcon(image);
        setSize(new Dimension(image.getIconWidth(), image.getIconHeight()));
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }
}
