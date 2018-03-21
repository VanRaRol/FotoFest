package com.example.oriolqa.foto_fest;

/**
 * Created by Oriol on 10/03/2018.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {

    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView eventName;
        TextView eventLocation;
        ImageView personPhoto;
        Button mapSearchFest;


        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            eventName = (TextView) itemView.findViewById(R.id.person_name);
            eventLocation = (TextView) itemView.findViewById(R.id.person_age);
            personPhoto = (ImageView) itemView.findViewById(R.id.person_photo);
            mapSearchFest = (Button) itemView.findViewById(R.id.map_search_fest);

        }
    }

    public void OnClick(View v){

    }

    List<Events> persons;

    RVAdapter(List<Events> persons) {
        this.persons = persons;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);


        PersonViewHolder pvh = new PersonViewHolder(v);

        return pvh;
    }

    @Override
    public void onBindViewHolder(final PersonViewHolder personViewHolder, final int i) {
        personViewHolder.eventName.setText(persons.get(i).event);
        personViewHolder.eventLocation.setText(persons.get(i).location);
        personViewHolder.personPhoto.setImageResource(persons.get(i).photoId);
        personViewHolder.mapSearchFest.setBottom(persons.get(i).button);
        personViewHolder.mapSearchFest.setOnClickListener(new View.OnClickListener() {
                                                              @Override
                                                              public void onClick(View view) {;
                                                                  view.getContext().startActivity(new Intent(view.getContext(), MapsMarkerActivity.class));
                                                              }

                                                          }
        );
        /*
        personViewHolder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {;
                Toast.makeText(view.getContext(), "Item " + i, Toast.LENGTH_SHORT).show();
            }

        }
        );


        @Override
public void onClick(View v) {

    final Intent intent;
    switch (getAdapterPostion()){
        case 0:
           intent =  new Intent(context, FirstActivity.class);
           break;

        case 1:
            intent =  new Intent(context, SecondActivity.class);
            break;
           ...
        default:
           intent =  new Intent(context, DefaultActivity.class);
           break;
     }
    context.startActivity(intent);
}

        */

        personViewHolder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {;
                view.getContext().startActivity(new Intent(view.getContext(), ChannelDetailActivity.class));
            }

                                               }
        );

    }

    @Override
    public int getItemCount() {
        return persons.size();
    }
}
