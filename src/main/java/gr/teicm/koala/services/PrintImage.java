package gr.teicm.koala.services;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import java.io.FileInputStream;
import java.io.IOException;

public class PrintImage
{
    public PrintImage(FileInputStream img) throws PrintException, IOException
    {

        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        pras.add(new Copies(1));
        PrintService pss[] = PrintServiceLookup.lookupPrintServices(DocFlavor.INPUT_STREAM.AUTOSENSE, pras);
        if (pss.length == 0)
        {
            new Message().noPrinterService();
            throw new RuntimeException("No printer services available.");
        }
        PrintService ps = pss[0];
        System.out.println("Printing to " + ps);
        DocPrintJob job = ps.createPrintJob();
        Doc doc = new SimpleDoc(img, DocFlavor.INPUT_STREAM.GIF, null);
        job.print(doc, pras);
        img.close();
    }
}