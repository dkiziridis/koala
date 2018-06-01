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
    private double latitude;
    private double longitude;
    private int width;
    private int height;
    private String imageName;
    private String type;
    private String date;

    public double getLatitude()
    {
        return latitude;
    }

    public double getLongitude()
    {
        return longitude;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public String getImageName()
    {
        return imageName;
    }

    public String getType()
    {
        return type;
    }

    public String getDate()
    {
        return date;
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
        System.out.println(handler.toString());//DEBUG

        //getting the list of all meta data elements
        String[] metadataNames = metadata.names();

        for (String tag : metadataNames)
        {
            System.out.println(tag + ": " + metadata.get(tag));


            switch (tag)
            {
                case "File Name":
                    System.out.println(tag + ": " + metadata.get(tag));
                    imageName = metadata.get(tag);
                    break;
                case "Image Height":
                    System.out.println(tag + ": " + metadata.get(tag));
                    height = Integer.valueOf(metadata.get(tag));
                    break;
                case "Image Width":
                    System.out.println(tag + ": " + metadata.get(tag));
                    width = Integer.valueOf(metadata.get(tag));
                    break;
                case "Content-Type":
                    System.out.println(tag + ": " + metadata.get(tag));
                    type = metadata.get(tag);
                    break;
                case "File Modified Date":
                    System.out.println(tag + ": " + metadata.get(tag));
                    date = metadata.get(tag);
                    break;
                case "geo:lat":
                    System.out.println(metadata.get(tag));
                    latitude = Double.valueOf(metadata.get(tag));
                    break;
                case "geo:long":
                    System.out.println(metadata.get(tag));
                    longitude = Double.valueOf(metadata.get(tag));
                    break;

                default:
                    break;


            }

        }
    }
}
