package gr.teicm.koala;

import javax.swing.*;

public interface IServiceListener
{
    void fetchImageById(int imageId);
    void clearImage();
    void viewExifData();
    void openLocalImage();
}
