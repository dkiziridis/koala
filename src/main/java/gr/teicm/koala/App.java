package gr.teicm.koala;

import gr.teicm.koala.controllers.Controller;
import gr.teicm.koala.models.LocalImageCollection;
import gr.teicm.koala.views.KPanel;

import javax.swing.*;
import java.io.IOException;

public class App
{
    public static void main(final String[] args) throws IOException
    {
        LocalImageCollection collection = new LocalImageCollection();
        KPanel kPanel = new KPanel();
        SwingUtilities.invokeLater(() ->
        {
            try
            {
                new Controller(collection, kPanel);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        });
    }
}
