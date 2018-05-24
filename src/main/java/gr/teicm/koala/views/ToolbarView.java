package gr.teicm.koala.views;

import gr.teicm.koala.Interfaces.IThumbPanelController;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ToolbarView extends JPanel
{

    public JButton setPathBtn;
    public JButton syncBtn;
    public JButton exifDataBtn;
    public JButton nextImgBtn;
    public JButton geolocateBtn;
    public JButton galleryBtn;
    public JButton previousImgBtn;

    private IThumbPanelController serviceListener;

    public ToolbarView()
    {
        setBorder(BorderFactory.createEtchedBorder());
        setLayout(new FlowLayout(FlowLayout.CENTER));
        previousImgBtn = new JButton(" < ");
        setPathBtn = new JButton("Path");
        syncBtn = new JButton("Sync");
        exifDataBtn = new JButton("EXIF");
        nextImgBtn = new JButton(" > ");
        geolocateBtn = new JButton("Geolocate");
        galleryBtn = new JButton("Gallery");


        previousImgBtn.addActionListener(e -> serviceListener.previousImage());

        nextImgBtn.addActionListener(e -> serviceListener.nextImage());

        galleryBtn.addActionListener(e -> serviceListener.showGallery());

        setPathBtn.addActionListener(e ->
        {
            try
            {
                serviceListener.setPath();
            } catch (IOException e1)
            {
                e1.printStackTrace();
            }
        });

        previousImgBtn.setName("previousImgBtn");
        setPathBtn.setName("setPathBtn");
        syncBtn.setName("syncBtn");
        exifDataBtn.setName("exifDataBtn");
        geolocateBtn.setName("geolocateBtn");
        galleryBtn.setName("galleryBtn");
        nextImgBtn.setName("nextImgBtn");

        add(setPathBtn);
        add(galleryBtn);
        add(previousImgBtn);
        add(nextImgBtn);
        add(geolocateBtn);
        add(syncBtn);


    }

    public void setServiceListener(IThumbPanelController serviceListener)
    {
        this.serviceListener = serviceListener;
    }

}
