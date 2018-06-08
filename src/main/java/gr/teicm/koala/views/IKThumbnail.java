package gr.teicm.koala.views;

import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import java.io.IOException;

public interface IKThumbnail
{
    void selectedImage();

    void viewEXIF() throws TikaException, IOException, SAXException;
}
