package gr.teicm.koala.controllers;

import gr.teicm.koala.Interfaces.IThumbnailListener;
import gr.teicm.koala.views.ThumbnailView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ThumbnailController extends ThumbnailView
{


    public ThumbnailController(ImageIcon image, String imgPath)
    {
        super(image, imgPath);
        imageThumbnail.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent mouseEvent)
            {
                //Ποτς γκενεν ατο ?
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent)
            {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent)
            {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent)
            {
                System.out.println("mouseEntered");
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                setBorder(BorderFactory.createLineBorder(Color.gray, 4));
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent)
            {
                setBorder(BorderFactory.createLineBorder(Color.black));
            }
        });

        setiThumbnailListener(new IThumbnailListener()
        {
            @Override
            public void selectedImage()
            {
                System.out.println("Something happened");

            }

            @Override
            public void viewEXIF()
            {

            }
        });


//        checkBox.addActionListener(new ActionListener()
//        {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent)
//            {
//            }
//        });


    }

}
