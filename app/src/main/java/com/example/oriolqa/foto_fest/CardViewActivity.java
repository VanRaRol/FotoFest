package com.example.oriolqa.foto_fest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CardViewActivity extends Activity {

    TextView personName;
    TextView personAge;
    ImageView personPhoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.cardview_activity);
        personName = (TextView)findViewById(R.id.person_name);
        personAge = (TextView)findViewById(R.id.person_age);
        personPhoto = (ImageView)findViewById(R.id.person_photo);




        personName.setText("Evento 1");
        personAge.setText("Lleida");
        personPhoto.setImageResource(R.drawable.eventos);




    }





}
