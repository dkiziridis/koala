package gr.teicm.koala.views;

import javax.swing.*;
import java.awt.*;

public class SingleImageView extends JPanel
{
    JLabel singleImage;
    public SingleImageView(ImageIcon singleImage)
    {
        setLayout(new BorderLayout());
        setVisible(true);
        this.singleImage.setIcon(singleImage);
        add(this.singleImage,BorderLayout.CENTER);
        //TODO add more buttons

    }
}
