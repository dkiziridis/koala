package gr.teicm.koala.views;

import javax.swing.*;
import java.awt.*;

public class KPanel
{

    private JPanel viewArea = new JPanel();

    public KPanel()
    {

    }


    public void showImage(KPhoto kPhoto)
    {
        viewArea.removeAll();
        viewArea.setLayout(new BorderLayout());
        viewArea.add(kPhoto.imagePanel, BorderLayout.CENTER);
        viewArea.updateUI();
    }

    public void addThumbnail(KThumbnail KThumbnail)
    {

        viewArea.setLayout(new GridLayout(0, 4, 2, 2));
        viewArea.add(KThumbnail.getThumbnailPane());
        viewArea.updateUI();
    }

    public JPanel getViewArea()
    {
        return viewArea;
    }


}
