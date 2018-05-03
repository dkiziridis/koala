package gr.teicm.koala.views;

import gr.teicm.koala.IGalleryListener;

import java.awt.*;
import javax.swing.*;

public class GalleryView extends JPanel
{
    /*public JList<JLabel> imageCollection;*/
    public JLabel image = new JLabel();
    public JPanel galleryPanel = new JPanel();


    public GalleryView()
    {
        galleryPanel.setLayout(new GridLayout(6, 6));

        setLayout(new BorderLayout());
        //add(new JScrollPane(galleryPanel), BorderLayout.CENTER);
        add(galleryPanel);
        add(new JScrollPane(galleryPanel));

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
        //image.setIcon(scaled);


            galleryPanel.add(new JLabel(new ImageIcon(String.valueOf(scaled))));


        galleryPanel.setBorder(BorderFactory.createLineBorder(Color.black));
    }




}