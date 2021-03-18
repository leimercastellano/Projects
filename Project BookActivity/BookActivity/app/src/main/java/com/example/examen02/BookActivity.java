package com.example.examen02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BookActivity extends AppCompatActivity {
    ArrayList<? extends Integer> listaImagenes;
    GridView gridView;
    ImageView imageView;
    TextView textTrainer;
    TextView textDuration;
    TextView textDescription;
    TextView textKcal;
    TextView textRoom;
    TextView textDate;
    TextView textTime;

    int[] listaImages;
    CustomAdapter customAdapter = new CustomAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        textTrainer = findViewById(R.id.textTrainerView);
        textDescription = findViewById(R.id.textDescripcionV);
        textKcal = findViewById(R.id.textKcalV);
        textDuration = findViewById(R.id.textDurationV);
        textRoom = findViewById(R.id.textRoomV);
        textDate = findViewById(R.id.textDateV);
        textTime = findViewById(R.id.textDateV);

        Intent i = getIntent();
        String title = i.getStringExtra(MainActivity.TITLE);
        String trainer = i.getStringExtra(MainActivity.TRAINER);
        String duration = i.getStringExtra(MainActivity.DURATION);
        String description = i.getStringExtra(MainActivity.DESCRIPTION);
        String kcal = i.getStringExtra(MainActivity.KCAL);
        String room = i.getStringExtra(MainActivity.ROOM);
        String date = i.getStringExtra(MainActivity.DATE);
        String time = i.getStringExtra(MainActivity.TIME);


        textTrainer.setText(trainer);
        textDescription.setText(description);
        textKcal.setText(kcal);
        textDuration.setText(duration);
        textRoom.setText(room);
        textDate.setText(date);
        textTime.setText(time);

        listaImagenes = new ArrayList<>();
         listaImagenes=  i.getIntegerArrayListExtra("IMAGENES");

        Toast.makeText(this, String.valueOf(listaImagenes.size()), Toast.LENGTH_SHORT).show();

        gridView = findViewById(R.id.gridView);
        gridView.setAdapter(customAdapter);
        registerForContextMenu(gridView);

    }


    private class CustomAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            //Retornamos el tamano de vistas que tenemos
            return listaImagenes.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.grid_row_data, null);
            ImageView imageRow = view.findViewById(R.id.imageViewRow);


            imageRow.setImageResource(listaImagenes.get(position));
            return view;
        }
    }


}