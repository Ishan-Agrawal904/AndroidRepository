package com.example.shayarimania;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shayarimania.PoetryModel.PoetryModel;
import com.squareup.picasso.Picasso;

public class PoetryReading extends AppCompatActivity implements View.OnClickListener{
    TextView PoetName, Poem1, Poem2, Poem3, Poem4;
    Button share, copy;
    ImageView poetImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poetry_reading);

//        checkConnection();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Shayari reading");

//        PoetName.setOnClickListener(this);

//        PoetryModel model = list.get(position);

        Intent intent1 = getIntent();

        String url = getIntent().getStringExtra("url");
        String poetName = getIntent().getStringExtra("poetName");
        String halfPoemFirst = getIntent().getStringExtra("halfPoemFirst");
        String halfPoemSecond = getIntent().getStringExtra("halfPoemSecond");
        String fullPoem3 = getIntent().getStringExtra("fullPoem3");
        String fullPoem4 = getIntent().getStringExtra("fullPoem4");

        PoetName = findViewById(R.id.PoetName);
        Poem1 = findViewById(R.id.Poem1);
        Poem2 = findViewById(R.id.Poem2);
        Poem3 = findViewById(R.id.Poem3);
        Poem4 = findViewById(R.id.Poem4);
        poetImage = findViewById(R.id.poetImage);
        share = findViewById(R.id.Share);
        copy = findViewById(R.id.copy);


        Picasso.get()
                .load(url)
                .into(poetImage);


        PoetName.setText(poetName);
        Poem1.setText(halfPoemFirst);
        Poem2.setText(halfPoemSecond);
        Poem3.setText(fullPoem3);
        Poem4.setText(fullPoem4);
//        PoetName.setText(poetName);




        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = getIntent().getStringExtra("url");
                String poetName = getIntent().getStringExtra("poetName");
                String halfPoemFirst = getIntent().getStringExtra("halfPoemFirst");
                String halfPoemSecond = getIntent().getStringExtra("halfPoemSecond");
                String fullPoem3 = getIntent().getStringExtra("fullPoem3");
                String fullPoem4 = getIntent().getStringExtra("fullPoem4");


                String data = "by:- " + poetName + "\n" + "\n" + halfPoemFirst + "\n" + halfPoemSecond + "\n"
                        + fullPoem3 + "\n" + fullPoem4 + "\n" + "\n" +
                        "by Shayari Mania app:- created by Ishan Agrawal";

                Intent intent1 = new Intent();
                intent1.setAction(Intent.ACTION_SEND);
//                intent.setAction(Intent.ACTION_SEND);
                intent1.setType("text/plain");
//                intent.setType("int/number");
                intent1.putExtra(Intent.EXTRA_SUBJECT, poetName + " shayari");
                intent1.putExtra(Intent.EXTRA_TEXT, data);

                startActivity(intent1);
            }
        });



        copy.setOnClickListener(v -> {

            String data = "by:- " + poetName + "\n" + "\n" + halfPoemFirst + "\n" + halfPoemSecond + "\n"
                    + fullPoem3 + "\n" + fullPoem4 ;

            ClipboardManager manager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("EditText", data);
            manager.setPrimaryClip(clip);

            Toast.makeText(PoetryReading.this, "Shayari Copied to ClipBoard !!!", Toast.LENGTH_SHORT).show();
        });


    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.PoetName:

//                Toast.makeText(this, "clicked Poet Name", Toast.LENGTH_SHORT).show();
                break;

            case R.id.poetImage :
//                Toast.makeText(this, "Image view is clicked", Toast.LENGTH_SHORT).show();
        }
    }




    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return super.onSupportNavigateUp();
    }

}