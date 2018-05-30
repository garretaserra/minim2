package com.sgs.minim2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        this.setTitle("Lista de Libros");

        API.getInstance().api.getBooks().enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {

                if(response.isSuccessful()) {
                    ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar1);
                    pb.setVisibility(View.INVISIBLE);

                    final List<Book> books = response.body();
                    ListView lv = (ListView) findViewById(R.id.booklist);
                    BookSimpleAdapter bsa = new BookSimpleAdapter(getApplicationContext(), books);
                    lv.setAdapter(bsa);
                    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent i = new Intent(getApplicationContext(), BookDetalle.class);
                            i.putExtra("id", books.get(position).get_id());
                            startActivity(i);
                        }
                    });
                }
                else{
                    Toast.makeText(getApplicationContext(), "Problem with server", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Connection failed", Toast.LENGTH_LONG).show();
            }
        });

    }
}
