package gr.teicm.koala.services;

import gr.teicm.koala.models.Model;
import org.hibernate.Session;

import javax.swing.*;

public class FetchImageService
{

    public ImageIcon fetchImageById(int imageId)
    {
        try (Session session = HibernateUtilService.getSession())
        {
            Model image = session.get(Model.class, imageId);
            System.out.println("Retrieved Image from Database using Hibernate.");
            return new ImageIcon(image.getImgData());
        }
    }

}
