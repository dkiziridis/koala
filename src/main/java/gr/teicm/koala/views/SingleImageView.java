package gr.teicm.koala.views;



import gr.teicm.koala.CustomComponents.ScaledImageLabel;
import gr.teicm.koala.services.ImageManipulationService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;


public class SingleImageView extends JPanel implements MouseWheelListener
{
    private String imagePath;
    private ImageIcon imageIcon;
    private ScaledImageLabel labelImage = new ScaledImageLabel();

    public SingleImageView(ImageIcon imageIcon, String imagePath)
    {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.NORTHWEST;

        this.imagePath = imagePath;
        this.imageIcon = imageIcon;
        labelImage.setIcon(this.imageIcon);

        constraints.gridy = 0;
        constraints.gridx = 0;
        JLabel labelImgFilePath = new JLabel();
        labelImgFilePath.setText(this.imagePath);
        add(labelImgFilePath, constraints);

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
        add(labelImage, constraints);

    }

    public String getImagePath()
    {
        return imagePath;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent)
    {
        if (mouseWheelEvent.getWheelRotation() > 0)
        {
            ImageManipulationService imageManipulationService = new ImageManipulationService();
            //TEST TODO
//            labelImage.setIcon();
            labelImage.setIcon(imageManipulationService.imageZoom(imageIcon, 10));
            revalidate();
            repaint();
            System.out.println("MouseWheel value = " + mouseWheelEvent);
        }
    }
}