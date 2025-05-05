package com.nigdroid.sangeet;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Nigam extends ArrayAdapter<String> {

    private  Context context;
    private String[] arr;

    public Nigam(@NonNull Context context, int resource, @NonNull String[] arr) {
        super(context, resource, arr);
        this.context=context;
        this.arr=arr;

    }

    @Nullable
    @Override
    public String getItem(int position) {
        return arr[position];
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView=LayoutInflater.from(getContext()).inflate(R.layout.my_nigam,parent,false);

       TextView t= convertView.findViewById(R.id.txt);
       t.setText(getItem(position));

       
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You clicked on:  " + arr[position], Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, Song_player.class);
                intent.putExtra("Song_Name_position",position);
                context.startActivity(intent);


            }
        });


        return convertView;
    }

}
