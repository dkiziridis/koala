package gr.teicm.koala.views;

import gr.teicm.koala.CustomComponents.ScaledImageLabel;

import javax.swing.*;

public class MJGA extends JFrame
{
    public MJGA()
    {
        JLabel trump = new ScaledImageLabel();
        trump.setIcon(new ImageIcon("mjga.jpg"));

        add(trump);

        setDefaultLookAndFeelDecorated(true);
        setTitle("EXIF Data");
        setLocationRelativeTo(null);
        setSize(800, 600);
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
