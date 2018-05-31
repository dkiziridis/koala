package gr.teicm.koala.controllers;

import gr.teicm.koala.Interfaces.IThumbPanelController;
import gr.teicm.koala.views.MenuBarView;
import gr.teicm.koala.views.ToolbarView;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;
import java.io.IOException;

public class Controller extends JFrame
{

    private ThumbnailPanelController thumbnailPanelController;

    public Controller() throws IOException
    {
        setLayout(new BorderLayout());
        ToolbarView toolbarView = new ToolbarView();
        MenuBarView menuBarView = new MenuBarView();
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
            public void geolocate()
            {
                //TODO -->> thumbnailPanelController.geolocate(24.23232,24.545454)
                setVisible(false);


            }

            @Override
            public void openFolder() throws IOException
            {
                thumbnailPanelController.openFolder();
            }

            @Override
            public void viewImage(String name)
            {
                thumbnailPanelController.viewImage("");
            }

        });

        thumbnailPanelController.addMouseWheelListener(new MouseAdapter()
        {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e)
            {//TODO change functions
                super.mouseWheelMoved(e);
                if (e.getWheelRotation() > 0)
                {
                    thumbnailPanelController.nextImage();

                    System.out.println("notches = " + e.getWheelRotation());
                } else
                {
                    thumbnailPanelController.previousImage();
                    System.out.println("notches = " + e.getWheelRotation());
                }
            }
        });

        toolbarView.addMouseWheelListener(new MouseInputAdapter()
        {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e)
            {
                super.mouseWheelMoved(e);
                if (e.getWheelRotation() > 0)
                {
                    thumbnailPanelController.nextImage();
                    System.out.println("notches = " + e.getWheelRotation());
                } else
                {
                    thumbnailPanelController.previousImage();
                    System.out.println("notches = " + e.getWheelRotation());
                }
            }
        });

        add(menuBarView, BorderLayout.NORTH);
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

