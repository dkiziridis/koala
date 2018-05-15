package gr.teicm.koala.views;

import javax.swing.*;
import java.awt.*;

public class SingleImageView extends JPanel
{
    JLabel singleImage;
    public SingleImageView(ImageIcon imageIcon)
    {
        singleImage = new JLabel();
        setLayout(new BorderLayout());
        singleImage.setIcon(imageIcon);
        add(singleImage,BorderLayout.CENTER);

        setVisible(true);
        //TODO add more buttons

    }


}
