package gr.teicm.koala.models;

import gr.teicm.koala.services.IOServices;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class LocalImageCollection
{
    private String path = System.getProperty("user.home");
    private File[] listOfFiles;
    private LinkedList<ImageIcon> imageCollection = new LinkedList<>();
    private int currentIndex = -1;

    public LocalImageCollection() throws IOException
    {
        initImageList();
    }

    public List<ImageIcon> getImageCollection()
    {
        return imageCollection;
    }

    private void initImageList() throws IOException
    {
        File folder = new File(path);
        listOfFiles = folder.listFiles();

        for (File name : listOfFiles)
        {
            if (name.getAbsolutePath().endsWith("jpg")
                    || name.getAbsolutePath().endsWith("bmp")
                    || name.getAbsolutePath().endsWith("png")
                    || name.getAbsolutePath().endsWith("jpeg")
                    || name.getAbsolutePath().endsWith("gif")
                    || name.getAbsolutePath().endsWith("JPG"))
            {
                ImageIcon photo = new ImageIcon(ImageIO.read(name));
                photo.setDescription(name.getAbsolutePath());
                this.imageCollection.add(photo);
            }
        }
    }

    public String pathToImage()
    {
        return getImage(currentIndex).getDescription();
    }

    public void resetCollection() throws IOException
    {
        this.path = new IOServices().openFolder().toAbsolutePath().toString();
        initImageList();
    }

    public ImageIcon getImageByPath(String path) throws NullPointerException
    {
        int i = 0;
        for (ImageIcon image : imageCollection)
        {
            i++;
            if (image.getDescription().equals(path))
            {
                currentIndex = i;
                return image;
            }
        }
        throw new NullPointerException();
    }

    public ImageIcon getImage(int direction)
    {
        if (direction == 1)
        {
            currentIndex++;
            if (currentIndex > imageCollection.size() - 1)
            {
                currentIndex = 0;
                return imageCollection.get(currentIndex);
            } else
            {
                return imageCollection.get(currentIndex);
            }

        } else if (direction == -1)
        {
            currentIndex--;
            if (currentIndex < 0)
            {
                currentIndex = imageCollection.size() - 1;
                return imageCollection.get(currentIndex);

            } else
            {
                return imageCollection.get(currentIndex);
            }

        } else
        {
            return imageCollection.get(currentIndex);
        }
    }

    public void clear()
    {
        path = null;
        listOfFiles = null;
        imageCollection.clear();
        currentIndex = -1;
    }
}
