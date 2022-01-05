package com.example.shayarimania;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class StartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        getSupportActionBar().hide();
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Thread thread1 = new Thread(){
            public void run(){
                try{
                    sleep(3000);      // --> Delays for the time written by you in milli-second, like in Facebook, first for 2 seconds, Facebook symbol is shown
                }
                catch (Exception exception){
                    exception.printStackTrace();
                }
                finally {
                    Intent intent1 = new Intent(StartScreen.this, MainActivity.class);
                    startActivity(intent1);     // --> used for starting the Intent made by us with its name
                    finish();     // --> If not used, then after 2nd screen is open and back is clicked, it goes back to Starting page and repeats the same thing / procedure after time specified by you (like above, again opening the MainActivty after 2 - 3 seconds)
                }
            }
        }; thread1.start();
    }
}