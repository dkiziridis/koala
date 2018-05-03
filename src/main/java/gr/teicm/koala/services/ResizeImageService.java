package gr.teicm.koala.services;

import net.coobird.thumbnailator.Thumbnails;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResizeImageService
{

    public Image resizeImage(ImageIcon image) throws IOException
    {
        Image imageTemp = image.getImage();
        BufferedImage buffered = (BufferedImage) imageTemp;

        BufferedImage thumbnail = Thumbnails.of(buffered)
                .size(200, 200)
                .asBufferedImage();

        //ImageIcon scaled = new ImageIcon(thumbnail);

        return thumbnail;
    }
}
