package com.sgs.minim2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class BookSimpleAdapter extends ArrayAdapter<Book> {
    public BookSimpleAdapter(@NonNull Context context, List<Book> resource) {
        super(context, 0,resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Book b = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.booksimple, parent, false);
        }
        try {
            TextView et = (TextView) convertView.findViewById(R.id.author_lbl);
            et.setText(b.getAuthor());
            TextView et2 = (TextView) convertView.findViewById(R.id.title_lbl);
            et2.setText(b.getTitle());
            Picasso.with(super.getContext()).load(b.getImage()).into((ImageView) convertView.findViewById(R.id.image1));
        }
        catch (Exception e){}
        return convertView;
    }

}
