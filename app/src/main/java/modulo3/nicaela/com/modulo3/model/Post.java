package modulo3.nicaela.com.modulo3.model;

import java.util.Date;

/**
 * Created by nicaela on 7/7/16.
 */
public class Post {
    private int id;
    private String title;
    private String content;
    private User user;
    private Date posted_date;

    public Post() {
        id = 0;
        title = "";
        content = "";
        user = new User();
        posted_date = new Date();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getPosted_date() {
        return posted_date;
    }

    public void setPosted_date(Date posted_date) {
        this.posted_date = posted_date;
    }

    public User getUser() {

        return user;
    }
}
