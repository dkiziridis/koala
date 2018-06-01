package gr.teicm.koala.views;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class StaticGeolocationView extends JFrame
{
    public StaticGeolocationView(double longitude, double latitude)

    {


        try
        {
            String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center=" + longitude + "," + latitude + "&zoom=11&size=612x612&scale=2&maptype=roadmap&markers=color:red%7Clabel:S%7C" + longitude + "," + latitude;

            String destinationFile = "image.jpg";
            String str = destinationFile;
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
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(new JLabel(new ImageIcon((new ImageIcon("image.jpg")).getImage().getScaledInstance(630, 600, java.awt.Image.SCALE_SMOOTH))));

        setVisible(true);
        pack();

    }

}