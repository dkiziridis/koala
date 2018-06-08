package gr.teicm.koala.services;

import org.apache.commons.io.FilenameUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class IOServices
{

    public String saveFile()
    {
        String path = "";
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));
        fileChooser.setDialogTitle("Save Album");
        fileChooser.setApproveButtonText("Save");
        fileChooser.setControlButtonsAreShown(true);

        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = fileChooser.getSelectedFile();
            path = selectedFile.getAbsolutePath();
        } else if (result == JFileChooser.CANCEL_OPTION)
        {
            System.out.println("No Data");
        }
        return path;
    }

    public Path openFolder()
    {
        File path;
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("user.home"));
        chooser.setDialogTitle("Select Folder");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            return chooser.getSelectedFile().toPath();
        } else
        {
            path = new File(System.getProperty("user.home"));
            return path.toPath();
        }
    }

    public void saveImage(ImageIcon icon, String path) throws IOException
    {
        Image img = icon.getImage();
        BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = bi.createGraphics();
        g2.drawImage(img, 0, 0, null);
        g2.dispose();
        ImageIO.write(bi, FilenameUtils.getExtension(icon.getDescription()), new File(path + icon.getDescription()));
    }

    public void printToFile(List<String> imagePaths)
    {
        if (imagePaths.size() != 0)
        {
            try (BufferedWriter write = new BufferedWriter(new FileWriter(saveFile())))
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
        } else
        {
            new Message().emptyAlbum();
        }

    }

    public List<String> readFromFile()
    {
        List<String> imagePaths = new LinkedList<>();
        JFileChooser fChoose = new JFileChooser(System.getProperty("user.home"));
        File file = fChoose.getSelectedFile();
        int returnVal = fChoose.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            try (BufferedReader br = new BufferedReader(new FileReader(file)))
            {
                String line;
                while ((line = br.readLine()) != null)
                {
                    imagePaths.add(line);
                }
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return imagePaths;
    }
}
