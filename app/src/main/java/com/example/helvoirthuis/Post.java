package com.example.helvoirthuis;

public class Post {
    private String post_id;
    private String post_title;
    private String post_header;
    private String post_body;
    private String post_expire_date;
    private String post_available_date;
    private String post_image;
    private String post_section;
    private String post_type;
    private String post_author;
    private String post_slug;

    public Post(String post_id, String post_title, String post_header, String post_body, String post_expire_date, String post_available_date, String post_image, String post_section, String post_type, String post_author, String post_slug) {
        this.post_id = post_id;
        this.post_title = post_title;
        this.post_header = post_header;
        this.post_body = post_body;
        this.post_expire_date = post_expire_date;
        this.post_available_date = post_available_date;
        this.post_image = post_image;
        this.post_section = post_section;
        this.post_type = post_type;
        this.post_author = post_author;
        this.post_slug = post_slug;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getPost_header() {
        return post_header;
    }

    public void setPost_header(String post_header) {
        this.post_header = post_header;
    }

    public String getPost_body() {
        return post_body;
    }

    public void setPost_body(String post_body) {
        this.post_body = post_body;
    }

    public String getPost_expire_date() {
        return post_expire_date;
    }

    public void setPost_expire_date(String post_expire_date) {
        this.post_expire_date = post_expire_date;
    }

    public String getPost_available_date() {
        return post_available_date;
    }

    public void setPost_available_date(String post_available_date) {
        this.post_available_date = post_available_date;
    }

    public String getPost_image() {
        return post_image;
    }

    public void setPost_image(String post_image) {
        this.post_image = post_image;
    }

    public String getPost_section() {
        return post_section;
    }

    public void setPost_section(String post_section) {
        this.post_section = post_section;
    }

    public String getPost_type() {
        return post_type;
    }

    public void setPost_type(String post_type) {
        this.post_type = post_type;
    }

    public String getPost_author() {
        return post_author;
    }

    public void setPost_author(String post_author) {
        this.post_author = post_author;
    }

    public String getPost_slug() {
        return post_slug;
    }

    public void setPost_slug(String post_slug) {
        this.post_slug = post_slug;
    }
}
