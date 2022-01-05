package com.example.shayarimania;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class AnimationScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_screen);
        
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);



        Thread thread = new Thread(){
            public void run(){
                try{
                    sleep(2000);      // --> Delays for the time written by you in milli-second, like in Facebook, first for 2 seconds, Facebook symbol is shown
                }
                catch (Exception exception){
                    exception.printStackTrace();
                }
                finally {

                    Intent intent = getIntent();

                    String url = getIntent().getStringExtra("url");
                    String poetName = getIntent().getStringExtra("poetName");
                    String halfPoemFirst = getIntent().getStringExtra("halfPoemFirst");
                    String halfPoemSecond = getIntent().getStringExtra("halfPoemSecond");
                    String fullPoem3 = getIntent().getStringExtra("fullPoem3");
                    String fullPoem4 = getIntent().getStringExtra("fullPoem4");

                    Intent intent1 = new Intent(AnimationScreen.this, PoetryReading.class);
                    intent1.putExtra("url", url);
                    intent1.putExtra("poetName", poetName);
                    intent1.putExtra("halfPoemFirst", halfPoemFirst);
                    intent1.putExtra("halfPoemSecond", halfPoemSecond);
                    intent1.putExtra("fullPoem3", fullPoem3);
                    intent1.putExtra("fullPoem4", fullPoem4);

                    startActivity(intent1);     // --> used for starting the Intent made by us with its name
                    finish();     // --> If not used, then after 2nd screen is open and back is clicked, it goes back to Starting page and repeats the same thing / procedure after time specified by you (like above, again opening the MainActivty after 2 - 3 seconds)
                }
            }
        }; thread.start();
    }
}