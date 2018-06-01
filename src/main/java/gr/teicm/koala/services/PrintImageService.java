package gr.teicm.koala.services;

import javax.print.*;
import java.io.FileInputStream;
import java.io.InputStream;

public class PrintImageService
{
    public PrintImageService(FileInputStream img) throws PrintException
    {
        DocFlavor flavour = DocFlavor.INPUT_STREAM.JPEG;
        PrintService[] services = PrintServiceLookup.lookupPrintServices(flavour, null);
        InputStream image = img;
        Doc doc = new SimpleDoc(img, flavour, null);
        if (services.length > 0)
        {
            DocPrintJob job = services[0].createPrintJob();
            job.print(doc, null);
        }
    }
}