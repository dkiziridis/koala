package gr.teicm.koala;


import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class View
{
    // view uses Swing framework to display UI to user
    private JFrame frame;
    private JLabel selectImageLabel; //select image
    private JLabel exifDataLabel; //upload image
    private JTextField imagePathTextfield; //image path

    private JButton uploadButton; //upload button


    /**
     * View Constructor
     *
     * @param title title used for the frame
     */
    public View(String title)
    {
        // Create the principal frame
        frame = new JFrame(title);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Create UI elements
        selectImageLabel = new JLabel("Select Image: ");
        exifDataLabel = new JLabel("EXIF :  ");
        imagePathTextfield = new JTextField();

        uploadButton = new JButton("Upload");



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
        frame.getContentPane().setLayout(layout);
    }

    public JFrame getFrame()
    {
        return frame;
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