package gr.teicm.koala;

import java.awt.BorderLayout;
import javax.swing.*;

class GalleryView extends JPanel
{
    public JLabel image;

    GalleryView()
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