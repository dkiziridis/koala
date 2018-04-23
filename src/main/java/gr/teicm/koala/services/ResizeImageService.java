package gr.teicm.koala.services;

import gr.teicm.koala.views.GalleryView;

import javax.swing.*;
import java.awt.*;

public class ResizeImageService
{

    public ImageIcon resizeImage(ImageIcon img, GalleryView galleryView)
    {
        Image imgTemp = img.getImage();
        Image newImage = imgTemp.getScaledInstance(galleryView.image.getWidth(), galleryView.image.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }
}
