package gr.teicm.koala.views;


import gr.teicm.koala.CustomComponents.ScaledImageLabel;

import javax.swing.*;
import java.awt.*;


public class KPhoto
{
    public JPanel imagePanel = new JPanel();
    private String imagePath;
    private ImageIcon imageIcon;
    private ScaledImageLabel labelImage = new ScaledImageLabel();

    public KPhoto(ImageIcon imageIcon)
    {
        imagePanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.NORTHWEST;

        this.imagePath = imageIcon.getDescription();
        this.imageIcon = imageIcon;
        labelImage.setIcon(this.imageIcon);

        constraints.gridy = 0;
        constraints.gridx = 0;
        JLabel labelImgFilePath = new JLabel();
        labelImgFilePath.setText(this.imagePath);
        imagePanel.add(labelImgFilePath, constraints);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1.0;

        constraints.gridx = 1;
//        add(fieldImgFilePath, constraints);

        constraints.gridx = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.weightx = 0.0;
//        add(buttonDisplay, constraints);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;

        constraints.gridy = 1;
        constraints.gridx = 0;
        constraints.gridwidth = 3;
        labelImage.setPreferredSize(new Dimension(800, 600));
        imagePanel.add(labelImage, constraints);

    }

    public String getImagePath()
    {
        return imagePath;
    }

//    @Override
//    public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent)
//    {
//        if (mouseWheelEvent.getWheelRotation() > 0)
//        {
//            ImageManipulationService imageManipulationService = new ImageManipulationService();
//            //TEST TODO
////            labelImage.setIcon();
//            labelImage.setIcon(imageManipulationService.imageZoom(imageIcon, 10));
//            revalidate();
//            repaint();
//            System.out.println("MouseWheel value = " + mouseWheelEvent);
//        }
//    }
}