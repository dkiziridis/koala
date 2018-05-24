package gr.teicm.koala.models;

import gr.teicm.koala.services.IOServices;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class LocalImageCollection
{

    private Path path;
    private File[] listOfFiles;
    private Map<String, ImageIcon> imageCollection;


    public LocalImageCollection()
    {
        path = new IOServices().setPath();
        File folder = new File(path.toString());
        listOfFiles = folder.listFiles();
        imageCollection = new HashMap<>();
    }

    public Map<String, ImageIcon> getImageCollection()
    {
        return imageCollection;
    }

    public void initImageList() throws IOException
    {
        for (File name : listOfFiles)
        {
            if (name.getAbsolutePath().endsWith("jpg")
                    || name.getAbsolutePath().endsWith("bmp")
                    || name.getAbsolutePath().endsWith("png")
                    || name.getAbsolutePath().endsWith("jpeg")
                    || name.getAbsolutePath().endsWith("gif")
                    || name.getAbsolutePath().endsWith("JPG"))
            {

                ImageIcon value = new ImageIcon(ImageIO.read(name));
                String key = name.getAbsolutePath();
                this.imageCollection.put(key, value);
            }
        }
    }

    public void setPath(Path path)
    {
        this.path = path;
    }

    public void clear()
    {
        for (File file : listOfFiles)
        {
            file = null;
        }
        for (Map.Entry<String, ImageIcon> pair : imageCollection.entrySet())
        {
            pair = null;
        }
        path = null;
    }
}
