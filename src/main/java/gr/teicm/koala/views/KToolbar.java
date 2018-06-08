package gr.teicm.koala.views;

import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import javax.print.PrintException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Path;

public class KToolbar extends JPanel
{

    private static final Path Path = null;
    private final JButton makeAlbumBtn;
    private JButton setPathBtn;
    private JButton syncBtn;
    private JButton exifDataBtn;
    private JButton nextImgBtn;
    private JButton geolocateBtn;
    private JButton galleryBtn;
    private JButton previousImgBtn;
    private JButton printImgBtn;

    private IKToolbar IKToolbar;

    public KToolbar()
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
        makeAlbumBtn = new JButton("Create Album");

        syncBtn.addActionListener(e ->
        {

            try
            {
                IKToolbar.sync();
            } catch (TikaException | IOException | SAXException e1)
            {
                e1.printStackTrace();
            }

        });
        printImgBtn.addActionListener(e ->
        {
            try
            {
                IKToolbar.printImage();
            } catch (PrintException | IOException e1)
            {
                e1.printStackTrace();
            }
        });

        previousImgBtn.addActionListener(e -> IKToolbar.previousImage());

        nextImgBtn.addActionListener(e -> IKToolbar.nextImage());

        galleryBtn.addActionListener(e ->
        {
            try
            {
                IKToolbar.showGallery();
            } catch (IOException e1)
            {
                e1.printStackTrace();
            }
        });

        setPathBtn.addActionListener(e ->
        {
            try
            {
                IKToolbar.openFolder();
            } catch (IOException e1)
            {
                e1.printStackTrace();
            }
        });

        geolocateBtn.addActionListener(e ->
        {
            try
            {
                IKToolbar.geolocate();
            } catch (TikaException | IOException | SAXException e1)
            {
                e1.printStackTrace();
            }
        });

        exifDataBtn.addActionListener(e ->
        {
            try
            {
                IKToolbar.exifService();
            } catch (TikaException | IOException | SAXException e1)
            {
                e1.printStackTrace();
            }
        });

        makeAlbumBtn.addActionListener(e -> IKToolbar.makeAlbum());


        add(setPathBtn);
        add(galleryBtn);
        add(previousImgBtn);
        add(nextImgBtn);
        add(geolocateBtn);
        add(printImgBtn);
        add(syncBtn);
        add(exifDataBtn);
        add(makeAlbumBtn);


    }

    public void hideOrShowButtons(boolean bool)
    {
        setPathBtn.setVisible(bool);
        syncBtn.setVisible(bool);

    }


    public void setIKToolbar(IKToolbar IKToolbar)
    {
        this.IKToolbar = IKToolbar;
    }

}
