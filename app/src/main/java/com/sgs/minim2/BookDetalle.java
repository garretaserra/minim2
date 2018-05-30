package com.sgs.minim2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookDetalle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detalle);
        this.setTitle("Libro");

        Intent i = this.getIntent();
        String id = i.getStringExtra("id");

        API.getInstance().api.getBook(id).enqueue(new Callback<BookDetail>() {
            @Override
            public void onResponse(Call<BookDetail> call, Response<BookDetail> response) {
                if(response.isSuccessful()) {
                    try {
                    BookDetail bd = response.body();

                        TextView author = (TextView) findViewById(R.id.author2);
                        author.setText(bd.getAuthor());
                        TextView title = (TextView) findViewById(R.id.title2);
                        title.setText(bd.getTitle());
                        TextView description = (TextView) findViewById(R.id.descripcion);
                        description.setText(bd.getDescription());
                        RatingBar rb = (RatingBar) findViewById(R.id.ratingBar);
                        rb.setRating(bd.getRating());
                        Picasso.with(getApplicationContext()).load(bd.getImage()).into((ImageView) findViewById(R.id.imageView3));
                        ListView lv = (ListView) findViewById(R.id.commentsList);
                        CommentAdapter ca = new CommentAdapter(getApplicationContext(), bd.getComments());
                        lv.setAdapter(ca);
                    }
                    catch (Exception e){
                        Toast.makeText(getApplicationContext(), "Missing arguments", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Problem with server", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<BookDetail> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Connection failed", Toast.LENGTH_LONG).show();
            }
        });

    }
}
