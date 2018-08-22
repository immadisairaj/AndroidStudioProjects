package com.example.immadisairaj.booklisting;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(Context context, List<Book> books) {
        super(context, 0, books);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.book_list, parent, false);
        }

        Book currentBook = getItem(position);

        TextView titleView = listItemView.findViewById(R.id.tv_title);
        titleView.setText(currentBook.getTitle());

        TextView descriptionView = listItemView.findViewById(R.id.tv_description);
        descriptionView.setText(currentBook.getDescription());

        TextView authorView = listItemView.findViewById(R.id.tv_author);
        authorView.setText(currentBook.getAuthor());

        return listItemView;
    }
}
