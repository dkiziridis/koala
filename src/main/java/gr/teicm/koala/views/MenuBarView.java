package gr.teicm.koala.views;

import javax.swing.*;
import java.awt.*;


public class MenuBarView extends JMenuBar
{
    private final JMenu file;
    private final JMenu edit;
    private final JMenu help;
    private final JMenu options;
    private final JMenuItem fileOpen;
    private final JMenuItem fileClose;
    private final JMenuItem fileExit;
    private final JMenuItem fileSave;
    private final JMenuItem editUndo;
    private final JMenuItem editRedo;
    private final JMenuItem helpAbout;
    private final JMenuItem optionsChangeBorder;

    public MenuBarView()
    {
        setBorder(BorderFactory.createEtchedBorder(Color.lightGray, Color.black));
        setLayout(new FlowLayout(FlowLayout.LEADING));
        file = new JMenu("File");
        edit = new JMenu("Edit");
        help = new JMenu("Help");
        options = new JMenu("Options");
        fileOpen = new JMenuItem("Open");
        fileClose = new JMenuItem("Close");
        fileSave = new JMenuItem("Save");
        fileExit = new JMenuItem("Exit");
        editUndo = new JMenuItem("Undo");
        editRedo = new JMenuItem("Redo");
        helpAbout = new JMenuItem("About");
        optionsChangeBorder = new JMenuItem("Matrix");

        add(file);
        add(edit);
        add(options);
        add(help);

        file.add(fileOpen);
        file.add(fileSave);
        file.add(fileClose);
        file.add(fileExit);
        edit.add(editUndo);
        edit.add(editRedo);
        help.add(helpAbout);
        options.add(optionsChangeBorder);

        helpAbout.addActionListener(actionEvent ->
        {

        });
        fileSave.addActionListener(actionEvent ->
        {

        });
        fileOpen.addActionListener(actionEvent ->
        {

        });
        fileExit.addActionListener(actionEvent ->
        {

        });
        fileClose.addActionListener(actionEvent ->
        {

        });
        optionsChangeBorder.addActionListener(actionEvent ->
        {

        });
    }


}
