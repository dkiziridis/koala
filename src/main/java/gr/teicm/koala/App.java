package gr.teicm.koala;

import gr.teicm.koala.controllers.Controller;

import javax.swing.*;

public class App
{
    public static void main(final String[] args)
    {
        SwingUtilities.invokeLater(Controller::new);
    }
}
