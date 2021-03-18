package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import java.util.ArrayList;

public class ReservaActivity extends AppCompatActivity {
private Spinner spinner;
private ArrayList<SpinnerClass> spinnerClassArrayList;
private SpinnerAdapter spinnerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);
        //Hooks


/*



        spinnerClassArrayList = new ArrayList<>();
        spinnerClassArrayList.add(new SpinnerClass("Refugi Josep Maria Blanc", R.drawable.foto1));
        spinnerClassArrayList.add(new SpinnerClass("Refugi Cap de Llauset", R.drawable.foto2));
        spinnerClassArrayList.add(new SpinnerClass("Refugi Ventosa i Clavell", R.drawable.foto3));
        spinnerClassArrayList.add(new SpinnerClass("Refugi Amitges", R.drawable.foto4));
        spinnerClassArrayList.add(new SpinnerClass("Refugi Josep Maria Montfort", R.drawable.foto5));

        spinnerAdapter = new SpinnerAdapter(ReservaActivity.this, spinnerClassArrayList);
        spinner.setAdapter(spinnerAdapter);


*/




    }
}