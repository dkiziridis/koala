package gr.teicm.koala.views;//package gr.teicm.koala.views;
//
//import gr.teicm.koala.services.ResizeImageService;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class SingleImageView extends JPanel
//{
//
//    public SingleImageView(ImageIcon imageIcon)
//    {
//
//        Image scaled = imageIcon.getImage();
//
////        Image scaledImage = scaled.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
//        JLabel singleImage = new ScaledImageLabel();
//        setLayout(new BorderLayout());
//        singleImage.setIcon(scaled);
//        JScrollPane scrollPane = new JScrollPane(singleImage);
//        add(scrollPane, BorderLayout.CENTER);
//        setVisible(true);
//        //TODO add more buttons
//
//
//    }
//
//    public class ScaledImageLabel extends JLabel
//    {
//        protected void paintComponent(Graphics g)
//        {
//            ImageIcon icon = (ImageIcon) getIcon();
//            if (icon != null)
//            {
//                ResizeImageService.drawScaledImage(icon.getImage(), this, g);
//            }
//        }
//    }
//}


import gr.teicm.koala.CustomComponents.ScaledImageLabel;

import javax.swing.*;
import java.awt.*;


public class SingleImageView extends JPanel
{
    private JLabel labelImage = new ScaledImageLabel();

    public SingleImageView(ImageIcon imageIcon)
    {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.NORTHWEST;

        labelImage.setIcon(imageIcon);

        constraints.gridy = 0;
        constraints.gridx = 0;
//        add(labelImgFilePath, constraints);

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





}