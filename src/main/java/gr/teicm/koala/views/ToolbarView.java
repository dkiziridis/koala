package gr.teicm.koala.views;

import gr.teicm.koala.Interfaces.IToolbarListener;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import javax.print.PrintException;
import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

public class ToolbarView extends JPanel
{

    private static final Path Path = null;
    private JButton setPathBtn;
    private JButton syncBtn;
    private JButton exifDataBtn;
    private JButton nextImgBtn;
    private JButton geolocateBtn;
    private JButton galleryBtn;
    private JButton previousImgBtn;
    private JButton printImgBtn;

    private IToolbarListener iToolbarListener;

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
        printImgBtn = new JButton("Print");

        printImgBtn.addActionListener(e ->
        {
            try
            {
                iToolbarListener.printImage("");
            } catch (FileNotFoundException | PrintException e1)
            {
                e1.printStackTrace();
            }
        });

        previousImgBtn.addActionListener(e -> iToolbarListener.previousImage());

        nextImgBtn.addActionListener(e -> iToolbarListener.nextImage());

        galleryBtn.addActionListener(e -> iToolbarListener.showGallery());

        setPathBtn.addActionListener(e ->
        {
            try
            {
                iToolbarListener.openFolder();
            } catch (IOException e1)
            {
                e1.printStackTrace();
            }
        });

        geolocateBtn.addActionListener(e ->
        {
            try
            {
                iToolbarListener.geolocate();
            } catch (TikaException | IOException | SAXException e1)
            {
                e1.printStackTrace();
            }
        });


//        previousImgBtn.setName("previousImgBtn");
//        setPathBtn.setName("setPathBtn");
//        syncBtn.setName("syncBtn");
//        exifDataBtn.setName("exifDataBtn");
//        geolocateBtn.setName("geolocateBtn");
//        galleryBtn.setName("galleryBtn");
//        nextImgBtn.setName("nextImgBtn");

        add(setPathBtn);
        add(galleryBtn);
        add(previousImgBtn);
        add(nextImgBtn);
        add(geolocateBtn);
        add(printImgBtn);
        add(syncBtn);


    }

    public void setiToolbarListener(IToolbarListener iToolbarListener)
    {
        this.iToolbarListener = iToolbarListener;
    }

}
