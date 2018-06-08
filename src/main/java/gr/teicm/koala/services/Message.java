package gr.teicm.koala.services;

import javax.swing.*;

public class Message
{
    public void latLongErrorMessage(String string)
    {
        JOptionPane.showMessageDialog(null,
                "No Lat/Long data available for this image. :\n" + string,
                "EXIF Error!",
                JOptionPane.ERROR_MESSAGE);
    }

    public void noPrinterService()
    {
        JOptionPane.showMessageDialog(null,
                "No Printer services available on this machine",
                "Print Services Error!",
                JOptionPane.ERROR_MESSAGE);
    }

    public void accessDenied()
    {
        JOptionPane.showMessageDialog(null,
                "Access denied",
                "Cannot write here!",
                JOptionPane.ERROR_MESSAGE);
    }
}
