package gr.teicm.koala.services;

import gr.teicm.koala.models.HibernateImage;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.swing.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class PullImage
{

    public List<String> fetchImageNames()
    {

        LinkedList<String> images = new LinkedList<>();

        try (Session session = HibernateUtil.getSession())
        {
            Query qry = session.createQuery("from HibernateImage p");

            List l = qry.list();
            System.out.println("Total Number Of Images : " + l.size());

            for (Object o : l)
            {
                HibernateImage p = (HibernateImage) o;
                images.add(p.getImageName());
            }
            session.close();
        }
        return images;
    }

    public ImageIcon fetchImageByName(String imageName)
    {
        try (Session session = HibernateUtil.getSession())
        {
            HibernateImage image = session.get(HibernateImage.class, imageName);
            System.out.println("Retrieved Image from Database using Hibernate.");
            return new ImageIcon(image.getImgData());
        }
    }

    public void downloadImages(List<String> imageList, String path) throws IOException
    {

        for (String image : imageList)
        {
            new IOServices().saveImage(fetchImageByName(image), path + "/" + image);
        }

    }

}
