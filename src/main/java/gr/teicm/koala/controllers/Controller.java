package gr.teicm.koala.controllers;

import gr.teicm.koala.Interfaces.IToolbarListener;
import gr.teicm.koala.models.LocalImageCollection;
import gr.teicm.koala.views.GalleryView;
import gr.teicm.koala.views.MenuBarView;
import gr.teicm.koala.views.ToolbarView;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import javax.print.PrintException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Controller extends JFrame
{

    private ThumbnailPanelController thumbnailPanelController;

    public Controller() throws IOException
    {
        LocalImageCollection collection = new LocalImageCollection();
        GalleryView galleryView = new GalleryView();
        setLayout(new BorderLayout());
        ToolbarView toolbarView = new ToolbarView();
        MenuBarView menuBarView = new MenuBarView();
        thumbnailPanelController = new ThumbnailPanelController(collection, galleryView);

        toolbarView.setiToolbarListener(new IToolbarListener()
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
            public void geolocate() throws TikaException, IOException, SAXException
            {
                //TODO -->> thumbnailPanelView.geolocate(24.23232,24.545454)
                setVisible(false);
                thumbnailPanelController.geolocate();
                setVisible(true);

            }

            @Override
            public void openFolder() throws IOException
            {
                thumbnailPanelController.openFolder();
            }

            @Override
            public void printImage(String path) throws FileNotFoundException, PrintException
            {
                thumbnailPanelController.printImage(path);

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

