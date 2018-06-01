package gr.teicm.koala.Interfaces;

import java.io.IOException;

public interface IThumbnailPanelListener
{
    void createComponents() throws IOException;

    void destroyComponents();

    void initThumbnailPanel() throws IOException;

    void viewImage(String name);

    void switchImage();
}
