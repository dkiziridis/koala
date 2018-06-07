package gr.teicm.koala.views;

import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import javax.print.PrintException;
import java.io.IOException;

public interface IKToolbar
{
    void showGallery() throws IOException;
    void nextImage();
    void previousImage();
    void geolocate() throws TikaException, IOException, SAXException;
    void openFolder() throws IOException;

    void printImage() throws IOException, PrintException;
}
