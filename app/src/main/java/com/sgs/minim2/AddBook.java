package com.sgs.minim2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddBook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        this.setTitle("Añadir Libro");
    }


    public void addBook(View view){
        Book b = new Book();
        EditText title = (EditText)findViewById(R.id.title_txt);
        b.setTitle(title.getText().toString());
        EditText author = (EditText)findViewById(R.id.author_txt);
        b.setAuthor(author.getText().toString());
        API.getInstance().api.addBook(b).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful())
                    Toast.makeText(getApplicationContext(), "Libro añadido", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "Problema con el servidor", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "No hay conexión", Toast.LENGTH_LONG).show();
            }
        });
    }

}
