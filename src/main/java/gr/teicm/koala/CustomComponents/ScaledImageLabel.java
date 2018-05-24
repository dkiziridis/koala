package gr.teicm.koala.CustomComponents;

import gr.teicm.koala.services.ResizeImageService;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class ScaledImageLabel extends JLabel
{
    protected void paintComponent(Graphics g)
    {
        ImageIcon icon = (ImageIcon) getIcon();
        if (icon != null)
        {
            ResizeImageService.drawScaledImage(icon.getImage(), this, g);
        }
    }
}