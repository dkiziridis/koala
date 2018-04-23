package gr.teicm.koala.views;

import java.awt.BorderLayout;
import javax.swing.*;

public class GalleryView extends JPanel
{
    public JLabel image;

    public GalleryView()
    {
        image = new JLabel();
        setLayout(new BorderLayout());
        add(new JScrollPane(image), BorderLayout.CENTER);
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