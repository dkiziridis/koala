package gr.teicm.koala.controllers;

import gr.teicm.koala.models.LocalImageCollection;
import gr.teicm.koala.services.ResizeImageService;
import gr.teicm.koala.views.SingleImageView;
import gr.teicm.koala.views.ThumbnailPanelView;
import gr.teicm.koala.views.ThumbnailView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class ThumbnailPanelController extends JPanel
{
    public JLabel image;
    public ThumbnailPanelView thumbnailPanelView;
    public ThumbnailView thumbnailView;
    private JScrollPane scrollPane;
    LocalImageCollection collection;


    public ThumbnailPanelController() throws IOException
    {

        //image = new JLabel();
        thumbnailPanelView = new ThumbnailPanelView();
        collection = new LocalImageCollection();
        collection.setImageList();
        collection.getImageList();
        setLayout(new CardLayout());
        scrollPane = new JScrollPane(thumbnailPanelView);

        add(scrollPane);

        initializeThumbnailPanel();

    }


    private void initializeThumbnailPanel() throws IOException
    {
        ResizeImageService resizeImageService = new ResizeImageService();

        for (ImageIcon imageIcon : collection.getImageList())
        {
            Image temp = resizeImageService.resizeImage(imageIcon); //TODO redesign, put resizeImageService in ThumbnailView
            ImageIcon img = new ImageIcon(temp);
            thumbnailView = new ThumbnailView(img);
            thumbnailPanelView.insertThumbnail(thumbnailView);


        }
    }

    public void insertImage(ImageIcon imageIcon)
    {
        image.setIcon(imageIcon);
    }

    public void clearImage()
    {
        thumbnailPanelView.setVisible(false);
    }

}