package gr.teicm.koala.Enums;

public enum Users
{
    ROOT("root"),
    ADMIN("administrator"),
    USER("getUser"),
    GUEST("guest");

    private String user;

    Users(String user)
    {
        this.user = user;
    }

    public String getUser()
    {
        return user;
    }
}
