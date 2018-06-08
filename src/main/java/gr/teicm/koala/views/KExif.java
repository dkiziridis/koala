package gr.teicm.koala.views;

import javax.swing.*;
import java.awt.*;

public class KExif extends JFrame
{

    private JLabel jimageHeight;
    private JLabel jimageWidth;
    private JLabel jimageName;
    private JLabel jlatitude;
    private JLabel jlongitude;
    private JLabel jcontentType;
    private JLabel jfileSize;
    private JLabel jdate;



    private GridLayout layout;

    public KExif(String imageHeight,
                 String imageWidth,
                 String imageName,
                 String latitude,
                 String longitude,
                 String contentType,
                 String fileSize,
                 String date)
    {
        layout = new GridLayout(7, 2);

        jimageHeight = new JLabel("Height : " + imageHeight);
        jimageWidth = new JLabel("Width : " + imageWidth);
        jimageName = new JLabel("Image Name : " + imageName);
        jlatitude = new JLabel("Latitude : " + latitude);
        jlongitude = new JLabel("Longitude : " + longitude);
        jcontentType = new JLabel("ContentType : " + contentType);
        jfileSize = new JLabel("File Size : " + fileSize + " bytes");
        jdate = new JLabel("File Modified Date : " + date);


        setLayout(layout);
        add(jimageName);
        add(jimageHeight);
        add(jimageWidth);
        add(jfileSize);
        add(jlatitude);
        add(jlongitude);
        add(jcontentType);
        add(jdate);
        setLayout(new GridLayout(8, 2));


        initComponents();
        setDefaultLookAndFeelDecorated(true);
        setTitle("EXIF Data");
        setLocationRelativeTo(null);
        setSize(500, 600);
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    private void initComponents()
    {


    }


}