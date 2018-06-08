package gr.teicm.koala.services;

import net.coobird.thumbnailator.Thumbnails;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static gr.teicm.koala.Enums.ThumbnailSize.HUGE;

public class ImageManipulation
{

    public ImageIcon makeThumbnail(ImageIcon image) throws IOException
    {
        Image imageTemp = image.getImage();
        BufferedImage buffered;
        buffered = (BufferedImage) imageTemp;

        return new ImageIcon(Thumbnails.of(buffered)
                .size(HUGE.getValue(),
                        HUGE.getValue())
                .asBufferedImage());

    }

    public ImageIcon imageZoom(ImageIcon imageIcon, int zoomLevel)
    {
        int newImageWidth = imageIcon.getIconWidth() * zoomLevel;
        int newImageHeight = imageIcon.getIconHeight() * zoomLevel;

        BufferedImage resizedImage = new BufferedImage(newImageWidth, newImageHeight, 4);
        resizedImage.getScaledInstance(newImageWidth, newImageHeight, 3);

        ImageIcon temp = new ImageIcon(resizedImage);

        return temp;
    }

    public static void drawScaledImage(Image image, Component canvas, Graphics g)
    {
        int imgWidth = image.getWidth(null);
        int imgHeight = image.getHeight(null);

        double imgAspect = (double) imgHeight / imgWidth;

        int canvasWidth = canvas.getWidth();
        int canvasHeight = canvas.getHeight();

        double canvasAspect = (double) canvasHeight / canvasWidth;

        int x1 = 0; // top left X position
        int y1 = 0; // top left Y position
        int x2 = 0; // bottom right X position
        int y2 = 0; // bottom right Y position

        if (imgWidth < canvasWidth && imgHeight < canvasHeight)
        {
            // the image is smaller than the canvas
            x1 = (canvasWidth - imgWidth) / 2;
            y1 = (canvasHeight - imgHeight) / 2;
            x2 = imgWidth + x1;
            y2 = imgHeight + y1;

        } else
        {
            if (canvasAspect > imgAspect)
            {
                y1 = canvasHeight;
                // keep image aspect ratio
                canvasHeight = (int) (canvasWidth * imgAspect);
                y1 = (y1 - canvasHeight) / 2;
            } else
            {
                x1 = canvasWidth;
                // keep image aspect ratio
                canvasWidth = (int) (canvasHeight / imgAspect);
                x1 = (x1 - canvasWidth) / 2;
            }
            x2 = canvasWidth + x1;
            y2 = canvasHeight + y1;
        }

        g.drawImage(image, x1, y1, x2, y2, 0, 0, imgWidth, imgHeight, null);
    }
}

