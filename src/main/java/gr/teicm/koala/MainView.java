package gr.teicm.koala;

import java.awt.BorderLayout;
import javax.swing.*;
import gr.teicm.koala.ToolbarView;
public class MainView extends JFrame
{
    // view uses Swing framework to display UI to user

    /**
     * View Constructor
     *
     * @param title title used for the frame
     */
    public MainView(String title)
    {
        // Create the principal frame
        this.setTitle(title);
        this.getContentPane().setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 200);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        initComponents();


    }

    public void initComponents()
    {

        // Create UI elements
        selectImageLabel = new JLabel("Select Image: ");
        exifDataLabel = new JLabel("EXIF :  ");
        imagePathTextfield = new JTextField();
        uploadButton = new JButton("Upload");
        mainPanel = new JPanel();
        // Add UI element to frame

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        layout.setAutoCreateGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(selectImageLabel)
                        .addComponent(exifDataLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(imagePathTextfield))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(uploadButton))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(selectImageLabel)
                        .addComponent(imagePathTextfield)
                        .addComponent(uploadButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(exifDataLabel))
        );

        layout.linkSize(SwingConstants.HORIZONTAL, uploadButton);
        this.getContentPane().setLayout(layout);
    }

    public void setFrame(JFrame frame)
    {
        this.frame = frame;
    }

    public JLabel getSelectImageLabel()
    {
        return selectImageLabel;
    }

    public void setSelectImageLabel(JLabel selectImageLabel)
    {
        this.selectImageLabel = selectImageLabel;
    }

    public JLabel getExifDataLabel()
    {
        return exifDataLabel;
    }

    public void setExifDataLabel(JLabel exifDataLabel)
    {
        this.exifDataLabel = exifDataLabel;
    }

    public JTextField getImagePathTextfield()
    {
        return imagePathTextfield;
    }

    public void setImagePathTextfield(JTextField imagePathTextfield)
    {
        this.imagePathTextfield = imagePathTextfield;
    }

    public JButton getUploadButton()
    {
        return uploadButton;
    }

    public void setUploadButton(JButton uploadButton)
    {
        this.uploadButton = uploadButton;
    }

}