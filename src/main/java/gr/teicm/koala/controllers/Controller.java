package gr.teicm.koala.controllers;

import gr.teicm.koala.models.LocalImageCollection;
import gr.teicm.koala.services.Geolocate;
import gr.teicm.koala.services.ImageManipulation;
import gr.teicm.koala.services.MetadataRetriever;
import gr.teicm.koala.services.PrintImage;
import gr.teicm.koala.views.*;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import javax.print.PrintException;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;

public class Controller
{
    private LocalImageCollection collection;
    private KPanel kPanel;
    private KToolbar kToolbar = new KToolbar();


    public Controller(LocalImageCollection collection, KPanel kPanel) throws IOException
    {
        this.collection = collection;
        this.kPanel = kPanel;

        kToolbar.setIKToolbar(new IKToolbar()
        {
            @Override
            public void showGallery() throws IOException
            {
                kPanel.getViewArea().removeAll();
                kToolbar.hideOrShowButtons(true);
                initKPanel();
            }

            @Override
            public void nextImage()
            {
                kPanel.showImage(new KPhoto(collection.getImage(1)));
                kToolbar.hideOrShowButtons(false);
            }

            @Override
            public void previousImage()
            {
                kPanel.showImage(new KPhoto(collection.getImage(-1)));
                kToolbar.hideOrShowButtons(false);
            }

            @Override
            public void geolocate() throws TikaException, IOException, SAXException
            {
                new Geolocate(collection.pathToImage());
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
                new PrintImage(file);
            }

            @Override
            public void exifService() throws TikaException, IOException, SAXException
            {
                MetadataRetriever metadata = new MetadataRetriever(collection.pathToImage());

                new KExif(metadata.getHeight(),
                        metadata.getWidth(),
                        metadata.getCompressionType(),
                        metadata.getLatitude(),
                        metadata.getLongitude(),
                        metadata.getContentType(),
                        metadata.getFileSize(),
                        metadata.getDate()
                );
            }
        });

        kToolbar.addMouseWheelListener(mouseWheelEvent ->
        {
            if (mouseWheelEvent.getWheelRotation() > 1)
            {
                kPanel.showImage(new KPhoto(collection.getImage(1)));
                kToolbar.hideOrShowButtons(false);
            } else
            {
                kPanel.showImage(new KPhoto(collection.getImage(-1)));
                kToolbar.hideOrShowButtons(false);
            }
        });
        initKPanel();
        KMenuBar kMenuBar = new KMenuBar();
        Koala koala = new Koala(kMenuBar, kPanel, kToolbar);
    }


    private void initKPanel() throws IOException
    {
        ImageManipulation imageManipulation = new ImageManipulation();
        for (ImageIcon image : collection.getImageCollection())
        {
            KThumbnail kThumbnail = new KThumbnail(imageManipulation.makeThumbnail(image));
            kThumbnail.setImgPath(image.getDescription());
            kThumbnail.imageThumbnail.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseClicked(MouseEvent e)
                {
                    super.mouseClicked(e);
                    kPanel.showImage(new KPhoto(collection.getImageByPath(image.getDescription())));
                    kToolbar.hideOrShowButtons(false);
                }

                @Override
                public void mouseEntered(MouseEvent e)
                {
                    super.mouseEntered(e);
                    kThumbnail.setBorder();
                }

                @Override
                public void mouseExited(MouseEvent e)
                {
                    super.mouseExited(e);
                    kThumbnail.unsetBorder();
                }
            });

            kThumbnail.setIKThumbnail(new IKThumbnail()
            {
                @Override
                public void selectedImage()
                {
                    System.out.println("lalal");
                }

                @Override
                public void viewEXIF() throws TikaException, IOException, SAXException
                {
                    MetadataRetriever metadata = new MetadataRetriever(image.getDescription());

                    new KExif(metadata.getHeight(),
                            metadata.getWidth(),
                            metadata.getCompressionType(),
                            metadata.getLatitude(),
                            metadata.getLongitude(),
                            metadata.getContentType(),
                            metadata.getFileSize(),
                            metadata.getDate()
                    );
                }
            });

            kPanel.addThumbnail(kThumbnail);
        }
    }
}