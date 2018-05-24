package gr.teicm.koala.Interfaces;

import javax.swing.*;
import java.io.IOException;

public interface IServiceListener
{
    void showGallery();

    void nextImage();

    void previousImage();

    void viewExifData();

    void setPath();
}
