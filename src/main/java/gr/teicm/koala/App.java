package gr.teicm.koala;

import gr.teicm.koala.controllers.Controller;

import javax.swing.*;
import java.io.IOException;

public class App
{
    public static void main(final String[] args)
    {
        SwingUtilities.invokeLater(() ->
        {
            try
            {
                new Controller();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        });


    }
}
