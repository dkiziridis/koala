package gr.teicm.koala;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Metadata;

import org.apache.tika.exception.TikaException;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;


import org.hibernate.Session;
import org.hibernate.Transaction;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.sql.Timestamp;
import java.io.FileInputStream;
import java.util.Set;

public class App
{
    public static void main(final String[] args) throws Exception
    {

        HibernateUtil hibernateUtil = new HibernateUtil();
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();

        //* Manual hibernate test

//        File img = new File("C:\\Users\\Crow\\Desktop\\test.jpg");
//        byte[] bFile = new byte[(int) img.length()];
//
//        try
//        {
//            FileInputStream fileInputStream = new FileInputStream(img);
//            fileInputStream.read(bFile);
//            fileInputStream.close();
//        } catch (Exception e)
//        {
//            e.printStackTrace();
//        }


        Model image = new Model();


//        image.setId(2);
//        image.setUserId("2342");
//        image.setImageName("test.jpg");
//        image.setImgData(bFile);
//        image.setHeight((short) 12994);
//        image.setWidth((short) 884);
//        image.setMimeType("jpeg");
//        image.setFileSize(bFile.length);
//        image.setLatitude(23.4);
//        image.setLongtitude(54.6);
//        image.setCameraBrand("Sony");
//        image.setCameraModel("DSLR");
//        image.setDate(new Timestamp(2001-24-2));
//        image.setMegapixels(7);
//        image.setDpi((short) 70);

        // Manual hibernate test */

        // tika test

        //Metadata metadata = ImageMetadataReader.readMetadata(new File("C:\\Users\\Crow\\Desktop\\test.jpg"));

               //image.setHeight(metadata);


//        session.save(image);
//        tx.commit();

        session.close();
        hibernateUtil.shutdown();


        MainView v = new MainView("Koala Photo");
        Model m = new Model();
        Controller c = new Controller(m,v);
        c.initController();
    }
}
