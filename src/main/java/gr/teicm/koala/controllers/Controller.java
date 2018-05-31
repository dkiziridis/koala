package gr.teicm.koala.controllers;

import gr.teicm.koala.Interfaces.IThumbPanelController;
import gr.teicm.koala.views.MenuBarView;
import gr.teicm.koala.views.ToolbarView;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.io.IOException;

public class Controller extends JFrame
{

    private ThumbnailPanelController thumbnailPanelController;
    private ToolbarView toolbarView;
    private MenuBarView menuBarView;

    public Controller() throws IOException
    {
        setLayout(new BorderLayout());
        toolbarView = new ToolbarView();
        menuBarView = new MenuBarView();
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
            public void viewImage(String name)
            {
                thumbnailPanelController.viewImage("");
            }

        });

        toolbarView.addMouseWheelListener(new MouseInputAdapter()
        {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e)
            {
                super.mouseWheelMoved(e);
                int notches = e.getWheelRotation();
                if (notches > 0)
                {
                    thumbnailPanelController.nextImage();
                    System.out.println("notches = " + notches);
                } else
                {
                    thumbnailPanelController.previousImage();
                    System.out.println("notches = " + notches);
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

