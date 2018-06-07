package gr.teicm.koala.views;

import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class KStaticGeolocation
{


    public KStaticGeolocation(double longitude, double latitude)

    {
        JFrame staticGeoLoc = new JFrame("Image Geolocation");
        String markerColor = "red";
        String zoom = "10";
        String mapSize = "800x600";

        try
        {
            String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center="
                    + longitude
                    + ","
                    + latitude
                    + "&zoom="
                    + zoom
                    + "&size="
                    + mapSize
                    + "&scale=2&maptype=roadmap&markers=color:"
                    + markerColor
                    + "%7Clabel:S%7C"
                    + longitude + ","
                    + latitude;

            String destinationFile = "image.jpg";
            URL url = new URL(imageUrl);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(destinationFile);

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1)
            {
                os.write(b, 0, length);
            }

            is.close();
            os.close();
        } catch (IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }


        JLabel map = new JLabel((Icon) new ImageIcon("map.jpg")
                .getImage()
                .getScaledInstance(800, 600, Image.SCALE_SMOOTH));

        staticGeoLoc.add(map);

//        staticGeoLoc.add(new JLabel(new ImageIcon((new ImageIcon("image.jpg")).getImage().getScaledInstance(630, 600, java.awt.Image.SCALE_SMOOTH))));

        staticGeoLoc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        staticGeoLoc.pack();
        staticGeoLoc.setVisible(true);


    }

}