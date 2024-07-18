package shared;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button extends JButton{
    
    public Button(String text){
        setText(text);
        setFont(new Font("Sans Serif", Font.BOLD, 17));
        setHorizontalTextPosition(JButton.CENTER);
        ImageIcon image = new ImageIcon(new ImageIcon(this.getClass().getResource("/assets/BUTTON.png")).getImage().getScaledInstance((int) (442/1.9),(int) (121/1.9), Image.SCALE_SMOOTH));
        setIcon(image);
        setSize(new Dimension(image.getIconWidth(), image.getIconHeight()));
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }
}
