package gr.teicm.koala.views;


import gr.teicm.koala.Interfaces.IThumbnailListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;


public class ThumbnailView extends JPanel
{
    public JLabel imageThumbnail;
    private String imgPath;
    public JCheckBox checkBox;
    public JButton exifBtn;
    public IThumbnailListener iThumbnailListener;
    public MouseListener mouseListener;

    public void setMouseListener(MouseListener mouseListener)
    {
        this.mouseListener = mouseListener;
    }

    public void setiThumbnailListener(IThumbnailListener iThumbnailListener)
    {
        this.iThumbnailListener = iThumbnailListener;
    }

    public ThumbnailView(ImageIcon image, String imgPath)
    {
        setLayout(new BorderLayout());
        this.imgPath = imgPath;

        exifBtn = new JButton("EXIF");
        checkBox = new JCheckBox("Select");


        checkBox.addActionListener(e -> iThumbnailListener.selectedImage());
        exifBtn.addActionListener(e -> iThumbnailListener.viewEXIF());

        imageThumbnail = new JLabel();
        imageThumbnail.setIcon(image);


        add(exifBtn, BorderLayout.PAGE_END);
        add(checkBox, BorderLayout.AFTER_LAST_LINE);
        add(imageThumbnail, BorderLayout.CENTER);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

}
