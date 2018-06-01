package gr.teicm.koala.controllers;

import gr.teicm.koala.Interfaces.IToolbarListener;
import gr.teicm.koala.models.LocalImageCollection;
import gr.teicm.koala.services.GeolocateService;
import gr.teicm.koala.services.ImageManipulationService;
import gr.teicm.koala.services.PrintImageService;
import gr.teicm.koala.views.GalleryView;
import gr.teicm.koala.views.SingleImageView;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import javax.print.PrintException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

class ThumbnailPanelController extends JPanel implements IToolbarListener
{
    private GalleryView galleryView;
    private LocalImageCollection collection;
    private SingleImageView singleImageView;
    private int currentImageIndex = 0;
    private String key;
    private ImageIcon value;


    public ThumbnailPanelController(LocalImageCollection collection, GalleryView galleryView) throws IOException
    {
        this.collection = collection;
        this.galleryView = galleryView;
        createComponents();
    }

    private void createComponents() throws IOException
    {
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
            ThumbnailController thumbnailController = new ThumbnailController(new ImageIcon(temp), pair.getKey());
            thumbnailController.imageThumbnail.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseClicked(MouseEvent e)
                {
                    super.mouseClicked(e);
                    viewImage(pair.getKey());
                }
            });
            galleryView.ThumbnailPanelView(thumbnailController);
        }
    }

    @Override
    public void nextImage()
    {
        if (currentImageIndex < collection.getImageCollection().size() - 1)
        {
            currentImageIndex++;
            switchImage();
        }
    }

    private void switchImage()
    {
        removeAll();
        value = (new ArrayList<>(collection.getImageCollection().values())).get(currentImageIndex);
        key = (new ArrayList<>(collection.getImageCollection().keySet())).get(currentImageIndex);
        System.out.println("currentImageIndex = " + currentImageIndex);//DEBUG bullshit
        singleImageView = new SingleImageView(value, key);
        add(singleImageView, BorderLayout.CENTER);
        updateUI();
    }

    @Override
    public void previousImage()
    {
        if (currentImageIndex > -1 && currentImageIndex != 0) //Don't fuck up the statement
        {
            currentImageIndex--;
            switchImage();
        }
    }

    @Override
    public void geolocate() throws TikaException, IOException, SAXException
    {
        new GeolocateService(key);
    }

    @Override
    public void openFolder() throws IOException
    {
        destroyComponents();
        createComponents();
        updateUI();
    }

    @Override
    public void printImage(String path) throws IOException, PrintException
    {
        path = key;
        FileInputStream file;
        file = new FileInputStream(path);
        new PrintImageService(file);


    }

    public void viewImage(String name)
    {
        removeAll();//Problem ?
        value = collection.getImageCollection().get(name);
        currentImageIndex = (new ArrayList<>(collection.getImageCollection().keySet())).indexOf(name);
        key = (new ArrayList<>(collection.getImageCollection().keySet())).get(currentImageIndex);
        System.out.println("currentImageIndex = " + currentImageIndex);
        singleImageView = new SingleImageView(value, key);
        add(singleImageView, BorderLayout.CENTER);
        updateUI();
    }

    public void showGallery()
    {
        removeAll();
        JScrollPane thumbnailGallery = new JScrollPane(galleryView);
        thumbnailGallery.getVerticalScrollBar().setUnitIncrement(16);
        add(thumbnailGallery, BorderLayout.CENTER);
        updateUI();
    }
}