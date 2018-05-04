package gr.teicm.koala.controllers;

import gr.teicm.koala.Interfaces.IGalleryListener;
import gr.teicm.koala.ThumbnailSize;
import gr.teicm.koala.models.LocalImageCollection;
import gr.teicm.koala.services.ResizeImageService;
import gr.teicm.koala.views.ThumbnailPanelView;
import gr.teicm.koala.views.ThumbnailView;

import java.awt.*;
import java.io.IOException;
import javax.swing.*;

public class ThumbnailPanelController extends JPanel
{
    public JLabel image = new JLabel();
    public ThumbnailPanelView thumbnailPanelView = new ThumbnailPanelView();
    public ThumbnailView thumbnailView;
    LocalImageCollection collection = new LocalImageCollection();
    int collectionSize = collection.imageList.size();


    public ThumbnailPanelController() throws IOException
    {

        collection.setImageList();
        collection.getImageList();
        setLayout(new BorderLayout());
        add(thumbnailPanelView);
        add(new JScrollPane(thumbnailPanelView));
        initializeThumbnailPanel();

    }

    public void initializeThumbnailPanel() throws IOException
    {
        ResizeImageService resizeImageService = new ResizeImageService();

        for (ImageIcon imageIcon: collection.getImageList())
        {
            Image temp = resizeImageService.resizeImage(imageIcon);
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
        image.setIcon(null);
    }
}