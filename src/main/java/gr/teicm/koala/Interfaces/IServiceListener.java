package gr.teicm.koala.Interfaces;

import javax.swing.*;
import java.io.IOException;

public interface IServiceListener
{
    void fetchImageById(int imageId);

    void clearImage();

    void showThumbnails() throws IOException;

    void viewExifData();

    void openLocalImage();
}
