package gr.teicm.koala.controllers;

import gr.teicm.koala.Interfaces.IServiceListener;
import gr.teicm.koala.services.IOServices;
import gr.teicm.koala.views.ToolbarView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Controller extends JFrame
{

    private ThumbnailPanelController thumbnailPanelController;
    private ToolbarView toolbarView;
    public Controller() throws IOException
    {
        setLayout(new BorderLayout());
        toolbarView = new ToolbarView();
        thumbnailPanelController = new ThumbnailPanelController();

        toolbarView.setServiceListener(new IServiceListener()
        {
            @Override
            public void showGallery()
            {
                thumbnailPanelController.showGallery();
            }

            @Override
            public void nextImage()
            {
                thumbnailPanelController.nextImage();
            }

            @Override
            public void previousImage()
            {
                thumbnailPanelController.previousImage();
            }


            @Override
            public void viewExifData()
            {

            }

            @Override
            public void setPath()
            {
//                IOServices openLocalImage = new IOServices();
                IOServices IOServices = new IOServices();
                IOServices.setPath();

//                ImageIcon image = openLocalImage.openImage();
//                Image resizedImg = image.getImage()
//                        .getScaledInstance(thumbnailPanelController.thumbnailPanelView
//                                .getWidth(), thumbnailPanelController.thumbnailPanelView
//                                .getHeight(), Image.SCALE_SMOOTH);
//                ImageIcon img = new ImageIcon(resizedImg);
////                thumbnailPanelController.nextImage(img);
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

