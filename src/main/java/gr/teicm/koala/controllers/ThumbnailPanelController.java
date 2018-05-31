package gr.teicm.koala.controllers;

import gr.teicm.koala.Interfaces.IThumbPanelController;
import gr.teicm.koala.models.LocalImageCollection;
import gr.teicm.koala.services.ImageManipulationService;
import gr.teicm.koala.views.GalleryView;
import gr.teicm.koala.views.SingleImageView;
import gr.teicm.koala.views.ThumbnailView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class ThumbnailPanelController extends JPanel implements IThumbPanelController
{
    private GalleryView galleryView;
    private LocalImageCollection collection;
    private SingleImageView singleImageView;
    private int currentImageIndex = 0;
    private String key;
    private ImageIcon value;

    ThumbnailPanelController() throws IOException
    {
        createComponents();
    }

    private void createComponents() throws IOException
    {
        collection = new LocalImageCollection();
        galleryView = new GalleryView();
        collection.initImageList();
        setLayout(new BorderLayout());
        JScrollPane thumbnailGallery = new JScrollPane(galleryView);
        thumbnailGallery.getVerticalScrollBar().setUnitIncrement(16);
        add(thumbnailGallery, BorderLayout.CENTER);
        initThumbnailPanel();
    }

    private void destroyComponents()
    {
        currentImageIndex = 0;
        galleryView = null;
        collection.clear();
        removeAll();

    }

    private void initThumbnailPanel() throws IOException
    {
        ImageManipulationService imageManipulationService = new ImageManipulationService();

        for (Map.Entry<String, ImageIcon> pair : collection.getImageCollection().entrySet())
        {
            Image temp = imageManipulationService.makeThumbnail(pair.getValue());
            ThumbnailView thumbnailView = new ThumbnailView(new ImageIcon(temp));
            thumbnailView.imageThumbnail.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseClicked(MouseEvent e)
                {
                    super.mouseClicked(e);
                    viewImage(pair.getKey());
                }
            });
            galleryView.ThumbnailPanelView(thumbnailView);
        }
    }

    @Override
    public void nextImage()
    {

        if (currentImageIndex < collection.getImageCollection().size() - 1)
        {
            currentImageIndex++;
            removeAll();
            value = (new ArrayList<>(collection.getImageCollection().values())).get(currentImageIndex);
            key = (new ArrayList<>(collection.getImageCollection().keySet())).get(currentImageIndex);
            System.out.println("currentImageIndex = " + currentImageIndex);
            singleImageView = new SingleImageView(value, key);
            add(singleImageView, BorderLayout.CENTER);
            revalidate();
            repaint();
        }
    }

    @Override
    public void previousImage()
    {

        if (currentImageIndex > -1 && currentImageIndex != 0)
        {
            currentImageIndex--;
            removeAll();
            value = (new ArrayList<>(collection.getImageCollection().values())).get(currentImageIndex);
            key = (new ArrayList<>(collection.getImageCollection().keySet())).get(currentImageIndex);
            System.out.println("currentImageIndex = " + currentImageIndex);
            singleImageView = new SingleImageView(value, key);
            add(singleImageView, BorderLayout.CENTER);
            revalidate();
            repaint();
        }

    }

    @Override
    public void setPath() throws IOException
    {
        destroyComponents();
        createComponents();
        revalidate();
        repaint();
    }


    @Override
    public void viewImage(String name)
    {
        removeAll();
        value = collection.getImageCollection().get(name);
        currentImageIndex = (new ArrayList<>(collection.getImageCollection().keySet())).indexOf(name);
        key = (new ArrayList<>(collection.getImageCollection().keySet())).get(currentImageIndex);
        System.out.println("currentImageIndex = " + currentImageIndex);
        singleImageView = new SingleImageView(value, key);
        add(singleImageView, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void showGallery()
    {

        removeAll();
        JScrollPane thumbnailGallery = new JScrollPane(galleryView);
        thumbnailGallery.getVerticalScrollBar().setUnitIncrement(16);
        add(thumbnailGallery, BorderLayout.CENTER);
        revalidate();
        repaint();

    }

}