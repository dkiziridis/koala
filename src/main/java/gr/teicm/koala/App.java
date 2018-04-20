package gr.teicm.koala;

import javax.swing.*;

public class App
{
    public static void main(final String[] args)
    {
        SwingUtilities.invokeLater(Controller::new);
    }
}
