package gr.teicm.koala.views;

import java.awt.*;
import javax.swing.*;

public class GalleryView extends JPanel
{
    public JLabel image;

    public GalleryView()
    {
        image = new JLabel();
        setLayout(new GridLayout());
        add(new JScrollPane(image), BorderLayout.CENTER);
        add()
    }

    public void insertImage(ImageIcon imageIcon)
    {
        image.setIcon(imageIcon);
    }

    public void clearImage()
    {
        image.setIcon(null);
    }

}