package gr.teicm.koala.views;

import gr.teicm.koala.Interfaces.IServiceListener;

import javax.swing.*;
import java.awt.*;

public class ToolbarView extends JPanel
{

    public JButton setPath;
    public JButton syncBtn;
    public JButton exifDataBtn;
    public JButton nextImgBtn;
    public JButton geolocateBtn;
    public JButton galleryBtn;
    public JButton previousImgBtn;

    private IServiceListener serviceListener;

    public ToolbarView()
    {
        setBorder(BorderFactory.createEtchedBorder());
        setLayout(new FlowLayout(FlowLayout.CENTER));
        previousImgBtn = new JButton(" < ");
        setPath = new JButton("Path");
        syncBtn = new JButton("Sync");
        exifDataBtn = new JButton("EXIF");
        nextImgBtn = new JButton(" > ");
        geolocateBtn = new JButton("Geolocate");
        galleryBtn = new JButton("Gallery");


        previousImgBtn.addActionListener(e -> serviceListener.previousImage());

        nextImgBtn.addActionListener(e -> serviceListener.nextImage());

        galleryBtn.addActionListener(e -> serviceListener.showGallery());

        setPath.addActionListener(e -> serviceListener.setPath());


        previousImgBtn.setName("previousImgBtn");
        setPath.setName("setPath");
        syncBtn.setName("syncBtn");
        exifDataBtn.setName("exifDataBtn");
        geolocateBtn.setName("geolocateBtn");
        galleryBtn.setName("galleryBtn");
        nextImgBtn.setName("nextImgBtn");

        add(setPath);
        add(galleryBtn);
        add(previousImgBtn);
//        add(exifDataBtn);
        add(nextImgBtn);
        add(geolocateBtn);
        add(syncBtn);


    }

    public void setServiceListener(IServiceListener serviceListener)
    {
        this.serviceListener = serviceListener;
    }

}
