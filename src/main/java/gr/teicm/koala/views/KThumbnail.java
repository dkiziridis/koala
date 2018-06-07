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
        thumbnailPane.add(checkBox, BorderLayout.NORTH);
        thumbnailPane.add(imageThumbnail, BorderLayout.CENTER);

        imageThumbnail.setBorder(BorderFactory.createLineBorder(Color.black));
        thumbnailPane.setSize(new Dimension(400, 400));
    }

    private void initComponents()
    {
        thumbnailPane = new JPanel();
        thumbnailPane.setLayout(new BorderLayout());
        imageThumbnail = new JLabel();

        exifBtn = new JButton("EXIF");
        checkBox = new JCheckBox("Select");

    }

    public void setBorder()
    {
        imageThumbnail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imageThumbnail.setBorder(BorderFactory.createLineBorder(Color.gray, 4));
    }

    public void unsetBorder()
    {
        imageThumbnail.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public JPanel getThumbnailPane()
    {
        return thumbnailPane;
    }

    public String getImgPath()
    {
        return imgPath;
    }

    public void setIKThumbnail(gr.teicm.koala.views.IKThumbnail IKThumbnail)
    {
        this.IKThumbnail = IKThumbnail;
    }
}
