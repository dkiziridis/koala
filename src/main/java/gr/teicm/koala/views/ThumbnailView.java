package gr.teicm.koala.views;

import gr.teicm.koala.services.ResizeImageService;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ThumbnailView extends JPanel
{

    JLabel imageThumbnail = new JLabel();
    public ThumbnailView(ImageIcon image)
    {
        imageThumbnail.setIcon(image);
        add(imageThumbnail);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public void setImageThumbnail(JLabel imageThumbnail)
    {
        this.imageThumbnail = imageThumbnail;
    }
}
