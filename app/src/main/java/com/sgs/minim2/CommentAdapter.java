package com.sgs.minim2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CommentAdapter extends ArrayAdapter<Comment> {
    public CommentAdapter(@NonNull Context context, List<Comment> resource) {
        super(context, 0,resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Comment c = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.commentlayout, parent, false);
        }
        TextView et = (TextView)convertView.findViewById(R.id.commentAuthor);
        et.setText(c.getUser());
        TextView comment = (TextView)convertView.findViewById(R.id.comment);
        comment.setText(c.getMessage());
        return convertView;
    }

}
