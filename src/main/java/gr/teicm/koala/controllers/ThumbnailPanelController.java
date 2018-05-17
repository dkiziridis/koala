package gr.teicm.koala.controllers;

import gr.teicm.koala.models.LocalImageCollection;
import gr.teicm.koala.services.ResizeImageService;
import gr.teicm.koala.views.SingleImageView;
import gr.teicm.koala.views.ThumbnailPanelView;
import gr.teicm.koala.views.ThumbnailView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class ThumbnailPanelController extends JPanel
{
    public JLabel image;
    public ThumbnailPanelView thumbnailPanelView;
    public ThumbnailView thumbnailView;
    private JScrollPane thumbnailGallery;
    LocalImageCollection collection;
    private SingleImageView singleImageView;
    CardLayout deck;

    public ThumbnailPanelController() throws IOException
    {

        //image = new JLabel();



        thumbnailPanelView = new ThumbnailPanelView();
        collection = new LocalImageCollection();
        collection.setImageList();
        collection.getImageList();
        setLayout(new CardLayout());
        thumbnailGallery = new JScrollPane(thumbnailPanelView);
        add("gallery",thumbnailGallery);
        deck = (CardLayout)(getLayout());

        initializeThumbnailPanel();

    }


    private void initializeThumbnailPanel() throws IOException
    {
        ResizeImageService resizeImageService = new ResizeImageService();

        for (ImageIcon imageIcon : collection.getImageList())
        {

            Image temp = resizeImageService.resizeImage(imageIcon); //TODO redesign, put resizeImageService in ThumbnailView
            thumbnailView = new ThumbnailView(new ImageIcon(temp));
            thumbnailView.imageThumbnail.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseClicked(MouseEvent e)
                {
                    super.mouseClicked(e);
                    System.out.println("image clicked : "+imageIcon.toString());
                    singleImageView = new SingleImageView(imageIcon);
                    showThumbnail(imageIcon.toString(),singleImageView); //Invokes function to add SingleImageView to deck


                }
            });
            thumbnailPanelView.ThumbnailPanelView(thumbnailView);

        }
    }

    public void insertImage(ImageIcon imageIcon)
    {
        image.setIcon(imageIcon);
    }

    private void showThumbnail(String name, SingleImageView singleImageView)
    {
        add(name,singleImageView); //Adds SingleImageView to deck
        deck.show(this, name);

    }
    public void clearImage()
    {
        thumbnailPanelView.setVisible(false);
    }

}