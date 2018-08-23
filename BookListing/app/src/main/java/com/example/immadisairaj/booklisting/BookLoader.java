package com.example.immadisairaj.booklisting;

import android.content.Context;
import android.support.annotation.Nullable;
import android.content.AsyncTaskLoader;

import java.util.List;

public class BookLoader extends AsyncTaskLoader<List<Book>> {

    private String mUrl;

    public BookLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        if(mUrl != null) {
            forceLoad();
        }
    }

    @Nullable
    @Override
    public List<Book> loadInBackground() {
        if (mUrl == null)
            return null;

        List<Book> books = QueryUtils.fetchBooksData(mUrl);
        return books;
    }
}
