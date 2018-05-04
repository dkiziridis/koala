package gr.teicm.koala;

public enum ThumbnailSize
{
    EXTRA_SMALL(75), SMALL(100), MEDIUM(125), BIG(150), HUGE(200);

    private final int value;

    ThumbnailSize(int i)
    {
        value = i;
    }

    public int getValue()
    {
        return value;
    }
}
