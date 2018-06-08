package gr.teicm.koala.services;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class IOServices
{

    //TODO BETTER?
    public ImageIcon openImage()
    {
        ImageIcon image = new ImageIcon();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("getUser.home")));
        fileChooser.setDialogTitle("Select Image");
        fileChooser.setControlButtonsAreShown(true);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Photos",
                "jpg",
                "gif",
                "png",
                "bmp");
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

    public Path openFolder()
    {
        File path;
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("getUser.home"));
        chooser.setDialogTitle("Select Folder");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            return chooser.getSelectedFile().toPath();
        }
        else
        {
            path = new File(System.getProperty("getUser.home"));
            return path.toPath();
        }
    }

    public void printToFile(List<String> imagePaths)
    {
        try (BufferedWriter write = new BufferedWriter(new FileWriter(openFolder().toFile())))
        {
            for (String str : imagePaths)
            {

                write.write(str);
                write.newLine();
            }
        } catch (IOException e)
        {
            new Message().accessDenied();
            e.printStackTrace();
        }
    }

    public void ReadFromFile()
    {
        File txt = new File("");
    }
}
