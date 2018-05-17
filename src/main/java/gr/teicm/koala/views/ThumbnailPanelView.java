package gr.teicm.koala.views;

import javax.swing.*;
import java.awt.*;

public class ThumbnailPanelView extends JPanel
{

    private int gridHeight;
    private int gridWidth;


    public void ThumbnailPanelView(ThumbnailView thumbnailView)
    {

        setLayout(new GridLayout(0,4, 2,2));
        add(thumbnailView);


    }

    public int getGridHeight()
    {
        return gridHeight;
    }
    public int getGridWidth()
    {
        return gridWidth;
    }

//    public void insertThumbnail(ThumbnailView thumbnailView)
//    {
//        add(thumbnailView);
//    }
}
