package gr.teicm.koala.views;


import javax.swing.*;
import java.awt.*;


public class KThumbnail
{
    private JPanel thumbnailPane;
    public JLabel imageThumbnail;
    private String imgPath;
    private JCheckBox checkBox;
    private JButton exifBtn;
    private IKThumbnail IKThumbnail;


    public KThumbnail(ImageIcon image)
    {
        initComponents();
        imgPath = image.getDescription();
        imageThumbnail.setIcon(image);

        checkBox.addActionListener(e -> IKThumbnail.selectedImage());
        exifBtn.addActionListener(e -> IKThumbnail.viewEXIF());

        thumbnailPane.add(exifBtn, BorderLayout.SOUTH);
        thumbnailPane.add(checkBox, BorderLayout.AFTER_LAST_LINE);
        thumbnailPane.add(imageThumbnail, BorderLayout.CENTER);

        imageThumbnail.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    private void initComponents()
    {

        this.thumbnailPane = new JPanel();
        this.thumbnailPane.setLayout(new BorderLayout());
        imageThumbnail = new JLabel();

        exifBtn = new JButton("EXIF");
        checkBox = new JCheckBox("Select");
    }

    public JPanel getThumbnailPane()
    {
        return thumbnailPane;
    }

    public String getImgPath()
    {
        return imgPath;
    }
}
