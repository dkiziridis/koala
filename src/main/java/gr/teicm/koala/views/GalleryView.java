package gr.teicm.koala.views;

import gr.teicm.koala.IGalleryListener;
import gr.teicm.koala.IServiceListener;

import java.awt.*;
import javax.swing.*;

public class GalleryView extends JPanel implements IGalleryListener
{
    /*public JList<JLabel> imageCollection;*/
    public JLabel image = new JLabel();
    public JPanel galleryPanel = new JPanel();
    private IGalleryListener listener;


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

    public void setThumbnail(JPanel thumbnail)
    {
        //image.setIcon(scaled);
        galleryPanel.add(thumbnail);
        galleryPanel.setSize(4 * 128, 4 * 128);
    }


    public void setGalleryListener(IGalleryListener galleryListener)
    {
        this.listener = galleryListener;
    }
}