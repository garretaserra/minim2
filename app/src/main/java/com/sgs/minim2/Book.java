package com.sgs.minim2;

import com.google.gson.annotations.SerializedName;

public class Book {

    @SerializedName("author")
    private String author;
    @SerializedName("title")
    private String title;
    private String image;
    private String _id;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {return "http://api.dsamola.tk/imagen.jpeg";
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
