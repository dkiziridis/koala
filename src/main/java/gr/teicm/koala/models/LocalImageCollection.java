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

    public Path path;
    private File[] listOfFiles;
    private Map<String, ImageIcon> imageCollection;


    public LocalImageCollection()
    {
        path = new IOServices().setPath();
        File folder = new File(path.toString());
//        File folder = new File(System.getProperty("user.home"));
        listOfFiles = folder.listFiles();
        imageCollection = new HashMap<>();
    }

    public Map<String, ImageIcon> getImageCollection()
    {
        return imageCollection;
    }

    public void initImageList() throws IOException
    {
        for (File name : listOfFiles) //TODO change for
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
                    this.imageCollection.put(key,value);
            }
        }
    }

    public void setPath(Path path)
    {
        this.path = path;
    }
}
