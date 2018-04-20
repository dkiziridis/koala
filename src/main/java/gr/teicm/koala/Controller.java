package gr.teicm.koala;


import javax.swing.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

import java.awt.*;

public class Controller extends JFrame implements ActionListener
{


    private GalleryView galleryView;
    private ToolbarView toolbarView;
    private ExifView exifView;
    private String currentPath;

    Controller(Model model, View View)
    {


    }

    Controller()
    {
        setLayout(new BorderLayout());
        toolbarView = new ToolbarView();
        galleryView = new GalleryView();
        exifView = new ExifView();

        add(toolbarView, BorderLayout.SOUTH);
        add(galleryView, BorderLayout.CENTER);

        toolbarView.openImgBtn.addActionListener(this);
        toolbarView.uploadBtn.addActionListener(this);
        toolbarView.exifDataBtn.addActionListener(this);
        toolbarView.clearImg.addActionListener(this);
        toolbarView.exifDataBtn.addActionListener(this);


        setTitle("Koala Photo Album");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(800, 600));
        //setMaximumSize(new Dimension(1200, 900));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public ImageIcon ResizeImage(String imgPath)
    {
        ImageIcon MyImage = new ImageIcon(imgPath);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(galleryView.image.getWidth(), galleryView.image.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(toolbarView.openImgBtn))
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
                galleryView.insertImage(ResizeImage(path));
                currentPath = path;
            } else if (result == JFileChooser.CANCEL_OPTION)
            {
                System.out.println("No Data");
            }
        } else if (e.getSource().equals(toolbarView.clearImg))
        {
            galleryView.clearImage();
        } else if (e.getSource().equals(toolbarView.exifDataBtn))
        {
            exifView.setTitle("EXIF Data");
            exifView.setSize(400, 700);
            exifView.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            exifView.setVisible(true);
        }

    }

    public int initGalleryView() //TODO
    {

        return 0;
    }


}

