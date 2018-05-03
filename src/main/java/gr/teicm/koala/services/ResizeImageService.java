package gr.teicm.koala.services;

import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResizeImageService
{
    private static final int SIZE = 128;
    public ImageIcon resizeImage(ImageIcon image) throws IOException
    {
        /*Image original = image;
        int w = original.getWidth(null);
        int h = original.getHeight(null);
        float scaleW = (float) SIZE / w;
        float scaleH = (float) SIZE / h;
        if (scaleW > scaleH)
        {
            w = -1;
            h = (int) (h * scaleH);
        } else
        {
            w = (int) (w * scaleW);
            h = -1;
        }
        Image scaled = original.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        ImageIcon img = new ImageIcon(scaled);*/



        Image imageTemp = image.getImage();
        BufferedImage buffered = (BufferedImage) imageTemp;

        BufferedImage thumbnail = Thumbnails.of(buffered)
                .size(200, 200)
                .asBufferedImage();

        ImageIcon scaled = new ImageIcon(thumbnail);

        return scaled;
    }
}
