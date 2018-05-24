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
import java.util.Map;

public class ThumbnailPanelController extends JPanel
{
    private ThumbnailPanelView thumbnailPanelView;
    LocalImageCollection collection;
    private SingleImageView singleImageView;
    private CardLayout deck;

    public ThumbnailPanelController() throws IOException
    {


        thumbnailPanelView = new ThumbnailPanelView();
        collection = new LocalImageCollection();
        collection.initImageList();
        collection.getImageCollection();
        setLayout(new CardLayout());
        JScrollPane thumbnailGallery = new JScrollPane(thumbnailPanelView);
        add("gallery", thumbnailGallery);
        deck = (CardLayout)(getLayout());
        initSingleImageViews();
        initThumbnailPanel();

    }


    private void initThumbnailPanel() throws IOException
    {
        ResizeImageService resizeImageService = new ResizeImageService();

        for (Map.Entry<String, ImageIcon> pair : collection.getImageCollection().entrySet())
        {

            Image temp = resizeImageService.makeThumbnail(pair.getValue()); //TODO redesign, put resizeImageService in ThumbnailView
            ThumbnailView thumbnailView = new ThumbnailView(new ImageIcon(temp));
            thumbnailView.imageThumbnail.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseClicked(MouseEvent e)
                {
                    super.mouseClicked(e);
                    System.out.println("image clicked : "+pair.getKey());
                    showCard(pair.getKey());
                }
            });
            thumbnailPanelView.ThumbnailPanelView(thumbnailView);
        }
    }

    private void initSingleImageViews()
    {
        for (Map.Entry<String, ImageIcon> pair : collection.getImageCollection().entrySet())
        {
            singleImageView = new SingleImageView(pair.getValue());
            insertCardsToDeck(pair.getKey(),singleImageView);
        }
    }


    private void insertCardsToDeck(String name, SingleImageView singleImageView)
    {
        add(singleImageView,name);
    }

    public void nextImage()
    {
        deck.next(this);
    }

    private void showCard(String name)
    {
        deck.show(this, name);

    }
    public void previousImage()
    {
        deck.previous(this);
    }

    public void showGallery()
    {
        deck.show(this,"gallery");
    }
}