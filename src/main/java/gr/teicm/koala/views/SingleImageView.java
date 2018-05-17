package gr.teicm.koala.views;

import javax.swing.*;
import java.awt.*;

public class SingleImageView extends JPanel
{
    JLabel singleImage;
    public JButton nextBtn;
    public JButton previousBtn;
    public JButton backBtn;
    private JScrollPane scrollPane;
    public SingleImageView(ImageIcon imageIcon)
    {
        nextBtn = new JButton("Next");
        previousBtn = new JButton("Previous");
        backBtn = new JButton("Back");
        singleImage = new JLabel();
        setLayout(new BorderLayout());
        singleImage.setIcon(imageIcon);
        scrollPane = new JScrollPane(singleImage);
        add(scrollPane,BorderLayout.CENTER);
        add(nextBtn,BorderLayout.EAST);
        add(previousBtn,BorderLayout.WEST);
        add(backBtn,BorderLayout.SOUTH);
        setVisible(true);
        //TODO add more buttons

    }


}
