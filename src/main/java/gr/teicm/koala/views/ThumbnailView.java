package gr.teicm.koala.views;


import javax.swing.*;
import java.awt.*;

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
