package gr.teicm.koala.services;

import javax.swing.*;

public class MessageService
{
    public void latLongErrorMessage(String string)
    {
        JOptionPane.showMessageDialog(null,
                "No Lat/Long data available for this image. :\n" + string,
                "Error: No Latitude and/or Longitude Data found.",
                JOptionPane.ERROR_MESSAGE);
    }
}
