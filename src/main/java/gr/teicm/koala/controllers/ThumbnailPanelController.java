package gr.teicm.koala.controllers;

import gr.teicm.koala.Interfaces.IThumbPanelController;
import gr.teicm.koala.models.LocalImageCollection;
import gr.teicm.koala.services.IOServices;
import gr.teicm.koala.services.ResizeImageService;
import gr.teicm.koala.views.SingleImageView;
import gr.teicm.koala.views.GalleryView;
import gr.teicm.koala.views.ThumbnailView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Map;

public class ThumbnailPanelController extends JPanel implements IThumbPanelController
{
    private GalleryView galleryView;
    private LocalImageCollection collection;
    private SingleImageView singleImageView;
    private CardLayout deck;
    private static final String firstCard = "GALLERY";

    public ThumbnailPanelController() throws IOException
    {
        createComponents();
    }

    public void createComponents() throws IOException
    {
        collection = new LocalImageCollection();
        galleryView = new GalleryView();
        collection.initImageList();
        setLayout(new CardLayout());
        JScrollPane thumbnailGallery = new JScrollPane(galleryView);
        add(firstCard, thumbnailGallery);
        deck = (CardLayout) (getLayout());
        initSingleImageViews();
        initThumbnailPanel();
    }

    public void destroyComponents()
    {
        galleryView = null;
        collection.clear();
        deck = null;
        removeAll();

    }

    private void initThumbnailPanel() throws IOException
    {
        ResizeImageService resizeImageService = new ResizeImageService();

        for (Map.Entry<String, ImageIcon> pair : collection.getImageCollection().entrySet())
        {
            Image temp = resizeImageService.makeThumbnail(pair.getValue());
            ThumbnailView thumbnailView = new ThumbnailView(new ImageIcon(temp));
            thumbnailView.imageThumbnail.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseClicked(MouseEvent e)
                {
                    super.mouseClicked(e);
                    showCard(pair.getKey());
                }
            });
            galleryView.ThumbnailPanelView(thumbnailView);
        }
    }

    private void initSingleImageViews()
    {
        for (Map.Entry<String, ImageIcon> pair : collection.getImageCollection().entrySet())
        {
            singleImageView = new SingleImageView(pair.getValue());
            insertCardToDeck(pair.getKey(), singleImageView);
        }
    }

    private void insertCardToDeck(String name, SingleImageView singleImageView)
    {
        add(singleImageView, name);
    }

    @Override
    public void nextImage()
    {
        deck.next(this);
    }

    @Override
    public void showCard(String name)
    {
        deck.show(this, name);
    }

    @Override
    public void previousImage()
    {
        deck.previous(this);
    }

    @Override
    public void setPath() throws IOException
    {
        destroyComponents();
        createComponents();
    }


    public void showGallery()
    {
        deck.show(this, firstCard);
    }

}