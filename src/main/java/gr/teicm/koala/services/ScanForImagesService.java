package gr.teicm.koala.services;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class ScanForImagesService
{

    public DefaultListModel scanForImages() throws IOException

    {

        File folder = new File(System.getProperty("user.home"));
        File[] listOfFiles = folder.listFiles();
        DefaultListModel listModel = new DefaultListModel();
        int count = 0;
        for (int i = 0; i < listOfFiles.length; i++)
        {
            String name = listOfFiles[i].toString();
            if (name.endsWith("jpg"))
            {
                ImageIcon ii = new ImageIcon(ImageIO.read(listOfFiles[i]));
                listModel.add(count++, ii);
            }

        }
        return listModel;
    }

}
