package mainMenu;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button extends JButton{
    
    public Button(String text){
        setText(text);
        setFont(new Font("Sans Serif", Font.BOLD, 17));
        setHorizontalTextPosition(JButton.CENTER);
        ImageIcon image = new ImageIcon(new ImageIcon(this.getClass().getResource("/assets/MainMenu/BUTTON.png")).getImage().getScaledInstance(442/2, 121/2, Image.SCALE_DEFAULT));
        setIcon(image);
        setSize(new Dimension(442/2, 121/2));
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }
}
