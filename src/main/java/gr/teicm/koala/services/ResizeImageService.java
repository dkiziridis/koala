package gr.teicm.koala.services;

import net.coobird.thumbnailator.Thumbnails;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResizeImageService
{

    public Image makeThumbnail(ImageIcon image) throws IOException
    {
        Image imageTemp = image.getImage();
        BufferedImage buffered = (BufferedImage) imageTemp;

        BufferedImage thumbnail = Thumbnails.of(buffered)
                .size(200, 200)
                .asBufferedImage();

        return thumbnail;
    }

    public ImageIcon resizeImage(ImageIcon image, int height, int width)
    {

        Toolkit toolkit =  Toolkit.getDefaultToolkit ();
        Dimension dim = toolkit.getScreenSize();
//        width = dim.getWidth();
//        height = dim.getHeight();
        //TODO
        return image;
    }
}
