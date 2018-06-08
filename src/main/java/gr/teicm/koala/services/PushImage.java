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
import java.time.LocalDateTime;
import java.time.ZoneId;

public class PushImage
{
    public PushImage(HibernateImage hibernateImage, String pathToImage) throws IOException, TikaException, SAXException
    {
        File imageFile = new File(pathToImage);
        Image image = ImageIO.read(imageFile);

        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();

        double latitude;
        double longitude;

        MetadataRetriever metadataRetrieverService = new MetadataRetriever(pathToImage);

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
        hibernateImage.setCameraBrand(null);
        hibernateImage.setCameraModel(null);
        hibernateImage.setDate(Timestamp.valueOf(LocalDateTime.now(ZoneId.of("UTC"))));
//        hibernateImage.setDate(Timestamp.valueOf(metadataRetrieverService.getDate()));
        hibernateImage.setMegapixels(null);
        hibernateImage.setDpi(null);

        session.save(hibernateImage);
        tx.commit();

    }
}
