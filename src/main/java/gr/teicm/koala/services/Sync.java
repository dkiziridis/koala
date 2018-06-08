package gr.teicm.koala.services;

import gr.teicm.koala.models.HibernateImage;
import gr.teicm.koala.models.LocalImageCollection;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class Sync
{
    PullImage pull = new PullImage();
    private LocalImageCollection localImageCollection;

    public void syncUp() throws TikaException, IOException, SAXException
    {

        List<String> imagesUp = pull.fetchImageNames();

        for (ImageIcon image : localImageCollection.getImageCollection())
        {
            imagesUp.remove(image.getDescription());
        }

        for (String image : imagesUp)
        {
            new PushImage(new HibernateImage(), image);
        }
    }

    public void syncDown() throws IOException
    {
        String path;
        List<String> imagesDown = pull.fetchImageNames();
        for (ImageIcon image : localImageCollection.getImageCollection())
        {

            imagesDown.remove(image.getDescription());
        }

        path = new IOServices().openFolder().toString();
        pull.downloadImages(imagesDown, path);
    }

    public void setLocalImageCollection(LocalImageCollection localImageCollection)
    {
        this.localImageCollection = localImageCollection;
    }
}
