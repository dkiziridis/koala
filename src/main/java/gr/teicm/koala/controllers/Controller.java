package gr.teicm.koala.controllers;

import gr.teicm.koala.Interfaces.IThumbPanelController;
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

        toolbarView.setServiceListener(new IThumbPanelController()
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
            public void setPath() throws IOException
            {
                thumbnailPanelController.setPath();
            }

            @Override
            public void showCard(String name)
            {
                thumbnailPanelController.showCard(new String());
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

