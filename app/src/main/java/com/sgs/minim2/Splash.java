package com.sgs.minim2;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aplash);
        //Simulacio de carregar
        Thread t = new Thread()
        {
            public void run()
            {
                try{
                    sleep(3000);
                }catch(InterruptedException ie)
                {
                    ie.printStackTrace();
                }finally
                {
                    Intent i = new Intent(getApplicationContext(),  MainActivity.class);
                    startActivity(i);
                }
            }
        }; t.start();
    }
}
