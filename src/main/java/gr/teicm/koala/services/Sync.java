package gr.teicm.koala.services;

import gr.teicm.koala.models.HibernateImage;
import gr.teicm.koala.models.LocalImageCollection;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import javax.swing.*;
import java.io.IOException;

public class Sync
{
    private LocalImageCollection localImageCollection;

    public void sync() throws TikaException, IOException, SAXException
    {

        for (ImageIcon image : localImageCollection.getImageCollection())
        {
            new PushImage(new HibernateImage(), image.getDescription());
        }

    }

    public void setLocalImageCollection(LocalImageCollection localImageCollection)
    {
        this.localImageCollection = localImageCollection;
    }
}
