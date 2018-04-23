package gr.teicm.koala;

import javax.swing.*;

public interface IServiceListener
{
    void resizeImage(ImageIcon img);
    void fetchImageById(int imageId);
    void clearImage();
    void viewExifData();
    void openLocalImage();
}
