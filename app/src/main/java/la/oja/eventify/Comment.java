package la.oja.eventify;

/**
 * Created by luna-aleixos on 28.04.2016.
 */
public class Comment
{
    private String message;
    private String authorEmail;

    public Comment()
    {}

    public Comment( String message, String authorEmail )
    {
        this.message = message;
        this.authorEmail = authorEmail;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage( String message )
    {
        this.message = message;
    }

    public String getAuthorEmail()
    {
        return authorEmail;
    }

    public void setAuthorEmail( String authorEmail )
    {
        this.authorEmail = authorEmail;
    }
};
