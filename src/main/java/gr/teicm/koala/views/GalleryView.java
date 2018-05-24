package gr.teicm.koala.views;

import javax.swing.*;
import java.awt.*;

public class GalleryView extends JPanel
{

    public void ThumbnailPanelView(ThumbnailView thumbnailView)
    {

        setLayout(new GridLayout(0, 4, 2, 2));
        add(thumbnailView);

    }
}
