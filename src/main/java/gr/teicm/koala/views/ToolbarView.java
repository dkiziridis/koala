package gr.teicm.koala.views;

import gr.teicm.koala.Interfaces.IServiceListener;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ToolbarView extends JPanel
{

    public JButton openImgBtn;
    public JButton uploadBtn;
    public JButton exifDataBtn;
    public JButton clearImg;
    public JButton geolocateBtn;
    public JButton fetchBtn;
    public JButton scanFolder;

    private IServiceListener serviceListener;

    public ToolbarView()
    {
        setBorder(BorderFactory.createEtchedBorder());
        setLayout(new FlowLayout(FlowLayout.CENTER));
        scanFolder = new JButton("Scan");
        openImgBtn = new JButton("Open");
        uploadBtn = new JButton("Upload");
        exifDataBtn = new JButton("EXIF");
        clearImg = new JButton("Clear");
        geolocateBtn = new JButton("Geolocate");
        fetchBtn = new JButton("Fetch Image");


        scanFolder.addActionListener(e ->
        {
            try
            {
                serviceListener.showThumbnails();
            } catch (IOException e1)
            {
                e1.printStackTrace();
            }
        });
        clearImg.addActionListener(e -> serviceListener.clearImage());

        fetchBtn.addActionListener(e -> serviceListener.fetchImageById(6));

        openImgBtn.addActionListener(e -> serviceListener.openLocalImage());


        scanFolder.setName("scanFolder");
        openImgBtn.setName("openImgBtn");
        uploadBtn.setName("uploadBtn");
        exifDataBtn.setName("exifDataBtn");
        clearImg.setName("clearImg");
        geolocateBtn.setName("geolocateBtn");
        fetchBtn.setName("fetchBtn");

        add(scanFolder);
        add(openImgBtn);
        add(uploadBtn);
        add(exifDataBtn);
        add(clearImg);
        add(geolocateBtn);
        add(fetchBtn);

    }

    public void setServiceListener(IServiceListener serviceListener)
    {
        this.serviceListener = serviceListener;
    }

}
