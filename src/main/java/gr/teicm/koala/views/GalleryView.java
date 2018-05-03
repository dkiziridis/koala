package gr.teicm.koala.views;

import java.awt.*;
import javax.swing.*;

public class GalleryView extends JPanel
{
    /*public JList<JLabel> imageCollection;*/
    public JLabel image = new JLabel();
    public JPanel galleryPanel = new JPanel();

    public GalleryView()
    {

        setLayout(new BorderLayout());
        add(new JScrollPane(galleryPanel), BorderLayout.CENTER);
    }

    public void insertImage(ImageIcon imageIcon)
    {
        image.setIcon(imageIcon);
        //imageCollection.add(image);

    }

    public void clearImage()
    {
        image.setIcon(null);
    }

    public void populatePanel(ImageIcon scaled)
    {
        galleryPanel.add(new JLabel(new ImageIcon(String.valueOf(scaled))));
        galleryPanel.setBorder(BorderFactory.createLineBorder(Color.black));
    }

}