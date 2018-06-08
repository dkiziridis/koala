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

public class MetadataRetriever
{
    private double latitude;
    private double longitude;
    private String width;
    private String height;
    private String imageName;
    private String type;
    private String date;
    private long fileSize;


    public MetadataRetriever(String path) throws IOException, TikaException, SAXException
    {
        File file = new File(path);
        imageName = file.getName();

        fileSize = file.length();

        //Parser method parameters
        Parser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        FileInputStream inputStream = new FileInputStream(file);
        ParseContext context = new ParseContext();

        parser.parse(inputStream, handler, metadata, context);

        String[] metadataNames = metadata.names();

        for (String tag : metadataNames)
        {
            switch (tag)
            {
                case "File Name":
                    break;
                case "Image Height":
                    height = String.valueOf(metadata.get(tag));
                    break;

                case "Image Width":
                    width = String.valueOf(metadata.get(tag));
                    break;

                case "Content-Type":
                    type = metadata.get(tag);
                    break;

                case "File Modified Date":
                    date = metadata.get(tag);
                    break;

                case "geo:lat":
                    latitude = Double.parseDouble(metadata.get(tag));
                    break;

                case "geo:long":
                    longitude = Double.parseDouble(metadata.get(tag));
                    break;

                case "File Size":
                    break;
                default:
                    break;


            }

        }

    }

    public double getLatitude()
    {
        return latitude;
    }

    public String getWidth()
    {
        return width;
    }

    public String getHeight()
    {
        return height;
    }

    public String getContentType()
    {
        return type;
    }

    public double getLongitude()
    {
        return longitude;
    }

    public String getDate()
    {

        return date;
    }

    public String getImageName()
    {
        return imageName;
    }

    public long getFileSize()
    {
        return fileSize;
    }
}