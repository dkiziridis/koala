package gr.teicm.koala;


import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Controller extends JFrame implements ActionListener
{

    private GalleryView galleryView;
    private ToolbarView toolbarView;
    private ExifView exifView;
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

    Controller()
    {
        setLayout(new BorderLayout());
        toolbarView = new ToolbarView();
        galleryView = new GalleryView();
        exifView = new ExifView();


        add(toolbarView, BorderLayout.SOUTH);
        add(galleryView, BorderLayout.CENTER);

        toolbarView.openImgBtn.addActionListener(this);
        toolbarView.uploadBtn.addActionListener(this);
        toolbarView.exifDataBtn.addActionListener(this);
        toolbarView.clearImg.addActionListener(this);
        toolbarView.exifDataBtn.addActionListener(this);
        toolbarView.testBtn.addActionListener(this);


        setTitle("Koala Photo Album");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(800, 600));
        //setMaximumSize(new Dimension(1200, 900));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }


    private ImageIcon retrieveImage(int imageId)
    {

        Session session = HibernateUtil.getSession();

        HibernateModel image = session.get(HibernateModel.class, imageId); //  get data according to imageId
        byte[] getImageInBytes = image.getImgData();  // convert to byte

        ImageIcon imageFile = new ImageIcon(image.getImageName()); // set name

        FileOutputStream outputStream = null;
        try
        {
            outputStream = new FileOutputStream(String.valueOf(imageFile));
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        try
        {
            outputStream.write(getImageInBytes);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        try
        {
            outputStream.close(); // close the output stream
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        System.out.println("Retrieved Image from Database using Hibernate.");
        session.close();

        return new ImageIcon(getImageInBytes);

    }


    public ImageIcon ResizeImage(ImageIcon img)
    {
        ImageIcon MyImage = new ImageIcon(String.valueOf(img));
        Image imgTemp = MyImage.getImage();
        Image newImage = imgTemp.getScaledInstance(galleryView.image.getWidth(), galleryView.image.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(toolbarView.openImgBtn))
        {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            fileChooser.setDialogTitle("Select Image");
            fileChooser.setControlButtonsAreShown(true);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Photos", "jpg", "gif", "png", "bmp");
            fileChooser.addChoosableFileFilter(filter);
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION)
            {
                File selectedFile = fileChooser.getSelectedFile();
                String path = selectedFile.getAbsolutePath();
                ImageIcon MyImage = new ImageIcon(path); //TODO better

                galleryView.insertImage(ResizeImage(MyImage));
                currentPath = path; // Temporary variable
            } else if (result == JFileChooser.CANCEL_OPTION)
            {
                System.out.println("No Data");
            }
        } else if (e.getSource().equals(toolbarView.clearImg))
        {
            galleryView.clearImage();
        } else if (e.getSource().equals(toolbarView.exifDataBtn))
        {
            exifView.setTitle("EXIF Data");
            exifView.setLocationRelativeTo(null);
            exifView.setSize(400, 700);
            exifView.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            exifView.setVisible(true);
        } else if (e.getSource().equals(toolbarView.testBtn))
        {
            ImageIcon test = retrieveImage(6);
            galleryView.insertImage(test); //TODO initial testing, doesn't show photo if resized using ResizeImage
//            galleryView.insertImage(ResizeImage(test));
        }

    }

    public int initGalleryView() //TODO
    {

        return 0;
    }


}

