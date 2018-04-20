package gr.teicm.koala;

import java.awt.FlowLayout;
import javax.swing.*;

public class ToolbarView extends JPanel
{
    public JButton openImgBtn;
    public JButton uploadBtn;
    public JButton exifDataBtn;
    public JButton clearImg;
    public JButton geolocateBtn;

    ToolbarView()
    {
        setBorder(BorderFactory.createEtchedBorder());
        setLayout(new FlowLayout(FlowLayout.CENTER));
        openImgBtn = new JButton("Open");
        uploadBtn = new JButton("Upload");
        exifDataBtn = new JButton("EXIF");
        clearImg = new JButton("Clear");
        geolocateBtn = new JButton("Geolocate");

        openImgBtn.setName("openImgBtn");
        uploadBtn.setName("uploadBtn");
        exifDataBtn.setName("exifDataBtn");
        clearImg.setName("clearImg");
        geolocateBtn.setName("geolocateBtn");

        add(openImgBtn);
        add(uploadBtn);
        add(exifDataBtn);
        add(clearImg);
        add(geolocateBtn);

    }

}
