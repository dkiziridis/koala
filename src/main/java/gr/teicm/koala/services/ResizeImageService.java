package gr.teicm.koala.services;

import gr.teicm.koala.views.GalleryView;

import javax.swing.*;
import java.awt.*;

public class ResizeImageService
{
    private static final int SIZE = 128;
    public ImageIcon resizeImage(Image image)
    {
        Image original = image;
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
        ImageIcon img = new ImageIcon(scaled);
        return img;
    }
}
