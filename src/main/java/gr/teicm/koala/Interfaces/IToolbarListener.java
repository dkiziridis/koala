package gr.teicm.koala.Interfaces;

import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import javax.print.PrintException;
import java.io.IOException;

public interface IToolbarListener
{
    void showGallery();
    void nextImage();
    void previousImage();

    void geolocate() throws TikaException, IOException, SAXException;
    void openFolder() throws IOException;

    void printImage(String path) throws IOException, PrintException;
}
