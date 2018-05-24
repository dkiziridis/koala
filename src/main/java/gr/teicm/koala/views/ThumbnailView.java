package gr.teicm.koala.views;


import gr.teicm.koala.Interfaces.IAppStateObserver;
import gr.teicm.koala.Interfaces.IThumbnailListener;
import gr.teicm.koala.controllers.ThumbnailPanelController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.file.Path;


public class ThumbnailView extends JPanel implements IAppStateObserver
{
    public JLabel imageThumbnail;
    private String imgPath;

    public ThumbnailView(ImageIcon image)
    {
        imageThumbnail = new JLabel();
        imageThumbnail.setIcon(image);
        imageThumbnail.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e)
            {
                super.mouseEntered(e);
                System.out.println("mouseEntered");
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                setBorder(BorderFactory.createLineBorder(Color.gray, 4));
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                super.mouseExited(e);
                setBorder(BorderFactory.createLineBorder(Color.black));
            }

        });

        add(imageThumbnail);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }


    public void setImgPath(String imgPath)
    {
        this.imgPath = imgPath;
    }


    @Override
    public void imageKey(String imageKey)
    {

    }
}
