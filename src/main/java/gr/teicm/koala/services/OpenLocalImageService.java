package gr.teicm.koala.services;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;

public class OpenLocalImageService
{
    private static ImageIcon image = new ImageIcon();

    public ImageIcon openImage()
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.setDialogTitle("Select Image");
        fileChooser.setControlButtonsAreShown(true);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Photos", "jpg", "gif", "png", "bmp");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            image = new ImageIcon(path); //TODO better
        } else if (result == JFileChooser.CANCEL_OPTION)
        {
            System.out.println("No Data");
        }
        return image;
    }

}
