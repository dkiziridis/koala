package gr.teicm.koala.views;

import javax.swing.*;
import java.awt.*;

public class SingleImageView extends JPanel
{

    public SingleImageView(ImageIcon imageIcon)
    {

        JLabel singleImage = new JLabel();
        setLayout(new BorderLayout());
        singleImage.setIcon(imageIcon);
        JScrollPane scrollPane = new JScrollPane(singleImage);
        add(scrollPane,BorderLayout.CENTER);
        setVisible(true);
        //TODO add more buttons

    }

}
