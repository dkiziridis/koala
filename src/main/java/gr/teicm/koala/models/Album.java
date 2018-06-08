package gr.teicm.koala.models;

import gr.teicm.koala.services.IOServices;

import java.util.List;

public class Album
{
    private List<String> album;

    public Album(List<String> album)
    {
        this.album = album;
        new IOServices().printToFile(album);
    }

    public List<String> getAlbum()
    {
        return album;
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
