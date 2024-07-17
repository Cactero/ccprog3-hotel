package shared;

import javax.swing.*;
import java.awt.*;

public class HeaderLabel extends JLabel {

    private ImageIcon headerImage;
    private JPanel headerHolder;

    public HeaderLabel(ImageIcon headerImage, JPanel headerHolder){
        super();
        this.headerImage = headerImage;
        this.headerHolder = headerHolder;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = headerImage.getImage();
        int panelWidth = headerHolder.getWidth();
        int panelHeight = headerHolder.getHeight();
        int imageWidth = image.getWidth(headerHolder);
        int imageHeight = image.getHeight(headerHolder);
        double scalingFactor = 0.55;

        // Calculate the new dimensions of the image to maintain aspect ratio
        double aspectRatio = (double) imageHeight / imageWidth;
        int newHeight = (int) (panelHeight * scalingFactor);
        int newWidth = (int) (newHeight / aspectRatio);

        if (newWidth > panelWidth * scalingFactor) {
            newWidth = (int) (panelWidth * scalingFactor);
            newHeight = (int) (newWidth * aspectRatio);
        }

        // Center the image
        int x = (panelWidth - newWidth) / 2;
        int y = (panelHeight - newHeight) / 2;

        // Draw the scaled image
        g.drawImage(image, x, y, newWidth, newHeight, this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(headerHolder.getWidth(), 130);  // Set a default size for layout purposes
    }
}
