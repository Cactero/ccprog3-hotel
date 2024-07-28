package main;

import shared.TemplateHeaderLabel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

/**
 * Parent abstract class for all views in the program.
 * @author Angela Domingo
 */
public abstract class AbstractView {
    protected JPanel contentHolder;

    public AbstractView(String headerImageSource){
        if (headerImageSource != null){
            // background image
            try {
                Image bgImage = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/assets/WINDOW_BACKGROUND.png")));
                contentHolder = new JPanel(new BorderLayout()) {
                    @Override public void paintComponent(Graphics g) {
                        g.drawImage(bgImage, 0, 0, this.getWidth(), this.getHeight(), this);
                    }
                };
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            JPanel headerHolder = new JPanel();
            headerHolder.setOpaque(false);
            ImageIcon headerImage = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(headerImageSource)));
            JLabel headerLabel = new TemplateHeaderLabel(headerImage, headerHolder);
            headerHolder.add(headerLabel);
            contentHolder.add(headerHolder, BorderLayout.NORTH);
        }

    }

    /**
     * Returns the content holder panel.
     * @return the JPanel that holds the content.
     */
    public JPanel getContentHolder() {
        return contentHolder;
    }
}
