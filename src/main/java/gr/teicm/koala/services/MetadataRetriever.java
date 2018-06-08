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

    public MetadataRetriever(String path) throws IOException, TikaException, SAXException
    {
        File file = new File(path);

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
                    imageName = metadata.get(tag);
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
                    latitude = metadata.get(tag);
                    break;

                case "geo:long":
                    longitude = metadata.get(tag);
                    break;

                case "File Size":
                    fileSize = String.valueOf(metadata.get(tag));
                    break;
                default:
                    break;


            }

        }

    }
}
