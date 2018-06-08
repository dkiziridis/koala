package gr.teicm.koala.CustomComponents;

import gr.teicm.koala.services.ImageManipulation;

import javax.swing.*;
import java.awt.*;


public class ScaledImageLabel extends JLabel
{
    protected void paintComponent(Graphics g)
    {
        ImageIcon icon = (ImageIcon) getIcon();
        if (icon != null)
        {
            ImageManipulation.drawScaledImage(icon.getImage(), this, g);
        }
    }
}