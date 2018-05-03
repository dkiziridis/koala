package gr.teicm.koala;

import javax.swing.*;
import java.io.IOException;

public interface IServiceListener
{
    void fetchImageById(int imageId);

    void clearImage();

    void setThumbnail(JPanel thumbnail) throws IOException;

    void viewExifData();

    void openLocalImage();
}
