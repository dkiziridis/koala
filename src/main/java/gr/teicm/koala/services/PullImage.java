package gr.teicm.koala.services;

import gr.teicm.koala.models.HibernateImage;
import org.hibernate.Session;

import javax.swing.*;

public class PullImage
{

    public ImageIcon fetchImageById(int imageId)
    {
        try (Session session = HibernateUtil.getSession())
        {
            HibernateImage image = session.get(HibernateImage.class, imageId);
            System.out.println("Retrieved Image from Database using Hibernate.");
            return new ImageIcon(image.getImgData());
        }
    }

}
