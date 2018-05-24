package gr.teicm.koala.Interfaces;

import javax.swing.*;
import java.io.IOException;

public interface IThumbPanelController
{
    void showGallery();
    void nextImage();
    void previousImage();
    void setPath() throws IOException;
    void showCard(String name);
}
