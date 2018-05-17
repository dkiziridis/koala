package gr.teicm.koala.controllers;

import gr.teicm.koala.Interfaces.IServiceListener;
import gr.teicm.koala.services.FetchImageService;
import gr.teicm.koala.services.OpenLocalImageService;
import gr.teicm.koala.views.ToolbarView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Controller extends JFrame
{

    private ThumbnailPanelController thumbnailPanelController;
    private ToolbarView toolbarView;

    //private FetchImageService services;
    //private ExifView exifView;
    private String currentPath;


    public Controller() throws IOException
    {
        setLayout(new BorderLayout());
        toolbarView = new ToolbarView();
        thumbnailPanelController = new ThumbnailPanelController();
//        exifView = new ExifView();
//        services = new FetchImageService();


        toolbarView.setServiceListener(new IServiceListener()
        {
            @Override
            public void fetchImageById(int imageId)
            {
                FetchImageService fetchImageService = new FetchImageService();
                ImageIcon image = fetchImageService.fetchImageById(imageId);
                Image resizedImg = image.getImage().getScaledInstance(thumbnailPanelController.image.getWidth(), thumbnailPanelController.image.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon img = new ImageIcon(resizedImg);
                thumbnailPanelController.insertImage(img);
            }

            @Override
            public void clearImage()
            {
                thumbnailPanelController.clearImage();
            }

            @Override
            public void showThumbnails() throws IOException
            {

               // thumbnailPanelController = new ThumbnailPanelController(); //This will update thumbnails
            }


            @Override
            public void viewExifData()
            {
                thumbnailPanelController.clearImage();
            }

            @Override
            public void openLocalImage()
            {
                OpenLocalImageService openLocalImage = new OpenLocalImageService();
                ImageIcon image = openLocalImage.openImage();
                Image resizedImg = image.getImage().getScaledInstance(thumbnailPanelController.thumbnailPanelView.getWidth(), thumbnailPanelController.thumbnailPanelView.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon img = new ImageIcon(resizedImg);
                thumbnailPanelController.insertImage(img);
            }
        });


        add(toolbarView, BorderLayout.SOUTH);
        add(thumbnailPanelController, BorderLayout.CENTER);

        setTitle("Koala Photo Album");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(800, 600));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

}

