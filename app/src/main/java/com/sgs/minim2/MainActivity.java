package com.sgs.minim2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void listadoLibros(View view){
        Intent i = new Intent(this, BookList.class);
        startActivity(i);
    }


    public void añdirLbro(View view){
        Intent i = new Intent(this, AddBook.class);
        startActivity(i);
    }

    public void about(View view){
        Intent i = new Intent(this, About.class);
        startActivity(i);
    }

}
