package gr.teicm.koala.views;

import javax.swing.*;
import java.awt.*;

public class ThumbnailPanelView extends JPanel
{

    private int gridHeight;
    private int gridWidth;

    public void ThumbailPanelView()
    {

        setLayout(new CardLayout());
        add(new JScrollPane(this));


    }

    public int getGridHeight()
    {
        return gridHeight;
    }
    public int getGridWidth()
    {
        return gridWidth;
    }

    public void insertThumbnail(ThumbnailView thumbnailView)
    {
        add(thumbnailView);
    }
}
