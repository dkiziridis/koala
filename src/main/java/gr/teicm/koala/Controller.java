package gr.teicm.koala;

import javax.swing.*;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

public class Controller
{

    ///////////////////////////////////DILOSI-MEAVLIWN///////////////////////////////////////////
    public Model model;
    public View view;

    //////////////////////////////////////////////////////////////////////////////////////////////////
    public Controller(Model m, View v)
    {
        model = m;
        view = v;
        initView();


    }

    //////////////////////////////////////INITIALAZATION////////////////////////////////////////////////
    public void initView()
    {
        view.getImagePathTextfield().setText(model.getCameraModel());
        view.getImagePathTextfield().setText(model.getCameraBrand());
    }

    public void initController()
    {
        view.getUploadButton().addActionListener(e -> saveFirstname());

    }
//////////////////////////////////////////////////////////////////////////////////////////////////////

    public void saveFirstname()
    {
        //model.setFirstName(view.getImagePathTextfield().getText());

        JOptionPane.showMessageDialog(null, "Image uploaded", "Info", INFORMATION_MESSAGE);
    }




}
