package gr.teicm.koala.services;

import gr.teicm.koala.Enums.Users;
import gr.teicm.koala.models.HibernateImage;
import org.apache.commons.io.FilenameUtils;
import org.apache.tika.exception.TikaException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.xml.sax.SAXException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

public class PushImageService
{
    public PushImageService(HibernateImage hibernateImage, String pathToImage) throws IOException, TikaException, SAXException
    {
        File imageFile = new File(pathToImage);
        Image image = ImageIO.read(imageFile);


        Session session = HibernateUtilService.getSession();
        Transaction tx = session.beginTransaction();

        double latitude;
        double longitude;

        MetadataRetrieverService metadataRetrieverService = new MetadataRetrieverService(pathToImage);

        latitude = metadataRetrieverService.getLatitude();
        longitude = metadataRetrieverService.getLongitude();


        hibernateImage.setUserId(Users.ROOT.getUser()); //Call User ENUM
        hibernateImage.setImageName(imageFile.getName());
        hibernateImage.setImgData(imageFile.toString().getBytes());
        hibernateImage.setHeight((short) ((BufferedImage) image).getHeight());
        hibernateImage.setWidth((short) ((BufferedImage) image).getHeight());
        hibernateImage.setMimeType(FilenameUtils.getExtension(pathToImage));
        hibernateImage.setFileSize((int) imageFile.length());
        hibernateImage.setLatitude(latitude);
        hibernateImage.setLongitude(longitude);
        hibernateImage.setCameraBrand("TODO");
        hibernateImage.setCameraModel("TODO LATER");
        hibernateImage.setDate(new Timestamp(2001 - 24 - 2));
        hibernateImage.setMegapixels(5); //TODO
        hibernateImage.setDpi((short) 70); //TODO

        session.save(hibernateImage);
        tx.commit();

    }
}
