package gr.teicm.koala.views;

import javax.swing.*;
import java.awt.*;

public class Koala
{

    public Koala(KMenuBar kMenuBar, KPanel kPanel, KToolbar kToolbar)
    {
        JScrollPane kScrollPanel = new JScrollPane(kPanel.getViewArea());
        kScrollPanel.getVerticalScrollBar().setUnitIncrement(16);

        JFrame koala = new JFrame();
        koala.setLayout(new BorderLayout());

        koala.add(kMenuBar, BorderLayout.NORTH);
        koala.add(kToolbar, BorderLayout.SOUTH);
        koala.add(kScrollPanel, BorderLayout.CENTER);

        koala.setTitle("Koala Photo Album");
        koala.setSize(1000, 600);
        koala.setLocationRelativeTo(null);
        koala.setMinimumSize(new Dimension(800, 600));
        koala.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        koala.setVisible(true);

    }
}
