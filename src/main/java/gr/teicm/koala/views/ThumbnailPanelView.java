package gr.teicm.koala.views;

import javax.swing.*;
import java.awt.*;

public class ThumbnailPanelView extends JPanel
{

    private int gridHeight;
    private int gridWidth;

    public void ThumbailPanelView(int height, int width)
    {
        this.gridHeight = height;
        this.gridWidth = width;

        setLayout(new GridLayout(height, width));
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
