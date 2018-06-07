package gr.teicm.koala.controllers;

import gr.teicm.koala.models.LocalImageCollection;
import gr.teicm.koala.services.GeolocateService;
import gr.teicm.koala.services.ImageManipulationService;
import gr.teicm.koala.services.PrintImageService;
import gr.teicm.koala.views.*;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import javax.print.PrintException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;

public class Controller
{
    private LocalImageCollection collection;
    private KPanel kPanel;
    private KToolbar KToolbar = new KToolbar();
    private KMenuBar KMenuBar = new KMenuBar();//TODO
    private JFrame frame;

    public Controller(LocalImageCollection collection, KPanel kPanel) throws IOException
    {
        this.collection = collection;
        this.kPanel = kPanel;
        frame = new JFrame();

        KToolbar.setIKToolbar(new IKToolbar()
        {
            @Override
            public void showGallery() throws IOException
            {
                kPanel.getViewArea().removeAll();
                initKPanel();
            }

            @Override
            public void nextImage()
            {
                kPanel.showImage(new KPhoto(collection.getImage(1)));

            }

            @Override
            public void previousImage()
            {
                kPanel.showImage(new KPhoto(collection.getImage(-1)));

            }

            @Override
            public void geolocate() throws TikaException, IOException, SAXException
            {
                new GeolocateService(collection.pathToImage());
            }

            @Override
            public void openFolder() throws IOException
            {
                collection.clear();
                collection.resetCollection();
                try
                {
                    showGallery();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void printImage() throws IOException, PrintException
            {
                FileInputStream file;
                file = new FileInputStream(collection.pathToImage());
                new PrintImageService(file);
            }
        });
        initKPanel();
        initFrame();
    }

    private void initFrame()
    {
        JScrollPane kScrollPanel = new JScrollPane(kPanel.getViewArea());
        kScrollPanel.getVerticalScrollBar().setUnitIncrement(16);

        frame.setLayout(new BorderLayout());

        frame.add(KMenuBar, BorderLayout.NORTH);
        frame.add(KToolbar, BorderLayout.SOUTH);
        frame.add(kScrollPanel, BorderLayout.CENTER);

        frame.setTitle("Koala Photo Album");
        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void initKPanel() throws IOException
    {
        ImageManipulationService imageManipulationService = new ImageManipulationService();
        for (ImageIcon image : collection.getImageCollection())
        {
            KThumbnail kThumbnail = new KThumbnail(imageManipulationService.makeThumbnail(image));
            kThumbnail.imageThumbnail.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseClicked(MouseEvent e)
                {
                    super.mouseClicked(e);
                    kPanel.showImage(new KPhoto(collection.getImageByPath(image.getDescription())));
                }

                @Override
                public void mouseEntered(MouseEvent e)
                {
                    super.mouseEntered(e);
                    kThumbnail.imageThumbnail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    kThumbnail.imageThumbnail.setBorder(BorderFactory.createLineBorder(Color.gray, 4));
                }

                @Override
                public void mouseExited(MouseEvent e)
                {
                    super.mouseExited(e);
                    kThumbnail.imageThumbnail.setBorder(BorderFactory.createLineBorder(Color.black));
                }
            });
            kPanel.addThumbnail(kThumbnail);
        }
    }
}