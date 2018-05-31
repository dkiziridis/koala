package gr.teicm.koala.CustomComponents;

import gr.teicm.koala.services.ImageManipulationService;

import javax.swing.*;
import java.awt.*;


public class ScaledImageLabel extends JLabel
{
    protected void paintComponent(Graphics g)
    {
        ImageIcon icon = (ImageIcon) getIcon();
        if (icon != null)
        {
            ImageManipulationService.drawScaledImage(icon.getImage(), this, g);
        }
    }
}