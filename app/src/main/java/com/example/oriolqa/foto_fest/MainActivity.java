package com.example.oriolqa.foto_fest;

/**
 * Created by Oriol QA on 07/03/2018.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {



    private List<Events> events;
    private RecyclerView rv;


    TextView personName;
    TextView personAge;
    ImageView personPhoto;
    Button map_search_fest;
    Button newReservation;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Intent intent = new Intent(this, LoginActivity.class);
        //startActivity(intent);


        setContentView(R.layout.recyclerview_activity);

        rv= findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        newReservation = (Button) findViewById(R.id.newReserve);
        newReservation.setOnClickListener(this);

        initializeData();
        initializeAdapter();
    }



    private void initializeData(){
        events = new ArrayList<>();
        events.add(new Events("Evento 1", "Mollerussa", R.drawable.eventos,1));
        events.add(new Events("Evento 2", "LLeida", R.drawable.eventos,1));
        events.add(new Events("Evento 3", "Barcelona", R.drawable.eventos,1));
        events.add(new Events("Evento 5", "Madrid", R.drawable.eventos,1));

        //Intent intent = new Intent(this, LoginActivity.class);
        //startActivity(intent);
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(events);
        rv.setAdapter(adapter);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, CalendarActivity.class);
        startActivity(intent);
    }
}
