package gr.teicm.koala.services;

import javax.swing.*;

class Message
{
    void latLongErrorMessage(String string)
    {
        JOptionPane.showMessageDialog(null,
                "No Lat/Long data available for this image. :\n" + string,
                "EXIF Error!",
                JOptionPane.ERROR_MESSAGE);
    }

    void noPrinterService()
    {
        JOptionPane.showMessageDialog(null,
                "No Printer services available on this machine",
                "Print Services Error!",
                JOptionPane.ERROR_MESSAGE);
    }

    void accessDenied()
    {
        JOptionPane.showMessageDialog(null,
                "Access denied",
                "Cannot write here!",
                JOptionPane.ERROR_MESSAGE);
    }

    void emptyAlbum()
    {
        JOptionPane.showMessageDialog(null,
                "Select photos to add to album first",
                "Album is empty!",
                JOptionPane.ERROR_MESSAGE);
    }
}
