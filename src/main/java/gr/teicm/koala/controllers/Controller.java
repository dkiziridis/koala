package gr.teicm.koala.controllers;

import gr.teicm.koala.IServiceListener;
import gr.teicm.koala.models.LocalImageCollection;
import gr.teicm.koala.services.FetchImageService;
import gr.teicm.koala.services.OpenLocalImageService;
import gr.teicm.koala.services.ResizeImageService;
import gr.teicm.koala.views.GalleryView;
import gr.teicm.koala.views.ToolbarView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Controller extends JFrame
{

    private GalleryView galleryView;
    private ToolbarView toolbarView;
    //private FetchImageService services;
    //private ExifView exifView;
    private String currentPath;
    private List<ImageIcon> bufferedImages = new List<ImageIcon>() //TODO
    {
        @Override
        public int size()
        {
            return 0;
        }

        @Override
        public boolean isEmpty()
        {
            return false;
        }

        @Override
        public boolean contains(Object o)
        {
            return false;
        }

        @Override
        public Iterator<ImageIcon> iterator()
        {
            return null;
        }

        @Override
        public Object[] toArray()
        {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a)
        {
            return null;
        }

        @Override
        public boolean add(ImageIcon imageIcon)
        {
            return false;
        }

        @Override
        public boolean remove(Object o)
        {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c)
        {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends ImageIcon> c)
        {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends ImageIcon> c)
        {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c)
        {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c)
        {
            return false;
        }

        @Override
        public void clear()
        {

        }

        @Override
        public ImageIcon get(int index)
        {
            return null;
        }

        @Override
        public ImageIcon set(int index, ImageIcon element)
        {
            return null;
        }

        @Override
        public void add(int index, ImageIcon element)
        {

        }

        @Override
        public ImageIcon remove(int index)
        {
            return null;
        }

        @Override
        public int indexOf(Object o)
        {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o)
        {
            return 0;
        }

        @Override
        public ListIterator<ImageIcon> listIterator()
        {
            return null;
        }

        @Override
        public ListIterator<ImageIcon> listIterator(int index)
        {
            return null;
        }

        @Override
        public List<ImageIcon> subList(int fromIndex, int toIndex)
        {
            return null;
        }
    };

    public Controller()
    {
        setLayout(new BorderLayout());
        toolbarView = new ToolbarView();
        galleryView = new GalleryView();
//        exifView = new ExifView();
//        services = new FetchImageService();


        toolbarView.setServiceListener(new IServiceListener()
        {
            @Override
            public void fetchImageById(int imageId)
            {
                FetchImageService fetchImageService = new FetchImageService();
                ImageIcon image = fetchImageService.fetchImageById(imageId);
                Image resizedImg = image.getImage().getScaledInstance(galleryView.image.getWidth(), galleryView.image.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon img = new ImageIcon(resizedImg);
                galleryView.insertImage(img);
            }

            @Override
            public void clearImage()
            {
                galleryView.clearImage();
            }

            @Override
            public void populatePanel() throws IOException
            {
                LocalImageCollection collection;
                collection = new LocalImageCollection();
                collection.setImageList();
                collection.getImageList();
                int collectionSize = collection.imageList.size();


                for (int i = 0; i < collectionSize; i++)
                {
                    ResizeImageService resizeImageService = new ResizeImageService();
                    ImageIcon temp = resizeImageService.resizeImage(collection.getImageList().get(i));
//                    ImageIcon temp = new ImageIcon(scaledImage);
                    galleryView.populatePanel(temp);
                }

                for (int i = 0; i < 6 * 6; i++) {
                    galleryView.galleryPanel.add();
                }

            }

            @Override
            public void viewExifData()
            {
                galleryView.clearImage();
            }

            @Override
            public void openLocalImage()
            {
                OpenLocalImageService openLocalImage = new OpenLocalImageService();
                ImageIcon image = openLocalImage.openImage();
                Image resizedImg = image.getImage().getScaledInstance(galleryView.galleryPanel.getWidth(), galleryView.galleryPanel.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon img = new ImageIcon(resizedImg);
                galleryView.insertImage(img);
            }
        });


        add(toolbarView, BorderLayout.SOUTH);
        add(galleryView, BorderLayout.CENTER);

        setTitle("Koala Photo Album");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(800, 600));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

}

