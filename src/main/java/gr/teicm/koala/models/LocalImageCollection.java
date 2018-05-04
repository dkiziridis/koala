package gr.teicm.koala.models;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class LocalImageCollection
{

    String path = "user.home";
    File folder = new File(System.getProperty(path));
    File[] listOfFiles = folder.listFiles();
    public LinkedList<ImageIcon> imageList = new LinkedList<>();

    public LinkedList<ImageIcon> getImageList()
    {
        return imageList;
    }

    public void setImageList() throws IOException
    {
        int count = 0;
        for (int i = 0; i < listOfFiles.length; i++) //TODO change for
        {
            String name = listOfFiles[i].toString();
            if (name.endsWith("jpg") || name.endsWith("bmp") || name.endsWith("png") || name.endsWith("jpeg") || name.endsWith("gif") || name.endsWith("JPG"))
            {
                ImageIcon image = new ImageIcon(ImageIO.read(listOfFiles[i]));
                this.imageList.add(count++, image);
            }
        }
    }
}
