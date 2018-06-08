package gr.teicm.koala.views;

import javax.swing.*;
import java.awt.*;

public class KExif extends JFrame
{

    // private JLabel userId;
    private JLabel jimageHeight;
    private JLabel jimageWidth;
    private JLabel jcompressionType;
    private JLabel jlatitude;
    private JLabel jlongitude;
    private JLabel jcontentType;
    private JLabel jfileSize;
    private JLabel jdate;



    private GridLayout layout;

    public KExif(String imageHeight,
                 String imageWidth,
                 String compressionType,
                 String latitude,
                 String longitude,
                 String contentType,
                 String fileSize,
                 String date)
    {
        layout = new GridLayout(7, 2);

        //userId = new JLabel("User ID : ");
        jimageHeight = new JLabel("Height : " + imageHeight);
        jimageWidth = new JLabel("Width : " + imageWidth);
        jcompressionType = new JLabel("Compression Type : " + compressionType);
        jlatitude = new JLabel("Latitude : " + latitude);
        jlongitude = new JLabel("Longitude : " + longitude);
        jcontentType = new JLabel("ContentType : " + contentType);
        jfileSize = new JLabel("File Size : " + fileSize);
        jdate = new JLabel("File Modified Date : " + date);


        setLayout(layout);
        //add(userId);
        add(jimageHeight);
        add(jimageWidth);
        add(jcompressionType);
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
