package com.example.immadisairaj.booklisting;

public class Book {

    private String mTitle, mDescription, mAuthor, mUrl;

    public Book(String mTitle, String mDescription, String mAuthor, String mUrl) {
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mAuthor = mAuthor;
        this.mUrl = mUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getUrl() {
        return mUrl;
    }
}
