package gr.teicm.koala;

import java.awt.*;
import javax.swing.*;

public class View extends JFrame
{
    // view uses Swing framework to display UI to user
    public ToolbarView toolbarView = new ToolbarView();
    public GalleryView galleryView = new GalleryView();

    /**
     * View Constructor
     *
     * @param title title used for the frame
     */
    public View(String title)
    {
        // Create the principal frame
        setTitle(title);
        getContentPane().setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        //setVisible(false);
        add(toolbarView);
        add(galleryView);
        //initComponents();


    }

    public void initComponents()
    {


        // Create UI elements

        // Add UI element to frame

    }


//    void setFormListener(IEventListener listener)
//    {
//        this.listener = listener;
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e)
//    {
//        JButton clicked = (JButton) e.getSource();
//        if (clicked == openImgBtn)
//        {
//            listener.buttonWasPressed("openImgBtn");
//        }else if (clicked == uploadBtn)
//        {
//            listener.buttonWasPressed("uploadBtn");
//        }else if (clicked == exifDataBtn)
//        {
//            listener.buttonWasPressed("exifDataBtn");
//        }
//    }
}