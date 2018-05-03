package gr.teicm.koala.views;

import gr.teicm.koala.IServiceListener;
import gr.teicm.koala.controllers.Controller;
import gr.teicm.koala.controllers.ToolBarViewController;
import gr.teicm.koala.services.FetchImageService;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class ToolbarView extends JPanel
{
//    Controller controller = new Controller();

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


        scanFolder.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    serviceListener.populatePanel();
                } catch (IOException e1)
                {
                    e1.printStackTrace();
                }
            }
        });
        clearImg.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                serviceListener.clearImage();

            }
        });

        fetchBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                serviceListener.fetchImageById(6);
            }
        });

        openImgBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                serviceListener.openLocalImage();
            }
        });


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
