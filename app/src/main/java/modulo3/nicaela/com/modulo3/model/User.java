package modulo3.nicaela.com.modulo3.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicaela on 9/7/16.
 */
public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    private String picture_url;
    private List<Post> posts;

    public User() {
        id = 0;
        username = "";
        email = "";
        password = "";
        picture_url = "";
        posts = new ArrayList<Post>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
