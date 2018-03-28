package gr.teicm.koala;


import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.File;
import java.sql.Timestamp;
import java.io.FileInputStream;

public class App
{

    public static void main(final String[] args) throws Exception
    {

        HibernateUtil hibernateUtil = new HibernateUtil();
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();


        // Manual hibernate test

        File img = new File("C:\\Users\\Crow\\Desktop\\test.jpg");
        byte[] bFile = new byte[(int) img.length()];

        try {
            FileInputStream fileInputStream = new FileInputStream(img);
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        Model image = new Model();
        image.setId(2);
        image.setUserId("2342");
        image.setImageName("test.jpg");
        image.setImgData(bFile);
        image.setHeight((short) 12994);
        image.setWidth((short) 884);
        image.setMimeType("jpeg");
        image.setFileSize(bFile.length);
        image.setLatitude(23.4);
        image.setLongtitude(54.6);
        image.setCameraBrand("Sony");
        image.setCameraModel("DSLR");
        image.setDate(new Timestamp(19-21-4411));
        image.setMegapixels(7);
        image.setDpi((short) 70);

        // Manual hibernate test */

        // tika test






        session.save(image);
        tx.commit();

        session.close();
        hibernateUtil.shutdown();

//        Model m = new Model();
//        View v = new View("Koala Photo Album");
//        koala.Controller c = new koala.Controller(m,v);
//        c.initController();
    }
}
