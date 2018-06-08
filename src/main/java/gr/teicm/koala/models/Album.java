package gr.teicm.koala.models;

import gr.teicm.koala.services.IOServices;

import java.util.LinkedList;
import java.util.List;

public class Album
{
    private List<String> album;
    private String savePath;

    public Album()
    {
        savePath = new IOServices().openFolder().toString();
        album = new LinkedList<>();
    }


    public void addImageToAlbum(String path)
    {
        album.add(path);
    }

    public void removeImageFromAlbum(String path)
    {
        album.remove(path);
    }
}
