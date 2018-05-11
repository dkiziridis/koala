package gr.teicm.koala.views;


import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ThumbnailView extends JPanel
{
    public JLabel imageThumbnail;

    public ThumbnailView(ImageIcon image)
    {
        imageThumbnail = new JLabel();
        imageThumbnail.setIcon(image);
        imageThumbnail.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e)
            {
                super.mouseEntered(e);
                System.out.println("mouseEntered");
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                setBorder(BorderFactory.createBevelBorder(2));
            }

            @Override
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);
                System.out.println("mouseClicked");

            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                super.mouseExited(e);
                setBorder(BorderFactory.createLineBorder(Color.black));
            }

        });
        add(imageThumbnail);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }


}
