package gr.teicm.koala.services;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MetadataRetrieverService
{
    private String latitude;
    private String longitude;
    private String width;
    private String height;
    private String imageName;
    private String type;
    private String date;
    private String fileSize;


    public String getLatitude()
    {
        return latitude;
    }

    public String getLongitude()
    {
        return longitude;
    }

    public String getWidth()
    {
        return width;
    }

    public String getHeight()
    {
        return height;
    }

    public String getCompressionType()
    {
        return imageName;
    }

    public String getContentType()
    {
        return type;
    }

    public String getFileSize()
    {
        return fileSize;
    }

    public String getDate()
    {
        return date;
    }

    public String getImageName()
    {
        return imageName;
    }

    public MetadataRetrieverService(String path) throws IOException, TikaException, SAXException
    {
        File file = new File(path);

        //Parser method parameters
        Parser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        FileInputStream inputStream = new FileInputStream(file);
        ParseContext context = new ParseContext();

        parser.parse(inputStream, handler, metadata, context);
        //System.out.println(handler.toString());//DEBUG

        //getting the list of all meta data elements
        String[] metadataNames = metadata.names();

        for (String tag : metadataNames)
        {
            //System.out.println(tag + ": " + metadata.get(tag));


            switch (tag)
            {
                case "File Name":
                    //System.out.println(tag + ": " + metadata.get(tag));
                    imageName = metadata.get(tag);
                    break;

                case "Image Height":
                    //System.out.println(tag + ": " + metadata.get(tag));
                    height = String.valueOf(metadata.get(tag));
                    break;

                case "Image Width":
                    //System.out.println(tag + ": " + metadata.get(tag));
                    width = String.valueOf(metadata.get(tag));
                    break;

                case "Content-Type":
                    //System.out.println(tag + ": " + metadata.get(tag));
                    type = metadata.get(tag);
                    break;

                case "File Modified Date":
                    //System.out.println(tag + ": " + metadata.get(tag));
                    date = metadata.get(tag);
                    break;

                case "geo:lat":
                    //System.out.println(metadata.get(tag));
                    latitude = metadata.get(tag);
                    break;

                case "geo:long":
                    // System.out.println(metadata.get(tag));
                    longitude = metadata.get(tag);
                    break;

                case "File Size":
                    // System.out.println(metadata.get(tag));
                    fileSize = String.valueOf(metadata.get(tag));
                    break;

//                case "File Modified Date":
//                    System.out.println(metadata.get(tag));
//                    fileModifiedDatte = String.valueOf(metadata.get(tag))

                default:
                    break;


            }

        }
    }
}
