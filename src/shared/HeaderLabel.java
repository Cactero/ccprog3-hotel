package shared;

import javax.swing.*;
import java.awt.*;

public class HeaderLabel extends JLabel {

    private ImageIcon headerImage;

    public HeaderLabel(ImageIcon headerImage) {
        super();
        this.headerImage = headerImage;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // Call the superclass's paintComponent method to ensure the background is drawn
        if (headerImage != null) {
            Image image = headerImage.getImage();
            int panelWidth = getWidth();
            int panelHeight = getHeight();
            int imageWidth = image.getWidth(this);
            int imageHeight = image.getHeight(this);

            // Check if imageWidth and imageHeight are valid
            if (imageWidth > 0 && imageHeight > 0) {
                // Calculate the new dimensions of the image to maintain aspect ratio
                double aspectRatio = (double) imageWidth / imageHeight;
                int newWidth, newHeight;

                if (panelWidth < panelHeight * aspectRatio) {
                    newWidth = panelWidth;
                    newHeight = (int) (panelWidth / aspectRatio);
                } else {
                    newHeight = panelHeight;
                    newWidth = (int) (panelHeight * aspectRatio);
                }

                // Center the image
                int x = (panelWidth - newWidth) / 2;
                int y = (panelHeight - newHeight) / 2;

                // Draw the scaled image
                g.drawImage(image, x, y, newWidth, newHeight, this);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 100);  // Set a default size for layout purposes
    }
}
