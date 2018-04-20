package gr.teicm.koala;

import javax.swing.*;
import java.awt.*;

public class ExifView extends JFrame
{
    private JLabel userId;
    private JLabel imageName;
    private JLabel imageHeight;
    private JLabel imageWidth;
    private JLabel mimeType;
    private JLabel fileSize;
    private JLabel latitude;
    private JLabel longitude;
    private JLabel cameraBrand;
    private JLabel cameraModel;
    private JLabel date;
    private JLabel megapixels;
    private JLabel dpi;
    private GridLayout layout;

    ExifView()
    {
        layout = new GridLayout(7,2);
        userId = new JLabel("User ID : ");
        imageName = new JLabel("Name : ");
        imageHeight = new JLabel("Height : ");
        imageWidth = new JLabel("Width : ");
        mimeType = new JLabel("Type : ");
        fileSize = new JLabel("Size : ");
        latitude = new JLabel("Latitude : ");
        longitude = new JLabel("Longitude : ");
        cameraBrand = new JLabel("Camera Brand : ");
        cameraModel = new JLabel("Camera Model : ");
        date = new JLabel("Date : ");
        megapixels = new JLabel("Megapixels : ");
        dpi = new JLabel("DPI : ");

        setLayout(layout);
        add(userId);
        add(imageName);
        add(imageHeight);
        add(imageWidth);
        add(mimeType);
        add(fileSize);
        add(latitude);
        add(longitude);
        add(cameraBrand);
        add(cameraModel);
        add(date);
        add(megapixels);
        add(dpi);
    }


    public JLabel getUserId()
    {
        return userId;
    }

    public void setUserId(JLabel userId)
    {
        this.userId = userId;
    }

    public JLabel getImageName()
    {
        return imageName;
    }

    public void setImageName(JLabel imageName)
    {
        this.imageName = imageName;
    }

    public JLabel getImageHeight()
    {
        return imageHeight;
    }

    public void setImageHeight(JLabel imageHeight)
    {
        this.imageHeight = imageHeight;
    }

    public JLabel getImageWidth()
    {
        return imageWidth;
    }

    public void setImageWidth(JLabel imageWidth)
    {
        this.imageWidth = imageWidth;
    }

    public JLabel getMimeType()
    {
        return mimeType;
    }

    public void setMimeType(JLabel mimeType)
    {
        this.mimeType = mimeType;
    }

    public JLabel getFileSize()
    {
        return fileSize;
    }

    public void setFileSize(JLabel fileSize)
    {
        this.fileSize = fileSize;
    }

    public JLabel getLatitude()
    {
        return latitude;
    }

    public void setLatitude(JLabel latitude)
    {
        this.latitude = latitude;
    }

    public JLabel getLongitude()
    {
        return longitude;
    }

    public void setLongitude(JLabel longitude)
    {
        this.longitude = longitude;
    }

    public JLabel getCameraBrand()
    {
        return cameraBrand;
    }

    public void setCameraBrand(JLabel cameraBrand)
    {
        this.cameraBrand = cameraBrand;
    }

    public JLabel getCameraModel()
    {
        return cameraModel;
    }

    public void setCameraModel(JLabel cameraModel)
    {
        this.cameraModel = cameraModel;
    }

    public JLabel getDate()
    {
        return date;
    }

    public void setDate(JLabel date)
    {
        this.date = date;
    }

    public JLabel getMegapixels()
    {
        return megapixels;
    }

    public void setMegapixels(JLabel megapixels)
    {
        this.megapixels = megapixels;
    }

    public JLabel getDpi()
    {
        return dpi;
    }

    public void setDpi(JLabel dpi)
    {
        this.dpi = dpi;
    }
}
