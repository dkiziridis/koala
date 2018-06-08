package gr.teicm.koala.views;

import javax.swing.*;
import java.awt.*;


public class KMenuBar extends JMenuBar
{
    private final JMenu file;
    private final JMenu edit;
    private final JMenu help;
    private final JMenu options;
    private final JMenuItem fileOpen;
    private final JMenuItem fileClose;
    private final JMenuItem fileExit;
    private final JMenuItem fileSave;
    private final JMenuItem helpAbout;
    private final JMenuItem optionsChangeBackground;
    IKMenuBar ikMenuBar;

    public KMenuBar()
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
        helpAbout = new JMenuItem("About");
        optionsChangeBackground = new JMenuItem("Dark Background");

        add(file);
        add(edit);
        add(options);
        add(help);

        file.add(fileOpen);
        file.add(fileSave);
        file.add(fileClose);
        file.add(fileExit);
        help.add(helpAbout);
        options.add(optionsChangeBackground);

        helpAbout.addActionListener(actionEvent ->
        {
            ikMenuBar.showAbout();
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
        optionsChangeBackground.addActionListener(actionEvent ->
        {
            ikMenuBar.changeBackground();
        });
    }

    public void setIkMenuBar(IKMenuBar ikMenuBar)
    {
        this.ikMenuBar = ikMenuBar;
    }

}
