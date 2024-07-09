package mainMenu;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button extends JButton{
    
    public Button(){
        ImageIcon image = new ImageIcon(this.getClass().getResource("/assets/MainMenu/BUTTON.png"));
        setIcon(image);
        setPreferredSize(new Dimension(442, 121));
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }
}
