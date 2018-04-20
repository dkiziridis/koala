package gr.teicm.koala;

import javax.swing.*;

public class App
{
    public static void main(final String[] args) throws Exception
    {
        SwingUtilities.invokeLater(Controller::new);
//        HibernateUtil hibernateUtil = new HibernateUtil();
//        Session session = HibernateUtil.getSession();
//        Transaction tx = session.beginTransaction();

        /* Manual hibernate test

        HibernateModel image = new HibernateModel();
        image.setId(2);
        image.setUserId("2342");
        image.setImageName("test.jpg");
        image.setImgData(bFile);
        image.setHeight((short) 12994);
        image.setWidth((short) 884);
        image.setMimeType("jpeg");
        image.setFileSize(bFile.length);
        image.setLatitude(23.4);
        image.setLongitude(54.6);
        image.setCameraBrand("Sony");
        image.setCameraModel("DSLR");
        image.setDate(new Timestamp(2001-24-2));
        image.setMegapixels(7);
        image.setDpi((short) 70);

        Manual hibernate test */

        // tika test

        //Metadata metadata = ImageMetadataReader.readMetadata(new File("C:\\Users\\Crow\\Desktop\\test.jpg"));

        //image.setHeight(metadata);


//        session.save(image);
//        tx.commit();

//        session.close();
//        hibernateUtil.shutdown();



    }
}
