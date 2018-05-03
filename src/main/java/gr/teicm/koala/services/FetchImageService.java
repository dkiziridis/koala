package gr.teicm.koala.services;

import gr.teicm.koala.models.HibernateImage;
import org.hibernate.Session;

import javax.swing.*;

public class FetchImageService
{

    public ImageIcon fetchImageById(int imageId)
    {
        try (Session session = HibernateUtilService.getSession())
        {
            HibernateImage image = session.get(HibernateImage.class, imageId);
            System.out.println("Retrieved Image from Database using Hibernate.");
            return new ImageIcon(image.getImgData());
        }
    }

}
